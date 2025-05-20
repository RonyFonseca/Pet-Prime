package Services;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivos {

    public static BufferedWriter criarAquivo(String path){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter(path, true));
            return file;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedReader lerAquivo(String path){
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            return file;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
