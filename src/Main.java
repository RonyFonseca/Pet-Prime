import Controllers.FuncionarioController;
import Controllers.ProdutoController;
import Controllers.Relatorios.RelatorioTrabalhos;
import Controllers.Servicos.Adestramento;
import Controllers.Servicos.Banho;
import Controllers.Servicos.Tosa;
import Models.Servico;
import Services.ProdutoService;
import View.Menus;
import View.ProdutoView;


public class Main {

    public static void main(String[] args) {
        while (true) {

            FuncionarioController sistemaDeFuncionario = new FuncionarioController();
            Boolean result;

            if(!sistemaDeFuncionario.procurarUser()){
                result = sistemaDeFuncionario.cadastrarFuncionario();
            } else {
                result = true;
            }

            if(result){
                Menus menu = new Menus();
                int opc = menu.menuPrincipal();
                if (opc == 1) {
                    opc = menu.menuAtendimentos();
                    if (opc == 1) {
                        opc = menu.menuIniciarAtendimento();
                        if (opc == 1) {
                            Servico servico = new Tosa();
                            servico.iniciarTrabalho();
                        } else if (opc == 2) {
                            Servico servico = new Banho();
                            servico.iniciarTrabalho();
                        } else if (opc == 3) {
                            Servico servico = new Adestramento();
                            servico.iniciarTrabalho();
                        }
                    } else if (opc == 2) {
                        Tosa tosa = new Tosa();
                        tosa.finalizarTrabalho();
                    } else if (opc == 3) {
                        RelatorioTrabalhos relatorio = new RelatorioTrabalhos();
                        relatorio.gerarRelatorio();
                    }
                } else if (opc == 2) {
                        ProdutoView produtoView = new ProdutoView();
                        ProdutoService produtoService = new ProdutoService();
                        ProdutoController produtoController = new ProdutoController(produtoView, produtoService);
                        produtoController.gerenciarProdutos();
                } else if (opc == 0) {
                    break;
                }
            }
        }
    }
}
