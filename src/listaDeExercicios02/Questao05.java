package listaDeExercicios02;

public class Questao05 {

    public static void main(String[] args) {
        int[] sorteio = new int[10];
        int[] diferentes = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println("Vetor Sorteio: ");
        for (int i = 0; i < 10; i++) {
            sorteio[i] = (int) (Math.random() * 10);
            System.out.print(sorteio[i] + " ");
        }
        System.out.println("\n\n");
        int posDif = 0;

        for (int i = 0; i < 10; i++) {
            int num = sorteio[i];
            boolean existe = false;
            for (int j = 0; j < 10; j++) {
                if (num == diferentes[j]) {
                    existe = true;
                    break;
                }
            }
            if (existe == false) {
                diferentes[posDif] = num;
                posDif++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (diferentes[i] >= 0) {
                int num = diferentes[i];
                int cont = 0;
                for (int j = 0; j < 10; j++) {
                    if (sorteio[j] == num) {
                        cont++;
                    }
                }
                System.out.println(diferentes[i] + ": " + cont + " vez(es)");
            }
        }
    }
}
