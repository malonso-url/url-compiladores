grammar Expr;

@header{
    package antlr;
}

prog: (decl | expr)+ EOF
    ;

decl: ID ':' INT_TYPE '=' NUM
    ;

expr: expr '*' expr
    | expr '+' expr
    | ID
    | NUM
    ;

/*Tokens*/
ID: [a-z][a-zA-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
INT_TYPE: 'INT';
COMMENT : '--' ~[\r\n]* -> skip;
WS : [\t\n]+ -> skip;