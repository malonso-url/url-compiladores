public class ParsingItem {

    public static final int TERMINAL = 0;
    public static final int NONTERMINAL = 1;
    public static final int STATE = 2;

    private String symbol;
    private int type;

    public ParsingItem(String symbol, int type){
        setSymbol(symbol);
        setType(type);
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    
}
