package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import src.LexAnalizer;

public class LexAnalizerTest {

    @Test
    public void TokenizeOneVariable() {
        String expression1 = "b _bprueba : #10001";
            
        ArrayList<String> tokens1 = LexAnalizer.tokenizeVariables(expression1);
        
        assertEquals("b", tokens1.get(0));
        assertEquals("ID", tokens1.get(1));
        assertEquals(":", tokens1.get(2));        
        assertEquals("VALUE_BIN", tokens1.get(3));
    }

    @Test
    public void TokenizeVariasVariable() {
        String expression1 = "b _bprueba : #10001 o _test : #2541 h _prueba2 : #AF10";
            
        ArrayList<String> tokens1 = LexAnalizer.tokenizeVariables(expression1);
        
        assertEquals("b", tokens1.get(0));
        assertEquals("ID", tokens1.get(1));
        assertEquals(":", tokens1.get(2));        
        assertEquals("VALUE_BIN", tokens1.get(3));

        assertEquals("o", tokens1.get(4));
        assertEquals("ID", tokens1.get(5));
        assertEquals(":", tokens1.get(6));        
        assertEquals("VALUE_OCT", tokens1.get(7));

        assertEquals("h", tokens1.get(8));
        assertEquals("ID", tokens1.get(9));
        assertEquals(":", tokens1.get(10));        
        assertEquals("VALUE_HEX", tokens1.get(11));
    }

    @Test
    public void TokenizeNormalExpresionTest() {
        String expression1 = "8 + 250";
            
        ArrayList<String> tokens1 = LexAnalizer.tokenize(expression1);
        
        assertEquals("number", tokens1.get(0));
        assertEquals("+", tokens1.get(1));
        assertEquals("number", tokens1.get(2));        
    }

    @Test
    public void TokenizeGroupExpresionTest() {

        String expression1 = "(8+2) * (32 / 4 )";
            
        ArrayList<String> tokens1 = LexAnalizer.tokenize(expression1);
        
        assertEquals("(", tokens1.get(0));
        assertEquals("number", tokens1.get(1));
        assertEquals("+", tokens1.get(2));
        assertEquals("number", tokens1.get(3));
        assertEquals(")", tokens1.get(4));
        assertEquals("*", tokens1.get(5));
        assertEquals("(", tokens1.get(6));
        assertEquals("number", tokens1.get(7));
        assertEquals("/", tokens1.get(8));
        assertEquals("number", tokens1.get(9));
        assertEquals(")", tokens1.get(10));

    }

}
