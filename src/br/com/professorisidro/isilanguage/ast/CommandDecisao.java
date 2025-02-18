package br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand{

    private String condition;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;

    public CommandDecisao(String condition, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf) {
        this.condition = condition;
        this.listaTrue = lt;
        this.listaFalse =lf;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();

        str.append("if (" + condition + ") {\n");
        // Bloco de comandos
        for (AbstractCommand cmd : listaTrue) {
            str.append(cmd.generateJavaCode());
            str.append("\n");
        }
        str.append("}\n");
        if(listaFalse.size() > 0) {
            str.append("else {\n");
            // Outro bloco de comandos
            for (AbstractCommand cmd : listaFalse) {
                str.append(cmd.generateJavaCode());
                str.append("\n");
            }
            str.append("}\n");
        }

        return str.toString();
    }

    @Override
    public String toString() {
        return "CommandDecisao[" +
                "condition = " + condition +
                ", listaTrue = " + listaTrue +
                ", listaFalse = " + listaFalse +
                ']';
    }
}
