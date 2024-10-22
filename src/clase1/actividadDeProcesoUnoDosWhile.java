package clase1;

/*El factorial de un número entero se denota de la siguiente manera "n!" 
y su resultado es n!=n*(n-1)*(n-2)*1. 
Por ejemplo: 5!=5*4*3*2*1 siendo el resultado 120. Se pide desarrollar 
un programa en Java que lea un valor N por teclado y determine su factorial.
 Utilice ciclo for() y while().
 */
import java.io.IOException;
import java.util.Scanner;

public class actividadDeProcesoUnoDosWhile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double multiplicacion = 1;

        System.out.println("Ingrese un valor entero");
        int entero = sc.nextInt();

        int i = 1;
        while (i <= entero) {
            multiplicacion = multiplicacion * i;
            i++;
        }
        System.out.println("el factorial de " + entero + " es: " + multiplicacion);
        sc.close();
    }
}
