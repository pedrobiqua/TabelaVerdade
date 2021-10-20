public class TabelaVerdade {
    //char printBit(boolean p): Imprime V ou F, de acordo com os valor booleano de entrada
    public char printBit(boolean p){
        if (p)
            return 'V';
        else
            return 'F';
    }

    //void printFormula (String formulaCorreta): imprime uma fórmula lógica CORRETA, entre ( )
    public void printFormula (String formulaCorreta){
        System.out.print(" (" + formulaCorreta + ") ");
    }

    //void tabelaUmLiteral(String FormulaCorreta): imprime tabela verdade
    //de uma fórmula CORRETA com 1 Literal/Variável.
    public void tabelaUmLiteral(String formulaCorreta){
        int i;
        boolean p, resp;

        System.out.println("+---+");
        System.out.print  ("| p |");
        printFormula (formulaCorreta);
        System.out.println();
        System.out.println("+---+");

        for (i = 1; i >= 0; i--){
        switch (i) {
        case 1:
            p = true;
            break;
        default:
            p = false;
        }
        // condicional ternário: x = (expresão booleana) ? código paara Verdade: código para Falso;
        resp = (formulaCorreta.charAt(0)=='~')? !p : p;
        System.out.print ("| " + printBit(p) + " |  ");
        System.out.println(printBit(resp));
        }
        System.out.println("+---+");
    }
    //void tabelaDoisLiterais(String formulaCorreta): Imprime tabela verdade
    //de uma fórmula CORRETA com 2 Literais/Variáveis.
    public void tabelaDoisLiterais(String formulaCorreta){
        int i;
        boolean p, q, resp = true;

        System.out.println("+---+---+");
        System.out.print  ("| p | q |");
        printFormula(formulaCorreta);
        System.out.println();
        System.out.println("+---+---+");

        for (i = 3; i >= 0; i--){
           switch (i){
           case 3:
               p = true; q = true;
               break;
           case 2:
               p = true; q = false;
               break;
           case 1:
               p = false; q = true;
               break;
           default:
               p = false; q = false;
           }
        if (formulaCorreta.length() == 3)
            resp = formulaCorreta.charAt(1) == '^'? p && q: p || q;
        else if (formulaCorreta.length() == 4) {
            if (formulaCorreta.charAt(0) == '~')
                resp = formulaCorreta.charAt(2) == '^' ? (!p && q) : (!p || q);
            else if (formulaCorreta.charAt(2) == '~')
                resp = formulaCorreta.charAt(1) == '^' ? (p && !q) : (p || !q);
        }else if (formulaCorreta.length() ==5){
            resp = formulaCorreta.charAt(3) == '^'? (!p && !q): (!p|| !q);
        }
        System.out.print("| " + printBit(p) + " | " + printBit(q));
        System.out.println(" | " + printBit(resp));
        }
        System.out.println("+---+---+");
    }

    //void tabelaDoisLiterais(String formulaCorreta): Imprime tabela verdade
    //de uma fórmula CORRETA com 3 Literais/Variáveis.

    public void tabelaTresLiterais (String formulaCorreta){
        int i;
        boolean p, q, r, resp = true;
        System.out.println("+---+---+---+----+---+---+");
        System.out.print  ("| p | q | r |" + formulaCorreta);
        System.out.println();
        System.out.println("+---+---+---+----+---+---+");

        for (i = 7; i >= 0; i--){
            switch (i){
            case 7:
                p = true; q = true; r = true;
                break;
            case 6:
                p = true; q = true; r = false;
                break;
            case 5:
                p = true; q = false; r = true;
                break;
            case 4:
                 p = true; q = false; r = false;
                 break;
            case 3:
                 p = false; q = true; r = true;
                 break;
             case 2:
                  p = false; q = true; r = false;
                  break;
            case 1:
                  p = false; q = false; r = true;
                  break;
            default:
                  p = false; q = false; r = false;
            }
            if (formulaCorreta.length() == 5) {
                if (formulaCorreta.charAt(1) == formulaCorreta.charAt(3)) {
                    resp = (formulaCorreta.charAt(1) == '^' && formulaCorreta.charAt(3) == '^') ? (p && q && r) : (p || q || r);
                }else if (formulaCorreta.charAt(1) != formulaCorreta.charAt(3)) {
                    resp = (formulaCorreta.charAt(1) == '^' && formulaCorreta.charAt(3) == 'v') ? (p && q || r) : (p || q && r);
                }
                
            }else if (formulaCorreta.length() == 6) {
                if (formulaCorreta.charAt(2) == formulaCorreta.charAt(4)) {
                    if (formulaCorreta.charAt(0) == '~') {
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == '^') ? (!p && q && r) : (!p || q || r);
                    }
                }else if (formulaCorreta.charAt(2) != formulaCorreta.charAt(4)) {
                    if (formulaCorreta.charAt(0) == '~') {
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == 'v') ? (!p && q || r) : (!p || q && r);
                    }
                }else if(formulaCorreta.charAt(1) == formulaCorreta.charAt(4)){
                    if(formulaCorreta.charAt(2) == '~'){
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == '^') ? (p && !q && r) : (p || !q || r);
                    }
                }else if(formulaCorreta.charAt(1) != formulaCorreta.charAt(4)){
                    if(formulaCorreta.charAt(2) == '~'){
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == 'v') ? (p && !q || r) : (p || !q && r);
                    }
                }else if(formulaCorreta.charAt(1) == formulaCorreta.charAt(3)){
                    if(formulaCorreta.charAt(4) == '~'){
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == '^') ? (p && q && !r) : (p || q || !r);
                    }
                }else if(formulaCorreta.charAt(1) != formulaCorreta.charAt(3)){
                    if(formulaCorreta.charAt(4) == '~'){
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == 'v') ? (p && q || !r) : (p || q && !r);
                    }
                }

            }else if(formulaCorreta.length() == 7){
                //formula ¬p v ¬q v r
                if (formulaCorreta.charAt(2) == formulaCorreta.charAt(5)){
                    if(formulaCorreta.charAt(0) == '~' && formulaCorreta.charAt(3) == '~'){
                        resp = (formulaCorreta.charAt(2)=='^' && formulaCorreta.charAt(5) == '^') ? (!p && !q && r) : (!p || !q || r);
                    }
                }else if(formulaCorreta.charAt(2) != formulaCorreta.charAt(5)){
                    if(formulaCorreta.charAt(0) == '~' && formulaCorreta.charAt(3) == '~'){
                        resp = (formulaCorreta.charAt(2)=='^' && formulaCorreta.charAt(5) == 'v') ? (!p && !q || r) : (!p || !q && r);
                    }
                }
                //formula ¬p v q v ¬r
                if (formulaCorreta.charAt(2) == formulaCorreta.charAt(4)) {
                    if (formulaCorreta.charAt(0) =='~' && formulaCorreta.charAt(5) == '~') {
                        resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(4) == '^') ? (!p && q && !r) : (!p || q || !r); 
                    }
                }else if (formulaCorreta.charAt(2) != formulaCorreta.charAt(4)) {
                    if (formulaCorreta.charAt(0) == '~' && formulaCorreta.charAt(5) == '~') {
                        resp = (formulaCorreta.charAt(2) =='^' && formulaCorreta.charAt(4) == 'v') ? (!p && q || !r) : (!p && q || !r);
                    }
                }
                //formula p v ¬q v ¬r
                if (formulaCorreta.charAt(1) == formulaCorreta.charAt(4)) {
                    if (formulaCorreta.charAt(2) == '~' && formulaCorreta.charAt(5) == '~') {
                        resp = (formulaCorreta.charAt(1) == '^' && formulaCorreta.charAt(4) == '^') ? (p && !q && !r) : (p || !q || !r);
                    }
                }else if (formulaCorreta.charAt(1) != formulaCorreta.charAt(4)) {
                    if (formulaCorreta.charAt(2) == '~' && formulaCorreta.charAt(5) == '~') {
                        resp = (formulaCorreta.charAt(1) == '^' && formulaCorreta.charAt(4) == 'v') ? (p && !q || !r) : (p || !q && !r);
                    }
                }
            }else if(formulaCorreta.length() == 8){
                if (formulaCorreta.charAt(2) == formulaCorreta.charAt(5)) {
                    resp = (formulaCorreta.charAt(2) == '^' && formulaCorreta.charAt(5) == '^') ? (!p && !q && !r) : (!p || !q || !r);
                }else if (formulaCorreta.charAt(2) != formulaCorreta.charAt(5)) {
                    resp = (formulaCorreta.charAt(2) == 'v' && formulaCorreta.charAt(5) == '^') ? (!p || !q && !r) : (!p && !q || !r);
                }
            }
            System.out.print("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r));
            System.out.println(" | " + printBit(resp) + "  |");
        }
        System.out.println("+---+---+---+----+---+---+");
    }

    //void boolean achaFormulaCom1Variavel(String formula): confere se fórmula com
    //1 variável está CORRETA; se sim, imprime tabela verdade.
    public boolean achaFormulaCom1Variavel(String formula){
        if((formula.charAt(0) == '~' && formula.charAt(1) == 'p')||         //fórmula = ~p
        (formula.charAt(0) == 'p' && formula.length() ==1 )){               //fórmula = p
            tabelaUmLiteral(formula);
            return true;
        }else
            return false;
    }


    //void boolean achaFormulaCom2Variaveis(String formula): confere se fórmula com
    //2 variáveis está CORRETA; se sim, imprime tabela verdade
    public boolean achaFormulaCom2Variaveis(String formula) {
        boolean formOk;
        if ((formula.length() == 3) && // 3 caracteres
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == 'q')) {
            if ((formula.charAt(1) == '^') ||            //fórmula = p^q
                    (formula.charAt(1) == 'v'))          //fórmula = pvq
                formOk = true;
            else
                formOk = false;
        } else if ((formula.length() == 4) &&       //4caracteres
                (formula.charAt(0) == '~') &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(3) == 'q')) {
            if ((formula.charAt(2) == '^') ||       //fórmula = p^~q
               (formula.charAt(2) == 'v')){
                formOk = true;
               }else{
                formOk = false;
            }
        }else if ((formula.length() == 5) && (formula.charAt(0) == '~') && (formula.charAt(1) == 'p') && (formula.charAt(3) == '~') && (formula.charAt(4) == 'q') ){   //5 caracteres //Fórmula ~p^~q
            if ((formula.charAt(2) == '^') || (formula.charAt(2) == 'v')) {
                formOk = true;
            }else{
                formOk = false;
            }
        }else if(true){ // Gambiarra nada a ver, depois tirar :)
            formOk = false;
        }

        if (formOk) {
            tabelaDoisLiterais(formula);
        }
        return formOk;
    }


    //void boolean achaFormulaCom3Variaveis (String formula): confere se fórmula com
    //3 variaveis está CORRETA, se sim, imprime tabela verdade
    public boolean achaFormulaCom3Variaveis(String formula){
        //char [] oper = new char[5];         //mantém as operações da fórmula
        tabelaTresLiterais(formula);
        return true;
    }

}