package edu.url.interpreter;

import java.util.ArrayList;

import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.url.antlr.variablesBaseVisitor;
import edu.url.antlr.variablesParser.AexprContext;
import edu.url.antlr.variablesParser.AssignexprContext;
import edu.url.antlr.variablesParser.BexprContext;
import edu.url.antlr.variablesParser.BoolvarContext;
import edu.url.antlr.variablesParser.BtermContext;
import edu.url.antlr.variablesParser.Code_declarationContext;
import edu.url.antlr.variablesParser.ExpressionsContext;
import edu.url.antlr.variablesParser.FactorContext;
import edu.url.antlr.variablesParser.FooterContext;
import edu.url.antlr.variablesParser.HeaderContext;
import edu.url.antlr.variablesParser.IntvarContext;
import edu.url.antlr.variablesParser.IoexprContext;
import edu.url.antlr.variablesParser.StartContext;
import edu.url.antlr.variablesParser.TermContext;
import edu.url.antlr.variablesParser.VarsContext;

public class Environment extends variablesBaseVisitor<VariableSegment> {

    private VariableSegment interpreterProgram;
    public String programa;
    public String nombre_programa;
    public Environment(String programa, String nombre_programa){
        interpreterProgram = new VariableSegment();
        this.programa = programa;
        this.nombre_programa = nombre_programa;
    }


    /***
     * METODOS NECESARIOS PARA LA DECLARACION DE VARIABLES
     */

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
            
        return interpreterProgram;
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
            
        return interpreterProgram;
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
    /***
     * Metodo necesario para iniciar la visita a los nodos
     */
    public VariableSegment visitHeader(HeaderContext ctx) {
        // Adding the name of the program
        programa += "public class " + ctx.getChild(1).toString() + "{\r\n";
        nombre_programa = "" + ctx.getChild(1).toString();
        return super.visitHeader(ctx);
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
        //System.out.println(programa);

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
        return interpreterProgram;
    }


    /***
     * METODOS NECESARIOS PARA LAS OPERACIONES ARITMETICAS
     */

    @Override
    public VariableSegment visitAexpr(AexprContext ctx) {
        System.out.println("Visit aritmetic expression");
        for (int i = 0; i < ctx.children.size(); i++){
            String simbolo = ctx.getChild(i).toString();
            System.out.println("Simbolo " + simbolo);
            if ("+-".contains(simbolo)){
                programa += " " + simbolo + " ";
            } else {
                visit(ctx.getChild(i));
            }
        }

        return null;
    }


    @Override
    public VariableSegment visitAssignexpr(AssignexprContext ctx) {
        System.out.println("Visit assignment expresion: " + ctx.getChild(0).toString());
        programa += "\r\n" + ctx.getChild(0).toString() + " = "; //El nombre de la variable
        visit(ctx.getChild(2)); //Visita la aexpr o bexpr
        programa += ";"; //agrega el ;
        return null;
    }


    @Override
    public VariableSegment visitFactor(FactorContext ctx) {
        System.out.println("visit factor");
        // Factor puede ser ID, INT o aexpr, en el ultimo caso validar con parentesis
        if (ctx.ID() != null){ //Es un id
            String localvar = ctx.getChild(0).toString();

            //Validar que la variable exista

            programa += " " + localvar;
        } else if (ctx.INT() != null){ //Es un num
            programa += " " + ctx.getChild(0).toString();
        } else { //Es una aexpr
            for (int i = 0; i < ctx.children.size(); i++){
                String simbolo = ctx.getChild(i).toString();
                System.out.println("Simbolo " + simbolo);
                if ("()".contains(simbolo)){
                    programa += " " + simbolo + " ";
                } else {
                    visit(ctx.getChild(i));
                }
            }
        }

        return null;
    }


    @Override
    public VariableSegment visitTerm(TermContext ctx) {
        
        for (int i = 0; i < ctx.children.size(); i++){
            String simbolo = ctx.getChild(i).toString();

            if ("*/".contains(simbolo)){
                programa += " " + simbolo + " ";
            } else {
                visit(ctx.getChild(i));
            }
        }

        return null;
    }

    //En esta seccion se programa para las boolean expression

    @Override
    public VariableSegment visitBexpr(BexprContext ctx) {
        for (int i = 0; i < ctx.children.size(); i++){
            String simbolo = ctx.getChild(i).toString();

            if (simbolo.equals("$not")){
                programa += " !";
            } else if (simbolo.equals("$and")){
                programa += " && ";
            } if (simbolo.equals("$or")){
                programa += " || ";
            } else {
                visit(ctx.getChild(i));
            }
        }
        return null;
    }


    @Override
    public VariableSegment visitBterm(BtermContext ctx) {
        
        for (int i = 0; i < ctx.children.size(); i++){
            String simbolo = ctx.getChild(i).toString();
            
            if (ctx.ID() != null){ //Es un id debo guardarlo
                programa += " " + simbolo + " ";
            } else if (simbolo.equals("$true")){ //Viene un true
                programa += " true ";
            } else if (simbolo.equals("$false")){ //Viene un true
                programa += " false ";
            } else if ("()=><=><=".contains(simbolo)){ //Es un simbolo
                programa += " " + simbolo + " ";
            } else {
                visit(ctx.getChild(i));
            }
        }

        return null;
    }
    
    
    
    

}
