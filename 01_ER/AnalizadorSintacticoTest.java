import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnalizadorSintacticoTest {
    @Test
    public void testEjemplo1() {

        int result = AnalizadorSintactico.ejemplo1Check("abbbbbbcd");
        assertEquals(1, result);

        result = AnalizadorSintactico.ejemplo1Check("acd");
        assertEquals(1, result);

        result = AnalizadorSintactico.ejemplo1Check("cdcdab");
        assertEquals(1, result);

        result = AnalizadorSintactico.ejemplo1Check("abcd");
        assertEquals(1, result);

        result = AnalizadorSintactico.ejemplo1Check("acbd");
        assertEquals(0, result);

    }

    @Test
    public void esParCheckTest(){
        int result = AnalizadorSintactico.binarioParCheck("10");
        assertEquals(2, result);

        result = AnalizadorSintactico.binarioParCheck("10000");
        assertEquals(2, result);

        result = AnalizadorSintactico.binarioParCheck("1111110");
        assertEquals(2, result);

        result = AnalizadorSintactico.binarioParCheck("0000");
        assertEquals(0, result);

        result = AnalizadorSintactico.binarioParCheck("100001");
        assertEquals(0, result);

        result = AnalizadorSintactico.binarioParCheck("1");
        assertEquals(0, result);
    }

    @Test
    public void declaracionVariableTest(){
        int result = AnalizadorSintactico.declaracionVariableCheck("n i = 10;");
        assertEquals(3, result);

        result = AnalizadorSintactico.declaracionVariableCheck("n variable    = 328;");
        assertEquals(3, result);

        result = AnalizadorSintactico.declaracionVariableCheck("n test=23;");
        assertEquals(3, result);

        result = AnalizadorSintactico.declaracionVariableCheck("n test=23");
        assertEquals(0, result);

        result = AnalizadorSintactico.declaracionVariableCheck("ntest=23");
        assertEquals(0, result);

        result = AnalizadorSintactico.declaracionVariableCheck("test=23");
        assertEquals(0, result);

        result = AnalizadorSintactico.declaracionVariableCheck("n test#=23");
        assertEquals(0, result);
    }
}
