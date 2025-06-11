package Services;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Services {
    public static Scanner scanner = new Scanner(System.in);

    public int criarPergunta(String msg, int num){
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        int ResultadoPergunta = scanner.nextInt();
        return ResultadoPergunta;
    }

    public String criarPergunta(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String ResultadoPergunta = scanner.next();
        return ResultadoPergunta;
    }

    public static void limparTela() {
        for(int i=0; i<30; i++){
            System.out.println(" ");
        };
    };

    public static Boolean criarAquivo(String path, String nome, String servico){
        final String pathName = "/home/rony/IdeaProjects/Pet-Prime/data/"+path+".txt";
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter(pathName, true));
            file.write("Inicio: "+data()+" - "+ hora()+"hrs\n"+"Trabalho: "+servico+" - Resposável: "+nome);
            file.newLine();
            file.newLine();
            file.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String hora(){
        LocalTime newHora = LocalTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        String hora = formatter2.format(newHora);

        return hora;
    }

    public static String data(){
        LocalDate newData = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = formatter.format(newData);

        return data;
    }

    public static Boolean lerAquivo(String path){
        final String pathName = "/home/rony/IdeaProjects/Pet-Prime/data/"+path+".txt";
        try{
            BufferedReader file = new BufferedReader(new FileReader(pathName));
            String linha;
            ArrayList<String> arquivo = new ArrayList<>();

            while((linha = file.readLine()) !=  null){
                arquivo.add(linha);
            };

            file.close();
            int contador = 0;
            for(int i=0; i<arquivo.size(); i++){
                contador++;
            }

            String valorAntigo = arquivo.get(contador-3);
            arquivo.set(contador-3, valorAntigo+" | Termino: "+ hora()+"hrs");

            BufferedWriter file1 = new BufferedWriter(new FileWriter(pathName));
            for(int i=0; i<arquivo.size(); i++){
                file1.write(arquivo.get(i)+"\n");
            }
            file1.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void pressioneEnterParaContinuar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}
