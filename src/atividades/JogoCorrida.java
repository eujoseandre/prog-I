package atividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JogoCorrida {

    static String corrida[][] = new String[2][50];
    static int posicaoTartaruga = 0;
    static int posicaoLebre = 0;
    static int numeroSorteado;
    static boolean exibeIntroducao = true;
    static boolean exibeTitulo = true;
    static boolean exibeSubTitulo = true;
    static BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
    static String nomeTartaruga;
    static String nomeLebre;
    static String CSI = "\u001B[";
    static boolean vencedor = false;

    public static void main(String[] args) throws IOException, InterruptedException {

        if (exibeIntroducao) {

            exibeIntroducao = false;
            System.out.println("\n");
            System.out.print(CSI + "31" + "m");
            System.out.println("BEM-VINDOS A CORRIDA DOS 50KM!\n");
            System.out.println(CSI + "m");
            System.out.print(CSI + "32" + "m");
            System.out.print("PERCUSO DA CORRIDA: ");
            System.out.print(CSI + "m");
            System.out.println("SUBIR UMA MONTANHA ESCORREGADIA.");
            System.out.print(CSI + "32" + "m");
            System.out.print("RECOMPENSA: ");
            System.out.print(CSI + "m");
            System.out.println("UM CESTO DE CENOURAS FRESCAS E ALFACE.");
        }

        if (exibeTitulo) {

            limpeza();
            exibeTitulo = false;

            System.out.println("\n\t\t");
            System.out.print(CSI + "31" + "m");
            System.out.println("COMPETIDORES >");
            System.out.println(CSI + "m");

            System.out.println("COMPETIDOR(A) 1: TARTARUGA.\n"
                    + "PERFIL DE JOGADOR: LENTA, PORÉM DETERMINADA.\n");
            System.out.println("DIGITE O NOME DESTE COMPETIDOR.\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(" > ");
            System.out.print(CSI + "m");
            nomeTartaruga = enter.readLine();

            System.out.print(CSI + "32" + "m");
            System.out.print("\n > NOME CONFIGURADO.");
            System.out.println(CSI + "m");

            System.out.println("\nCOMPETIDOR(A) 2: LEBRE.\n"
                    + "PERFIL DE JOGADOR: VELOZ, PORÉM PRESUNÇOSA.\n");
            System.out.println("DIGITE O NOME DESTE COMPETIDOR.\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(" > ");
            System.out.print(CSI + "m");
            nomeLebre = enter.readLine();

            System.out.print(CSI + "32" + "m");
            System.out.print("\n > NOME CONFIGURADO.");
            System.out.println(CSI + "m");
        }

        while (exibeSubTitulo) {
            exibeSubTitulo = false;

            System.out.println("\nAPERTE ENTER PARA INICIAR A CORRIDA!");
            System.out.println("APERTE 0 PARA SAIR.\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(" > ");
            System.out.print(CSI + "m");

            switch (enter.readLine()) {
                case "":
                    break;
                case "0":
                    System.out.println("");
                    System.out.print(CSI + "31" + "m");
                    System.out.print("JOGO ENCERRADO PELO O USUÁRIO.");
                    System.out.println(CSI + "m");
                    System.exit(0);
                            
                    System.out.println("");
                    System.out.print(CSI + "31" + "m");
                    System.out.println("DESEJA REALMENTE ENCERRAR O JOGO?");
                    System.out.println(CSI + "m");
                    System.out.println("APERTE ENTER PARA CONTINUAR.");
                    System.out.println("APERTE 0 PARA FINALIZAR.\n");
                    System.out.print(CSI + "32" + "m");
                    System.out.print(" > ");
                    System.out.print(CSI + "m");

                    switch (enter.readLine()) {
                        case "":
                            break;
                        case "0":
                            System.out.println("");
                            System.out.print(CSI + "31" + "m");
                            System.out.print("JOGO ENCERRADO PELO O USUÁRIO.");
                            System.out.println(CSI + "m");
                            System.exit(0);
                        default:
                            System.out.println("");
                            System.out.print(CSI + "31" + "m");
                            System.out.print("OPÇÃO INVÁLIDA.");
                            System.out.println(CSI + "m");
                            exibeSubTitulo = true;
                            main(args);
                            break;
                    }
                    break;
                default:
                    System.out.println("");
                    System.out.print(CSI + "31" + "m");
                    System.out.print("OPÇÃO INVÁLIDA.");
                    System.out.println(CSI + "m");
                    exibeSubTitulo = true;
                    main(args);
                    break;
            }
        }
        Thread.sleep(20);
        exibePosicao();
        verificaVencedor();
        sorteiaNumero();
        movimentaAnimal();
        while (!vencedor) {
            main(args);
        }
}

    public static void sorteiaNumero() {
        numeroSorteado = (int) (Math.random() * 10);
        System.out.println("\n");
        System.out.print(CSI + "32" + "m");
        System.out.println(" > " + nomeTartaruga.toUpperCase() + " E " + nomeLebre.toUpperCase()
                + " ESTÃO SUBINDO A MONTANHA.");
        System.out.print(CSI + "m");
        System.out.print(CSI + "32" + "m");
        System.out.print(" > ");
        System.out.print(CSI + "m");
        System.out.println("NÚMERO SORTEADO: " + numeroSorteado);
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

        limpeza();
        corrida[0][posicaoTartaruga] = "T";
        corrida[1][posicaoLebre] = "L";
    }

    public static void verificaVencedor() throws IOException {

        if (posicaoTartaruga == 49 && posicaoLebre == 49) {
            System.out.print(CSI + "31" + "m");
            System.out.println("\nEMPATE ENTRE OS COMPETIDORES!");
            System.out.println(CSI + "m");
            vencedor = true;
            jogarNovamente();
        }

        if (posicaoTartaruga == 49) {
            System.out.println("\n");
            System.out.println("RESULTADO DA CORRIDA:\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(nomeTartaruga.toUpperCase() + " GANHOU O DESAFIO! :D\n");
            System.out.print(CSI + "m");
            System.out.print(CSI + "32" + "m");
            System.out.print("RECOMPENSA: ");
            System.out.print(CSI + "m");
            System.out.println("UM CESTO DE CENOURAS FRECAS E ALFACE!\n");

            System.out.print(CSI + "31" + "m");
            System.out.println(nomeLebre.toUpperCase() + " PERDEU :(");
            System.out.println(CSI + "m");
            vencedor = true;
            jogarNovamente();
        }

        if (posicaoLebre == 49) {
            System.out.println("\n");
            System.out.println("RESULTADO DA CORRIDA:\n");
            System.out.print(CSI + "32" + "m");
            System.out.print(nomeLebre.toUpperCase() + " GANHOU A CORRIDA! :D\n");
            System.out.println(CSI + "m");
            System.out.print(CSI + "32" + "m");
            System.out.print("RECOMPENSA: ");
            System.out.print(CSI + "m");
            System.out.println("UM CESTO DE CENOURAS FRECAS E ALFACE!\n");

            System.out.print(CSI + "31" + "m");
            System.out.print(nomeTartaruga.toUpperCase() + "PERDEU :(");
            System.out.println(CSI + "m");
            vencedor = true;
            jogarNovamente();
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

    public static void limpeza() {

        for (String[] parametro : corrida) {
            for (int coluna = 0; coluna < corrida[0].length; coluna++) {
                parametro[coluna] = "-";
            }
        }
    }

    public static void jogarNovamente() throws IOException {

        System.out.print(CSI + "32" + "m");
        System.out.println("JOGAR NOVAMENTE?");
        System.out.println(CSI + "m");
        System.out.println("APERTE ENTER PARA JOGAR DE NOVO.");
        System.out.println("APERTE 0 PARA SAIR.\n");
        System.out.print(CSI + "32" + "m");
        System.out.print(" > ");
        System.out.print(CSI + "m");
        switch (enter.readLine()) {
            case "":
                exibeTitulo = true;
                exibeSubTitulo = true;
                posicaoTartaruga = 0;
                posicaoLebre = 0;
                break;
            case "0":
                System.out.println("");
                System.out.print(CSI + "31" + "m");
                System.out.print("JOGO ENCERRADO PELO O USUÁRIO.");
                System.out.println(CSI + "m");
                System.exit(0);
            default:
                System.out.println("");
                System.out.print(CSI + "31" + "m");
                System.out.println("OPÇÃO INVÁLIDA!");
                System.out.println(CSI + "m");
                jogarNovamente();
                break;
        }
    }
}