// Generated from C:/Users/lufel/Desktop/UFABC/Compiladores/projeto-isiLanguage\IsiLang.g4 by ANTLR 4.9
package br.com.professorisidro.isilanguage.parser;

    import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
    import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
    import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
    import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
    import br.com.professorisidro.isilanguage.exceptions.IsiTypeException;
    import br.com.professorisidro.isilanguage.ast.IsiProgram;
    import br.com.professorisidro.isilanguage.ast.AbstractCommand;
    import br.com.professorisidro.isilanguage.ast.CommandLeitura;
    import br.com.professorisidro.isilanguage.ast.CommandEscrita;
    import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
    import br.com.professorisidro.isilanguage.ast.CommandDecisao;
    import br.com.professorisidro.isilanguage.ast.CommandEnquanto;

    import java.util.Stack;
    import java.util.ArrayList;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link IsiLangVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class IsiLangBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements IsiLangVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProg(IsiLangParser.ProgContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDecl(IsiLangParser.DeclContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDeclaravar(IsiLangParser.DeclaravarContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTipo(IsiLangParser.TipoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBloco(IsiLangParser.BlocoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCmd(IsiLangParser.CmdContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCmdleitura(IsiLangParser.CmdleituraContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCmdescrita(IsiLangParser.CmdescritaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCmdattrib(IsiLangParser.CmdattribContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCmdselecao(IsiLangParser.CmdselecaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCmdenquanto(IsiLangParser.CmdenquantoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpr(IsiLangParser.ExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTermo(IsiLangParser.TermoContext ctx) { return visitChildren(ctx); }
}