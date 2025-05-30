package edu.url.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.junit.Test;

import edu.url.antlr.variablesLexer;
import edu.url.antlr.variablesParser;

public class EnvironmentTest {
    @Test
    public void testVisitStart() {
        String input = ""+
            "$name Ejemplo" +
            "$vars:\r\n" + 
            "$int variable1 = 2\r\n" +
            "$int variable2 = 0\r\n" +
            "$bool test = $true\r\n" + 
            "$bool testBool2 = $false\r\n" +
            "$code:" +
            "$write test\r\n" + 
            "$write variable1\r\n" +
            "$end";

        // Crear lexer y parser
        variablesLexer lexer = new variablesLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        variablesParser parser = new variablesParser(tokens);

        // Obtener el árbol de sintaxis
        ParseTree tree = parser.start();

        String codigoIntermedio = "";
        String nombre = "";

        // Usar el visitor
        Environment visitor = new Environment(codigoIntermedio, nombre);
        VariableSegment programa = visitor.visit(tree);

        assertEquals(2, programa.getIntVariables().size());

        assertEquals(2, programa.getBoolVariables().size());

        int variable1Value = programa.getIntVariables().get("variable1").getValue();
        assertEquals(2, variable1Value);

        int variable2Value = programa.getIntVariables().get("variable2").getValue();
        assertEquals(0, variable2Value);

        boolean variableTestValue = programa.getBoolVariables().get("test").getValue();
        assertTrue(variableTestValue);

        boolean variableTest2 = programa.getBoolVariables().get("testBool2").getValue();
        assertFalse(variableTest2);
    }
}
