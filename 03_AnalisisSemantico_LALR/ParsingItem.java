public class ParsingItem {

    public static final int TERMINAL = 0;
    public static final int NONTERMINAL = 1;
    public static final int STATE = 2;

    private Object symbol;
    private int type;

    public ParsingItem(Object symbol, int type){
        setSymbol(symbol);
        setType(type);
    }

    public Object getSymbol() {
        return symbol;
    }
    public void setSymbol(Object symbol) {
        this.symbol = symbol;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    
}
