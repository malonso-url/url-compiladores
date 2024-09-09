public class Lexema {
    private String symbol;
    private String value;

    public Lexema(String symbol, String value){
        setSymbol(symbol);
        setValue(value);
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    
}
