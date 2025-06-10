package Controllers.Servicos;
import Models.Servico;

import static Services.Services.*;

public class Adestramento implements Servico {
    private String nome;
    private final String SERVICO = "Adestramento";

    public Adestramento(){}

    public Adestramento (String nome){
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
