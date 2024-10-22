package jOptionEjemplos;
/* VERSION FINAL-------------------------------------------------*/

/* Ingrese N enteros por teclado, cuente y sume los Enteros pares*/

/* Variables -------------------------------------------------------*/
/* Variable    Tipo         Descripcion                 Valor Inical*/
/* ---------------------------------------------------------------- */
/*      N       entero         valor Ingrasado            s/d       */
/*      suma    entero      almacena suma de los pàres     0        */
/*      cont    entero      cuenta los pàres  ingresados   0        */
/* ---------------------------------------------------------------- */
/* ------------------------------------ *
 * JOptionPane.showInputDialog(Componente padre, Mensaje, Titulo, Tipo de
 * mensaje);
 * ------------------------------------ *
 * showInputDialog -> Tipo de Mensaje *
 *------------------------------------*
 * messageType : -1 -> Sin Icono
 * messageType : 0 -> Error
 * messageType : 1 -> Información
 * messageType : 2 -> Warning
 * messageType : 3 -> Question
 * 
 * ------------------------------------------------------------------------*
 * JOptionPane.showMessageDialog(Componente padre, Mensaje, Titulo, Icono);
 * ------------------------------------------------------------------------
 * showInputDialog -> iconos *
 * ---------------------------*
 * ERROR_MESSAGE
 * INFORMATION_MESSAGE
 * WARNING_MESSAGE
 * QUESTION_MESSAGE
 * PLAIN_MESSAGE
 */
/*---------------------------------- */

import javax.swing.JOptionPane;

public class sumaParesJOption_2 {
    public static void main(String[] ar) {
        int n = 0, cont = 0, suma = 0;
        String salidaStr;
        n = ingresaValores();

        while (n != 0) {
            if (n % 2 == 0) {
                cont++;
                suma += n;
            }
            n = ingresaValores();
        }
        salidaStr = "La suma de los pare es i gual a: " + suma + "\nLa cantidad de pares es igual a: " + cont;
        JOptionPane.showMessageDialog(null, salidaStr, "PROG-1", 3);
    }

    public static int ingresaValores() {
        boolean error = false;
        int entero = 0;
        do {
            try {
                error = false;
                entero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un entero", "Hola!!!",
                        JOptionPane.INFORMATION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un Entero", "PROG-1", 0);
                error = true;
            }
        } while (error);
        return entero;
    }
}
