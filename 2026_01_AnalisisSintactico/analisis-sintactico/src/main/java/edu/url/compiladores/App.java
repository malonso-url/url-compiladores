package edu.url.compiladores;

import org.antlr.v4.runtime.CharStreams;

import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.url.compiladores.antlr.ExprLexer;
import edu.url.compiladores.antlr.ExprParser;
import edu.url.compiladores.antlr.ExprBaseVisitor;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Scanner in = new Scanner(System.in);
        // Entrada de prueba (DEBE cumplir la gramática)
        String input = "STARTPROG\r\nx=10\r\ny=20\r\nx+y*30\r\nENDPROG";

        // Lexer
        CharStream cs = CharStreams.fromString(input);
        ExprLexer lexer = new ExprLexer(cs);

        // Tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Parser
        ExprParser parser = new ExprParser(tokens);

        // Regla inicial
        ParseTree tree = parser.prog();

        // Mostrar árbol como texto
        System.out.println("Árbol sintáctico:");
        System.out.println(tree.toStringTree(parser));

        // Visitar el árbol
        System.out.println("\nVisitando nodos:");
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);

    }
}
