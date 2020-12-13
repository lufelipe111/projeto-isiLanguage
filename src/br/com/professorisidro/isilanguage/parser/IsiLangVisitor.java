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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IsiLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IsiLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdselecao(IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdenquanto(IsiLangParser.CmdenquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(IsiLangParser.TermoContext ctx);
}