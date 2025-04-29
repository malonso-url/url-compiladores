// Generated from variables.g4 by ANTLR 4.13.2

    package edu.url.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link variablesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface variablesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link variablesParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(variablesParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(variablesParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#footer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFooter(variablesParser.FooterContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(variablesParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#code_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode_declaration(variablesParser.Code_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#intvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntvar(variablesParser.IntvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#boolvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolvar(variablesParser.BoolvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(variablesParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#aexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr(variablesParser.AexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(variablesParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(variablesParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpr(variablesParser.BexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#bterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBterm(variablesParser.BtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#assignexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignexpr(variablesParser.AssignexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link variablesParser#ioexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoexpr(variablesParser.IoexprContext ctx);
}