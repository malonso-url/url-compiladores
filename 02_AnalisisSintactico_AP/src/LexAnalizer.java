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

    public static void main(String[] args) {
        
    }
}