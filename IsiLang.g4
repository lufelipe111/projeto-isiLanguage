grammar IsiLang;

@header {
    import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
    import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
    import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
    import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
    import java.util.ArrayList;
}

@members {
    private int _tipo;
    private String _varname;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
}

prog    : 'programa'  decl bloco  'fimprog;'
        ;

decl : (declaravar)+
     ;

declaravar  : tipo ID (VIR ID)* SC
            ;

tipo    : 'numero' {System.out.println("TIPO NUMERO")}
        | 'texto'  {System.out.println("TIPO TEXTO")}
        ;

bloco   : (cmd)+
        ;

cmd     : cmdleitura {System.out.println("Reconheci um comando de LEITURA");}
        | cmdescrita {System.out.println("Reconheci um comando de ESCRITA");}
        | cmdattrib  {System.out.println("Reconheci um comando de ATRIBUICAO");}
        ;

cmdleitura  : 'leia' AP
                     ID {System.out.println("ID=" + _input.LT(-1).getText());}
                     FP
                     SC
            ;

cmdescrita  : 'escreva' AP
                        ID
                        FP
                        SC
            ;

cmdattrib   : ID ATTR expr SC {System.out.println("Reconheci um comando de atribuicao");}
            ;

expr        : termo ( OP termo )*
            ;

termo       : ID | NUMBER
            ;

VIR     : ','
        ;

AP      : '('
        ;

FP      : ')'
        ;

OP      : '+' | '-' | '*' | '/'
        ;

SC      : ';'
        ;

ATTR    : '='
        ;

ID      : [a-z] ([a-z] | [A-Z] | [0-9])*
        ;

NUMBER  : [0-9]+ ('.' [0-9]+)?
        ;

WS      : (' ' | '\n' | '\t' | '\r') -> skip
        ;