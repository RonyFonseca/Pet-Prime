package View;

import Services.Services;

public class Menus {
    Services services =  new Services();
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";

    public String menuCadastroFuncionario(){
        String nome;
        while(true){
            System.out.println("--------["+GREEN+"CADASTRO"+RESET+"]--------");
            System.out.println(CYAN+"[1]: Nome"+RESET);
            System.out.println("--------------------------");
            nome = services.criarPergunta("Digite seu "+ CYAN+"nome"+RESET+":" );
            if(nome.equalsIgnoreCase("banho")||nome.equalsIgnoreCase("tosa")||nome.equalsIgnoreCase("adestramento")){
                System.out.println(RED+"Digitar um nome válido"+RESET);
            }else{
                return nome;
            }
        }
    }

    public int menuPrincipal(){
        System.out.println("--------["+GREEN+"HOME"+RESET+"]--------");
        System.out.println(CYAN+"[1]"+RESET+ "-" +GREEN+"Atendimento"+RESET);
        System.out.println(CYAN+"[2]"+RESET+ "-" +GREEN+"Produtos"+RESET);
        System.out.println(CYAN+"[0]"+ "-" +RED+"Sair"+RESET);
        System.out.println("----------------------");
        int opc = services.criarPergunta("Escolha uma "+ CYAN+"opção: "+RESET, 1);
        if(services.validarOpcoesMenu(2, opc)){
            return opc;
        } else {
            return 400;
        }
    }

    public int menuAtendimentos(){
        System.out.println("-----["+GREEN+"ATENDIMENTO"+RESET+"]-----");
        System.out.println(CYAN+"[1]"+RESET+ "-"+ GREEN+"Iniciar atendimento"+RESET);
        System.out.println(CYAN+"[2]"+RESET+ "-"+ GREEN+"Finalizar atendimento"+RESET);
        System.out.println(CYAN+"[3]"+RESET+ "-"+ GREEN+"Gerar relatorio"+RESET);
        System.out.println(CYAN+"[0]"+RESET+ "-"+ RED+"Voltar"+RESET);
        System.out.println("---------------------");
        int opc = services.criarPergunta("Escolha uma "+CYAN+"opção: "+RESET, 1);
        if(services.validarOpcoesMenu(3, opc)){
            return opc;
        } else {
            return 400;
        }
    }

    public int menuIniciarAtendimento(){
        System.out.println("-----["+CYAN+"ATENDIMENTO"+RESET+"]-----");
        System.out.println(CYAN+"[1]"+RESET+ "-"+ GREEN+"Tosa"+RESET);
        System.out.println(CYAN+"[2]"+RESET+ "-"+ GREEN+"Banho"+RESET);
        System.out.println(CYAN+"[3]"+RESET+ "-"+ GREEN+"Adestrar"+RESET);
        System.out.println(CYAN+"[0]"+RESET+ "-"+ RED+"Voltar"+RESET);
        System.out.println("---------------------");
        int opc = services.criarPergunta("Escolha uma opção: ", 1);
        if(services.validarOpcoesMenu(3, opc)){
            return opc;
        } else {
            return 400;
        }
    }

}
