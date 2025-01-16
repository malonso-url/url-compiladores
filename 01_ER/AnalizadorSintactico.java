import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorSintactico{

    public static int ejemplo1Check(String input){
        Pattern pattern = Pattern.compile("^(ab*|cd)+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if(matchFound) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int binarioParCheck(String input){
        Pattern pattern = Pattern.compile("^1(0|1)*0$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if(matchFound) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int classifyToken(String input) {
        // Patrón para palabras reservadas
        String reservedWords = "int|program|var|string|public";
        // Patrón para operadores aritméticos
        String arithmeticOperators = "\\+|-|\\*|/";
        // Patrón para identificadores (letras, números y guiones bajos, pero no pueden comenzar con un número)
        String identifier = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        // Patrón para números (enteros o decimales)
        String number = "^\\d+(\\.\\d+)?$";

        if (Pattern.matches(reservedWords, input)) {
            return 1; // Palabra reservada
        } else if (Pattern.matches(arithmeticOperators, input)) {
            return 2; // Operador aritmético
        } else if (Pattern.matches(identifier, input)) {
            return 3; // Identificador
        } else if (Pattern.matches(number, input)) {
            return 4; // Número
        } else {
            return 5; // No coincide con ninguno
        }
    }

    public static int declaracionVariableCheck(String input){
        Pattern pattern = Pattern.compile("^n +[a-zA-Z][a-zA-Z0-9]* *= *[0-9]+ *;$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if(matchFound) {
            return 3;
        } else {
            return 0;
        }
    }

}