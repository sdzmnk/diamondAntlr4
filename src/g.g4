grammar g;

program
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
    ;

assign
    : IDENT '=' expression
    ;

inp
    : 'gets' '.' ('to_i' | 'to_f')
    ;

out
    : 'puts' '"' IDENT '"'
    | DIGIT
    | SPEC_SIGN
    ;

ifStatement
    : 'if' boolExpr thenBlock (elseBlock)? 'end'
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
    : 'for' IDENT 'in' range 'do' doBlock 'end'
    ;

range
    : startValue '..' endValue
    ;

startValue
    : INT_NUMB | IDENT
    ;

endValue
    : INT_NUMB | IDENT
    ;

untilStatement
    : 'until' boolExpr 'do' doBlock 'end'
    ;

doBlock
    : statement | statementList
    ;

switchStatement
    : 'switch' IDENT 'do' caseBlock+ (defaultBlock)? 'end'
    ;

caseBlock
    : 'case' value ':' thenBlock
    ;

value
    : LETTER | DIGIT
    ;

defaultBlock
    : 'default' ':' thenBlock
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
    : factor (('*' | '/') factor)*
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
    : '~' | '!' | '@' | '#' | '$' | '%'
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
