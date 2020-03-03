package funcoesComMatrizString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FuncoesString01 {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("Nome: ");
        String nome = entrada.readLine();
        int tamanho = nome.length();
        System.out.println("Quant. caracteres: " + tamanho);
        String[] nomePessoa = new String[tamanho];
        for (int i = 0; i < tamanho; i++) {
            nomePessoa[i] = String.valueOf(nome.charAt(i));
            System.out.println(i + ": " + nomePessoa[i]);
        }
        System.out.println("Maiúsculas: " + nome.toUpperCase());
        System.out.println("Minúsculas: " + nome.toLowerCase());
    }
}
