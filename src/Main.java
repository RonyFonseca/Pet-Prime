import Controllers.Servicos.Banho;
import Controllers.Servicos.Tosa;

public class Main {
    public static void main(String[] args) {
        //Criando um trabalho de tosa
        //Tosa tosa = new Tosa("Demi");
        //tosa.finalizarTrabalho();

        //Criando um trabalho de banho
        Banho banho = new Banho("Rony");
        banho.finalizarTrabalho();
        banho.getDescricao();
    }
}
