// Generated from src/main/java/edu/url/compiladores/antlr/Expr.g4 by ANTLR 4.13.2
package edu.url.compiladores.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrAssign}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrAssign(ExprParser.InstrAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrPrint}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrPrint(ExprParser.InstrPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrConditional}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrConditional(ExprParser.InstrConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignInt}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignInt(ExprParser.AssignIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignString}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignString(ExprParser.AssignStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignBool}
	 * labeled alternative in {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignBool(ExprParser.AssignBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintExpr}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(ExprParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintBool}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintBool(ExprParser.PrintBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintString}
	 * labeled alternative in {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintString(ExprParser.PrintStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(ExprParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTermOnly}
	 * labeled alternative in {@link ExprParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTermOnly(ExprParser.BoolTermOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link ExprParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(ExprParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link ExprParser#boolTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(ExprParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolFactorOnly}
	 * labeled alternative in {@link ExprParser#boolTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFactorOnly(ExprParser.BoolFactorOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(ExprParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(ExprParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolId}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolId(ExprParser.BoolIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolParens}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolParens(ExprParser.BoolParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolComparison}
	 * labeled alternative in {@link ExprParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolComparison(ExprParser.BoolComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ExprParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ExprParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(ExprParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ExprParser.IdContext ctx);
}