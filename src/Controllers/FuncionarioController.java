package Controllers;

import View.Menus;

import static Services.Services.*;

public class FuncionarioController {
    Menus menus = new Menus();

    public Boolean cadastrarFuncionario(){
        try{
            String nome = menus.menuCadastroFuncionario();

            if(nome.isEmpty()){
                System.out.println("Seu nome está sem nada !");
                return false;
            }

            if(validarNumero(nome)){
                System.out.println("Você digitou um número");
                return false;
            }

            Boolean result = cadastrarUserNoFile(nome);

            if(result){
                Thread.sleep(100);
                System.out.println("Cadastro realizado com sucesso");
                return true;
            }else{
                System.out.println("Erro ao cadastrar");
                return false;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean procurarUser(){
        try{
            String user = procurarUserNoFile();
            if(!user.isEmpty()){
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException e){
            return false;
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }

}
