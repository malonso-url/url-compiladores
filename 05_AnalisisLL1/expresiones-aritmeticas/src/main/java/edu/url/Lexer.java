package edu.url;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Implementación de ILexer
class Lexer implements ILexer {

    @Override
    public ArrayList<TokenSymbol> getTokensFromString(String expresion) {
        ArrayList<TokenSymbol> tokens = new ArrayList<>();

        // Definir el patrón para números, operadores y paréntesis
        Pattern pattern = Pattern.compile("\\d+|\\+|\\-|\\*|/|\\(|\\)");
        Matcher matcher = pattern.matcher(expresion);

        while (matcher.find()) {
            String match = matcher.group();

            // Clasificar el token
            if (match.matches("\\d+")) {
                tokens.add(new TokenSymbol("num", match));
            } else if (match.equals("+")) {
                tokens.add(new TokenSymbol("suma", match));
            } else if (match.equals("-")) {
                tokens.add(new TokenSymbol("resta", match));
            } else if (match.equals("*")) {
                tokens.add(new TokenSymbol("multiplicacion", match));
            } else if (match.equals("/")) {
                tokens.add(new TokenSymbol("div", match));
            } else if (match.equals("(")) {
                tokens.add(new TokenSymbol("lpar", match));
            } else if (match.equals(")")) {
                tokens.add(new TokenSymbol("rpar", match));
            }
        }

        return tokens;
    }
}