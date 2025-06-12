package View;

import Services.ProdutoService;
import Services.Services;
import Models.Produto;
import java.util.List;

public class ProdutoView {
    Services services= new Services();
    public int exibirMenuProdutos() {
        System.out.println("=== Gerenciamento de Produtos (Estoque) ===");
        System.out.println("1. Cadastrar Novo Produto");
        System.out.println("2. Listar Todos os Produtos");
        System.out.println("3. Buscar Produto por ID");
        System.out.println("4. Atualizar Produto");
        System.out.println("5. Atualizar Estoque de Produto");
        System.out.println("6. Remover Produto");
        System.out.println("0. Voltar ao Menu Principal");

        int opc = services.criarPergunta("Escolha uma opção", 1);
        if(services.validarOpcoesMenu(6, opc)){
            return opc;
        } else {
            return 400;
        }
    }

    public Produto solicitarDadosNovoProduto() {
        System.out.println("--- Cadastro de Novo Produto ---");
        String nome = ProdutoService.lerString("Nome do produto");
        String descricao = ProdutoService.lerString("Descrição");
        double preco = ProdutoService.lerDouble("Preço");
        int estoque = ProdutoService.lerInteiro("Quantidade em estoque inicial");
        return new Produto(nome, descricao, preco, estoque); // Usa construtor que gera ID
    }

    public void listarProdutos(List<Produto> produtos) {
        System.out.println("--- Lista de Produtos ---");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
        }
        // ConsoleUtils.pressioneEnterParaContinuar(); // Movido para o controller
    }

    public int solicitarIdProduto(String acao) {
        return ProdutoService.lerInteiro("Digite o ID do produto para " + acao);
    }

    public Produto solicitarDadosAtualizacaoProduto(Produto produtoExistente) {
        System.out.println("--- Atualização de Produto ID: " + produtoExistente.getIdProduto() + " ---");
        System.out.println("Deixe em branco para manter o valor atual, exceto para preço e estoque (digite o novo valor).");

        String nome = ProdutoService.lerString("Novo Nome (" + produtoExistente.getNome() + ")");
        if (!nome.isEmpty()) produtoExistente.setNome(nome);

        String descricao = ProdutoService.lerString("Nova Descrição (" + produtoExistente.getDescricao() + ")");
        if (!descricao.isEmpty()) produtoExistente.setDescricao(descricao);

        // Para números, geralmente se pede o novo valor diretamente
        produtoExistente.setPreco(ProdutoService.lerDouble("Novo Preço (" + produtoExistente.getPreco() + ")"));
        produtoExistente.setEstoque(ProdutoService.lerInteiro("Novo Estoque (" + produtoExistente.getEstoque() + ")"));

        return produtoExistente;
    }

    public int solicitarNovaQuantidadeEstoque() {
        return ProdutoService.lerInteiro("Digite a nova quantidade em estoque");
    }

    public boolean confirmarAcao(String mensagem) {
        String resposta = ProdutoService.lerString(mensagem + " (S/N)").toUpperCase();
        return resposta.equals("S");
    }

    public void exibirDetalhesProduto(Produto produto) {
        System.out.println("--- Detalhes do Produto ---");
        if (produto != null) {
            System.out.println(produto.toString());
            System.out.println("Descrição: " + produto.getDescricao());
        } else {
            System.out.println("Produto não encontrado.");
        }
        // ConsoleUtils.pressioneEnterParaContinuar(); // Movido para o controller
    }
}