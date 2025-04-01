// Generated from variables.g4 by ANTLR 4.13.2

    package edu.url.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class variablesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, NEWLINE=23, BLANKSPACE=24, 
		INT=25, ID=26;
	public static final int
		RULE_start = 0, RULE_vars = 1, RULE_intvar = 2, RULE_boolvar = 3, RULE_expressions = 4, 
		RULE_aexpr = 5, RULE_term = 6, RULE_factor = 7, RULE_bexpr = 8, RULE_bterm = 9, 
		RULE_assignexpr = 10, RULE_ioexpr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "vars", "intvar", "boolvar", "expressions", "aexpr", "term", 
			"factor", "bexpr", "bterm", "assignexpr", "ioexpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$vars:'", "'$code:'", "'$int'", "'='", "'$bool'", "'$true'", 
			"'$false'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'$not'", "'$and'", 
			"'$or'", "'<'", "'<='", "'>'", "'>='", "'=='", "'$write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "NEWLINE", 
			"BLANKSPACE", "INT", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "variables.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public variablesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(variablesParser.EOF, 0); }
		public List<VarsContext> vars() {
			return getRuleContexts(VarsContext.class);
		}
		public VarsContext vars(int i) {
			return getRuleContext(VarsContext.class,i);
		}
		public List<ExpressionsContext> expressions() {
			return getRuleContexts(ExpressionsContext.class);
		}
		public ExpressionsContext expressions(int i) {
			return getRuleContext(ExpressionsContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__4) {
				{
				{
				setState(25);
				vars();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			match(T__1);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 104878272L) != 0)) {
				{
				{
				setState(32);
				expressions();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarsContext extends ParserRuleContext {
		public IntvarContext intvar() {
			return getRuleContext(IntvarContext.class,0);
		}
		public BoolvarContext boolvar() {
			return getRuleContext(BoolvarContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_vars);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				intvar();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				boolvar();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntvarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(variablesParser.ID, 0); }
		public TerminalNode INT() { return getToken(variablesParser.INT, 0); }
		public IntvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterIntvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitIntvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitIntvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntvarContext intvar() throws RecognitionException {
		IntvarContext _localctx = new IntvarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_intvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__2);
			setState(45);
			match(ID);
			setState(46);
			match(T__3);
			setState(47);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolvarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(variablesParser.ID, 0); }
		public BoolvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterBoolvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitBoolvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitBoolvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolvarContext boolvar() throws RecognitionException {
		BoolvarContext _localctx = new BoolvarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_boolvar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__4);
			setState(50);
			match(ID);
			setState(51);
			match(T__3);
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public AssignexprContext assignexpr() {
			return getRuleContext(AssignexprContext.class,0);
		}
		public IoexprContext ioexpr() {
			return getRuleContext(IoexprContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressions);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				aexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				bexpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				assignexpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				ioexpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AexprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitAexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitAexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		AexprContext _localctx = new AexprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			term();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				{
				setState(61);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(62);
				term();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			factor();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				{
				setState(69);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(70);
				factor();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode INT() { return getToken(variablesParser.INT, 0); }
		public TerminalNode ID() { return getToken(variablesParser.ID, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__11);
				setState(77);
				aexpr();
				setState(78);
				match(T__12);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(INT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BexprContext extends ParserRuleContext {
		public List<BtermContext> bterm() {
			return getRuleContexts(BtermContext.class);
		}
		public BtermContext bterm(int i) {
			return getRuleContext(BtermContext.class,i);
		}
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitBexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitBexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		BexprContext _localctx = new BexprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(84);
				match(T__13);
				}
			}

			setState(87);
			bterm();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__15) {
				{
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(89);
					match(T__13);
					}
				}

				setState(92);
				bterm();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BtermContext extends ParserRuleContext {
		public BtermContext bterm() {
			return getRuleContext(BtermContext.class,0);
		}
		public TerminalNode ID() { return getToken(variablesParser.ID, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public BtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterBterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitBterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitBterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtermContext bterm() throws RecognitionException {
		BtermContext _localctx = new BtermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bterm);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(T__11);
				setState(99);
				bterm();
				setState(100);
				match(T__12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				match(T__6);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				match(T__11);
				setState(106);
				aexpr();
				setState(107);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(108);
				aexpr();
				setState(109);
				match(T__12);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(variablesParser.ID, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public AssignexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterAssignexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitAssignexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitAssignexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignexprContext assignexpr() throws RecognitionException {
		AssignexprContext _localctx = new AssignexprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
			setState(114);
			match(T__3);
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(115);
				aexpr();
				}
				break;
			case 2:
				{
				setState(116);
				bexpr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IoexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(variablesParser.ID, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public IoexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).enterIoexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof variablesListener ) ((variablesListener)listener).exitIoexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof variablesVisitor ) return ((variablesVisitor<? extends T>)visitor).visitIoexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoexprContext ioexpr() throws RecognitionException {
		IoexprContext _localctx = new IoexprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ioexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__21);
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(120);
				match(ID);
				}
				break;
			case 2:
				{
				setState(121);
				bexpr();
				}
				break;
			case 3:
				{
				setState(122);
				aexpr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001a~\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u001b\b\u0000\n\u0000\f\u0000\u001e\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005@\b\u0005\n\u0005\f\u0005C\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006H\b\u0006\n\u0006\f\u0006K\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007S\b\u0007\u0001\b\u0003\bV\b\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b[\b\b\u0001\b\u0005\b^\b\b\n\b\f\ba\t\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\tp\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nv\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b|\b\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0005\u0001\u0000\u0006\u0007\u0001\u0000\b\t\u0001\u0000\n\u000b"+
		"\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0015\u0085\u0000\u0018\u0001"+
		"\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004,\u0001\u0000\u0000"+
		"\u0000\u00061\u0001\u0000\u0000\u0000\b:\u0001\u0000\u0000\u0000\n<\u0001"+
		"\u0000\u0000\u0000\fD\u0001\u0000\u0000\u0000\u000eR\u0001\u0000\u0000"+
		"\u0000\u0010U\u0001\u0000\u0000\u0000\u0012o\u0001\u0000\u0000\u0000\u0014"+
		"q\u0001\u0000\u0000\u0000\u0016w\u0001\u0000\u0000\u0000\u0018\u001c\u0005"+
		"\u0001\u0000\u0000\u0019\u001b\u0003\u0002\u0001\u0000\u001a\u0019\u0001"+
		"\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c\u001a\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001f\u0001"+
		"\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f#\u0005\u0002"+
		"\u0000\u0000 \"\u0003\b\u0004\u0000! \u0001\u0000\u0000\u0000\"%\u0001"+
		"\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\'\u0005\u0000\u0000"+
		"\u0001\'\u0001\u0001\u0000\u0000\u0000(+\u0003\u0004\u0002\u0000)+\u0003"+
		"\u0006\u0003\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000"+
		"+\u0003\u0001\u0000\u0000\u0000,-\u0005\u0003\u0000\u0000-.\u0005\u001a"+
		"\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0005\u0019\u0000\u00000\u0005"+
		"\u0001\u0000\u0000\u000012\u0005\u0005\u0000\u000023\u0005\u001a\u0000"+
		"\u000034\u0005\u0004\u0000\u000045\u0007\u0000\u0000\u00005\u0007\u0001"+
		"\u0000\u0000\u00006;\u0003\n\u0005\u00007;\u0003\u0010\b\u00008;\u0003"+
		"\u0014\n\u00009;\u0003\u0016\u000b\u0000:6\u0001\u0000\u0000\u0000:7\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000"+
		";\t\u0001\u0000\u0000\u0000<A\u0003\f\u0006\u0000=>\u0007\u0001\u0000"+
		"\u0000>@\u0003\f\u0006\u0000?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\u000b\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DI\u0003\u000e\u0007\u0000"+
		"EF\u0007\u0002\u0000\u0000FH\u0003\u000e\u0007\u0000GE\u0001\u0000\u0000"+
		"\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000J\r\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0005"+
		"\f\u0000\u0000MN\u0003\n\u0005\u0000NO\u0005\r\u0000\u0000OS\u0001\u0000"+
		"\u0000\u0000PS\u0005\u0019\u0000\u0000QS\u0005\u001a\u0000\u0000RL\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000"+
		"S\u000f\u0001\u0000\u0000\u0000TV\u0005\u000e\u0000\u0000UT\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W_\u0003"+
		"\u0012\t\u0000XZ\u0007\u0003\u0000\u0000Y[\u0005\u000e\u0000\u0000ZY\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\^\u0003\u0012\t\u0000]X\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u0011\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\f\u0000\u0000cd\u0003"+
		"\u0012\t\u0000de\u0005\r\u0000\u0000ep\u0001\u0000\u0000\u0000fp\u0005"+
		"\u0006\u0000\u0000gp\u0005\u0007\u0000\u0000hp\u0005\u001a\u0000\u0000"+
		"ij\u0005\f\u0000\u0000jk\u0003\n\u0005\u0000kl\u0007\u0004\u0000\u0000"+
		"lm\u0003\n\u0005\u0000mn\u0005\r\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"ob\u0001\u0000\u0000\u0000of\u0001\u0000\u0000\u0000og\u0001\u0000\u0000"+
		"\u0000oh\u0001\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000p\u0013\u0001"+
		"\u0000\u0000\u0000qr\u0005\u001a\u0000\u0000ru\u0005\u0004\u0000\u0000"+
		"sv\u0003\n\u0005\u0000tv\u0003\u0010\b\u0000us\u0001\u0000\u0000\u0000"+
		"ut\u0001\u0000\u0000\u0000v\u0015\u0001\u0000\u0000\u0000w{\u0005\u0016"+
		"\u0000\u0000x|\u0005\u001a\u0000\u0000y|\u0003\u0010\b\u0000z|\u0003\n"+
		"\u0005\u0000{x\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000|\u0017\u0001\u0000\u0000\u0000\r\u001c#*:AIRUZ_ou{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}