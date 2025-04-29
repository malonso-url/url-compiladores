package edu.url.interpreter;

import java.util.ArrayList;

import edu.url.antlr.variablesBaseVisitor;

import edu.url.antlr.variablesParser.BoolvarContext;
import edu.url.antlr.variablesParser.Code_declarationContext;
import edu.url.antlr.variablesParser.ExpressionsContext;
import edu.url.antlr.variablesParser.FooterContext;
import edu.url.antlr.variablesParser.HeaderContext;
import edu.url.antlr.variablesParser.IntvarContext;
import edu.url.antlr.variablesParser.IoexprContext;
import edu.url.antlr.variablesParser.StartContext;
import edu.url.antlr.variablesParser.VarsContext;

public class Environment extends variablesBaseVisitor<VariableSegment> {

    private VariableSegment interpreterProgram;
    private String programa;
    public Environment(String programa){
        interpreterProgram = new VariableSegment();
        this.programa = programa;
    }

    
    

    

    @Override
    public VariableSegment visitBoolvar(BoolvarContext ctx) {
        System.out.println("Saving Bool var");
        //Debido a que la regla es
        // boolvar: '$bool' ID '=' ('$true'|'$false')?
        // Me interesa el children(1) que es el ID y el children(3) que es el valor
        Variable<Boolean> boolVar = new Variable<>(
            ctx.getChild(1).toString()
            , ctx.getChild(3).toString().equals("$true")
            , 0);
        
        interpreterProgram.getBoolVariables().put(ctx.getChild(1).toString(), boolVar);

        programa += "\r\npublic static boolean " + ctx.getChild(1).toString() + " = " + ctx.getChild(3).toString().equals("$true") + ";";
            
        return super.visitBoolvar(ctx);
    }

    

    @Override
    public VariableSegment visitCode_declaration(Code_declarationContext ctx) {
        
        programa += "\r\npublic static void main(String[] args){";

        //Visito las declaraciones dentro de code
        for (int i = 0; i < ctx.children.size(); i++){
            visit(ctx.getChild(i));
        }

        programa += "\r\n}";

        return interpreterProgram;
    }






    @Override
    public VariableSegment visitHeader(HeaderContext ctx) {
        // Adding the name of the program
        programa += "public class " + ctx.getChild(1).toString() + "{\r\n";
        return super.visitHeader(ctx);
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

        //Como se que es un int, le coloco de una vez int
        programa += "\r\npublic static int " + ctx.getChild(1).toString() + " = " + ctx.getChild(3).toString() + ";";
            
        return super.visitIntvar(ctx);
    }

    

    @Override
    public VariableSegment visitStart(StartContext ctx) {
        System.out.println("Interpreter start...");

        visit(ctx.header());

        for (int i = 0; i < ctx.vars().size(); i++){
            visit(ctx.vars(i));
        }

        visit(ctx.code_declaration());
        
        visit(ctx.footer());
        System.out.println(programa);

        return interpreterProgram;
    }

    


    @Override
    public VariableSegment visitFooter(FooterContext ctx) {
        //Voy a realizar la visita al footer
        programa += "\r\n}";
        return interpreterProgram;
    }






    @Override
    public VariableSegment visitVars(VarsContext ctx) {
        System.out.println("Analizying Vars Section");
        return visit(ctx.getChild(0)); //Puede ser intVar o boolVar
    }






    @Override
    public VariableSegment visitExpressions(ExpressionsContext ctx) {
        
        return visit(ctx.getChild(0));
    }






    @Override
    public VariableSegment visitIoexpr(IoexprContext ctx) {
        if (ctx.getChild(0).toString().equals("$write")){ //operacion de escritura
            programa += "\r\nSystem.out.println(" + ctx.getChild(1).toString() + ");";
        } else { //operacion de lectura

        }
        return super.visitIoexpr(ctx);
    }
    
    
}
