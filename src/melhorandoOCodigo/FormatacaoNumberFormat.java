/*

A classe FormatacaoNumberFormat, faz parte do pacote java.text e permite formatar números
conforme a localização geográfica em que você se encontra, realizando a distinção
entre o sinal de ponto, milhar e de decimal, também identifica a posição do sinal
do número e identifica o prefixo que indica a moeda em caso de valores monetários.

FormatacaoNumberFormat possui três mêtodos para formatar números, valores monetários e percentuais */

package melhorandoOCodigo;

import java.text.NumberFormat;

public class FormatacaoNumberFormat {

    public static void main(String[] args) {

//        Os principais métodos do FormatacaoNumberFormat são:
//
//        getNumberInstance() - Retorna a instância de um objeto com base no formato da localidade padrão.
//        É utilizado para numeros. 
//        
//        getCurrencyInstance() - Usado para formatar moedas.
//                
//        getIntegerInstance() - Usado para formatar números ignorando casas decimais. 
//                
//        getPercentInstance() - Usado para formatar frações pro exemplo 0,15 é formatado e mostrado como 15%.
            
           getCurrencyInstance();
           getCurrencyInstance2();
    }

    public static void getCurrencyInstance() {
        System.out.println(NumberFormat.getCurrencyInstance().format(12345678.90));
        // imprimirá R$ 12.345.678,90
    }

    public static void getCurrencyInstance2() {
        double [] n = {523.34, 54344.23, 95845.223, 1084.895};

        NumberFormat z = NumberFormat.getCurrencyInstance();

        for (int a = 0; a < n.length; a++) {
            if (a != 0) {
                System.out.print(", ");
            }
            System.out.print(z.format(n[a]));
        }
        System.out.println();
        /* Imprime: R$ 523,34, R$ 54.344,23, R$ 95.845,22, R$ 1.084,90 */
    }
}
