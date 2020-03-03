package listaDeExercicios05;

import java.text.NumberFormat;

public class Questao02 {

    static double salario;
    static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        while (salario < 998) {
            salario = Math.random() * 10000;
        }
        exibeSalario("Salário Atual: ");
        aumentaSalario(10);
    }

    public static void exibeSalario(String mensagem) {
        System.out.println(mensagem + nf.format(salario));
    }

    public static void aumentaSalario(double perc) {
        salario += (salario * (perc / 100));
        exibeSalario("Salário após aumento: ");
    }
}