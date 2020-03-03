
package funcoesComMatrizString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FuncoesString02 {
   public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader (System.in));
        System.out.print("CPF: ");
        String cpf = entrada.readLine();
        //nome = nome.trim();
        //int tamanho = nome.length();
        //System.out.println("Tamanho: " + tamanho);
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        System.out.println("Nome: " + cpf);
    } 
}
