package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import src.LexAnalizer;
import src.SintaxAnalizer;

public class SintaxAnalizerTest {
    
    @Test
    public void basicExpressionParseTest() throws Exception{
        String expression1 = "8 + 250";
        ArrayList<String> tokens1 = LexAnalizer.tokenize(expression1);
        SintaxAnalizer parser = new SintaxAnalizer();

        assertEquals(SintaxAnalizer.SUCCESS, parser.parse(tokens1));
    }

    @Test
    public void GroupExpressionParseTest() throws Exception{
        String expression1 = "(8+2) * (32 / 4 )";
        ArrayList<String> tokens1 = LexAnalizer.tokenize(expression1);
        SintaxAnalizer parser = new SintaxAnalizer();

        assertEquals(SintaxAnalizer.SUCCESS, parser.parse(tokens1));
    }

    @Test
    public void NestedGroupsExpressionParseTest() throws Exception{
        String expression1 = "((8 + 3) / 2)";
        ArrayList<String> tokens1 = LexAnalizer.tokenize(expression1);
        SintaxAnalizer parser = new SintaxAnalizer();

        assertEquals(SintaxAnalizer.SUCCESS, parser.parse(tokens1));
    }
}
