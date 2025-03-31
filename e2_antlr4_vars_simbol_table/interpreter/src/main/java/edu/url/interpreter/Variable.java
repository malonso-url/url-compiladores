package edu.url.interpreter;

public class Variable<T> {
    private String name;
    private T value;
    private int scope;

    public Variable(String name, T value, int scope){
        setName(name);
        setValue(value);
        setScope(scope);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public int getScope() {
        return scope;
    }
    public void setScope(int scope) {
        this.scope = scope;
    }

    
}
