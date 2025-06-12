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

    public static Boolean criarAquivo( String nome, String servico){
        final String pathName = "C:\\Users\\Rony\\Documents\\GitHub\\Pet-Prime\\data\\atendimento.txt";
        try{
            if(avaliarArquivo()){
                BufferedWriter file = new BufferedWriter(new FileWriter(pathName, true));
                file.write("Inicio: "+data()+" - "+ hora()+"+hrs\n"+"Trabalho: "+servico+" - Resposável: "+nome);
                file.newLine();
                file.newLine();
                file.close();
                return true;
            } else {
                System.out.println("Você ainda está em serviço, finalize para iniciar outro");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList passarTxtPraArray(String pathName){
        try{
            BufferedReader file = new BufferedReader(new FileReader(pathName));
            String linha;
            ArrayList<String> arquivo = new ArrayList<>();

            while((linha = file.readLine()) !=  null){
                arquivo.add(linha);
            };

            file.close();
            return arquivo;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean lerAquivo(){
        final String pathName = "C:\\Users\\Rony\\Documents\\GitHub\\Pet-Prime\\data\\atendimento.txt";
        try{
            ArrayList<String> arquivo = passarTxtPraArray(pathName);

            int contador = 0;
            for(int i=0; i<arquivo.size(); i++){
                contador++;
            }

            String valorAntigo = arquivo.get(contador-3);
            arquivo.set(contador-3, valorAntigo+" | Termino: "+ hora()+"-hrs");

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

    public static Boolean avaliarArquivo(){
        final String pathName = "C:\\Users\\Rony\\Documents\\GitHub\\Pet-Prime\\data\\atendimento.txt";
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

            if(contador == 0){
                return true;
            }

            String valorAntigo = arquivo.get(contador-3);

            if(valorAntigo.contains("Termino")){
                return true;
            } else {

                return false;
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean cadastrarUserNoFile(String nome){
        final String pathName = "C:\\Users\\Rony\\Documents\\GitHub\\Pet-Prime\\data\\user.txt";
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter(pathName));
            file.write(nome);
            file.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public static String procurarUserNoFile(){
        final String pathName = "C:\\Users\\Rony\\Documents\\GitHub\\Pet-Prime\\data\\user.txt";
        try{
            BufferedReader file = new BufferedReader(new FileReader(pathName));
            String nome = file.readLine();
            file.close();
            return nome;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean validarOpcoesMenu(int quantidadeAtual, int quantidadeDigitada){
        for(int i=0; i<=quantidadeAtual; i++){
            if(i == quantidadeDigitada){
                return true;
            }
        }
        return false;
    }


    public static void pressioneEnterParaContinuar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    public static Boolean validarNumero(String num){
        try{
            Double.parseDouble(num);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static String somarHoras(ArrayList array){
        int totalHoras = 0;
        int totalMinutos = 0;
        //tosa
        try{
            for(int i = 0; i < array.size(); i++){
                String linha = array.get(i).toString();
                String horasInicio = linha.split(" ")[3].split("\\+")[0];
                String horasFinal = linha.split(" ")[6].split("-")[0];

                int horaInicio = Integer.parseInt(horasInicio.split(":")[0]);
                int minutoInicio = Integer.parseInt(horasInicio.split(":")[1]);

                int horaFinal = Integer.parseInt(horasFinal.split(":")[0]);
                int minutoFinal = Integer.parseInt(horasFinal.split(":")[1]);

                int diferencaHoras = horaFinal - horaInicio;
                int diferencaMinutos = minutoFinal - minutoInicio;

                if (diferencaMinutos < 0) {
                    diferencaMinutos += 60;
                    diferencaHoras -= 1;
                }

                totalHoras += diferencaHoras;
                totalMinutos += diferencaMinutos;
            }

            totalHoras += totalMinutos / 60;
            totalMinutos = totalMinutos % 60;

            return String.format("%02d:%02d", totalHoras, totalMinutos);
        }catch(ArrayIndexOutOfBoundsException e){
            return "Em serviço";
        }
    }
}
