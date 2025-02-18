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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, VIR=11, AP=12, FP=13, ACH=14, FCH=15, OP=16, OPREL=17, SC=18, 
		DT=19, ATTR=20, ID=21, NUMBER=22, WS=23, STRING=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "VIR", "AP", "FP", "ACH", "FCH", "OP", "OPREL", "SC", "DT", "ATTR", 
			"ID", "NUMBER", "WS", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", "'enquanto'", "','", "'('", "')'", "'{'", 
			"'}'", null, null, "';'", "'.'", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "VIR", 
			"AP", "FP", "ACH", "FCH", "OP", "OPREL", "SC", "DT", "ATTR", "ID", "NUMBER", 
			"WS", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    private int _tipo;
	    private String _varName;
	    private String _varValue;
	    private IsiSymbolTable symbolTable = new IsiSymbolTable();
	    private IsiSymbol symbol;
	    private IsiProgram program = new IsiProgram();
	    private ArrayList<AbstractCommand> curThread;
	    private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	    private ArrayList<AbstractCommand> listaTrue;
	    private ArrayList<AbstractCommand> listaFalse;
	    private ArrayList<AbstractCommand> listaWhile;

	    private String _readID;
	    private String _writeID;
	    private String _exprID;
	    private String _exprContent;
	    private String _exprDecision;
	    private String _exprWhile;
	    private int _type;

	    public void verificaID(String id) {
	        if(!symbolTable.exists(id)) {
	            throw new IsiSemanticException("Symbol " + id + " not declared");
	        }
	    }

	    public void verificaUsoVars() {
	        for(IsiSymbol symbol : symbolTable.values()) {
	            IsiVariable curr = (IsiVariable) symbol;
	            if(curr.getValue() == null) {
	                System.out.println("variable " + curr.getName() + " is declared but never used");
	            }
	        }
	    }

	    public void exibeComandos() {
	        for (AbstractCommand c : program.getComandos()) {
	            System.out.println(c);
	        }
	    }

	    public void generateCode() {
	        program.generateTarget();
	    }


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00b9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u008d\n\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\7\26\u0098\n\26\f\26\16\26\u009b\13\26"+
		"\3\27\6\27\u009e\n\27\r\27\16\27\u009f\3\27\3\27\6\27\u00a4\n\27\r\27"+
		"\16\27\u00a5\5\27\u00a8\n\27\3\30\3\30\3\30\3\30\3\31\3\31\5\31\u00b0"+
		"\n\31\3\31\7\31\u00b3\n\31\f\31\16\31\u00b6\13\31\3\31\3\31\2\2\32\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\t\5\2,-//\61\61\4\2>>@@\3"+
		"\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\6\2\"\"\62;C\\c|\2\u00c1"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\3\63\3\2\2\2\5<\3\2\2\2\7E\3\2\2\2\tL\3\2\2\2\13R\3\2"+
		"\2\2\rW\3\2\2\2\17_\3\2\2\2\21b\3\2\2\2\23h\3\2\2\2\25n\3\2\2\2\27w\3"+
		"\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2\2\37\177\3\2\2\2!\u0081\3\2\2"+
		"\2#\u008c\3\2\2\2%\u008e\3\2\2\2\'\u0090\3\2\2\2)\u0092\3\2\2\2+\u0095"+
		"\3\2\2\2-\u009d\3\2\2\2/\u00a9\3\2\2\2\61\u00ad\3\2\2\2\63\64\7r\2\2\64"+
		"\65\7t\2\2\65\66\7q\2\2\66\67\7i\2\2\678\7t\2\289\7c\2\29:\7o\2\2:;\7"+
		"c\2\2;\4\3\2\2\2<=\7h\2\2=>\7k\2\2>?\7o\2\2?@\7r\2\2@A\7t\2\2AB\7q\2\2"+
		"BC\7i\2\2CD\7\60\2\2D\6\3\2\2\2EF\7p\2\2FG\7w\2\2GH\7o\2\2HI\7g\2\2IJ"+
		"\7t\2\2JK\7q\2\2K\b\3\2\2\2LM\7v\2\2MN\7g\2\2NO\7z\2\2OP\7v\2\2PQ\7q\2"+
		"\2Q\n\3\2\2\2RS\7n\2\2ST\7g\2\2TU\7k\2\2UV\7c\2\2V\f\3\2\2\2WX\7g\2\2"+
		"XY\7u\2\2YZ\7e\2\2Z[\7t\2\2[\\\7g\2\2\\]\7x\2\2]^\7c\2\2^\16\3\2\2\2_"+
		"`\7u\2\2`a\7g\2\2a\20\3\2\2\2bc\7g\2\2cd\7p\2\2de\7v\2\2ef\7c\2\2fg\7"+
		"q\2\2g\22\3\2\2\2hi\7u\2\2ij\7g\2\2jk\7p\2\2kl\7c\2\2lm\7q\2\2m\24\3\2"+
		"\2\2no\7g\2\2op\7p\2\2pq\7s\2\2qr\7w\2\2rs\7c\2\2st\7p\2\2tu\7v\2\2uv"+
		"\7q\2\2v\26\3\2\2\2wx\7.\2\2x\30\3\2\2\2yz\7*\2\2z\32\3\2\2\2{|\7+\2\2"+
		"|\34\3\2\2\2}~\7}\2\2~\36\3\2\2\2\177\u0080\7\177\2\2\u0080 \3\2\2\2\u0081"+
		"\u0082\t\2\2\2\u0082\"\3\2\2\2\u0083\u008d\t\3\2\2\u0084\u0085\7@\2\2"+
		"\u0085\u008d\7?\2\2\u0086\u0087\7>\2\2\u0087\u008d\7?\2\2\u0088\u0089"+
		"\7?\2\2\u0089\u008d\7?\2\2\u008a\u008b\7#\2\2\u008b\u008d\7?\2\2\u008c"+
		"\u0083\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0088\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d$\3\2\2\2\u008e\u008f\7=\2\2\u008f&\3\2"+
		"\2\2\u0090\u0091\7\60\2\2\u0091(\3\2\2\2\u0092\u0093\7<\2\2\u0093\u0094"+
		"\7?\2\2\u0094*\3\2\2\2\u0095\u0099\t\4\2\2\u0096\u0098\t\5\2\2\u0097\u0096"+
		"\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		",\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\t\6\2\2\u009d\u009c\3\2\2\2"+
		"\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a7"+
		"\3\2\2\2\u00a1\u00a3\7\60\2\2\u00a2\u00a4\t\6\2\2\u00a3\u00a2\3\2\2\2"+
		"\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8"+
		"\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8.\3\2\2\2\u00a9"+
		"\u00aa\t\7\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\30\2\2\u00ac\60\3\2\2"+
		"\2\u00ad\u00af\7$\2\2\u00ae\u00b0\t\5\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b4"+
		"\3\2\2\2\u00b1\u00b3\t\b\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u00b8\7$\2\2\u00b8\62\3\2\2\2\f\2\u008c\u0097\u0099\u009f\u00a5"+
		"\u00a7\u00af\u00b2\u00b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}