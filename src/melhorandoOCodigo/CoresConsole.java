
package melhorandoOCodigo;

public class CoresConsole {
    
        public static void main(String[] args) {
            
        String CSI = "\u001B[";
        
        System.out.print (CSI + "31" + "m");
        System.out.print ("Texto vermelho");
        System.out.println (CSI + "m");
        
        System.out.print (CSI + "32" + "m");
        System.out.print ("Texto verde");
        System.out.println (CSI + "m");
        
        System.out.print (CSI + "33" + "m");
        System.out.print ("Texto amarelo");
        System.out.println (CSI + "m");
        
        System.out.print (CSI + "34" + "m");
        System.out.print ("Texto azul");
        System.out.println (CSI + "m");
        
        System.out.print (CSI + "35" + "m");
        System.out.print ("Texto lilás");
        System.out.println (CSI + "m");
        
        System.out.print (CSI + "36" + "m");
        System.out.print ("Texto ciano");
        System.out.println (CSI + "m");
        
        System.out.print (CSI + "37" + "m");
        System.out.print ("Texto cinza");
        System.out.println (CSI + "m");
        
    }
}
