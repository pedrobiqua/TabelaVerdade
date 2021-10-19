import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String formula;
        boolean tabOk= false;

        TabelaVerdade tb = new TabelaVerdade();

        System.out.print("Entre com a Fórmula: ");
        formula = leitor.nextLine();
        formula = formula.toLowerCase();

        switch (formula.length()){
        case 1:
        case 2:
            tabOk = tb.achaFormulaCom1Variavel(formula);
            break;
        case 3:
        case 4:
            tabOk = tb.achaFormulaCom2Variaveis(formula);
            break;
        case 5:
            if (formula.charAt(0) == '~'){
                tabOk = tb.achaFormulaCom2Variaveis(formula);
            }else{
                tabOk = tb.achaFormulaCom3Variaveis(formula);
            }
            break;
        // TO DO ...
        //case 6:
        //case 7:
        //case 8:
        default:
            tabOk = false;
        }
        if (!tabOk)
            System.out.println("Tabela não econtrada, pois a fórmula está incorreta!");
        leitor.close();
    }
}
