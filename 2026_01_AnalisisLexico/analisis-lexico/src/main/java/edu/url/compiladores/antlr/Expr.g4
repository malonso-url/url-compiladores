grammar Expr;

prog:   (expr NEWLINE)* ;

expr:   expr ('*'|'/') expr
    |   expr ('+'|'-') expr
    |   INT
    |   '(' expr ')'
	|	IDENTIFICADOR
    ;
	
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
IDENTIFICADOR : ([a-z]|[A-Z])+;