package Models;
import static View.Menus.*;

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private static int proximoId = 1;

    public Produto(int idProduto, String nome, String descricao, double preco, int estoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        if (idProduto >= proximoId) {
            proximoId = idProduto + 1;
        }
    }

    public Produto(String nome, String descricao, double preco, int estoque) {
        this(proximoId++, nome, descricao, preco, estoque);
    }

    public int getIdProduto() { return idProduto; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    public static void setProximoId(int id) { // Usado ao carregar do arquivo para definir o próximo ID corretamente
        proximoId = id;
    }
    public String ArquivoString(String delimiter) {
        return idProduto + delimiter + nome + delimiter + descricao + delimiter + preco + delimiter + estoque;
    }

    public static Produto StringDoArquivo(String fileString, String delimiter) {
        String[] parte = fileString.split(delimiter);
        if (parte.length == 5) {
            try {
                int id = Integer.parseInt(parte[0]);
                String nome = parte[1];
                String descricao = parte[2];
                double preco = Double.parseDouble(parte[3]);
                int estoque = Integer.parseInt(parte[4]);
                return new Produto(id, nome, descricao, preco, estoque);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter dados do produto do arquivo: " + fileString + " - " + e.getMessage());
                return null;
            }
        }
        System.out.println("Formato inválido da linha do produto no arquivo: " + fileString);
        return null;
    }
    @Override
    public String toString() {
        return CYAN+"ID: "+RESET + idProduto + " | "+ GREEN+"Nome: "+RESET + nome + "| "+ GREEN+"Preço: R$ "+RESET + String.format("%.2f", preco) + "| "+ GREEN+"Estoque: "+RESET + estoque;
    }
}