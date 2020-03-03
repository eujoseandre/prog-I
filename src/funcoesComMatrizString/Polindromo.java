package funcoesComMatrizString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polindromo {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("Frase: ");
        String frase = entrada.readLine();
        frase = frase.replace(" ", "");
        frase = frase.replace("-", "");
        String[] vetor = new String[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            vetor[i] = String.valueOf(frase.charAt(i));
            //System.out.print(vetor[i] + " ");
        }
        System.out.println("");
        boolean palindromo = true;
        int ultPos = vetor.length - 1;
        for (int i = 0; i < vetor.length / 2; i++) {
            if (!vetor[i].equals(vetor[ultPos])) {
                palindromo = false;
                break;
            } else {
                ultPos--;
            }
        }
        if (palindromo) {
            System.out.println("É um palíndromo");
        } else {
            System.out.println("NÃO é um palíndromo");
        }
    }
}
