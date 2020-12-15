grammar IsiLang;

@header {
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
}

@members {
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
}

prog    : 'programa'  decl bloco  'fimprog.'
           {
              program.setVarTable(symbolTable);
              program.setComandos(stack.pop());
              verificaUsoVars();
           }
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
                  } else {
                    throw new IsiSemanticException("Variable " + _varName + " already exists");
                  }
                }
              )*
              DT
            ;

tipo    : 'numero' {_tipo = IsiVariable.NUMBER;}
        | 'texto'  {_tipo = IsiVariable.TEXT;}
        ;

bloco   : {
            curThread = new ArrayList<AbstractCommand>();
            stack.push(curThread);
          }
          (cmd)+
        ;

cmd     : cmdleitura
        | cmdescrita
        | cmdattrib
        | cmdselecao
        | cmdenquanto
        ;

cmdleitura  : 'leia' AP
                     ID {
                         verificaID(_input.LT(-1).getText());
                         _readID = _input.LT(-1).getText();
                     }
                     FP
                     DT
                     {
                        IsiVariable var =  (IsiVariable) symbolTable.get(_readID);
                        _type = var.getType();
                        IsiVariable newVar = new IsiVariable(_readID, _type, _readID);
                        symbolTable.put(_readID, newVar);
                        CommandLeitura cmd = new CommandLeitura(_readID, var);
                        stack.peek().add(cmd);
                     }
            ;

cmdescrita  : 'escreva' AP
                        (ID { verificaID(_input.LT(-1).getText()); }
                        | STRING) { _writeID =  _input.LT(-1).getText(); }
                        FP
                        DT
                        {
                            CommandEscrita cmd = new CommandEscrita(_writeID);
                            stack.peek().add(cmd);
                        }
            ;

cmdattrib   : ID {
                    verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                    IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
                    _type = var.getType();
              }
              ATTR { _exprContent = ""; }
              (
                    expr {
                        if (_type != IsiVariable.NUMBER) {
                            throw new IsiTypeException("variable " + _exprID + " isn't a NUMERO");
                        }
                    }
                  | STRING {
                        _exprContent += _input.LT(-1).getText();
                        if (_type != IsiVariable.TEXT) {
                            throw new IsiTypeException("variable " + _exprID + " isn't a TEXTO");
                        }
                  }
              ) {
                IsiVariable newVar = new IsiVariable(_exprID, _type, _exprContent);
                symbolTable.put(_exprID, newVar);
              }
              DT
              {
                CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
                stack.peek().add(cmd);
              }
            ;

cmdselecao  : 'se'
              AP
              (ID {
                _exprDecision = _input.LT(-1).getText();
                IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
                _type = var.getType();
                if (_type != IsiVariable.NUMBER) {
                    throw new IsiTypeException("variable " + _input.LT(-1).getText() + " isn't a NUMERO");
                }
              }
              | NUMBER { _exprDecision = _input.LT(-1).getText(); })
              OPREL { _exprDecision += _input.LT(-1).getText(); }
              ( ID {
                  IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
                  var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
                  _type = var.getType();
                  if (_type != IsiVariable.NUMBER) {
                      throw new IsiTypeException("variable " + _input.LT(-1).getText() + " isn't a NUMERO");
                  }
              }
              | NUMBER) { _exprDecision += _input.LT(-1).getText(); }
              FP
              'entao'
              ACH
              bloco
              FCH
              {
                listaTrue = stack.pop();
              }
              (
              'senao'
              ACH
              bloco
              FCH
              {
                listaFalse = stack.pop();
                CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue,listaFalse);
                stack.peek().add(cmd);
              })?
            ;

cmdenquanto : 'enquanto'
              AP
              (ID {
                {
                    IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
                    _type = var.getType();
                    if (_type != IsiVariable.NUMBER) {
                        throw new IsiTypeException("variable " + _input.LT(-1).getText() + " isn't a NUMERO");
                    }
                }
              }
              | NUMBER) { _exprWhile = _input.LT(-1).getText(); }
              OPREL { _exprWhile += _input.LT(-1).getText(); }
              ( ID {
                  IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
                  _type = var.getType();
                  if (_type != IsiVariable.NUMBER) {
                      throw new IsiTypeException("variable " + _input.LT(-1).getText() + " isn't a NUMERO");
                  }
              }
              | NUMBER) { _exprWhile += _input.LT(-1).getText(); }
              FP
              ACH
              bloco
              FCH
              {
                listaWhile = stack.pop();
                CommandEnquanto cmd = new CommandEnquanto(_exprWhile, listaWhile);
                stack.peek().add(cmd);
              }
             ;

expr        : termo (
                OP { _exprContent += _input.LT(-1).getText(); }
                termo
              )*
            ;

termo       : ID {
                    verificaID(_input.LT(-1).getText());
                    _exprContent += _input.LT(-1).getText();
              }
            |
            NUMBER {
                _exprContent += _input.LT(-1).getText();
            }
            ;



VIR     : ','
        ;

AP      : '('
        ;

FP      : ')'
        ;

ACH     : '{'
        ;

FCH     : '}'
        ;

OP      : '+' | '-' | '*' | '/'
        ;

OPREL   : '>' | '<' | '>=' | '<=' | '==' | '!='
        ;

SC      : ';'
        ;

DT      : '.'
        ;

ATTR    : ':='
        ;

ID      : [a-z] ([a-z] | [A-Z] | [0-9])*
        ;

NUMBER  : [0-9]+ ('.' [0-9]+)?
        ;

WS      : (' ' | '\n' | '\t' | '\r') -> skip
        ;

STRING     : '"' ([a-z] | [A-Z] | [0-9]) ([a-z] | [A-Z] | [0-9] | ' ')* '"'
        ;