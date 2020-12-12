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
    private String _varName;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;
}

prog    : 'programa'  decl bloco  'fimprog;'
        ;

decl : (declaravar)+
     ;

declaravar  : tipo {
                _varName = _input.LT(-1).getText();
                _varValue = null;
                symbol = new IsiVariable(_varName, _tipo, _varValue);
                System.out.println("Simbolo adicionado: " + symbol);
                symbolTable.add(symbol);
              }
              ID {
                   _varName = _input.LT(-1).getText();
                   _varValue = null;
                   symbol = new IsiVariable(_varName, _tipo, _varValue);
                   System.out.println("Simbolo adicionado: " + symbol);
                   symbolTable.add(symbol);
                 }
              (
                VIR
                ID
              )*
              SC
            ;

tipo    : 'numero' {_tipo = IsiVariable.NUMBER;}
        | 'texto'  {_tipo = IsiVariable.TEXT;}
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