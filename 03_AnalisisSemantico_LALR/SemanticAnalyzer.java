import java.util.HashMap;
import java.util.ArrayList;

public class SemanticAnalyzer {

    private HashMap<String, SymbolItem> symbolsTable;

    public SemanticAnalyzer(){
        symbolsTable = new HashMap<String, SymbolItem>();
    }

    public void ExecuteOperation(String operation, ArrayList<GrammarSymbol> lexemas, GrammarSymbol symbol) throws Exception{
        switch (operation) {
            case "save_int_in_st":
            case "save_boolean_in_st":
                saveInSymbolTable(operation, lexemas, ((Lexema)lexemas.get(4)).getSymbol());    
            break;

            case "set_val":
                setBooleanVal(lexemas, symbol);
            break;
        
            default:
                break;
        }
    }

    private void setBooleanVal(ArrayList<GrammarSymbol> lexemas, GrammarSymbol symbol){
        ((NonTerminalSymbol)symbol).getAttributes().put("value", ((Lexema)lexemas.get(0)).getValue().toString());
    }

    private void saveInSymbolTable(String operation, ArrayList<GrammarSymbol> lexemas, String variableType) throws Exception{

        String id = ((Lexema)lexemas.get(3)).getValue();
        int function = SymbolItem.VARIABLE;
        int scope = SymbolItem.GLOBAL;
        int memoryAddress = 0;
        Object value = null;
        int type = 0;

        switch (variableType) {
            case "int":
                type = SymbolItem.INT;
                value = ((Lexema)lexemas.get(1)).getValue();
            break;
        
            case "boolean":
                type = SymbolItem.BOOLEAN;
                value = ((NonTerminalSymbol)lexemas.get(1)).getAttributes().get("value");
            break;
            default:
                break;
        }
        
        SymbolItem newSymbolItem = new SymbolItem(id, function, type, scope, memoryAddress, value);

        if (!symbolsTable.containsKey(id)){ //Symbolo no existe
            symbolsTable.put(id, newSymbolItem);
        } else { //Simbolo encontrado
            throw new Exception("Simbolo " + id + " ya existe");
        }
    }
    
}