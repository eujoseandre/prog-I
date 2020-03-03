package listaDeExercicios06;

public class Questao03 {
    public static void main(String[] args) {
        int [] vetor = new int [10];
        int num = 10;
        
        for (int i = 1; i <=num ; i++) {
            if((num / 1 == num) && (num / num == 0)){
                System.out.println(i + " É PRIMO");
            }
            else
                System.out.println(i + " NÃO É PRIMO");
        }
    }
}
