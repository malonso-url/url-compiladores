package edu.url;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.url.antlr.EjemploGood2BaseVisitor;
import edu.url.antlr.EjemploGood2Parser;

public class Evaluador extends EjemploGood2BaseVisitor<Integer> {

    @Override
    public Integer visitStart(EjemploGood2Parser.StartContext ctx) {
        System.out.println("Visit: Start");
        return visit(ctx.expr()); // Inicia la evaluación
    }

    @Override
    public Integer visitExpr(EjemploGood2Parser.ExprContext ctx) {
        int value = visit(ctx.term(0)); // Primer término
        for (int i = 1; i < ctx.term().size(); i++) {
            value += visit(ctx.term(i)); // Sumar cada término después de '+'
        }
        
        
        System.out.println("Visit: Expr");
        System.out.println("Value: " + value);
        return value;
    }

    @Override
    public Integer visitTerm(EjemploGood2Parser.TermContext ctx) {
        int value = visit(ctx.factor(0)); // Primer factor
        for (int i = 1; i < ctx.factor().size(); i++) {
            value *= visit(ctx.factor(i)); // Multiplicar cada factor después de '*'
        }
        
        System.out.println("Visit: Term");
        System.out.println("Value: " + value);
        return value;
    }

    @Override
    public Integer visitFactor(EjemploGood2Parser.FactorContext ctx) {
        System.out.println("Visit: Factor");

        if (ctx.INT() != null) {
            System.out.println("value: " + Integer.parseInt(ctx.INT().getText()));
            return Integer.parseInt(ctx.INT().getText()); // Convertir el número
        } else {
            return visit(ctx.expr()); // Evaluar la expresión dentro de paréntesis
        }
        
        
    }
}
