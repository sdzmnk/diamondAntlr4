// Generated from C:/Users/sdzim/IdeaProjects/untitled2/src/g.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#progam}.
	 * @param ctx the parse tree
	 */
	void enterProgam(gParser.ProgamContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#progam}.
	 * @param ctx the parse tree
	 */
	void exitProgam(gParser.ProgamContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(gParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(gParser.DeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(gParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(gParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(gParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(gParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(gParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(gParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(gParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(gParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(gParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(gParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#inp}.
	 * @param ctx the parse tree
	 */
	void enterInp(gParser.InpContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#inp}.
	 * @param ctx the parse tree
	 */
	void exitInp(gParser.InpContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#out}.
	 * @param ctx the parse tree
	 */
	void enterOut(gParser.OutContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#out}.
	 * @param ctx the parse tree
	 */
	void exitOut(gParser.OutContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 */
	void enterThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 */
	void exitThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(gParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(gParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(gParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(gParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(gParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(gParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#startValue}.
	 * @param ctx the parse tree
	 */
	void enterStartValue(gParser.StartValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#startValue}.
	 * @param ctx the parse tree
	 */
	void exitStartValue(gParser.StartValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#endValue}.
	 * @param ctx the parse tree
	 */
	void enterEndValue(gParser.EndValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#endValue}.
	 * @param ctx the parse tree
	 */
	void exitEndValue(gParser.EndValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#untilStatement}.
	 * @param ctx the parse tree
	 */
	void enterUntilStatement(gParser.UntilStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#untilStatement}.
	 * @param ctx the parse tree
	 */
	void exitUntilStatement(gParser.UntilStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#doBlock}.
	 * @param ctx the parse tree
	 */
	void enterDoBlock(gParser.DoBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#doBlock}.
	 * @param ctx the parse tree
	 */
	void exitDoBlock(gParser.DoBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(gParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(gParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(gParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(gParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(gParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(gParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(gParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(gParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElifStatement(gParser.ElifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElifStatement(gParser.ElifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#elifBlock}.
	 * @param ctx the parse tree
	 */
	void enterElifBlock(gParser.ElifBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#elifBlock}.
	 * @param ctx the parse tree
	 */
	void exitElifBlock(gParser.ElifBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(gParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(gParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(gParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(gParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#arithmExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmExpression(gParser.ArithmExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#arithmExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmExpression(gParser.ArithmExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(gParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(gParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(gParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(gParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(gParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(gParser.RelOpContext ctx);
}