package Services;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivos {
    private static String path = "C:\\Users\\Rony Fonseca de Lima\\IdeaProjects\\Pet-Prime\\data\\";

    public static BufferedWriter criarAquivo(String nome){
        path = path + nome;
        try{

            BufferedWriter file = new BufferedWriter(new FileWriter(path));
            return file;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedReader lerAquivo(String nome){
        path = path + nome;
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            return file;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
