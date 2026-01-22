package edu.url.compiladores;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;  
import org.antlr.v4.runtime.Lexer;

import edu.url.compiladores.antlr.ExprLexer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Ejemplo de entrada
        String input = "10+20*30+variable+hola123";

        
        CharStream cs = CharStreams.fromString(input);
        ExprLexer lexer = new ExprLexer(cs);

        Token token;
        while ((token = lexer.nextToken()).getType() != Token.EOF) {
            String typeName = ExprLexer.VOCABULARY.getSymbolicName(token.getType());
            System.out.printf("Token %-12s  Texto: '%s'%n", typeName, token.getText());
        }
    }
}
