// Generated from EjemploGood2.g4 by ANTLR 4.13.2

    package edu.url.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EjemploGood2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EjemploGood2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EjemploGood2Parser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(EjemploGood2Parser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link EjemploGood2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(EjemploGood2Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EjemploGood2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(EjemploGood2Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link EjemploGood2Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(EjemploGood2Parser.FactorContext ctx);
}