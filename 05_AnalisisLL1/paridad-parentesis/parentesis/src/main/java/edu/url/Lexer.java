package edu.url;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * Analizador Léxico
*/
public class Lexer {
    
    public ArrayList<TokenSymbol> getTokensFromSourceCode(String input) throws Exception{
        ArrayList<TokenSymbol> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\(|\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();

            if (match.equals("(")){
                tokens.add(new TokenSymbol("TERMINAL", "(", "("));
            } else if (match.equals(")")){
                tokens.add(new TokenSymbol("TERMINAL", ")", ")"));
            } else {
                throw new Exception("Symbolo no reconocido: " + match);
            }
        }

        tokens.add(new TokenSymbol("TERMINAL", "$", "$")); //Finalización de la cadena de entrada
        return tokens;
    }

}
