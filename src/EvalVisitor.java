
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends gBaseVisitor<Integer> {
    /** Memory to store variable values */
    Map<String, Integer> memory = new HashMap<>();

    /** prog: (COMMENT | declarationList)* 'begin' (COMMENT | statementList)* 'finish' */
    @Override
    public Integer visitProg(gParser.ProgContext ctx) {
        for (var child : ctx.children) {
            visit(child);
        }
        System.out.println("Program executed successfully.");
        return 0;
    }

    /** assign: IDENT '=' expression */
    @Override
    public Integer visitAssign(gParser.AssignContext ctx) {
        String id = ctx.IDENT().getText();
        int value = visit(ctx.expression());
        memory.put(id, value);
        return value;
    }

    /** out: 'puts' (CONST | '"' IDENT '"') */
    @Override
    public Integer visitOut(gParser.OutContext ctx) {
        if (ctx.CONST() != null) {
            System.out.println(ctx.CONST().getText());
        } else if (ctx.IDENT() != null) {
            System.out.println(memory.getOrDefault(ctx.IDENT().getText(), 0));
        }
        return 0;
    }

    /** inp: 'gets' '.' ('to_i' | 'to_f') */
    @Override
    public Integer visitInp(gParser.InpContext ctx) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        if (ctx.getChild(2).getText().equals("to_i")) {
            return Integer.parseInt(input);
        } else if (ctx.getChild(2).getText().equals("to_f")) {
            return (int) Float.parseFloat(input);
        }
        return 0;
    }

    /** ifStatement: 'if' boolExpr thenBlock (elseBlock)? 'end' */
    @Override
    public Integer visitIfStatement(gParser.IfStatementContext ctx) {
        // Проверка условия if
        if (visit(ctx.boolExpr()) != 0) {
            // Если условие if выполняется, выполняем блок then
            for (var statement : ctx.thenBlock().statement()) {
                visit(statement);
            }
            return 0; // Завершаем выполнение после блока then для if
        }

        // Проходим по всем elif блокам (если есть)
        for (gParser.ElifStatementContext elif : ctx.elifStatement()) {
            // Каждый elif проверяется через visitElifStatement
            if (visit(elif) != 0) {
                return 0; // Завершаем выполнение после первого выполненного elif
            }
        }

        // Проверка блока else, если условия if и elif не выполнены
        if (ctx.elseBlock() != null) {
            for (var statement : ctx.elseBlock().statement()) {
                visit(statement);
            }
        }

        return 0; // Завершаем выполнение после блока else (если он был)
    }


    // Visit elif statements
    @Override
    public Integer visitElifStatement(gParser.ElifStatementContext ctx) {
        // First, check the condition of the main 'if'
        if (visit(ctx.boolExpr()) != 0) {
            // If true, execute the thenBlock
            visit(ctx.thenBlock());
            return 0;  // Exit after the then block
        }

        // Loop through all the elif blocks
        for (gParser.ElifBlockContext elifBlock : ctx.elifBlock()) {
            // Check the condition of the elif block
            if (visit(elifBlock.boolExpr()) != 0) {
                // If condition is true, execute the corresponding thenBlock
                visit(elifBlock.thenBlock());
                return 0;  // Exit after the first matched elif
            }
        }

        // If none of the elif blocks matched, check for an optional else block
        if (ctx.elseBlock() != null) {
            visit(ctx.elseBlock());  // Execute else block if present
        }

        return 0; // Finish after evaluating the elif/else blocks
    }

    @Override
    public Integer visitElifBlock(gParser.ElifBlockContext ctx) {
        // The elif block has a boolean condition and a corresponding thenBlock.
        // We simply evaluate the boolean expression and execute the thenBlock if true.
        if (visit(ctx.boolExpr()) != 0) {
            visit(ctx.thenBlock());
            return 0;  // Exit after executing the then block
        }
        return 0;  // Return 0 if the condition of elif is not met (i.e., no action)
    }



    /** whileStatement: 'while' boolExpr 'do' doBlock 'end' */
    @Override
    public Integer visitWhileStatement(gParser.WhileStatementContext ctx) {
        while (visit(ctx.boolExpr()) != 0) {
            visit(ctx.doBlock());
        }
        return 0;
    }

    /** untilStatement: 'until' boolExpr 'do' doBlock 'end' */
    @Override
    public Integer visitUntilStatement(gParser.UntilStatementContext ctx) {
        do {
            visit(ctx.doBlock());
        } while (visit(ctx.boolExpr()) == 0);
        return 0;
    }

    /**
     * forStatement: 'for' IDENT 'in' SPEC_SIGN range SPEC_SIGN 'do' doBlock 'end'
     */
    @Override
    public Integer visitForStatement(gParser.ForStatementContext ctx) {
        // Extract the identifier (the loop variable)
        String loopVar = ctx.IDENT().getText();

        // Extract the range (start and end values)
        int startValue = visitStartValue(ctx.range().startValue());
        int endValue = visitEndValue(ctx.range().endValue());

        // Iterate over the range (inclusive range)
        for (int i = startValue; i <= endValue; i++) {
            // Store the loop variable value in memory (map)
            memory.put(loopVar, i);

            // Visit the doBlock, which contains the statements to be executed inside the loop
            visitDoBlock(ctx.doBlock());
        }

        return 0; // Void return type since we're executing the statements
    }

    // In EvalVisitor class

    @Override
    public Integer visitStartValue(gParser.StartValueContext ctx) {
        if (ctx.CONST() != null) {
            // Handle CONST value (parse the constant)
            return Integer.parseInt(ctx.CONST().getText());
        } else if (ctx.IDENT() != null) {
            // Handle IDENT (variable name)
            String varName = ctx.IDENT().getText();
            Integer value = memory.get(varName); // Retrieve from memory
            if (value == null) {
                throw new RuntimeException("Variable " + varName + " is not initialized.");
            }
            return value;
        }
        return null;  // This should not happen if grammar is correct
    }

    @Override
    public Integer visitEndValue(gParser.EndValueContext ctx) {
        if (ctx.CONST() != null) {
            // Handle CONST value (parse the constant)
            return Integer.parseInt(ctx.CONST().getText());
        } else if (ctx.IDENT() != null) {
            // Handle IDENT (variable name)
            String varName = ctx.IDENT().getText();
            Integer value = memory.get(varName); // Retrieve from memory
            if (value == null) {
                throw new RuntimeException("Variable " + varName + " is not initialized.");
            }
            return value;
        }
        return null;  // This should not happen if grammar is correct
    }


    /** switchStatement: 'switch' IDENT 'do' caseBlock+ 'end' */
    /** switchStatement: 'switch' IDENT 'do' caseBlock+ 'end' */
    @Override
    public Integer visitSwitchStatement(gParser.SwitchStatementContext ctx) {
        String id = ctx.IDENT().getText();
        int value = memory.getOrDefault(id, 0);  // Retrieve the value of the identifier in memory.
        boolean matched = false;  // Flag to check if a matching case was found.

        // Iterate over all case blocks in the switch statement.
        for (gParser.CaseBlockContext caseBlock : ctx.caseBlock()) {
            // Visit the value of the case and check if it matches the value of the identifier.
            Integer caseValue = visit(caseBlock.value());  // Retrieve the value for the current case block.

            // If the case value matches the switch value and no case has been matched yet, execute the thenBlock.
            if (caseValue != null && caseValue == value && !matched) {
                visit(caseBlock.thenBlock());  // Execute the corresponding thenBlock.
                matched = true;  // Mark that a case has been matched.
                break;  // Exit after finding the first matching case (you can modify this behavior if necessary).
            }
        }

        // If no case matched, you could add an optional default case handling here if your grammar supports it.
        // If there's no need for a default case, this block can be omitted.

        return 0;
    }

    /** Helper method to visit values (e.g., for case values) */
    @Override
    public Integer visitValue(gParser.ValueContext ctx) {
        if (ctx.CONST() != null) {
            // Return the constant value
            return Integer.valueOf(ctx.CONST().getText());
        } else if (ctx.LETTER() != null) {
            // Treat LETTER as an identifier and return its value from memory
            String id = ctx.LETTER().getText();
            return memory.getOrDefault(id, 0);  // Return 0 if the identifier is not found in memory
        }
        return 0;  // Default case
    }



    /** arithmExpression: term (('+' | '-') term)* */
    @Override
    public Integer visitArithmExpression(gParser.ArithmExpressionContext ctx) {
        int result = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            int value = visit(ctx.term(i));
            result = operator.equals("+") ? result + value : result - value;
        }
        return result;
    }

    /** term: factor (('*' | '/' | '**') factor)* */
    @Override
    public Integer visitTerm(gParser.TermContext ctx) {
        int result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size();
             i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            int value = visit(ctx.factor(i));
            switch (operator) {
                case "*":
                    result *= value;
                    break;
                case "/":
                    result /= value;
                    break;
                case "**":
                    result = (int) Math.pow(result, value);
                    break;
            }
        }
        return result;
    }

    /** boolExpr: arithmExpression relOp arithmExpression */
    @Override
    public Integer visitBoolExpr(gParser.BoolExprContext ctx) {
        int left = visit(ctx.arithmExpression(0));
        int right = visit(ctx.arithmExpression(1));
        String operator = ctx.relOp().getText();
        switch (operator) {
            case "<":
                return left < right ? 1 : 0;
            case "<=":
                return left <= right ? 1 : 0;
            case ">":
                return left > right ? 1 : 0;
            case ">=":
                return left >= right ? 1 : 0;
            case "==":
                return left == right ? 1 : 0;
            case "!=":
                return left != right ? 1 : 0;
        }
        return 0;
    }




    /** factor: IDENT | CONST | '(' arithmExpression ')' */
    @Override
    public Integer visitFactor(gParser.FactorContext ctx) {
        if (ctx.IDENT() != null) {
            return memory.getOrDefault(ctx.IDENT().getText(), 0);
        } else if (ctx.CONST() != null) {
            return Integer.valueOf(ctx.CONST().getText());
        } else {
            return visit(ctx.arithmExpression());
        }
    }

    /** Helper method to handle null visits */
    private Integer visitOrDefault(org.antlr.v4.runtime.tree.ParseTree node, Integer defaultValue) {
        return node != null ? visit(node) : defaultValue;
    }
}
