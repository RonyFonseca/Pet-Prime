package Models;

public class Funcionario extends Pessoa{
    private String cargo;

    public Funcionario(String nome, String senha, String cargo){
        super(nome, senha);
        this.cargo = cargo;
    }
}
