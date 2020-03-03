package atividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JogoDaForca {
    
    static String[] animais = {"JACARE", "TAMANDUA", "CAMALEAO", "GOLFINHO", "MORCEGO", "ELEFANTE", "SALAMANDRA", "ORNITORRINCO",
        "COALA", "PINGUIM"};

    static String[] frutas = {"MEXERICA", "MELANCIA", "MANGA", "MORANGO", "ABACATE", "ACAI", "BANANA", "JABUTICABA",
        "GRAVIOLA", "ACEROLA"};

    static String[] objetos = {"COMPUTADOR", "TRANSISTOR", "VALVULA", "CHIPSET", "VENTOINHA", "BARRAMENTO", "DISQUETE", "PILHA",
        "ARDUINO", "ROTEADOR"};

    static String[] veiculos = {"HARLEY", "CADILAC", "LIMOSINE", "COLHEITADEIRA", "TUCSON", "HILUX", "KOMBI", "CAMINHAO",
        "PICKUP", "FUSCA"};

    static String[] profissoes = {"ENGENHEIRA", "OTORRINOLARINGOLOGISTA", "FISIOTERAPEUTA", "BOMBEIRO", "CONTADOR", "DESIGNER", "PROGRAMADOR", "PEDAGOGA",
        "CAMINHONEIRO", "PESQUISADOR"};

    static String palavraSorteada;
    static String[] palavra;
    static String[] espelho;
    static boolean vencedor = false;
    static Scanner entrada = new Scanner(System.in);
    static BufferedReader leitura = new BufferedReader(new InputStreamReader(System.in));
    static String jogador;
    static String CSI = "\u001B[";
    static int contErros = 0;
    static String nomeTema;
    static String letra = "";

    public static void main(String[] args) throws IOException {
        
        System.out.println("\n");
        System.out.print(CSI + "34" + "m");
        System.out.print("BEM-VINDO AO JOGO DA FORCA!\n");
        System.out.println(CSI + "m");
        
        System.out.print(CSI + "32" + "m");
        System.out.print("VOCÊ TEM 8 VIDAS DURANTE TODO O JOGO.");
        System.out.println(CSI + "m");
        
        System.out.println("\nAGORA, ADICIONE O NOME DO PLAYER.");
        System.out.println(CSI + "32" + "m");
        
        System.out.print(" > ");
        System.out.print(CSI + "m");
        jogador = leitura.readLine();
        
        System.out.println("");
        System.out.print(CSI + "32" + "m");
        System.out.print("NOME CONFIGURADO.");
        System.out.println(CSI + "m");
        
        System.out.println("");
        System.out.print(CSI + "34" + "m");
        System.out.print("PLAYER " + jogador.toUpperCase());
        System.out.print(CSI + "m");
        System.out.println(": SELECIONE O TEMA.");
        System.out.println(CSI + "31" + "m");
        
        System.out.print(CSI + "32" + "m");
        System.out.print("< ");
        System.out.print(CSI + "m");
        System.out.print("ANIMAIS - FRUTAS - VEICULOS - OBJETOS - PROFISSOES");
        System.out.print(CSI + "32" + "m");
        System.out.print(" >");
        System.out.println(CSI + "m");
        
        System.out.println("");
        System.out.print(CSI + "32" + "m");
        System.out.print(" > ");
        System.out.print(CSI + "m");

        switch (leitura.readLine().toUpperCase()) {

            case "ANIMAIS":
                nomeTema = "ANIMAIS.";
                sorteiaPalavra(animais);
                break;
            case "FRUTAS":
                nomeTema = "FRUTAS.";
                sorteiaPalavra(frutas);
                break;
            case "VEICULOS":
                nomeTema = "VEICULOS.";
                sorteiaPalavra(veiculos);
                break;
            case "OBJETOS":
                nomeTema = "OBJETOS.";
                sorteiaPalavra(objetos);
                break;
            case "PROFISSOES":
                nomeTema = "PROFISSOES.";
                sorteiaPalavra(profissoes);
                break;
            default:
                System.out.println("\nOPÇÃO INVÁLIDA!\n");
                main(args);
        }
            jogar();
    }

    public static void sorteiaPalavra(String vetor[]) {

        palavraSorteada = vetor[(int)  (Math.random() * 10)];
        palavra = new String[palavraSorteada.length()];
        espelho = new String[palavraSorteada.length()];

        for (int i = 0; i < palavra.length; i++) {
            palavra[i] = String.valueOf(palavraSorteada.charAt(i));
        }
        for (int i = 0; i < espelho.length; i++) {
            espelho[i] = "__";
        }
    }

    public static void jogar() throws IOException {
        
        verificaGanhador();
        System.out.println("");
        System.out.print(CSI + "32" + "m");
        System.out.print("> ");
        System.out.print(CSI + "m");
        System.out.print(CSI + "34" + "m");
        System.out.print("TEMA: " + nomeTema);
        System.out.print(CSI + "m");
        imprimiEspelho();
        boolean naoTemLetra = true;
        
        while (!vencedor && contErros < 8) {
            
            System.out.println("");
            System.out.print(CSI + "32" + "m");
            System.out.print("> VIDAS: " + (8 - contErros));
            
            System.out.println("");
            System.out.print("> ");
            System.out.print(CSI + "m");
            System.out.println("DIGITE UMA LETRA: ");
            System.out.println("");
            System.out.print(CSI + "32" + "m");
            System.out.print(" > ");
            System.out.print(CSI + "m");
            letra = entrada.next();
            letra = letra.toUpperCase();
            
            for (int i = 0; i < palavra.length; i++) {
                
                if (palavra[i].equals(letra) && !espelho[i].equals(letra)) {
                    espelho[i] = letra;
                    naoTemLetra = false;
                }
            }
            
            if (naoTemLetra) {
                contErros++;
                System.out.print(CSI + "31" + "m");
                System.out.print("\n> NÃO TEM ESSA LETRA NA PALAVRA.");
                System.out.println(CSI + "m");
                jogar();
            }
            jogar();
        }
            if (contErros == 8){
                System.out.println("\n");
                System.out.print(CSI + "31" + "m");
                System.out.print("VOCÊ PERDEU TODAS A SUAS VIDAS :(");
                System.out.println(CSI + "m");
                System.out.print(CSI + "32" + "m");
                System.out.print("\nA PALAVRA ERA: ");
                for (String parametro : palavra) {
                System.out.print(parametro);
            }
                System.out.print(CSI + "m");
                jogarNovamente();
        }
    }

    public static void imprimiEspelho() {
        System.out.println("\n");
        for (String parametro : espelho) {
            System.out.print(" " + parametro);
        }
        System.out.println("");
    }
    public static void verificaGanhador() throws IOException {
        int cont = 0;
        for (String parametro : espelho) {
            if (!"__".equals(parametro)) {
                cont++;
            }
        }
        if (cont == palavra.length) {
            vencedor = true;
        }
        if (vencedor){
            System.out.println("");
            System.out.print(CSI + "32" + "m");
            System.out.print("PARABÉNS " + jogador.toUpperCase() + ", VOCE GANHOU!");
            System.out.println(CSI + "m");
            System.out.print("\nA PALAVRA É: ");
                for (String parametro : palavra) {
                System.out.print(parametro);
            }
            jogarNovamente();
        }
    }
    public static void jogarNovamente() throws IOException {
        
        System.out.println("\n");
        System.out.print(CSI + "32" + "m");
        System.out.print("JOGAR NOVAMENTE?");
        System.out.println(CSI + "m");
        System.out.println("\nAPERTE ENTER PARA COMEÇAR.");
        System.out.println("OU APERTE 0 PARA SAIR DO JOGO.\n");
        System.out.print(CSI + "32" + "m");
        System.out.print(" > ");
        System.out.print(CSI + "m");
        switch(leitura.readLine()){
            
            case "": contErros = 0;
                     vencedor = false;
                     main(frutas);
                break;
                
            case "0": System.out.print(CSI + "31" + "m");
                      System.out.print("\nJOGO FINALIZADO PELO O USUÁRIO");
                      System.out.println(CSI + "m");
                      System.exit(0);
                break;
            default: System.out.println("");
                     System.out.print(CSI + "31" + "m");
                     System.out.print("OPÇÃO INVÁLIDA.");
                     System.out.println(CSI + "m");
                     jogarNovamente();
                break;
        }
    }
}
