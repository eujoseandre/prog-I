package atividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JogoCorrida2 {

    static String corrida[][] = new String[2][50];
    static int posicaoTartaruga;
    static int posicaoLebre;
    static int numeroSorteado;
    static BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
    static String nomeTartaruga;
    static String nomeLebre;
    static boolean exibeIntroducao = true;
    static String CSI = "\u001B[";
    static boolean vencedor;

    public static void main(String[] args) throws IOException, InterruptedException {

        if (exibeIntroducao) {

            exibeIntroducao = false;

            for (String[] parametro : corrida) {
                for (int coluna = 0; coluna < corrida[0].length; coluna++) {
                    parametro[coluna] = "-";
                }
            }
            System.out.println("\n");
            System.out.print(CSI + "31" + "m");
            System.out.println("Bem-vindos a corrida dos 50KM!\n");
            System.out.println(CSI + "m");
            System.out.print(CSI + "32" + "m");
            System.out.print("Percuso da corrida: ");
            System.out.print(CSI + "m");
            System.out.println("subir uma montanha escorregadía.");
            System.out.print(CSI + "32" + "m");
            System.out.print("Recompensa: ");
            System.out.print(CSI + "m");
            System.out.println("um cesto de cenouras frescas e alface.");

            System.out.println("\n\t\t");
            System.out.print(CSI + "31" + "m");
            System.out.println("Competidores >");
            System.out.println(CSI + "m");

            System.out.println("Competidor(a) 1: TARTARUGA.\n"
                    + "Perfil de Jogador: lenta, porém determinada.\n");
            System.out.println("Digite o nome deste competidor.\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(" > ");
            System.out.print(CSI + "m");
            nomeTartaruga = enter.readLine();

            System.out.print(CSI + "32" + "m");
            System.out.print("\n > Nome configurado.");
            System.out.println(CSI + "m");

            System.out.println("\nCompetidor(a) 2: LEBRE.\n"
                    + "Perfil de Jogador: veloz, porém presunçosa.\n");
            System.out.println("Digite o nome deste competidor.\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(" > ");
            System.out.print(CSI + "m");
            nomeLebre = enter.readLine();

            System.out.print(CSI + "32" + "m");
            System.out.print("\n > Nome configurado.");
            System.out.println(CSI + "m");
        }
        System.out.println("\nAperte ENTER para iniciar!");
        System.out.println("Aperte 1 para reiniciar o jogo.");
        System.out.println("Aperte 0 para sair.\n");
        System.out.print(CSI + "32" + "m");
        System.out.print(" > ");
        System.out.print(CSI + "m");

        switch (enter.readLine()) {
            case "":
                vencedor = false;
                posicaoTartaruga = 0;
                posicaoLebre = 0;
                break;
            case "0":
                System.out.println("");
                System.out.print(CSI + "31" + "m");
                System.out.print("Jogo encerrado pelo o usúario.");
                System.out.println(CSI + "m");
                System.exit(0);
                break;
            case "1":
                exibeIntroducao = true;
                vencedor = false;
                posicaoTartaruga = 0;
                posicaoTartaruga = 0;
                main(args);
                break;
            default:
                System.out.println("");
                System.out.print(CSI + "31" + "m");
                System.out.print("Opção inválida.");
                System.out.println(CSI + "m");
                main(args);
                break;
        }

        while (!vencedor) {
            //Thread.sleep(20);
            sorteiaNumero();
            exibePosicao();
            verificaVencedor();
            movimentaAnimal();
        }

        boolean jogarNovamente = true;

        while (jogarNovamente) {
            System.out.println("");
            System.out.print(CSI + "32" + "m");
            System.out.println("Jogar novamente?");
            System.out.print(CSI + "m");
            main(args);
        }
    }

    public static void sorteiaNumero() {
        numeroSorteado = (int) (Math.random() * 10);
        System.out.println("\n");
        System.out.print(CSI + "32" + "m");
        System.out.println(" > " + nomeTartaruga.toUpperCase() + " e " + nomeLebre.toUpperCase()
                + " estão subindo a montanha.");
        System.out.print(CSI + "m");
        System.out.print(CSI + "32" + "m");
        System.out.print(" > ");
        System.out.print(CSI + "m");
        System.out.println("Número sorteado: " + numeroSorteado);
        System.out.println("");
    }

    public static void movimentaAnimal() {

        if (numeroSorteado < 3) {
            posicaoTartaruga += 3;
            if (posicaoTartaruga > 49) {
                posicaoTartaruga = 49;
            }
        } else if (numeroSorteado < 6) {
            posicaoTartaruga -= 6;
            if (posicaoTartaruga < 0) {
                posicaoTartaruga = 0;
            }
        } else {
            posicaoTartaruga += 1;
            if (posicaoTartaruga > 49) {
                posicaoTartaruga = 49;
            }
        }

        if (numeroSorteado > 1 && numeroSorteado < 5) {
            posicaoLebre -= 8;
            if (posicaoLebre < 0) {
                posicaoLebre = 0;
            }
        } else if (numeroSorteado < 8) {
            posicaoLebre += 2;
            if (posicaoLebre > 49) {
                posicaoLebre = 49;
            }
        } else {
            posicaoLebre -= 4;
            if (posicaoLebre < 0) {
                posicaoLebre = 0;
            }
        }

        for (String[] parametro : corrida) {
            for (int coluna = 0; coluna < corrida[0].length; coluna++) {
                parametro[coluna] = "-";
            }
        }
        corrida[0][posicaoTartaruga] = "T";
        corrida[1][posicaoLebre] = "L";
    }

    public static void verificaVencedor() throws IOException {

        if (posicaoTartaruga == 49 && posicaoLebre == 49) {
            System.out.print(CSI + "31" + "m");
            System.out.println("\nEmpate entre os competidores!");
            System.out.println(CSI + "m");
            vencedor = true;
        }

        if (posicaoTartaruga == 49) {
            System.out.println("\n");
            System.out.println("Resultado da corrida:\n");
            System.out.print(CSI + "31" + "m");
            System.out.print("Tartaruga " + nomeTartaruga.toUpperCase() + " ganhou o desafio! :D\n");
            System.out.print(CSI + "m");
            System.out.print(CSI + "31" + "m");
            System.out.print("Recompensa: ");
            System.out.print(CSI + "m");
            System.out.println("um cesto de cenouras frescas e alface!\n");

            System.out.print(CSI + "31" + "m");
            System.out.println("Lebre " + nomeLebre.toUpperCase() + " perdeu o desafio :(");
            System.out.println(CSI + "m");
            vencedor = true;
        }

        if (posicaoLebre == 49) {
            System.out.println("\n");
            System.out.println("Resultado da corrida:\n");
            System.out.print(CSI + "31" + "m");
            System.out.print("Lebre " + nomeLebre.toUpperCase() + " ganhou o desafio! :D\n");
            System.out.println(CSI + "m");
            System.out.print(CSI + "31" + "m");
            System.out.print("Recompensa: ");
            System.out.print(CSI + "m");
            System.out.println("um cesto de cenouras frescas e alface!\n");

            System.out.print(CSI + "31" + "m");
            System.out.print("Tartaruga " + nomeTartaruga.toUpperCase() + " perdeu o desafio :(");
            System.out.println(CSI + "m");
            vencedor = true;
        }
    }

    public static void exibePosicao() {

        for (String[] parametro : corrida) {
            for (int coluna = 0; coluna < corrida[0].length; coluna++) {
                System.out.print(parametro[coluna]);
            }
            System.out.println("");
        }
    }
}