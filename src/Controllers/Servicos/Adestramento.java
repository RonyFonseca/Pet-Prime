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
        this.nome = procurarUserNoFile();
        criarAquivo(this.nome, SERVICO);
        return "Inicio: "+data()+" - "+ hora()+"hrs\n"+"Trabalho: "+SERVICO+" - Resposável: "+nome;
    };

    @Override
    public String finalizarTrabalho(){
        lerAquivo();
        return "Termino: "+data()+" - "+ hora()+"hrs\n"+"Trabalho: "+SERVICO+" - Resposável: "+nome;
    }

    @Override
    public String toString(){
        return "Responsável: "+nome+"\nServiço: "+SERVICO+"\nData: "+data()+"\nHora: "+hora();
    }
}
