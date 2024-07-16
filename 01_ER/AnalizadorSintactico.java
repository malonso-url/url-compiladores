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