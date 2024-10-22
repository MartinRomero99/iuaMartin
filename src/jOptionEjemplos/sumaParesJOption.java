package jOptionEjemplos;
/* Ingrese N enteros por teclado, cuente y sume los Enteros pares*/

/* IMPLEMENTADO SIN EXCEPCIONES Y SIN METODOS--------------------*/

/* Variables */
/* Variable    Tipo         Descripcion                 Valor Inical*/
/* ---------------------------------------------------------------- */
/*      N       entero         valor Ingrasado            s/d       */
/*      suma    entero      almacena suma de los pàres     0        */
/*      cont    entero      cuenta los pàres  ingresados   0        */
/* ---------------------------------------------------------------- */

import javax.swing.JOptionPane;

public class sumaParesJOption {
    public static void main(String[] ar) {
        int n, cont = 0, suma = 0;
        String ns, salidaStr;
        ns = JOptionPane.showInputDialog("Ingrese un entero");
        if (ns != null) {
            n = Integer.parseInt(ns);
            /*--------------------------------------------------------------------------------- */
            /*
             * JOptionPane.showInputDialog(Componente padre, Mensaje, Titulo, Tipo de
             * mensaje);
             */
            /*--------------------------------------------------------------------------------- */
            while (n != 0) {
                if (n % 2 == 0) {
                    cont++;
                    suma += n;
                }
                n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un entero"));
            }
            salidaStr = "La suma de los pare es i gual a: " + suma + "\nLa cantidad de pares es igual a: " + cont;
            JOptionPane.showMessageDialog(null, salidaStr, "PROG-1", 3);
        } else
            JOptionPane.showMessageDialog(null, "Adios", "Sin datos", JOptionPane.QUESTION_MESSAGE);

        /* messageType : -1 -> Sin Icono */
        /* messageType : 0 -> Error */
        /* messageType : 1 -> Información */
        /* messageType : 2 -> Warning */
        /* messageType : 3 -> Question */

        /*
         * ERROR_MESSAGE
         * INFORMATION_MESSAGE
         * WARNING_MESSAGE
         * QUESTION_MESSAGE
         * PLAIN_MESSAGE
         */

        // JOptionPane.showMessageDialog(null, "Mensaje con QUESTION_MESSAGE o 3",
        // "Javadesde0.com", JOptionPane.QUESTION_MESSAGE);
    }
}
