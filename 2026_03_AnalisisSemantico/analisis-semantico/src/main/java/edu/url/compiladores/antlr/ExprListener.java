// Generated from src/main/java/edu/url/compiladores/antlr/Expr.g4 by ANTLR 4.13.2
package edu.url.compiladores.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstrAssign}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstrAssign(ExprParser.InstrAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrAssign}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstrAssign(ExprParser.InstrAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstrPrint}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstrPrint(ExprParser.InstrPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrPrint}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstrPrint(ExprParser.InstrPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstrConditional}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstrConditional(ExprParser.InstrConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrConditional}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstrConditional(ExprParser.InstrConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignInt}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssignInt(ExprParser.AssignIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignInt}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssignInt(ExprParser.AssignIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignString}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssignString(ExprParser.AssignStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignString}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssignString(ExprParser.AssignStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignBool}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssignBool(ExprParser.AssignBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignBool}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssignBool(ExprParser.AssignBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintExpr}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(ExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintExpr}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(ExprParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintBool}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintBool(ExprParser.PrintBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintBool}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintBool(ExprParser.PrintBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintString}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintString(ExprParser.PrintStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintString}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintString(ExprParser.PrintStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(ExprParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(ExprParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTermOnly}
	 * labeled alternative in {@link ExprParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolTermOnly(ExprParser.BoolTermOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTermOnly}
	 * labeled alternative in {@link ExprParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolTermOnly(ExprParser.BoolTermOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link ExprParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(ExprParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link ExprParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(ExprParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link ExprParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(ExprParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link ExprParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(ExprParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFactorOnly}
	 * labeled alternative in {@link ExprParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactorOnly(ExprParser.BoolFactorOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFactorOnly}
	 * labeled alternative in {@link ExprParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactorOnly(ExprParser.BoolFactorOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(ExprParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(ExprParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(ExprParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(ExprParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolId}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolId(ExprParser.BoolIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolId}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolId(ExprParser.BoolIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolParens}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolParens(ExprParser.BoolParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolParens}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolParens(ExprParser.BoolParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolComparison}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolComparison(ExprParser.BoolComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolComparison}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolComparison(ExprParser.BoolComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ExprParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ExprParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(ExprParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(ExprParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ExprParser.IdContext ctx);
}