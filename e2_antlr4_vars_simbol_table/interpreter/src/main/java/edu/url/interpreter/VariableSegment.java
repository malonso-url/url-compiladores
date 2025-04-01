package edu.url.interpreter;

import java.util.Map;
import java.util.TreeMap;

public class VariableSegment {
    private Map<String, Variable<Boolean>> boolVariables;
    private Map<String, Variable<Integer>> intVariables;

    public VariableSegment(){
        boolVariables = new TreeMap<>();
        intVariables = new TreeMap<>();
    }

    public Map<String, Variable<Boolean>> getBoolVariables() {
        return boolVariables;
    }

    public Map<String, Variable<Integer>> getIntVariables() {
        return intVariables;
    }

}
