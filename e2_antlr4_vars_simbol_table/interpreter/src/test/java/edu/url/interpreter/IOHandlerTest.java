package edu.url.interpreter;

import org.junit.Test;

import java.util.ArrayList;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import edu.url.antlr.variablesLexer;
import edu.url.antlr.variablesParser;

public class IOHandlerTest {
    @Test
    public void testVisitIoexpr() {
        String input = ""+
            "$vars:\r\n" + 
            "$int variable1 = 2\r\n" +
            "$int variable2 = 0\r\n" +
            "$bool test = $true\r\n" + 
            "$bool testBool2 = $false" +
            "$code:\r\n" +
            "$write test\r\n" + 
            "$write variable1\r\n" +
            "$write variable100\r\n";

        //Para las variables
        // Crear lexer y parser
        variablesLexer lexer = new variablesLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        variablesParser parser = new variablesParser(tokens);

        // Obtener el árbol de sintaxis
        ParseTree tree = parser.start();

        String codigoIntermedio = "";
        // Usar el visitor
        Environment visitor = new Environment(codigoIntermedio);
        VariableSegment programa = visitor.visit(tree);


        // Crear lexer y parser para IO
        variablesLexer lexerIO = new variablesLexer(CharStreams.fromString(input));
        CommonTokenStream tokensIO = new CommonTokenStream(lexerIO);
        variablesParser parserIO = new variablesParser(tokensIO);

        // Obtener el árbol de sintaxis
        ParseTree treeIO = parserIO.start();

        // Usar el visitor
        IOHandler visitorIO = new IOHandler(programa);
        visitorIO.visit(treeIO);
    }
}
