package edu.url;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ParserTest {
    @Test
    public void testIsValidCode() throws Exception{
        Lexer analizadorLexico = new Lexer();
        ArrayList<TokenSymbol> tokens = analizadorLexico.getTokensFromSourceCode("()");

        Parser analizadorSintactico = new Parser();
        assertTrue(analizadorSintactico.isValidCode(tokens));
    }


    @Test
    public void testIsValidCodeNestedParentesis() throws Exception{
        Lexer analizadorLexico = new Lexer();
        ArrayList<TokenSymbol> tokens = analizadorLexico.getTokensFromSourceCode("(())()");

        Parser analizadorSintactico = new Parser();
        assertTrue(analizadorSintactico.isValidCode(tokens));
    }

    @Test
    public void testIsValidCodeFail() throws Exception{
        Lexer analizadorLexico = new Lexer();

        try{
            ArrayList<TokenSymbol> tokens = analizadorLexico.getTokensFromSourceCode("(())))");
            Parser analizadorSintactico = new Parser();
            assertTrue(analizadorSintactico.isValidCode(tokens));
        } catch(Exception e){
            assertTrue(e.getMessage().toLowerCase().contains("incorrecto"));
        }
        
        
    }
}
