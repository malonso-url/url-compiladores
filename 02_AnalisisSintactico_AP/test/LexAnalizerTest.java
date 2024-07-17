package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import src.LexAnalizer;

public class LexAnalizerTest {
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
