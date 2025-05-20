import View.Menus;

import java.util.Scanner;

import static Controllers.FuncionarioSystem.LogarFuncionario;
import static Services.Logado.VerificarLogin;
import static Controllers.FuncionarioSystem.CriarFuncionario;

public class Main {
    public static void main(String[] args) {
        Scanner nc = new Scanner(System.in);
        Menus menus = new Menus();
        Boolean t = true;
        while(t){
            if(VerificarLogin()){
                System.out.print("Sair da conta: ");
                int opc = nc.nextInt();
                if(opc == 0){
                    LogarFuncionario();
                }
                t=false;
            } else {
                int resultado = menus.menuInicialCriacao();
                if(resultado == 0){
                    CriarFuncionario();
                }
            }
        }
    }
}
