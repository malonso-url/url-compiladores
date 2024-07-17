package src;

import java.util.ArrayList;
import java.util.Stack;


/***
 * This class parse an expression using a Pushdown Automata, the grammer used is:
 * 
    G = (V, Σ, R, S)
    V = { E, E', T, T', F }
    Σ = { +, -, *, /, (, ), id }
    R:
    E  → T E'
    E' → + T E' | - T E' | ε
    T  → F T'
    T' → * F T' | / F T' | ε
    F  → ( E ) | id
    S = E
    
 */
public class SintaxAnalizer {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    Stack<String> internalStack;

    public int parse(ArrayList<String> tokens) throws Exception{
        internalStack = new Stack<String>();
        internalStack.push("E");

        while (!tokens.isEmpty()) {
            String lookAhead = tokens.get(0);

            switch (internalStack.peek()) {
                case "(":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case ")":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case "+":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case "-":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case "*":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case "/":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case "number":{
                    if (internalStack.peek().equals(lookAhead)){
                        tokens.remove(0);
                        internalStack.pop();
                    } else {
                        throw new Exception("Expected: " + internalStack.peek() + " but found: " + lookAhead);
                    }
                }break;

                case "E":{
                    internalStack.pop();
                    internalStack.push("G");
                    internalStack.push("T");
                }break;

                case "G":{
                    if (lookAhead.equals("+")){
                        internalStack.pop();
                        internalStack.push("G");
                        internalStack.push("T");
                        internalStack.push("+");
                    } else if (lookAhead.equals("-")){
                        internalStack.pop();
                        internalStack.push("G");
                        internalStack.push("T");
                        internalStack.push("-");
                    } else {
                        internalStack.pop();
                    }

                }break;

                case "T":{
                    internalStack.pop();
                    internalStack.push("H");
                    internalStack.push("F");
                }break;

                case "H":{
                    if (lookAhead.equals("*")){
                        internalStack.pop();
                        internalStack.push("H");
                        internalStack.push("F");
                        internalStack.push("*");
                    } else if (lookAhead.equals("/")){
                        internalStack.pop();
                        internalStack.push("H");
                        internalStack.push("F");
                        internalStack.push("/");
                    } else {
                        internalStack.pop();
                    }
                }break;

                case "F":{
                    if (lookAhead.equals("(")){
                        internalStack.pop();
                        internalStack.push(")");
                        internalStack.push("E");
                        internalStack.push("(");
                    } else if (lookAhead.equals("number")){
                        internalStack.pop();
                        internalStack.push("number");
                    } else {
                        throw new Exception("Symbol not found: " + internalStack.peek());
                    }
                }break;
            
                default:
                    throw new Exception("Symbol not found: " + internalStack.peek());
            }

        }

        //Stack must be empty if success operation, remove all Non-Terminals that produce empty string
        while (!internalStack.isEmpty()) {
            switch (internalStack.peek()) {
                case "G":
                    internalStack.pop();
                    break;

                case "H":
                    internalStack.pop();
                    break;
            
                default:
                    throw new Exception("Incorrect sintax");
            }
        }

        if (internalStack.isEmpty())
            return SUCCESS;
        else
            return ERROR;
    }
}
