package edu.url.interpreter;

import edu.url.antlr.variablesBaseVisitor;
import edu.url.antlr.variablesParser.ExpressionsContext;
import edu.url.antlr.variablesParser.IoexprContext;
import edu.url.antlr.variablesParser.StartContext;

public class IOHandler extends variablesBaseVisitor<String>{

    VariableSegment actualEnvironment;
    public IOHandler(VariableSegment actualEnvironment){
        this.actualEnvironment = actualEnvironment;
    }

    @Override
    public String visitExpressions(ExpressionsContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public String visitIoexpr(IoexprContext ctx) {

        String nombreVariable = ctx.getChild(1).toString();
        if (actualEnvironment.getBoolVariables().containsKey(nombreVariable)){
            System.out.println("variable booleana nombre: " + nombreVariable + " valor: " + actualEnvironment.getBoolVariables().get(nombreVariable).getValue());
        } else if (actualEnvironment.getIntVariables().containsKey(nombreVariable)){
            System.out.println("variable entera nombre: " + nombreVariable + " valor: " + actualEnvironment.getIntVariables().get(nombreVariable).getValue());
        } else {
            System.out.println("variable no declarada");
        }
        
        return "";
    }

    @Override
    public String visitStart(StartContext ctx) {
        /*for (int i = 0; i < ctx.expressions().size(); i++){
            visit(ctx.expressions(i));
        }*/
        return "";
    }
    
}
