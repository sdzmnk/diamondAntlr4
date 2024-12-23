grammar g;

prog
    : (COMMENT | declarationList)* 'begin' (COMMENT | statementList)* 'finish'
    ;

declarationList
    : declaration+
    ;

declaration
    : IDENT '^' type
    ;

type
    : 'int'
    | 'float'
    | 'boolval'
    ;

statementList
    : statement+
    ;

statement
    : assign
    | inp
    | out
    | ifStatement
    | whileStatement
    | forStatement
    | switchStatement
    | elifStatement
    | untilStatement
    |declarationList1
    ;

declarationList1
    : identList1 '=' expressionList1
    ;

identList1
    : IDENT (',' IDENT)*
    ;

expressionList1
    : expression (',' expression)*
    ;


assign
    : IDENT '=' expression
    ;

inp
    : 'gets' '.' ('to_i' | 'to_f')
    ;

out
    : 'puts' (CONST | '"' IDENT '"') ;

ifStatement
    : 'if' boolExpr thenBlock (elifStatement)* (elseBlock)? 'end'
    ;

thenBlock
    : statement+
    ;

elseBlock
    : 'else' statement+
    ;

whileStatement
    : 'while' boolExpr 'do' doBlock 'end'
    ;

forStatement
    : 'for' IDENT 'in' SPEC_SIGN range SPEC_SIGN 'do' doBlock 'end'
    ;

range
    : startValue '..' endValue
    ;

startValue
    : CONST | IDENT
    ;

endValue
    : CONST | IDENT
    ;

untilStatement
    : 'until' boolExpr 'do' doBlock 'end'
    ;

doBlock
    : statement | statementList
    ;

switchStatement
    : 'switch' IDENT 'do' caseBlock+ 'end'
    ;

caseBlock
    : 'case' value ':' thenBlock
    ;

value
    : LETTER | CONST
    ;


elifStatement
    : 'if' boolExpr thenBlock elifBlock+ (elseBlock)? 'end'
    ;

elifBlock
    : 'elif' boolExpr thenBlock
    ;

expression
    : arithmExpression
    ;

boolExpr
    : arithmExpression relOp arithmExpression
    | 'true'
    | 'false'
    ;

arithmExpression
    : term (('+' | '-') term)*
    ;

term
    : factor (('*' | '/' | '**') factor)*
    ;



factor
    : IDENT
    | CONST
    | '(' arithmExpression ')'
    ;

relOp
    : '<' | '>' | '<=' | '>=' | '==' | '!='
    ;

CONST
    : INT_NUMB | FLOAT_NUMB | BOOL_CONST
    ;

INT_NUMB
    : SIGN? UNSIGNED_INT
    ;

FLOAT_NUMB
    : SIGN? ('.' UNSIGNED_INT | UNSIGNED_INT '.' | UNSIGNED_INT '.' UNSIGNED_INT)
    ;

BOOL_CONST
    : 'true' | 'false'
    ;

UNSIGNED_INT
    : DIGIT+
    ;

SIGN
    : '+' | '-'
    ;

SPEC_SIGN
    : '~' | '!' | '@' | '#' | '$' | '%' | '[' | ']'
    ;

IDENT
    : LETTER (LETTER | DIGIT | '_')*
    ;

DIGIT
    : [0-9]
    ;

LETTER
    : [a-zA-Z]
    ;

COMMENT
    : '#' (~[\r\n])* '\r'? '\n' -> skip
    ;

WHITESPACE
    : [ \t\r\n]+ -> skip
    ;
