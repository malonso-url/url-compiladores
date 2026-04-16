package edu.url.compiladores;

/**
 * Represents a variable entry in the symbol table.
 */
public class Variable {

    private final String name;
    private final String value;
    private final String type;
    private final String scope;

    public Variable(String name, String value, String type, String scope) {
        this.name  = name;
        this.value = value;
        this.type  = type;
        this.scope = scope;
    }

    public String getName()  { return name;  }
    public String getValue() { return value; }
    public String getType()  { return type;  }
    public String getScope() { return scope; }

    @Override
    public String toString() {
        return String.format("%-15s %-10s %-10s %-10s", name, value, type, scope);
    }
}
