import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    // Terminal tokens defined in the grammar
     private static final String[] TERMINALS = {
        "int", "boolean", "id", "num", "=", ";", "true", "false"
    };

    // Patterns for matching tokens
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
        "\\b(int|boolean|[a-zA-Z_][a-zA-Z0-9]*|[0-9]+|true|false)\\b|[=;]"
    );

    /**
     * Parses the input string and returns lexical tokens based on Grammar No. 1.
     * @param input The string to be parsed.
     * @return ArrayList<String> containing the lexical tokens.
     */
    public static ArrayList<Lexema> getLexicalTokens(String input) {
        ArrayList<Lexema> tokens = new ArrayList<Lexema>();
        Matcher matcher = TOKEN_PATTERN.matcher(input);

        // Find all matching tokens
        while (matcher.find()) {

            String token = matcher.group();

            if (token.matches("int") ) {
                tokens.add(new Lexema("int", token));
            } else if (token.matches("boolean") ) {
                tokens.add(new Lexema("boolean", token));
            } else if (token.matches("boolean") ) {
                tokens.add(new Lexema("boolean", token));
            } else if (token.matches("true")) {
                tokens.add(new Lexema("true", token));
            } else if (token.matches("false")) {
                tokens.add(new Lexema("false", token));
            } else if (token.matches("[a-zA-Z_][a-zA-Z0-9]*")) {
                tokens.add(new Lexema("id", token));
            } else if (token.matches("[0-9]+")) {
                tokens.add(new Lexema("num", token));
            } else if (token.matches(";")) {
                tokens.add(new Lexema(";", token));
            } else if (token.matches("=")) {
                tokens.add(new Lexema("=", token));
            } 
        }

        tokens.add(new Lexema("$", "eof"));

        return tokens;
    }


}
