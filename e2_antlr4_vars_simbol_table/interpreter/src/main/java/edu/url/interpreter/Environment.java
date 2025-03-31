package edu.url.interpreter;

import edu.url.antlr.variablesBaseVisitor;
import edu.url.antlr.variablesParser.AexprContext;
import edu.url.antlr.variablesParser.AssignexprContext;
import edu.url.antlr.variablesParser.BexprContext;
import edu.url.antlr.variablesParser.BoolvarContext;
import edu.url.antlr.variablesParser.BtermContext;
import edu.url.antlr.variablesParser.ExpressionsContext;
import edu.url.antlr.variablesParser.FactorContext;
import edu.url.antlr.variablesParser.IntvarContext;
import edu.url.antlr.variablesParser.IoexprContext;
import edu.url.antlr.variablesParser.StartContext;
import edu.url.antlr.variablesParser.TermContext;
import edu.url.antlr.variablesParser.VarsContext;

public class Environment extends variablesBaseVisitor<BasicProgram> {

    private BasicProgram interpreterProgram;
    public Environment(){
        interpreterProgram = new BasicProgram();
    }

    @Override
    public BasicProgram visitAexpr(AexprContext ctx) {
        // TODO Auto-generated method stub
        return super.visitAexpr(ctx);
    }

    @Override
    public BasicProgram visitAssignexpr(AssignexprContext ctx) {
        // TODO Auto-generated method stub
        return super.visitAssignexpr(ctx);
    }

    @Override
    public BasicProgram visitBexpr(BexprContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBexpr(ctx);
    }

    @Override
    public BasicProgram visitBoolvar(BoolvarContext ctx) {
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
    public BasicProgram visitBterm(BtermContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBterm(ctx);
    }

    @Override
    public BasicProgram visitExpressions(ExpressionsContext ctx) {
        // TODO Auto-generated method stub
        return super.visitExpressions(ctx);
    }

    @Override
    public BasicProgram visitFactor(FactorContext ctx) {
        // TODO Auto-generated method stub
        return super.visitFactor(ctx);
    }

    @Override
    public BasicProgram visitIntvar(IntvarContext ctx) {
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
    public BasicProgram visitIoexpr(IoexprContext ctx) {
        // TODO Auto-generated method stub
        return super.visitIoexpr(ctx);
    }

    @Override
    public BasicProgram visitStart(StartContext ctx) {
        System.out.println("Interpreter start...");
        for (int i = 0; i < ctx.vars().size(); i++){
            visit(ctx.vars(i));
        }

        return interpreterProgram;
    }

    @Override
    public BasicProgram visitTerm(TermContext ctx) {
        // TODO Auto-generated method stub
        return super.visitTerm(ctx);
    }

    @Override
    public BasicProgram visitVars(VarsContext ctx) {
        System.out.println("Analizying Vars Section");
        return visit(ctx.getChild(0)); //Puede ser intVar o boolVar
    }
    
}
