package edu.url.compiladores;

import edu.url.compiladores.antlr.ExprBaseVisitor;
import edu.url.compiladores.antlr.ExprParser;

public class EvalVisitor extends ExprBaseVisitor<Void> {

    @Override
    public Void visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.IDENTIFICADOR().getText();
        String value = ctx.INT().getText();

        System.out.println("Asignación encontrada:");
        System.out.println("  Variable: " + id);
        System.out.println("  Valor   : " + value);

        return null;
    }

    @Override
    public Void visitExpr(ExprParser.ExprContext ctx) {

        if (ctx.INT() != null) {
            System.out.println("Entero: " + ctx.INT().getText());
        }
        else if (ctx.IDENTIFICADOR() != null) {
            System.out.println("Identificador: " + ctx.IDENTIFICADOR().getText());
        }
        else if (ctx.getChildCount() == 3) {
            System.out.println(
                "Expresión: " +
                ctx.getChild(0).getText() + " " +
                ctx.getChild(1).getText() + " " +
                ctx.getChild(2).getText()
            );
        }

        return visitChildren(ctx);
    }
}