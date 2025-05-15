import View.Menus;

import static Controllers.FuncionarioSystem.CriarFuncionario;
import static Services.Logado.VerificarLogin;

public class Main {
    public static void main(String[] args) {
        Menus menus = new Menus();
        menus.menuInicialCriacao();
    }
}
