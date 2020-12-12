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

    public void verificaID(String id) {
        if(!symbolTable.exists(_varName)) {
          throw new IsiSemanticException("Symbol " + _varName + " not declared");
        }
    }
}

prog    : 'programa'  decl bloco  'fimprog;'
        ;

decl : (declaravar)+
     ;

declaravar  : tipo
              ID {
                _varName = _input.LT(-1).getText();
                _varValue = null;
                symbol = new IsiVariable(_varName, _tipo, _varValue);
                if(!symbolTable.exists(_varName)) {
                  symbolTable.add(symbol);
                  System.out.println("Simbolo adicionado: " + symbol);
                } else {
                  throw new IsiSemanticException("Variable" + _varName + "already exists");
                }
                symbolTable.add(symbol);
              }
              (
                VIR
                ID {
                  _varName = _input.LT(-1).getText();
                  _varValue = null;
                  symbol = new IsiVariable(_varName, _tipo, _varValue);
                  if(!symbolTable.exists(_varName)) {
                    symbolTable.add(symbol);
                    System.out.println("Simbolo adicionado: " + symbol);
                  } else {
                    throw new IsiSemanticException("Variable " + _varName + " already exists");
                  }
                }
              )*
              SC
            ;

tipo    : 'numero' {_tipo = IsiVariable.NUMBER;}
        | 'texto'  {_tipo = IsiVariable.TEXT;}
        ;

bloco   : (cmd)+
        ;

cmd     : cmdleitura
        | cmdescrita
        | cmdattrib
        ;

cmdleitura  : 'leia' AP
                     ID { verificaID(_input.LT(-1).getText()); }
                     FP
                     SC
            ;

cmdescrita  : 'escreva' AP
                        ID { verificaID(_input.LT(-1).getText()); }
                        FP
                        SC
            ;

cmdattrib   : ID { verificaID(_input.LT(-1).getText()); }
              ATTR
              expr
              SC
            ;

expr        : termo ( OP termo )*
            ;

termo       : ID { verificaID(_input.LT(-1).getText()); }
            | NUMBER
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