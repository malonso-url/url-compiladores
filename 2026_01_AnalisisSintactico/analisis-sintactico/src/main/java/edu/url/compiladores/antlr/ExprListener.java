// Generated from Expr.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by the {@code InstrExpr}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstrExpr(ExprParser.InstrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrExpr}
	 * labeled alternative in {@link ExprParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstrExpr(ExprParser.InstrExprContext ctx);
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
	 * Enter a parse tree produced by {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ExprParser.AssignContext ctx);
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
}