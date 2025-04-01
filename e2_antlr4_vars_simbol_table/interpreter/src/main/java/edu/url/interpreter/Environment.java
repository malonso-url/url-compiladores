package edu.url.interpreter;

import edu.url.antlr.variablesBaseVisitor;

import edu.url.antlr.variablesParser.BoolvarContext;
import edu.url.antlr.variablesParser.IntvarContext;
import edu.url.antlr.variablesParser.StartContext;
import edu.url.antlr.variablesParser.VarsContext;

public class Environment extends variablesBaseVisitor<VariableSegment> {

    private VariableSegment interpreterProgram;
    public Environment(){
        interpreterProgram = new VariableSegment();
    }

    
    

    

    @Override
    public VariableSegment visitBoolvar(BoolvarContext ctx) {
        System.out.println("Saving Bool var");
        //Debido a que la regla es
        // boolvar: '$bool' ID '=' ('$true'|'$false')?
        // Me interesa el children(1) que es el ID y el children(3) que es el valor
        Variable<Boolean> intVar = new Variable<>(
            ctx.getChild(1).toString()
            , ctx.getChild(3).toString().equals("$true")
            , 0);
        
        interpreterProgram.getBoolVariables().put(ctx.getChild(1).toString(), intVar);
            
        return super.visitBoolvar(ctx);
    }

    @Override
    public VariableSegment visitIntvar(IntvarContext ctx) {
        System.out.println("Saving int var");
        //Debido a que la regla es
        // intvar: '$int' ID '=' INT
        // Me interesa el children(1) que es el ID y el children(3) que es el valor
        Variable<Integer> intVar = new Variable<>(
            ctx.getChild(1).toString()
            , Integer.parseInt(ctx.getChild(3).toString())
            , 0);
        
        interpreterProgram.getIntVariables().put(ctx.getChild(1).toString(), intVar);
            
        return super.visitIntvar(ctx);
    }

    

    @Override
    public VariableSegment visitStart(StartContext ctx) {
        System.out.println("Interpreter start...");
        for (int i = 0; i < ctx.vars().size(); i++){
            visit(ctx.vars(i));
        }

        return interpreterProgram;
    }


    @Override
    public VariableSegment visitVars(VarsContext ctx) {
        System.out.println("Analizying Vars Section");
        return visit(ctx.getChild(0)); //Puede ser intVar o boolVar
    }
    
}
