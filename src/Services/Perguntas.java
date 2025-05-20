package Services;
import java.util.Scanner;

public class Perguntas {
    Scanner scanner = new Scanner(System.in);

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

}
