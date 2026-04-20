grammar Expr;

prog
    : 'STARTPROG' NEWLINE (instructions)* 'ENDPROG'
    ;

instructions
    : assign NEWLINE            # InstrAssign
    | print NEWLINE             # InstrPrint
    | conditional NEWLINE       # InstrConditional
    ;

assign
    : 'I>' IDENTIFICADOR '=' expr       # AssignInt
    | 'S>' IDENTIFICADOR '=' STRING     # AssignString
    | 'B>' IDENTIFICADOR '=' boolExpr   # AssignBool
    ;

print
    : 'PRINT' expr              # PrintExpr
    | 'PRINT' boolExpr          # PrintBool
    | 'PRINT' STRING            # PrintString
    ;

conditional
    : 'IF' boolExpr 'THEN' instructions 'ENDIF'
    ;

/* =======================
   EXPRESIONES BOOLEANAS
   ======================= */

boolExpr
    : boolExpr 'or' boolTerm     # OrExpr
    | boolTerm                   # BoolTermOnly
    ;

boolTerm
    : boolTerm 'and' boolFactor  # AndExpr
    | boolFactor                 # BoolFactorOnly
    ;

boolFactor
    : 'not' boolFactor           # NotExpr
    | BOOL                       # BoolLiteral
    | IDENTIFICADOR              # BoolId
    | '(' boolExpr ')'           # BoolParens
    | comparison                 # BoolComparison
    ;

/* Comparaciones aritméticas */
comparison
    : expr ('==' | '!=' | '<' | '<=' | '>' | '>=') expr
    ;

/* =======================
   EXPRESIONES ARITMÉTICAS
   ======================= */

expr
    : expr ('*'|'/') expr    # MulDiv
    | expr ('+'|'-') expr    # AddSub
    | INT                    # IntLiteral
    | '(' expr ')'           # Parens
    | IDENTIFICADOR          # Id
    ;

/* =======================
   TOKENS
   ======================= */

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
BOOL    : [TF] ;
IDENTIFICADOR : [a-zA-Z]+ ;
STRING  : '"'([a-zA-Z0-9 _])*'"' ;
WS      : [ \t]+ -> skip ;
