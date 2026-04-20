package edu.url.compiladores;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.url.compiladores.antlr.ExprLexer;
import edu.url.compiladores.antlr.ExprParser;

import java.io.IOException;
import java.util.Scanner;

/**
 * Compilador - Análisis Semántico
 * Translates the custom language to Java, prints the symbol table,
 * and reports any semantic type errors found during the visit.
 */
public class App
{
    public static void main(String[] args) throws IOException
    {
        // Ask the user for the path to the input file
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo de entrada: ");
        String filePath = in.nextLine().trim();
        in.close();

        // Load the file as a CharStream
        CharStream cs = CharStreams.fromFileName(filePath);

        // Lexer → Tokens → Parser
        ExprLexer lexer   = new ExprLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        // Start rule
        ParseTree tree = parser.prog();

        // ── Visit the tree ────────────────────────────────────────────────────
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);

        // ── Print symbol table ────────────────────────────────────────────────
        System.out.println("\n========== TABLA DE VARIABLES ==========");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "NOMBRE", "VALOR", "TIPO", "ÁMBITO");
        System.out.println("-".repeat(47));
        for (Variable v : visitor.getSymbolTable()) {
            System.out.println(v);
        }
        System.out.println("=========================================");

        // ── Print semantic errors (if any) ───────────────────────────────────
        if (visitor.hasErrors()) {
            System.out.println("\n========== ERRORES SEMÁNTICOS ==========");
            for (String err : visitor.getErrors()) {
                System.out.println(err);
            }
            System.out.println("=========================================");
        } else {
            System.out.println("\n✔ Sin errores semánticos.");
        }

        // ── Print translated Java code ────────────────────────────────────────
        System.out.println("\n========== CÓDIGO JAVA GENERADO ==========");
        System.out.println(visitor.getJavaCode());
        System.out.println("==========================================");
    }
}
