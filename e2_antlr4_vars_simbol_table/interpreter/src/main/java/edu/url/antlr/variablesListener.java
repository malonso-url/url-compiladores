// Generated from variables.g4 by ANTLR 4.13.2

    package edu.url.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link variablesParser}.
 */
public interface variablesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link variablesParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(variablesParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(variablesParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(variablesParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(variablesParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#footer}.
	 * @param ctx the parse tree
	 */
	void enterFooter(variablesParser.FooterContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#footer}.
	 * @param ctx the parse tree
	 */
	void exitFooter(variablesParser.FooterContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(variablesParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(variablesParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#code_declaration}.
	 * @param ctx the parse tree
	 */
	void enterCode_declaration(variablesParser.Code_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#code_declaration}.
	 * @param ctx the parse tree
	 */
	void exitCode_declaration(variablesParser.Code_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#intvar}.
	 * @param ctx the parse tree
	 */
	void enterIntvar(variablesParser.IntvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#intvar}.
	 * @param ctx the parse tree
	 */
	void exitIntvar(variablesParser.IntvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#boolvar}.
	 * @param ctx the parse tree
	 */
	void enterBoolvar(variablesParser.BoolvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#boolvar}.
	 * @param ctx the parse tree
	 */
	void exitBoolvar(variablesParser.BoolvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(variablesParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(variablesParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(variablesParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(variablesParser.AexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(variablesParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(variablesParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(variablesParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(variablesParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterBexpr(variablesParser.BexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitBexpr(variablesParser.BexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#bterm}.
	 * @param ctx the parse tree
	 */
	void enterBterm(variablesParser.BtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#bterm}.
	 * @param ctx the parse tree
	 */
	void exitBterm(variablesParser.BtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#assignexpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignexpr(variablesParser.AssignexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#assignexpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignexpr(variablesParser.AssignexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link variablesParser#ioexpr}.
	 * @param ctx the parse tree
	 */
	void enterIoexpr(variablesParser.IoexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link variablesParser#ioexpr}.
	 * @param ctx the parse tree
	 */
	void exitIoexpr(variablesParser.IoexprContext ctx);
}