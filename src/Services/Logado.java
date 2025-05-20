package Services;
import java.io.BufferedReader;
import java.io.IOException;
import static Services.Arquivos.lerAquivo;
public class Logado {
    public static Boolean VerificarLogin(){
        try {
            BufferedReader file = lerAquivo("C:\\Users\\Rony Fonseca de Lima\\IdeaProjects\\Pet-Prime\\data\\user.txt");
            String linha;
            String user = "";

            while((linha = file.readLine()) != null){
                user = linha;
            }

            file.close();

            if(user.length()>0){
                return true;
            } else {
                return false;
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch (Exception e){
            return false;
        }
        return null;
    }
}
