package edu.url;

public class TokenSymbol {
    private String type;
    private String symbol;
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    private String value;

    public TokenSymbol(String type, String value, String symbol){
        setType(type);
        setValue(value);
        setSymbol(symbol);
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
