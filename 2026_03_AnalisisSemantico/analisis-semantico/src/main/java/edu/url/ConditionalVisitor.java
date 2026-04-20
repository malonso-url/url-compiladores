package edu.url;

import edu.url.compiladores.antlr.ExprBaseVisitor;
import edu.url.compiladores.antlr.ExprParser.ConditionalContext;

public class ConditionalVisitor extends ExprBaseVisitor<Void>{

    @Override
    public Void visitConditional(ConditionalContext ctx) {
        // TODO Auto-generated method stub
        return super.visitConditional(ctx);
    }
    
}
