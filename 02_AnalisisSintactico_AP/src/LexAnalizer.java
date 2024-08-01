package src;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexAnalizer
{
    /***
     * This method gets an arithmetic expression and returns the tokens, this method was built using IA
     * prompt: "Necesito una función en Java que dada una expresión aritmética como String, me devuelva los tokens en un ArrayList, los tokens serían: número, (, ), +, -, *, /, ejemplos serían: (8+2) * (32 / 4 ) y también ((8 + 3) / 2)"
     * @param expression an arithmetic expresion, example: "(8+2) * (32 / 4 )" or "((8 + 3) / 2)"
     * @return an ArrayList with all the tokens
     */
     public static ArrayList<String> tokenize(String expression) {
        ArrayList<String> tokens = new ArrayList<>();
        String regex = "\\d+|\\(|\\)|\\+|\\-|\\*|\\/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        
        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("\\d+")) {
                tokens.add("number");
            } else {
                tokens.add(token.trim());
            }
        }
        
        return tokens;
    }


    public static ArrayList<String> tokenizeVariables(String declaracion_variables){
        ArrayList<String> tokens = new ArrayList<>();
        String regex = "_[a-zA-Z0-9]+|#[01]+|#[0-7]+|#[0-9A-F]+|[boh]|:";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(declaracion_variables);
        
        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("_[a-zA-Z0-9]+")) {
                tokens.add("ID");
            } else if (token.matches("#[01]+")) {
                tokens.add("VALUE_BIN");
            } else if (token.matches("#[0-7]+")) {
                tokens.add("VALUE_OCT");
            } else if (token.matches("#[0-9A-F]+")) {
                tokens.add("VALUE_HEX");
            }
            else {
                tokens.add(token.trim());
            }
        }
        
        return tokens;
    }

}