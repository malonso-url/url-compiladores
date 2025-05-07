package edu.url;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import edu.url.antlr.EjemploGood2Lexer;
import edu.url.antlr.EjemploGood2Parser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
                // Expresión a evaluar
        String input = "10+20+30";

        // Crear lexer y parser
        EjemploGood2Lexer lexer = new EjemploGood2Lexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EjemploGood2Parser parser = new EjemploGood2Parser(tokens);

        // Obtener el árbol de sintaxis
        ParseTree tree = parser.start();

        // Usar el visitor
        Evaluador visitor = new Evaluador();
        int resultado = visitor.visit(tree);

        System.out.println("Resultado: " + resultado);
    }
}
