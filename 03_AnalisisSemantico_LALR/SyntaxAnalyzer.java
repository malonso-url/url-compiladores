import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SyntaxAnalyzer {

    public static final int RESULT_ACCEPT = 0;
    public static final int RESULT_FAILED = 1;
    
    private HashMap<Integer, HashMap<String, Operation>> parsingTable;
    private HashMap<Integer, Production> productions;
    private Stack<ParsingItem> parsingStack;

    public SyntaxAnalyzer(){
        createProductions();
        createParsingTable();        
        parsingStack = new Stack<ParsingItem>();
    } 

    private void createProductions(){
        productions = new HashMap<Integer, Production>();
        productions.put(1, new Production("<var>", "int","id","=","num","n_var"));
        productions.get(1).setActions("save_int_in_st");
        productions.put(2, new Production("<var>", "boolean","id","=","<b_opt>","n_var"));
        productions.get(2).setActions("save_boolean_in_st");
        productions.put(3, new Production("<n_var>", ";","<var>"));
        productions.put(4, new Production("<n_var>", "ε"));
        productions.put(5, new Production("<b_opt>", "true"));
        productions.put(6, new Production("<b_opt>", "false"));
    }

    private void createParsingTable(){
        parsingTable = new HashMap<Integer, HashMap<String, Operation>>();

        //Adding states
        for (int i = 0; i <= 15; i++ ){
            parsingTable.put(i, new HashMap<String, Operation>());
        }
        
        //Adding 0
        parsingTable.get(0).put("int", new Operation(Operation.SHIFT, 2));
        parsingTable.get(0).put("boolean", new Operation(Operation.SHIFT, 3)); 
        parsingTable.get(0).put("<var>", new Operation(Operation.GOTO, 1));

        //Adding 1
        parsingTable.get(1).put("$", new Operation(Operation.ACCEPT, 1));

        //Adding 2
        parsingTable.get(2).put("id", new Operation(Operation.SHIFT, 4));

        //Adding 3
        parsingTable.get(3).put("id", new Operation(Operation.SHIFT, 5));

        //Adding 4
        parsingTable.get(4).put("=", new Operation(Operation.SHIFT, 6));

        //Adding 5
        parsingTable.get(5).put("=", new Operation(Operation.SHIFT, 7));

        //Adding 6
        parsingTable.get(6).put("num", new Operation(Operation.SHIFT, 8));

        //Adding 7
        parsingTable.get(7).put("true", new Operation(Operation.SHIFT, 10));
        parsingTable.get(7).put("false", new Operation(Operation.SHIFT, 11));
        parsingTable.get(7).put("<b_opt>", new Operation(Operation.GOTO, 9));

        //Adding 8
        parsingTable.get(8).put(";", new Operation(Operation.SHIFT, 13));
        parsingTable.get(8).put("$", new Operation(Operation.REDUCE, 4));
        parsingTable.get(8).put("<n_var>", new Operation(Operation.GOTO, 12));

        //Adding 9
        parsingTable.get(9).put(";", new Operation(Operation.SHIFT, 13));
        parsingTable.get(9).put("$", new Operation(Operation.REDUCE, 4));
        parsingTable.get(9).put("<n_var>", new Operation(Operation.GOTO, 14));

        //Adding 10
        parsingTable.get(10).put(";", new Operation(Operation.REDUCE, 5));
        parsingTable.get(10).put("$", new Operation(Operation.REDUCE, 5));

        //Adding 11
        parsingTable.get(11).put(";", new Operation(Operation.REDUCE, 6));
        parsingTable.get(11).put("$", new Operation(Operation.REDUCE, 6));

        //Adding 12
        parsingTable.get(12).put("$", new Operation(Operation.REDUCE, 1));

        //Adding 13
        parsingTable.get(13).put("int", new Operation(Operation.SHIFT, 2));
        parsingTable.get(13).put("boolean", new Operation(Operation.SHIFT, 3));
        parsingTable.get(13).put("<var>", new Operation(Operation.GOTO, 15));

        //Adding 14
        parsingTable.get(14).put("$", new Operation(Operation.REDUCE, 2));

        //Adding 15
        parsingTable.get(15).put("$", new Operation(Operation.REDUCE, 3));
    }
    
    public int parse(ArrayList<Lexema> tokens){
        //Starting with the stack
        parsingStack.push(new ParsingItem("0", ParsingItem.STATE));

        for (Lexema token : tokens){

  
            //top of stack is state
            if (parsingStack.peek().getType() == ParsingItem.STATE){
                Operation toDo = parsingTable.get(Integer.parseInt(parsingStack.peek().getSymbol())).get(token.getSymbol());
                if (toDo != null){
                    if (toDo.getType() == Operation.SHIFT){
                        parsingStack.push( new ParsingItem(token.getSymbol(), ParsingItem.TERMINAL) );
                        parsingStack.push( new ParsingItem("" + toDo.getState(), ParsingItem.STATE ) );
                    } else if (toDo.getType() == Operation.REDUCE){
                        Production prod = productions.get(toDo.getProduction());
                        int index = prod.getSymbols().length - 1;
                        while (index >= 0) { //remove the symbols from the stack

                            if (prod.getSymbols()[index].equals("ε")){
                                index--;
                            } else {
                                parsingStack.pop(); //remove the state
                                ParsingItem symbol = parsingStack.pop(); //removes the symbol
                                
                                if (symbol.getSymbol().equals(prod.getSymbols()[index])){
                                    parsingStack.pop();
                                    index--;
                                } else {
                                    return RESULT_FAILED;
                                }

                            }
                        }
                        parsingStack.push(new ParsingItem(prod.getNonTerminalKey(), ParsingItem.NONTERMINAL));

                    } else if (toDo.getType() == Operation.ACCEPT){
                        return RESULT_ACCEPT;
                    } else {
                        return RESULT_FAILED;
                    }

                } else {
                    return RESULT_FAILED;
                }

            } else if (parsingStack.peek().getType() == ParsingItem.NONTERMINAL){

                //Need to find a GoTo
                ParsingItem nonTerminal = parsingStack.pop();
                ParsingItem lastState = parsingStack.pop();
                Operation toDo = parsingTable.get(Integer.parseInt(lastState.getSymbol())).get(nonTerminal.getSymbol());

                if (toDo != null){
                    if (toDo.getType() == Operation.GOTO){
                        parsingStack.push(lastState);
                        parsingStack.push(nonTerminal);
                        parsingStack.push(new ParsingItem("" + toDo.getState(), ParsingItem.STATE));
                    } else {
                        return RESULT_FAILED;
                    }

                } else {
                    return RESULT_FAILED;
                }

            } else {
                return RESULT_FAILED;
            }
            //top of stack is non-terminal

        }

        return RESULT_ACCEPT;
    }

}
