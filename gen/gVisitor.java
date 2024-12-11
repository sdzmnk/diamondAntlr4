// Generated from C:/Users/sdzim/IdeaProjects/untitled2/src/g.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#progam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgam(gParser.ProgamContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#declarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationList(gParser.DeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(gParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(gParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(gParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(gParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(gParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#inp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInp(gParser.InpContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#out}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut(gParser.OutContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(gParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(gParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(gParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#startValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartValue(gParser.StartValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#endValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndValue(gParser.EndValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#untilStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilStatement(gParser.UntilStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#doBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoBlock(gParser.DoBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(gParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(gParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(gParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(gParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#elifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifStatement(gParser.ElifStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#elifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifBlock(gParser.ElifBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(gParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(gParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#arithmExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmExpression(gParser.ArithmExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(gParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(gParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(gParser.RelOpContext ctx);
}