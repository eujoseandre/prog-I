package melhorandoOCodigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterParaIniciar {

    static BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
    static boolean titulo = true;

    public static void main(String[] args) throws IOException {
        if (titulo) {
            System.out.println("\nCOM O IF ELSE");
            titulo = false;
        }
        System.out.print("\nDigite Enter para iniciar: ");
        if (enter.readLine().equals("")) {
            System.out.println("\nParabéns!");
            System.out.println("É assim que se usa o ENTER para iniciar algo.");
            System.out.println("\nAGORA COM O SWITCH CASE");
            comSwitch();
        } else {
            System.out.println("\nOpção inválida.");
            main(args);
        }
    }

    public static void comSwitch() throws IOException {
        
        System.out.print("\nDigite Enter para iniciar: ");
        switch (enter.readLine()) {
            case "":
                System.out.println("\nParabéns");
                System.out.println("É aaim que se usa o ENTER para iniciar algo.");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpção inválida.");
                comSwitch();
                break;
        }
    }
}
