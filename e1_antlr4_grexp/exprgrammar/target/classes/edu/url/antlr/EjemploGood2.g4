grammar EjemploGood2;		

@header {
    package edu.url.antlr;
}

start: expr EOF;

expr: term ( '+' term )* ;   // Eliminamos la recursión izquierda en E
term: factor ( '*' factor )* ; // Eliminamos la recursión izquierda en T
factor: '(' expr ')' 
      | INT 
      ;

NEWLINE : [\r\n]+ -> skip;
INT     : [0-9]+ ;