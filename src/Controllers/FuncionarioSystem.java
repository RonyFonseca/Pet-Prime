package Controllers;
import View.Menus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static Services.Arquivos.criarAquivo;
import static Services.Arquivos.lerAquivo;

public class FuncionarioSystem {
    static Menus menus = new Menus();

    public static void CriarFuncionario() {
        try{
            final String STATUS = "Funcionário";
            BufferedWriter file =  criarAquivo("C:\\Users\\Rony Fonseca de Lima\\IdeaProjects\\Pet-Prime\\data\\user.txt");
            String[] data = menus.menuCriarFuncionario();
            file.newLine();
            file.write(data[0]+ " ");
            file.write(data[1] + " ");
            file.write(data[2] + " ");
            file.write(STATUS);
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        };
    };

    public static void LogarFuncionario() {
        try {
            BufferedReader file = lerAquivo("C:\\Users\\Rony Fonseca de Lima\\IdeaProjects\\Pet-Prime\\data\\user.txt");
            String[] data = menus.menuLogin();
            String linha="";
            while((linha = file.readLine())!=null){
                String nome = linha.split(" ")[0];
                String senha = linha.split(" ")[2];

                if(nome.equals(data[0])){
                    if(senha.equals(data[1])){
                        System.out.println("Você logou seu corno");
                    }
                }
            }
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
