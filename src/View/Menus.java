package View;

import Services.Services;

public class Menus {
    Services services =  new Services();
    public int menuPrincipal(){
        System.out.println("--------[HOME]--------");
        System.out.println("[1] - Atendimento");
        System.out.println("[2] - Produtos");
        System.out.println("[0] - Sair");
        System.out.println("----------------------");
        int opc = services.criarPergunta("Escolha uma opção: ", 1);
        if(services.validarOpcoesMenu(2, opc)){
            return opc;
        } else {
            return 400;
        }
    }

    public int menuAtendimentos(){
        System.out.println("-----[ATENDIMENTO]-----");
        System.out.println("[1] - Iniciar atendimento");
        System.out.println("[2] - Finalizar atendimento");
        System.out.println("[0] - Voltar");
        System.out.println("---------------------");
        int opc = services.criarPergunta("Escolha uma opção: ", 1);
        if(services.validarOpcoesMenu(2, opc)){
            return opc;
        } else {
            return 400;
        }
    }

    public int menuIniciarAtendimento(){
        System.out.println("-----[ATENDIMENTO]-----");
        System.out.println("[1] - Tosa");
        System.out.println("[2] - Banho");
        System.out.println("[3] - Adestrar");
        System.out.println("[0] - Voltar");
        System.out.println("---------------------");
        int opc = services.criarPergunta("Escolha uma opção: ", 1);
        if(services.validarOpcoesMenu(3, opc)){
            return opc;
        } else {
            return 400;
        }
    }
}
