package edu.url.compiladores;

import edu.url.compiladores.antlr.ExprBaseVisitor;
import edu.url.compiladores.antlr.ExprParser;
import edu.url.compiladores.antlr.ExprParser.ProgContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Visits the parse tree and:
 *  1. Builds a Java source string (translation).
 *  2. Collects every assigned variable into a symbol table (List<Variable>).
 *  3. Validates types in arithmetic and boolean expressions.
 *
 * NOTE: Expressions are NOT evaluated — they are only translated to Java code.
 */
public class EvalVisitor extends ExprBaseVisitor<String> {

    // ── Fields ────────────────────────────────────────────────────────────────

    /** Accumulates the translated Java source code. */
    private final StringBuilder javaCode = new StringBuilder();

    /** Symbol table: one entry per assignment found in the source. */
    private final List<Variable> symbolTable = new ArrayList<>();

    /**
     * Fast lookup map: variable name → declared type ("int" | "String" | "boolean").
     * Used for semantic type validation.
     */
    private final Map<String, String> typeMap = new HashMap<>();

    /** Accumulates semantic error messages. */
    private final List<String> errors = new ArrayList<>();

    /** Current scope name (updated when entering/leaving blocks). */
    private String currentScope = "global";

    // ── Public accessors ──────────────────────────────────────────────────────
    public String         getJavaCode()    { return javaCode.toString(); }
    public List<Variable> getSymbolTable() { return symbolTable; }
    public List<String>   getErrors()      { return errors; }
    public boolean        hasErrors()      { return !errors.isEmpty(); }

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

    // Production: assign NEWLINE   #InstrAssign
    @Override
    public String visitInstrAssign(ExprParser.InstrAssignContext ctx) {
        visit(ctx.assign());
        return null;
    }

    // Production: print NEWLINE   #InstrPrint
    @Override
    public String visitInstrPrint(ExprParser.InstrPrintContext ctx) {
        visit(ctx.print());
        return null;
    }

    // Production: conditional NEWLINE   #InstrConditional
    @Override
    public String visitInstrConditional(ExprParser.InstrConditionalContext ctx) {
        visit(ctx.conditional());
        return null;
    }

    // =========================================================================
    // assign alternatives
    // =========================================================================

    // Production: 'I>' IDENTIFICADOR '=' expr   #AssignInt
    @Override
    public String visitAssignInt(ExprParser.AssignIntContext ctx) {
        String name  = ctx.IDENTIFICADOR().getText();
        String expr  = visit(ctx.expr());   // translate the expression to Java code

        javaCode.append("        int ").append(name).append(" = ").append(expr).append(";\n");
        // Store the expression text as the value in the symbol table
        registerVariable(name, expr, "int");
        return null;
    }

    // Production: 'S>' IDENTIFICADOR '=' STRING   #AssignString
    @Override
    public String visitAssignString(ExprParser.AssignStringContext ctx) {
        String name      = ctx.IDENTIFICADOR().getText();
        String rawString = ctx.STRING().getText();                          // includes quotes
        String value     = rawString.substring(1, rawString.length() - 1); // strip quotes for table

        javaCode.append("        String ").append(name).append(" = ").append(rawString).append(";\n");
        registerVariable(name, value, "String");
        return null;
    }

    // Production: 'B>' IDENTIFICADOR '=' boolExpr   #AssignBool
    @Override
    public String visitAssignBool(ExprParser.AssignBoolContext ctx) {
        String name     = ctx.IDENTIFICADOR().getText();
        String boolExpr = visit(ctx.boolExpr());   // translate the boolean expression to Java code

        javaCode.append("        boolean ").append(name).append(" = ").append(boolExpr).append(";\n");
        // Store the expression text as the value in the symbol table
        registerVariable(name, boolExpr, "boolean");
        return null;
    }

    // =========================================================================
    // print alternatives
    // =========================================================================

    // Production: 'PRINT' expr   #PrintExpr
    @Override
    public String visitPrintExpr(ExprParser.PrintExprContext ctx) {
        String code = visit(ctx.expr());
        javaCode.append("        System.out.println(").append(code).append(");\n");
        return null;
    }

    // Production: 'PRINT' boolExpr   #PrintBool
    @Override
    public String visitPrintBool(ExprParser.PrintBoolContext ctx) {
        String code = visit(ctx.boolExpr());
        javaCode.append("        System.out.println(").append(code).append(");\n");
        return null;
    }

    // Production: 'PRINT' STRING   #PrintString
    @Override
    public String visitPrintString(ExprParser.PrintStringContext ctx) {
        javaCode.append("        System.out.println(").append(ctx.STRING().getText()).append(");\n");
        return null;
    }

    // =========================================================================
    // conditional : 'IF' boolExpr 'THEN' instructions 'ENDIF'
    // =========================================================================
    @Override
    public String visitConditional(ExprParser.ConditionalContext ctx) {
        String condition = visit(ctx.boolExpr());

        javaCode.append("        if (").append(condition).append(") {\n");

        String outerScope = currentScope;
        currentScope = currentScope + ".if";
        visit(ctx.instructions());
        currentScope = outerScope;

        javaCode.append("        }\n");
        return null;
    }

    // =========================================================================
    // boolExpr — returns Java boolean expression string (no evaluation)
    // =========================================================================

    // Production: boolExpr 'or' boolTerm   #OrExpr
    @Override
    public String visitOrExpr(ExprParser.OrExprContext ctx) {
        return visit(ctx.boolExpr()) + " || " + visit(ctx.boolTerm());
    }

    // Production: boolTerm   #BoolTermOnly
    @Override
    public String visitBoolTermOnly(ExprParser.BoolTermOnlyContext ctx) {
        return visit(ctx.boolTerm());
    }

    // =========================================================================
    // boolTerm — returns Java boolean expression string (no evaluation)
    // =========================================================================

    // Production: boolTerm 'and' boolFactor   #AndExpr
    @Override
    public String visitAndExpr(ExprParser.AndExprContext ctx) {
        return visit(ctx.boolTerm()) + " && " + visit(ctx.boolFactor());
    }

    // Production: boolFactor   #BoolFactorOnly
    @Override
    public String visitBoolFactorOnly(ExprParser.BoolFactorOnlyContext ctx) {
        return visit(ctx.boolFactor());
    }

    // =========================================================================
    // boolFactor — returns Java boolean expression string (no evaluation)
    // =========================================================================

    // Production: 'not' boolFactor   #NotExpr
    @Override
    public String visitNotExpr(ExprParser.NotExprContext ctx) {
        return "!" + visit(ctx.boolFactor());
    }

    // Production: BOOL   #BoolLiteral  (T → true, F → false)
    @Override
    public String visitBoolLiteral(ExprParser.BoolLiteralContext ctx) {
        return ctx.BOOL().getText().equals("T") ? "true" : "false";
    }

    // Production: IDENTIFICADOR   #BoolId
    // Validate that the variable is declared and is of type boolean.
    @Override
    public String visitBoolId(ExprParser.BoolIdContext ctx) {
        String name = ctx.IDENTIFICADOR().getText();
        validateType(name, "boolean", "expresión booleana");
        return name;
    }

    // Production: '(' boolExpr ')'   #BoolParens
    @Override
    public String visitBoolParens(ExprParser.BoolParensContext ctx) {
        return "(" + visit(ctx.boolExpr()) + ")";
    }

    // Production: comparison   #BoolComparison
    @Override
    public String visitBoolComparison(ExprParser.BoolComparisonContext ctx) {
        return visit(ctx.comparison());
    }

    // =========================================================================
    // comparison : expr op expr
    // =========================================================================
    @Override
    public String visitComparison(ExprParser.ComparisonContext ctx) {
        String left  = visit(ctx.expr(0));
        String op    = ctx.getChild(1).getText();
        String right = visit(ctx.expr(1));
        return left + " " + op + " " + right;
    }

    // =========================================================================
    // expr — returns Java arithmetic expression string (no evaluation)
    // =========================================================================

    // Production: expr ('*'|'/') expr   #MulDiv
    // Validate that any identifier operands are of type int.
    @Override
    public String visitMulDiv(ExprParser.MulDivContext ctx) {
        validateExprOperand(ctx.expr(0));
        validateExprOperand(ctx.expr(1));
        String left  = visit(ctx.expr(0));
        String op    = ctx.getChild(1).getText();
        String right = visit(ctx.expr(1));
        return left + " " + op + " " + right;
    }

    // Production: expr ('+'|'-') expr   #AddSub
    // Validate that any identifier operands are of type int.
    @Override
    public String visitAddSub(ExprParser.AddSubContext ctx) {
        validateExprOperand(ctx.expr(0));
        validateExprOperand(ctx.expr(1));
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
    // Just return the variable name as Java code — no evaluation.
    @Override
    public String visitId(ExprParser.IdContext ctx) {
        return ctx.IDENTIFICADOR().getText();
    }

    // =========================================================================
    // Helpers
    // =========================================================================

    /**
     * If the given expr node is a plain identifier (#Id), validate that the
     * declared type is "int" (required for arithmetic operations).
     */
    private void validateExprOperand(ExprParser.ExprContext expr) {
        if (expr instanceof ExprParser.IdContext) {
            String name = ((ExprParser.IdContext) expr).IDENTIFICADOR().getText();
            validateType(name, "int", "expresión aritmética");
        }
        // INT literals and sub-expressions (Parens, MulDiv, AddSub) need no check here
    }

    /**
     * Registers a variable in both the symbol table list and the fast-lookup map.
     */
    private void registerVariable(String name, String value, String type) {
        typeMap.put(name, type);
        symbolTable.add(new Variable(name, value, type, currentScope));
    }

    /**
     * Validates that {@code name} is declared and has the expected type.
     * Records an error message if the check fails.
     */
    private void validateType(String name, String expectedType, String context) {
        if (!typeMap.containsKey(name)) {
            String msg = "ERROR SEMÁNTICO: Variable '" + name + "' no declarada"
                       + " (usada en " + context + ").";
            errors.add(msg);
            System.err.println(msg);
        } else {
            String actualType = typeMap.get(name);
            if (!actualType.equals(expectedType)) {
                String msg = "ERROR SEMÁNTICO: Variable '" + name + "' es de tipo '"
                           + actualType + "' pero se esperaba '" + expectedType
                           + "' en " + context + ".";
                errors.add(msg);
                System.err.println(msg);
            }
        }
    }
}
