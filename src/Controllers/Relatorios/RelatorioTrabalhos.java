package Controllers.Relatorios;

import Controllers.RelatorioController;

import java.util.ArrayList;

import static Services.Services.passarTxtPraArray;
import static Services.Services.somarHoras;

public class RelatorioTrabalhos extends RelatorioController {
    final private String pathName = "C:\\Users\\Rony\\Documents\\GitHub\\Pet-Prime\\data\\atendimento.txt";
    @Override
    public void gerarRelatorio(){
        ArrayList<String> arquivo = passarTxtPraArray(pathName);

        ArrayList<String> tosaServicos = new ArrayList<>();
        ArrayList<String> banhoServicos = new ArrayList<>();
        ArrayList<String> adestramentoServicos = new ArrayList<>();

        for(int i = 0; i < arquivo.size(); i++){
            if(arquivo.get(i).contains("Tosa")){
                tosaServicos.add(arquivo.get(i-1)+"--"+arquivo.get(i));
            }else if(arquivo.get(i).contains("Banho")){
                banhoServicos.add(arquivo.get(i-1)+"--"+arquivo.get(i));
            }else if(arquivo.get(i).contains("Adestramento")){
                adestramentoServicos.add(arquivo.get(i-1)+"--"+arquivo.get(i));
            }
        }

        System.out.println("-------[TOSA]-------");
        System.out.println("Quantidade de serviços realizados:" + tosaServicos.size());
        System.out.println("Quantidade de horas: " + somarHoras(tosaServicos));
        System.out.println("--------------------");

        System.out.println("-------[BANHO]-------");
        System.out.println("Quantidade de serviços realizados:" + banhoServicos.size());
        System.out.println("Quantidade de horas: " + somarHoras(banhoServicos));
        System.out.println("--------------------");

        System.out.println("-------[ADESTRAMENTO]-------");
        System.out.println("Quantidade de serviços realizados:" + adestramentoServicos.size());
        System.out.println("Quantidade de horas: " + somarHoras(adestramentoServicos));
        System.out.println("-----------------------------");
    }
}
