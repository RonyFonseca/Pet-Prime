package Services;
import java.io.BufferedReader;
import java.io.IOException;
import static Services.Arquivos.lerAquivo;
public class Logado {
    private static String path = "C:\\Users\\Rony Fonseca de Lima\\IdeaProjects\\Pet-Prime\\data\\usuarios.txt";

    public static void VerificarLogin(){
        try {
            BufferedReader file = lerAquivo("usuarios.txt");
            System.out.println(file.readLine());
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    };
}
