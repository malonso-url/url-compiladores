grammar variables;		

@header {
    package edu.url.antlr;
}

start: '$vars:' vars* '$code:' expressions* EOF;

vars: intvar
	| boolvar
	;

intvar: '$int' ID '=' INT
		;
		
boolvar: '$bool' ID '=' ('$true'|'$false')
		;

expressions: aexpr
		| bexpr
		| assignexpr
		| ioexpr
		;

aexpr: term ( ('+'|'-') term )* ; 
term: factor ( ('*'|'/') factor )* ; 
factor: '(' aexpr ')' 
		| INT
		| ID
      ;
	  
bexpr: ('$not')? bterm ( ('$and'|'$or') ('$not')? bterm )* ; 
bterm: '(' bterm ')' 
		| '$true'
		| '$false'
		| ID
		| '(' aexpr ('<'|'<='|'>'|'>='|'==') aexpr ')'
      ;
	  
assignexpr: ID '=' ( aexpr | bexpr ) 
		;
	  
ioexpr: '$write' (ID | bexpr | aexpr)
		;

NEWLINE : [\r\n]+ -> skip;
BLANKSPACE: [ ]+ -> skip;
INT     : [0-9]+ ;
ID		: [a-zA-Z][a-zA-Z0-9_]* ;