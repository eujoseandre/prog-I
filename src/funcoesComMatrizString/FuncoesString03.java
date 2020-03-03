package funcoesComMatrizString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FuncoesString03 {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("Frase: ");
        String frase = entrada.readLine();
        String letraIn = frase.substring(0, 1);
        frase = frase.replace(String.valueOf(frase.charAt(0)),
                letraIn.toUpperCase());
        System.out.println(frase);
    }
}
