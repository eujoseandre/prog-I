
package melhorandoOCodigo;

import java.text.DecimalFormat;

public class FormatacaoDecimalFormat {

    public static void main(String[] args) {

        double valor = 2000.0;
        double vezes = 3.0;
        double prestacao = valor / vezes;

        DecimalFormat df = new DecimalFormat("0.##");
        String dx = df.format(prestacao);

        System.out.print(dx);
    }
    // sera impresso : 666,67
}
