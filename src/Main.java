import Controllers.Servicos.Banho;
import Controllers.Servicos.Tosa;
import Models.Servico;
import View.Menus;

public class Main {
    public static void main(String[] args) {
        while(true){
            Menus menu = new Menus();
            int opc = menu.menuPrincipal();
            if(opc == 1){
                opc = menu.menuAtendimentos();
                if(opc == 1){
                    opc = menu.menuIniciarAtendimento();
                    if(opc == 1){
                        Servico servico = new Tosa();
                        servico.iniciarTrabalho();
                    } else if(opc == 2){
                        Servico servico = new Banho();
                        servico.iniciarTrabalho();
                    } else if(opc == 3){
                        //Adestrar
                    }
                }else if(opc == 2){
                    Servico servico = new Tosa();
                    servico.finalizarTrabalho();
                }
            } else if(opc == 2){
                //Produtos
            } else if(opc == 0){
                //sair
                break;
            }
        }
    }
}
