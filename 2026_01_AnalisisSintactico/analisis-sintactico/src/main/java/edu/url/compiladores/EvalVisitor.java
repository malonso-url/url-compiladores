package edu.url.compiladores;

import edu.url.compiladores.antlr.ExprBaseVisitor;
import edu.url.compiladores.antlr.ExprParser;
import edu.url.compiladores.antlr.ExprParser.ProgContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Visits the parse tree and:
 *  1. Builds a Java source string (translation).
 *  2. Collects every assigned variable into a symbol table (List<Variable>).
 */
public class EvalVisitor extends ExprBaseVisitor<String> {

    // ── Output ────────────────────────────────────────────────────────────────
    /** Accumulates the translated Java source code. */
    private final StringBuilder javaCode = new StringBuilder();

    /** Symbol table: one entry per assignment found in the source. */
    private final List<Variable> symbolTable = new ArrayList<>();

    /** Current scope name (updated when entering/leaving blocks). */
    private String currentScope = "global";

    // ── Public accessors ──────────────────────────────────────────────────────
    public String getJavaCode()          { return javaCode.toString(); }
    public List<Variable> getSymbolTable() { return symbolTable; }

    // =========================================================================
    // prog : 'STARTPROG' NEWLINE (instructions)* 'ENDPROG'
    // =========================================================================
    @Override
    public String visitProg(ProgContext ctx) {
        javaCode.append("public class Traduccion {\n");
        javaCode.append("    public static void main(String[] args) {\n");

        visitChildren(ctx);

        javaCode.append("    }\n");
        javaCode.append("}\n");
        return null;
    }

    // =========================================================================
    // instructions alternatives
    // =========================================================================

    // Production: (expr NEWLINE)   #InstrExpr
    @Override
    public String visitInstrExpr(ExprParser.InstrExprContext ctx) {
        String exprCode = visit(ctx.expr());
        javaCode.append("        ").append(exprCode).append(";\n");
        return null;
    }

    // Production: (assign NEWLINE)   #InstrAssign
    @Override
    public String visitInstrAssign(ExprParser.InstrAssignContext ctx) {
        visit(ctx.assign());   // visitAssign handles javaCode + symbolTable
        return null;
    }

    // Production: (conditional NEWLINE)   #InstrConditional
    @Override
    public String visitInstrConditional(ExprParser.InstrConditionalContext ctx) {
        visit(ctx.conditional());
        return null;
    }

    // =========================================================================
    // assign : IDENTIFICADOR '=' INT
    // =========================================================================
    @Override
    public String visitAssign(ExprParser.AssignContext ctx) {
        String name  = ctx.IDENTIFICADOR().getText();
        String value = ctx.INT().getText();
        String type  = "int";   // grammar only allows INT on the right-hand side

        // Java translation
        javaCode.append("        ")
                .append(type).append(" ")
                .append(name).append(" = ")
                .append(value).append(";\n");

        // Symbol table entry
        symbolTable.add(new Variable(name, value, type, currentScope));

        return null;
    }

    // =========================================================================
    // conditional : 'IF' expr 'THEN' instructions 'ENDIF'
    // =========================================================================
    @Override
    public String visitConditional(ExprParser.ConditionalContext ctx) {
        String condition = visit(ctx.expr());

        javaCode.append("        if (").append(condition).append(") {\n");

        // Push a new scope for the body
        String outerScope = currentScope;
        currentScope = currentScope + ".if";

        visit(ctx.instructions());

        currentScope = outerScope;
        javaCode.append("        }\n");
        return null;
    }

    // =========================================================================
    // expr alternatives — each returns the Java expression as a String
    // =========================================================================

    // Production: expr ('*'|'/') expr   #MulDiv
    @Override
    public String visitMulDiv(ExprParser.MulDivContext ctx) {
        String left  = visit(ctx.expr(0));
        String op    = ctx.getChild(1).getText();
        String right = visit(ctx.expr(1));
        return left + " " + op + " " + right;
    }

    // Production: expr ('+'|'-') expr   #AddSub
    @Override
    public String visitAddSub(ExprParser.AddSubContext ctx) {
        String left  = visit(ctx.expr(0));
        String op    = ctx.getChild(1).getText();
        String right = visit(ctx.expr(1));
        return left + " " + op + " " + right;
    }

    // Production: INT   #IntLiteral
    @Override
    public String visitIntLiteral(ExprParser.IntLiteralContext ctx) {
        return ctx.INT().getText();
    }

    // Production: '(' expr ')'   #Parens
    @Override
    public String visitParens(ExprParser.ParensContext ctx) {
        return "(" + visit(ctx.expr()) + ")";
    }

    // Production: IDENTIFICADOR   #Id
    @Override
    public String visitId(ExprParser.IdContext ctx) {
        return ctx.IDENTIFICADOR().getText();
    }
}
