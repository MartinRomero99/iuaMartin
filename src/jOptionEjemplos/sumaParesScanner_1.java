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

public class sumaParesScanner_1 {
    public static void main(String[] ar) {
        Scanner e = new Scanner(System.in);
        int n, cont = 0, suma = 0;
        n = ingresaValor(e);
        /*---------------------------------- */
        while (n != 0) {
            if (n % 2 == 0) {
                cont++;
                suma += n;
            }
            n = ingresaValor(e);
        }
        System.out.println("La suma de los pares es igual a: " + suma);
        System.out.println("La cantidad de pares es igual a: " + cont);
        e.close();
    }

    /*------------------------------------------------------------ */
    /* Agregamos un Método que permite Ingresar y Validar el valor */
    /*------------------------------------------------------------ */
    public static int ingresaValor(Scanner data) {
        int valor = 0;
        boolean error = false;
        /* IMPLEMENTAMOS EL USO DE EXCEPCIONES */
        do {
            try {
                error = false;
                System.out.print("Ingrese un Entero: ");
                valor = data.nextInt();
            } catch (Exception e) {
                System.out.println(":-( ¡Debe ingresar un Entero!!!\n");
                error = true;
                /*
                 * Esta Instrucción se agrega para que libere el final de línea que daja la
                 * clase
                 * cuando se ingresa un entero
                 */
                data.nextLine();
            }
        } while (error);
        return valor;
    }
}
