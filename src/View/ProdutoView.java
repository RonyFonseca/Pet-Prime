package View;

import Services.ProdutoService;
import Services.Services;
import Models.Produto;

import java.sql.SQLOutput;
import java.util.List;
import static View.Menus.*;

public class ProdutoView {
    public int exibirMenuProdutos() {
        System.out.println("=== Gerenciamento de Produtos ("+GREEN+"Estoque"+RESET+") ===");
        System.out.println(CYAN+"[1]"+RESET+"-"+GREEN+"Cadastrar Novo Produto"+RESET);
        System.out.println(CYAN+"[2]"+RESET+"-"+GREEN+"Listar Todos os Produtos"+RESET);
        System.out.println(CYAN+"[3]"+RESET+"-"+GREEN+"Buscar Produto por ID"+RESET);
        System.out.println(CYAN+"[4]"+RESET+"-"+GREEN+"Atualizar Produto"+RESET);
        System.out.println(CYAN+"[5]"+RESET+"-"+GREEN+"Atualizar Estoque de Produto"+RESET);
        System.out.println(CYAN+"[6]"+RESET+"-"+GREEN+"Remover Produto"+RESET);
        System.out.println(CYAN+"[0]"+RESET+"-"+RED+"Voltar"+RESET);
        return ProdutoService.lerInteiro("Escolha uma "+CYAN+"opção"+RESET);
    }

    public Produto solicitarDadosNovoProduto() {
        while(true){
            System.out.println("--- Cadastro de Novo Produto ---");
            String nome = ProdutoService.lerString("Nome do produto");

            if(!nome.isEmpty()){
                String descricao = ProdutoService.lerString("Descrição");
                if(!descricao.isEmpty()){
                    double preco = ProdutoService.lerDouble("Preço");
                    if(!(preco <= 0)){
                        int estoque = ProdutoService.lerInteiro("Quantidade em estoque inicial");
                        if(!(estoque <= 0)){
                            return new Produto(nome.trim(), descricao.trim(), preco, estoque);
                        }else{
                            System.out.println("-----------------------["+RED+"REFLITA"+RESET+"]------------------------");
                            System.out.println("O estoque não pode ser negativo !");
                            System.out.println("E por "+RED+"consequência"+RESET+" vai fazer tudo do 0");
                            System.out.println("--------------------------------------------------------");
                        }
                    }else{
                        System.out.println("-----------------------["+RED+"REFLITA"+RESET+"]------------------------");
                        System.out.println("O preço não pode ser negativo !");
                        System.out.println("E por "+RED+"consequência"+RESET+" vai fazer tudo do 0");
                        System.out.println("--------------------------------------------------------");
                    }
                }else{
                    System.out.println("-----------------------["+RED+"REFLITA"+RESET+"]------------------------");
                    System.out.println("A descrição não pode estar vazia!");
                    System.out.println("E por "+RED+"consequência"+RESET+" vai fazer tudo do 0");
                    System.out.println("--------------------------------------------------------");
                }
            }else{System.out.println("O nome não pode estar vazio!");}


        }
        // Usa construtor que gera ID
    }

    public void listarProdutos(List<Produto> produtos) {
        System.out.println("--- Lista de"+ GREEN+" Produtos "+RESET+ "---");
        if (produtos.isEmpty()) {
            System.out.println(RED+"Nenhum"+RESET+ " produto cadastrado.");
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

    public boolean confirmarAcao(String msg) {
        String resposta = ProdutoService.lerString(msg + " (S/N)").toUpperCase().trim();
        return resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("sim");
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