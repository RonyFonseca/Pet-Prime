package View;

import Services.Perguntas;

public class Menus {
    Perguntas pergunta = new Perguntas();
    public int menuInicialCriacao(){
        System.out.println("======================");
        System.out.println("[0] Criar Funcionario");
        System.out.println("[1] Logar Funcionario");
        System.out.println("[2] Criar Cliente");
        System.out.println("[3] logar Cliente");
        System.out.println("======================");
        int resultadoPergunta = pergunta.criarPergunta("Escolha a opção: ", 1);
        return resultadoPergunta;
    }

    public String[] menuCriarFuncionario(){
        System.out.println("=============");
        System.out.println("[0] Nome");
        System.out.println("[1] Cargo");
        System.out.println("[2] Senha");
        System.out.println("=============");
        String nomeDoFuncionario = pergunta.criarPergunta("Digite seu Nome: ");
        String cargoDoFuncionario = menuDeCargos();
        String senhaDoFuncionario = pergunta.criarPergunta("Digite seu Senha: ");

        String[] data = {nomeDoFuncionario, cargoDoFuncionario,senhaDoFuncionario};
        return data;
    }

    public String menuDeCargos(){
        System.out.println("---------------");
        System.out.println("[0] Veterinário");
        System.out.println("[1] Pet-Shop");
        System.out.println("---------------");
        int resultadoPergunta = pergunta.criarPergunta("Escolha a opção do seu cargo: ", 1);

        String cargoDoFuncionario;
        if(resultadoPergunta == 0){
            cargoDoFuncionario = "Veterinário";
            return cargoDoFuncionario;
        }else if(resultadoPergunta == 1){
            cargoDoFuncionario = "Pet-Shop";
            return cargoDoFuncionario;
        } else {
            System.out.println("Você não colocou uma opção válida animal");
        }
        return null;
    }

    public String[] menuLogin(){
        System.out.println("=============");
        System.out.println("[0] Nome");
        System.out.println("[2] Senha");
        System.out.println("=============");
        String nomeDoFuncionario = pergunta.criarPergunta("Digite seu Nome: ");
        String senhaDoFuncionario = pergunta.criarPergunta("Digite seu Senha: ");
        String[] data = {nomeDoFuncionario,senhaDoFuncionario};
        return data;
    }

}
