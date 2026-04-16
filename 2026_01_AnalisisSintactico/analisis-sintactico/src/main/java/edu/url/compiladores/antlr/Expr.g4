grammar Expr;

prog: 'STARTPROG' NEWLINE (instructions)* 'ENDPROG'
    ;

instructions: (expr NEWLINE)         # InstrExpr
    | (assign NEWLINE)               # InstrAssign
    | (conditional NEWLINE)          # InstrConditional
    ;

assign: IDENTIFICADOR '=' INT
    ;

expr:   expr ('*'|'/') expr    # MulDiv
    |   expr ('+'|'-') expr    # AddSub
    |   INT                    # IntLiteral
    |   '(' expr ')'           # Parens
    |   IDENTIFICADOR          # Id
    ;

conditional: 'IF' expr 'THEN' instructions 'ENDIF'
    ;
	
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
IDENTIFICADOR : ([a-z]|[A-Z])+;