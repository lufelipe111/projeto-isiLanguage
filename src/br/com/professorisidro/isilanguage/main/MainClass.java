package br.com.professorisidro.isilanguage.main;

import br.com.professorisidro.isilanguage.parser.IsiLangLexer;
import br.com.professorisidro.isilanguage.parser.IsiLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/** Esta é a classe que é responsável por criar a interação com o usuário
 *  instanciando nosso parser e apontando para o aroquivo fonte.
 *
 *  Arquivo fonte: *.isi
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            IsiLangLexer lexer;
            IsiLangParser parser;

            // Leio o arquivo "input.isi" e isso é entrada para analisador lexico
            lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));

            // Crio um fluxo de tokens para passar para o parser
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // Crio meu parser a partir do token stream
            parser = new IsiLangParser(tokenStream);

            parser.prog();

            System.out.println("Compilation success!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
