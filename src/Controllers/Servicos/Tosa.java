package Controllers.Servicos;

import Models.Servico;

import static Services.Services.*;
import static Services.Services.data;
import static Services.Services.hora;
import static Services.Services.lerAquivo;

public class Tosa implements Servico {
    private String nome;
    private final String SERVICO = "Tosa";

    public Tosa() {}

    public Tosa(String nome) {
        this.nome = nome;
    }

    @Override
    public String iniciarTrabalho(){
        criarAquivo("atendimento", this.nome, SERVICO);
        return "Inicio: "+data()+" - "+ hora()+"hrs\n"+"Trabalho: "+SERVICO+" - Resposável: "+nome;
    };

    @Override
    public String finalizarTrabalho(){
        lerAquivo("atendimento");
        return "Termino: "+data()+" - "+ hora()+"hrs\n"+"Trabalho: "+SERVICO+" - Resposável: "+nome;
    }

    @Override
    public void getDescricao(){
        System.out.println("Responsável: "+nome+"\nServiço: "+SERVICO+"\nData: "+data()+"\nHora: "+hora());
    }
}
