package edu.url;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class LexerTest {
    @Test
    public void testGetTokensFromSourceCode() throws Exception{
        Lexer analizadorLexico = new Lexer();

        ArrayList<TokenSymbol> tokens = analizadorLexico.getTokensFromSourceCode("()");

        assertEquals(2, tokens.size());

        assertEquals("TERMINAL", tokens.get(0).getType());
        assertEquals("(", tokens.get(0).getSymbol());

        assertEquals("TERMINAL", tokens.get(1).getType());
        assertEquals(")", tokens.get(1).getSymbol());
    }

    @Test
    public void testGetInvalidTokensFromSourceCode() throws Exception{
        Lexer analizadorLexico = new Lexer();
        ArrayList<TokenSymbol> tokens = null;

        try {
            tokens = analizadorLexico.getTokensFromSourceCode("(2)");
        } catch (Exception e){
            assertEquals(1, tokens.size());
            assertTrue(e.getMessage().toLowerCase().contains("Symbolo no reconocido:"));
        }
        
    }
}
