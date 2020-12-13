package br.com.professorisidro.isilanguage.ast;

import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IsiProgram {
    private IsiSymbolTable varTable;
    private ArrayList<AbstractCommand> comandos;
    private String programName;


    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass {\n");
        str.append("    public static void main (String args[]) {\n");
        str.append("        Scanner _key = new Scanner(System.in);\n");
        for(IsiSymbol symbol : varTable.getAll()) {
            str.append(symbol.generateJavaCode()+"\n");
        }
        for (AbstractCommand command : comandos) {
            str.append(command.generateJavaCode()+"\n");
        }
        str.append("    }\n");
        str.append("}");

        try {
            FileWriter fw = new FileWriter(new File("MainClass.java"));
            fw.write(str.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IsiSymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(IsiSymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
