package Controllers;

import Models.Produto;
import Services.ProdutoService;
import Services.Services;
import View.ProdutoView;
import java.util.List;
import java.util.Optional;

public class ProdutoController {
    private ProdutoView produtoView;
    private ProdutoService produtoService;

    public ProdutoController(ProdutoView produtoView, ProdutoService produtoService) {
        this.produtoView = produtoView;
        this.produtoService = produtoService;
    }

    public void gerenciarProdutos() {
        int opcao;
        do {
            opcao = produtoView.exibirMenuProdutos();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProdutoPorId();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    atualizarEstoqueProduto();
                    break;
                case 6:
                    removerProduto();
                    break;
                case 0:
                    produtoService.exibirMensagem("Voltando ao Menu Principal...");
                    break;
                default:
                    ProdutoService.exibirMensagem("Opção inválida. Tente novamente.");
            }
            if (opcao != 0) Services.pressioneEnterParaContinuar();
        } while (opcao != 0);
    }

    private void cadastrarProduto() {
        Produto novoProduto = produtoView.solicitarDadosNovoProduto();
        produtoService.salvar(novoProduto);
        ProdutoService.exibirMensagem("Produto cadastrado com sucesso! ID: " + novoProduto.getIdProduto());
    }

    private void listarProdutos() {
        List<Produto> produtos = produtoService.listarTodos();
        produtoView.listarProdutos(produtos);
    }

    private void buscarProdutoPorId() {
        int id = produtoView.solicitarIdProduto("buscar");
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
        produtoView.exibirDetalhesProduto(produtoOpt.orElse(null));
    }

    private void atualizarProduto() {
        int id = produtoView.solicitarIdProduto("atualizar");
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
        if (produtoOpt.isPresent()) {
            Produto produtoParaAtualizar = produtoOpt.get();
            // A view pode modificar o objeto diretamente ou retornar um novo com os dados
            Produto dadosAtualizados = produtoView.solicitarDadosAtualizacaoProduto(produtoParaAtualizar);
            // Se a view modificou o original, apenas salvar.
            // Se retornou um novo, precisa copiar os dados para o original ou reconstruir e salvar.
            // No exemplo da ProdutoView, ela modifica o objeto passado.
            produtoService.salvar(dadosAtualizados);
            ProdutoService.exibirMensagem("Produto atualizado com sucesso!");
        } else {
            produtoService.exibirMensagem("Produto com ID " + id + " não encontrado.");
        }
    }

    private void atualizarEstoqueProduto() {
        int id = produtoView.solicitarIdProduto("atualizar estoque");
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
        if (produtoOpt.isPresent()) {
            int novaQuantidade = produtoView.solicitarNovaQuantidadeEstoque();
            if (novaQuantidade >= 0) {
                Produto produto = produtoOpt.get();
                produto.setEstoque(novaQuantidade);
                produtoService.salvar(produto); // Salva o produto com o estoque atualizado
                produtoService.exibirMensagem("Estoque do produto '" + produto.getNome() + "' atualizado para " + novaQuantidade + " unidades.");
            } else {
                ProdutoService.exibirMensagem("Quantidade em estoque não pode ser negativa.");
            }
        } else {
            produtoService.exibirMensagem("Produto com ID " + id + " não encontrado.");
        }
    }
    private void removerProduto() {
        int id = produtoView.solicitarIdProduto("remover");
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
        if (produtoOpt.isPresent()) {
            if (produtoView.confirmarAcao("Tem certeza que deseja remover o produto '" + produtoOpt.get().getNome() + "'?")) {
                produtoService.remover(id);
                ProdutoService.exibirMensagem("Produto removido com sucesso!");
            } else {
                ProdutoService.exibirMensagem("Remoção cancelada.");
            }
        } else {
            ProdutoService.exibirMensagem("Produto com ID " + id + " não encontrado.");
        }
    }
}