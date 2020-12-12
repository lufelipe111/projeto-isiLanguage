grammar IsiLang;

prog    : 'programa'  bloco  'fimprog;'
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

cmdattrib   : ID ATTR expr SC
            ;

expr        : termo ( OP termo )*
            ;

termo       : ID | NUMBER
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