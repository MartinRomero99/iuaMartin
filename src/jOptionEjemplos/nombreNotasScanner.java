package jOptionEjemplos;
/* Ingrese nombre y Nota de Alumnos  - Al finalizar mostrar la nota mayor y el nombre del Alumno que posee esa nota*/

/* Variables */
/* Variable          Tipo         Descripcion                 Valor Inical*/
/* -------------------------------------------------------------------- */
/*      nota        entero      valor Ingresado                   s/d   */
/*      nombre      String      almacena el nombre del alumno     s/d   */
/*      notaMayor   entero      almacena la Nota Mayor             0    */
/*      nombreMayor String      alm. el nombre del alumno Mayor    ""   */
/*      La carga Finaliza cuando se escriba la palabra 'Salir'          */
/* -------------------------------------------------------------------- */

import java.util.Scanner;

public class nombreNotasScanner {
    public static void main(String[] ar) {
        Scanner ent = new Scanner(System.in);
        int nota, notaMayor = 0;
        String nombre, nombreMayor = "";
        boolean lSalir = false;
        /*--------------------------------------------------- */
        do {
            System.out.print("Ingrese el Nombre del Estudiante: ");
            nombre = ent.nextLine();

            /* Para comparar datos del tipo String utilizamos el Método */
            /* CompareTo de la clase String. si son iguales retorna 0, de lo contario */
            /* puede retornar > 0 o < 0 */
            /* Con el método toUpperCase(), ponemos en mayúscula el valor ingresado */
            /* para que podamos comparar con la palabra 'SALIR' */

            if (nombre.toUpperCase().compareTo("SALIR") != 0 && !lSalir) {
                System.out.print("Ingrese la Nota del Estudiante: ");

                /*-------------------------------------------------------------*
                 * Cargamos la Variable nota con esta instrucción para eviatr  *
                 *  que quede el buffer con datos String - lo vimos en clase - */
                /*-------------------------------------------------------------*/
                nota = Integer.parseInt(ent.nextLine());

                if (nota > notaMayor) {
                    notaMayor = nota;
                    nombreMayor = nombre;
                }
            } else {
                lSalir = true;
            }
        } while (!lSalir);

        /*--------------------------------------------------- */

        System.out
                .println("El nombre del estudiante con mayor nota es " + nombreMayor + " con una nota de " + notaMayor);
        ent.close();
    }
}
