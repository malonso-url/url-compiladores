package edu.url;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Parser implements IParser{

    public Parser(){
        init();
    }

    private void init(){
        // Creación del HashMap
        Map<String, Map<String, List<TokenSymbol>>> parsingTable = new HashMap<>();

        // Añadiendo reglas al HashMap
        parsingTable.put("<S>", new HashMap<>());
        parsingTable.get("<S>").put("num", List.of(new TokenSymbol("NT", "<E>"), new TokenSymbol("T", "$")));
        parsingTable.get("<S>").put("lpar", List.of(new TokenSymbol("NT", "<E>"), new TokenSymbol("T", "$")));

        parsingTable.put("<E>", new HashMap<>());
        parsingTable.get("<E>").put("num", List.of(new TokenSymbol("NT", "<T>"), new TokenSymbol("NT", "<A>")));
        parsingTable.get("<E>").put("lpar", List.of(new TokenSymbol("NT", "<T>"), new TokenSymbol("NT", "<A>")));

        parsingTable.put("<A>", new HashMap<>());
        parsingTable.get("<A>").put("suma", List.of(new TokenSymbol("T", "suma"), new TokenSymbol("NT", "<T>"), new TokenSymbol("NT", "<A>")));
        parsingTable.get("<A>").put("resta", List.of(new TokenSymbol("T", "resta"), new TokenSymbol("NT", "<T>"), new TokenSymbol("NT", "<A>")));
        parsingTable.get("<A>").put("rpar", List.of());
        parsingTable.get("<A>").put("$", List.of());

        parsingTable.put("<T>", new HashMap<>());
        parsingTable.get("<T>").put("num", List.of(new TokenSymbol("NT", "<F>"), new TokenSymbol("NT", "<B>")));
        parsingTable.get("<T>").put("lpar", List.of(new TokenSymbol("NT", "<F>"), new TokenSymbol("NT", "<B>")));

        parsingTable.put("<B>", new HashMap<>());
        parsingTable.get("<B>").put("multiplicacion", List.of(new TokenSymbol("T", "multiplicacion"), new TokenSymbol("NT", "<F>"), new TokenSymbol("NT", "<B>")));
        parsingTable.get("<B>").put("division", List.of(new TokenSymbol("T", "division"), new TokenSymbol("NT", "<F>"), new TokenSymbol("NT", "<B>")));
        parsingTable.get("<B>").put("suma", List.of());
        parsingTable.get("<B>").put("resta", List.of());
        parsingTable.get("<B>").put("rpar", List.of());
        parsingTable.get("<B>").put("$", List.of());

        parsingTable.put("<F>", new HashMap<>());
        parsingTable.get("<F>").put("num", List.of(new TokenSymbol("T", "num")));
        parsingTable.get("<F>").put("lpar", List.of(new TokenSymbol("T", "lpar"), new TokenSymbol("NT", "<E>"), new TokenSymbolSymbol("T", "rpar")));
    }


    @Override
    public boolean validateExpresion(List<TokenSymbol> tokens) throws Exception{
        Stack<TokenSymbol> parsinStack = new Stack<>();
        parsinStack.push(new TokenSymbol("<S>", "<S>"));
        while (!tokens.isEmpty() && parsinStack.peek().equals("$")) {
            
        }
        return false;
    }

    @Override
    public List<String> getActionsList(List<TokenSymbol> tokens) throws Exception{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActionsList'");
    }
    
}
