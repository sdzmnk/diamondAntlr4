public class CodeTranslateListener extends gBaseListener {

    private int labelCounter = 0;

    private String newLabel() {
        return "m" + (labelCounter++);
    }
    @Override
    public void exitProg(gParser.ProgContext ctx) {
        System.out.println("Код згенеровано");
    }
    @Override
    public void enterProg(gParser.ProgContext ctx) {
        System.out.print("\n");
    }

    @Override
    public void exitOut(gParser.OutContext ctx) {
        if (ctx.CONST() != null) {
            System.out.print(ctx.CONST().getText() + "\tOUT\nout_op\n");
        } else if (ctx.IDENT() != null) {
            System.out.print(ctx.IDENT().getText() + "\tOUT\nout_op\n");
        }
    }

    @Override
    public void enterAssign(gParser.AssignContext ctx) {
        String id = ctx.IDENT().getText();
        System.out.print(id + "\tl-val\n");
    }

    @Override
    public void exitAssign(gParser.AssignContext ctx) {
        System.out.print("=\tassign_op\n");
    }

    @Override
    public void exitArithmExpression(gParser.ArithmExpressionContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String text = ctx.getChild(i).getText();
            if (text.equals("+")) {
                System.out.print("+\tadd_op\n");
            } else if (text.equals("-")) {
                System.out.print("-\tadd_op\n");
            }
        }
    }

    @Override
    public void exitTerm(gParser.TermContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String text = ctx.getChild(i).getText();
            if (text.equals("*")) {
                System.out.print("*\tmult_op\n");
            } else if (text.equals("/")) {
                System.out.print("/\tmult_op\n");
            } else if (text.equals("**")) {
                System.out.print("**\tpow_op\n");
            }
        }
    }

    @Override
    public void exitFactor(gParser.FactorContext ctx) {
        if (ctx.CONST() != null) {
            String value = ctx.CONST().getText();
            if (value.contains(".")) {
                System.out.print(value + "\tfloat\n");
            } else {
                System.out.print(value + "\tint\n");
            }
        } else if (ctx.IDENT() != null) {
            System.out.print(ctx.IDENT().getText() + "\tr-val\n");
        }
    }

    @Override
    public void exitBoolExpr(gParser.BoolExprContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String text = ctx.getChild(i).getText();
            if (text.matches("<|>|<=|>=|==|!=")) {
                System.out.print(text + "\trel_op\n");
            }
        }
    }

    @Override
    public void enterIfStatement(gParser.IfStatementContext ctx) {
        System.out.print("if\tkeyword\n");
    }

    @Override
    public void exitIfStatement(gParser.IfStatementContext ctx) {
        System.out.print("end\tkeyword\n");
    }

    @Override
    public void enterWhileStatement(gParser.WhileStatementContext ctx) {
        String label = newLabel();
        System.out.print(label + "\tlabel\n: \tcolon\n");
    }

    @Override
    public void exitWhileStatement(gParser.WhileStatementContext ctx) {
        String label = newLabel();
        System.out.print(label + "\tlabel\nJMP\tjump\n");
    }

    @Override
    public void enterUntilStatement(gParser.UntilStatementContext ctx) {
        String label = newLabel();
        System.out.print(label + "\tlabel\n: \tcolon\n");
    }

    @Override
    public void exitUntilStatement(gParser.UntilStatementContext ctx) {
        String label = newLabel();
        System.out.print(label + "\tlabel\nJMP\tjump\n");
    }

    @Override
    public void enterForStatement(gParser.ForStatementContext ctx) {
        String label = newLabel();
        System.out.print(label + "\tlabel\n: \tcolon\n");
    }

    @Override
    public void exitForStatement(gParser.ForStatementContext ctx) {
        String label = newLabel();
        System.out.print(label + "\tlabel\nJMP\tjump\n");
    }

    @Override
    public void enterSwitchStatement(gParser.SwitchStatementContext ctx) {
        System.out.print("switch\tkeyword\n");
    }

    @Override
    public void exitSwitchStatement(gParser.SwitchStatementContext ctx) {
        System.out.print("end\tkeyword\n");
    }

    @Override
    public void enterCaseBlock(gParser.CaseBlockContext ctx) {
        System.out.print("case\tkeyword\n");
    }

    @Override
    public void exitCaseBlock(gParser.CaseBlockContext ctx) {
        System.out.print("end\tkeyword\n");
    }
}
