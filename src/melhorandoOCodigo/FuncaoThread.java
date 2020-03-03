package melhorandoOCodigo;

public class FuncaoThread {

    static boolean loopInfinito = true;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        imprimi();
        while (loopInfinito) {
            main(args);
        }
    }

    public static void imprimi() {

        System.out.println("É ASSIM QUE FUNCIONA A FUNÇÃO THREAD.SLEEP");
        System.out.println("\nVOCÊ ESTIPULA UM LIMITE DE VELOCIDADE.");
        System.out.println("E ESSA FUNÇÃO FAZ COM QUE TODA A CLASSE OPERE NAQUELA"
                + " VELOCIDADE QUE VOCE ESTIPULOU.");
        System.out.println("TIPO AGORA! LEGAL NÉ?\n");
    }
}
