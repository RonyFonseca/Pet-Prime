package Controllers;
import java.io.BufferedWriter;
import java.io.IOException;

import static Services.Arquivos.criarAquivo;

public class FuncionarioSystem {
    private static String path = "C:\\Users\\Rony Fonseca de Lima\\IdeaProjects\\Pet-Prime\\data\\usuarios.txt";

    public static void CriarFuncionario() {
        try{
            BufferedWriter file =  criarAquivo("usuarios.txt");
            file.write("Admin"+ " ");
            file.write("Funcionario"+ " ");
            file.write("123");
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        };
    };
}
