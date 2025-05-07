package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
 * 
S		    -> <variable> eof
<variable>	-> b ID : VALUE_BIN <variable>
		    -> o ID : VALUE_OCT <variable>
		    -> h ID : VALUE_HEX <variable>
		    -> ε
 * 
*/

public class VariableAnalizer {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;

    HashMap<String, String> parsingTable = new HashMap<String, String>();

    public VariableAnalizer(){

        /*Creación de la tabla de parseo usando un HashMap, la llave es la unión de
         el símbolo terminal con el símbolo no terminal, el value es la producción en la celda*/
        parsingTable.put("Sb", "<variable> $");
        parsingTable.put("So", "<variable> $");
        parsingTable.put("Sh", "<variable> $");
        parsingTable.put("<variable>b", "b ID : VALUE_BIN <variable>");
        parsingTable.put("<variable>o", "o ID : VALUE_OCT <variable>");
        parsingTable.put("<variable>h", "h ID : VALUE_HEX <variable>");
    }

    public int parse(ArrayList<String> tokens) throws Exception{

        ArrayList<String> simbolos = new ArrayList<String>();
        simbolos.add("S");
        int index = 0;

        while(!tokens.isEmpty()){
            String key = simbolos.get(index) + tokens.get(0);
            String production = parsingTable.get(key);

            if (production != null){
                
            } else {
                throw new Exception("Símbolo " + tokens.get(0) + " No esperado");
            }
        }

        return SUCCESS;
    }

}
