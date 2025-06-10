package Models;

public class Produto {
        private int idProduto;
        private String nome;
        private String descricao;
        private double preco;
        private int estoque;
        private static int proximoId = 1; // para localizar o produto

        public Produto(int idProduto, String nome, String descricao, double preco, int estoque) {
            this.idProduto = idProduto;
            this.nome = nome;
            this.descricao = descricao;
            this.preco = preco;
            this.estoque = estoque;
            if (idProduto >= proximoId) { // Ajusta o proximoId se carregado do arquivo
                proximoId = idProduto + 1;
            }
        }
        // Construtor para novos produtos onde o ID ja for gerado
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
    public String toFileString(String delimiter) {
        return idProduto + delimiter + nome + delimiter + descricao + delimiter + preco + delimiter + estoque;
    }

    @Override
    public String toString() {
        return "ID: " + idProduto + ", Nome: '" + nome + '\'' + ", Preço: R$" + String.format("%.2f", preco) + ", Estoque: " + estoque;
    }
}

