grammar Expr;

prog: 'STARTPROG' NEWLINE (instructions)* 'ENDPROG'
    ;

instructions: (expr NEWLINE) 
    | (assign NEWLINE)
    ;

assign: IDENTIFICADOR '=' INT
    ;

expr:   expr ('*'|'/') expr
    |   expr ('+'|'-') expr
    |   INT
    |   '(' expr ')'
	|	IDENTIFICADOR
    ;
	
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
IDENTIFICADOR : ([a-z]|[A-Z])+;