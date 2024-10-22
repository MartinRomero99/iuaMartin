package jOptionEjemplos;
/* Ingrese N enteros por teclado, cuente y sume los Enteros pares*/

/* Variables */
/* Variable    Tipo         Descripcion                 Valor Inical*/
/* ---------------------------------------------------------------- */
/*      N       entero         valor Ingrasado            s/d       */
/*      suma    entero      almacena suma de los pàres     0        */
/*      cont    entero      cuenta los pàres  ingresados   0        */
/* ---------------------------------------------------------------- */

import java.util.Scanner;

public class sumaParesScanner {
    public static void main(String[] ar) {
        Scanner e = new Scanner(System.in);
        int n, cont = 0, suma = 0;
        System.out.print("Ingrese un Entero: ");
        n = e.nextInt();
        /*---------------------------------- */
        while (n != 0) {
            if (n % 2 == 0) {
                cont++;
                suma += n;
            }
            System.out.print("Ingrese un Entero: ");
            n = e.nextInt();
        }
        System.out.println("La suma de los pares es igual a: " + suma);
        System.out.println("La cantidad de pares es igual a: " + cont);
        e.close();
    }
}
