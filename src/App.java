import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in); //Instanciando Objeto
        String formula; //Criando a variavel tipo string
        boolean tabOk= false; //Criando a variavel tipo boolean

        TabelaVerdade tb = new TabelaVerdade();//Instanciando Objeto

        System.out.print("Entre com a Fórmula: ");
        formula = leitor.nextLine();
        formula = formula.toLowerCase(); //Colocando em minusculo o input

        switch (formula.length()){ //Irá vereficar o tamanho da formula.
        case 1://Se for tamanho 1 ele irá entrar no case 2            
        case 2://Se for tamanho 2 ele irá entrar no case 2
            tabOk = tb.achaFormulaCom1Variavel(formula); // Irá executar o metodo
            break;   // Esse metodo verefica se a formula é valida ou não, se ela for valida ela executa o Metodo TabelaUmLiteral
        case 3:
        case 4: 
            tabOk = tb.achaFormulaCom2Variaveis(formula); // Irá executar o metodo
            break; // Esse metodo verefica se a formula é valida ou não, se ela for valida ela executa o Metodo TabelaDoisLiterais
        case 5:
            if (formula.charAt(0) == '~'){
                tabOk = tb.achaFormulaCom2Variaveis(formula);
            }else{
                tabOk = tb.achaFormulaCom3Variaveis(formula);
            }   // Esse metodo verefica se a formula é valida ou não, se ela for valida ela executa o Metodo TabelaTresLiterais
            break;
        case 6:
            tabOk = tb.achaFormulaCom3Variaveis(formula);
            break;
        case 7:
            tabOk = tb.achaFormulaCom3Variaveis(formula);
            break;
        case 8:
            tabOk = tb.achaFormulaCom3Variaveis(formula);
            break;
        default:
            tabOk = false; //Colocamos como default false para se caso não entrar em nenhum case printar que a formula está incorreta
        }
        if (!tabOk)
            System.out.println("Tabela não econtrada, pois a fórmula está incorreta!");
        leitor.close();
    }
}
