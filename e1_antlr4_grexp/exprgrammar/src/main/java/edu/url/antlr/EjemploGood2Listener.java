// Generated from EjemploGood2.g4 by ANTLR 4.13.2

    package edu.url.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EjemploGood2Parser}.
 */
public interface EjemploGood2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EjemploGood2Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(EjemploGood2Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link EjemploGood2Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(EjemploGood2Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link EjemploGood2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EjemploGood2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EjemploGood2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EjemploGood2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EjemploGood2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(EjemploGood2Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link EjemploGood2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(EjemploGood2Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link EjemploGood2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(EjemploGood2Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EjemploGood2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(EjemploGood2Parser.FactorContext ctx);
}