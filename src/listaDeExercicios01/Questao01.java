package listaDeExercicios01;

public class Questao01 {

    public static void main(String[] args) {

        int[] vetor = new int[10];
        System.out.println("Vetor: ");
        for (int i = 0; i < 10; i++) {
            vetor[i] = (int) (Math.random() * 10);
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
        System.out.println("Vetor na ordem inversa: ");
        for (int i = 9; i >= 0; i--) {
            System.out.print(vetor[i] + " ");
        }
    }
}
