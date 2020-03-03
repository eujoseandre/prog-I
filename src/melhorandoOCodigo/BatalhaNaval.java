package melhorandoOCodigo;

import java.util.Scanner;

public class BatalhaNaval {

    static String matriz[][] = new String[6][6];
    static String espelho[][] = new String[6][6];
    static int posicaoColuna;
    static int posicaoLinha;
    static String num;
    static boolean vencedor = false;
    static boolean config = true;

    public static void main(String[] args) {

        while (config) {
            config = false;

            int cont = 9;

            for (String[] matriz1 : matriz) {
                for (int j = 0; j < matriz[0].length; j++) {
                    cont++;
                    matriz1[j] = Integer.toString(cont);
                }
            }
            int cont2 = 9;

            for (String[] espelho1 : espelho) {
                for (int j = 0; j < espelho[0].length; j++) {
                    cont2++;
                    espelho1[j] = Integer.toString(cont2);
                }
            }
            sorteiaPremio();

        }
        exibeMatriz();
        verificaVencedor();
        while (!vencedor) {
            jogar();
            main(args);
        }
    }

    public static void sorteiaPremio() {
        posicaoColuna = (int) (Math.random() * 6);
        posicaoLinha = (int) (Math.random() * 6);
        matriz[posicaoLinha][posicaoColuna] = "T";
    }

    public static void jogar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("\nDigite uma posição: ");
        System.out.println("");
        System.out.print(" > ");
        num = entrada.next();
        System.out.println("");

        for (int i = 0; i < espelho.length; i++) {
            for (int j = 0; j < espelho[0].length; j++) {

                if (espelho[i][j].equals(num)) {
                    if (matriz[i][j].equals("T")) {
                        espelho[i][j] = "T";
                    } else {
                        espelho[i][j] = "  ";
                    }
                }
            }
        }
    }

    public static void exibeMatriz() {

        for (String[] espelho1 : espelho) {
            for (int j = 0; j < espelho[0].length; j++) {
                System.out.print("[ " + espelho1[j] + " ]");
            }
            System.out.println("");
        }

    }

    public static void verificaVencedor() {
        for (String[] espelho1 : espelho) {
            for (int j = 0; j < espelho[0].length; j++) {
                if (espelho1[j].equals("T")) {
                    vencedor = true;
                    System.out.println("\nVocê encontrou o Tesouro!");
                }
            }
        }
    }
}
