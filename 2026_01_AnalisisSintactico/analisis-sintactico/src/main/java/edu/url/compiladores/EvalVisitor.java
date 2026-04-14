package edu.url.compiladores;

import edu.url.compiladores.antlr.ExprBaseVisitor;
import edu.url.compiladores.antlr.ExprParser;
import edu.url.compiladores.antlr.ExprParser.ProgContext;

public class EvalVisitor extends ExprBaseVisitor<Void> {

    

    @Override
    public Void visitProg(ProgContext ctx) {
        
        System.out.println("public class Ejemplo1 { public static void main(String[] args) {");
        super.visitProg(ctx);
        System.out.println("} }");
        return null;
    }

    @Override
    public Void visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.IDENTIFICADOR().getText();
        String value = ctx.INT().getText();

        //System.out.println("Asignación encontrada:");
        //System.out.println("  Variable: " + id);
        //System.out.println("  Valor   : " + value);
        System.out.println("int " + id + " = " + value + ";");

        return null;
    }

    // Production: expr ('*'|'/') expr   #MulDiv
    @Override
    public Void visitMulDiv(ExprParser.MulDivContext ctx) {

        System.out.println(
            ctx.expr(0).getText() + " " +
            ctx.getChild(1).getText() + " " +
            ctx.expr(1).getText() + ";"
        );
        return visitChildren(ctx);
    }

    // Production: expr ('+'|'-') expr   #AddSub
    @Override
    public Void visitAddSub(ExprParser.AddSubContext ctx) {
        System.out.println(
            ctx.expr(0).getText() + " " +
            ctx.getChild(1).getText() + " " +
            ctx.expr(1).getText() + ";"
        );
        return visitChildren(ctx);
    }

    // Production: INT   #IntLiteral
    @Override
    public Void visitIntLiteral(ExprParser.IntLiteralContext ctx) {
        // System.out.println("Entero: " + ctx.INT().getText());
        return null; // leaf node, no children to visit
    }

    // Production: '(' expr ')'   #Parens
    @Override
    public Void visitParens(ExprParser.ParensContext ctx) {
        return visitChildren(ctx); // visit the inner expr
    }

    // Production: IDENTIFICADOR   #Id
    @Override
    public Void visitId(ExprParser.IdContext ctx) {
        // System.out.println("Identificador: " + ctx.IDENTIFICADOR().getText());
        return null; // leaf node, no children to visit
    }
}