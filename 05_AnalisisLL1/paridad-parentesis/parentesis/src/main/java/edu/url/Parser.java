package edu.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Parser {

    Map<String, Map<String, List<TokenSymbol>>> parsingTable = new HashMap<>();

    public Parser(){
        init();
    }

    private void init(){
        
        // Añadiendo reglas al HashMap

        parsingTable.put("<S>", new HashMap<>());
        parsingTable.get("<S>").put("(", List.of(new TokenSymbol("NON-TERMINAL", "<B>", "<B>"), new TokenSymbol("TERMINAL", "$", "$")));

        parsingTable.put("<B>", new HashMap<>());
        parsingTable.get("<B>").put("(", List.of(new TokenSymbol("TERMINAL", "(", "("), new TokenSymbol("NON-TERMINAL", "<R>", "<R>"), new TokenSymbol("NON-TERMINAL", "<B>", "<B>")));
        parsingTable.get("<B>").put("$", new ArrayList<>());

        parsingTable.put("<R>", new HashMap<>());
        parsingTable.get("<R>").put("(", List.of(new TokenSymbol("TERMINAL", "(", "("), new TokenSymbol("NON-TERMINAL", "<R>", "<R>"), new TokenSymbol("NON-TERMINAL", "<R>", "<R>")));
        parsingTable.get("<R>").put(")", List.of(new TokenSymbol("TERMINAL", ")", ")")));

        /* 
         * <S>::= <B> $ 
         * Non-Terminal	        "("	                    ")"	            $
         * <B>	                <B> ::= "(" <R> <B>	        	        <B> ::= 𝜀
         * <R>	                <R> ::= "(" <R> <R>	    <R> ::= ")"	    (No se aplica)
        */
    }

    public boolean isValidCode(ArrayList<TokenSymbol> tokens) throws Exception{
        
        Stack<TokenSymbol> stackTool = new Stack<>();
        stackTool.push(new TokenSymbol("NON-TERMINAL", "<S>", "<S>"));  //simbolo inicial
        int index = 0;

        while(index < tokens.size()){
            TokenSymbol nexTokenSymbol = tokens.get(index);

            if (stackTool.peek().getType().equals("NON-TERMINAL")){
                //Hacer esto solo si lo que está en el top del stack es un NON-TERMINAL
            List<TokenSymbol> production = parsingTable.get(stackTool.peek().getSymbol()).get(nexTokenSymbol.getSymbol());

            if (production != null){
                stackTool.pop();
                for (int i = production.size() - 1; i >= 0; i--){
                    stackTool.push(production.get(i));
                }

                } else {
                    throw new Exception("Simbolo: " + nexTokenSymbol.getSymbol() + " Incorrecto ");
                }
            } else {
                //Hacer esto solo si lo que está en el top del stack es un TERMINAL
                if (nexTokenSymbol.getSymbol().equals(stackTool.peek().getSymbol())){ //Son igual entonces ACCEPT
                    index++;
                    stackTool.pop();
                } else { //No son iguales entonces Fail
                    throw new Exception("Error en simbolo: " + nexTokenSymbol.getSymbol() + " se esperaba: " + stackTool.peek().getSymbol());
                }
            }

        }

        return stackTool.isEmpty();
    }
}
