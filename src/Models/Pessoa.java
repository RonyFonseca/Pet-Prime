package Models;

public abstract class Pessoa {
    protected String nome;
    protected String senha;

    public Pessoa(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
}
