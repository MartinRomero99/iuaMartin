package jOptionEjemplos;

import java.util.Locale;

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
* JOptionPane.showConfirmDialog(Componente padre, mensaje, titulo, tipo de seleccion, tipo de mensaje, icono)
* JOptionPane.DEFAULT_OPTION: 1 boton (ACEPTAR).
* JOptionPane.OK_CANCEL_OPTION: 2 botones (SI/NO).
* JOptionPane.YES_NO_OPTION: 3 botones (SI/NO/CANCELAR).
* JOptionPane.YES_NO_CANCEL_OPTION: 3 botones (ACEPTAR/CANCELAR).
* SALIDA: 
*   ACEPTAR - SI -> 0
*   NO -> 1
*   CANCELAR -> 2 
/*---------------------------------- */

import javax.swing.JOptionPane;

public class sumaParesJOption_3 {
    public static void main(String[] ar) {
        Locale.setDefault(new Locale("es", "ES"));
        int n = 0, cont = 0, suma = 0, nResp;
        String salidaStr;
        do {
            n = ingresaValores();
            if (n % 2 == 0) {
                cont++;
                suma += n;
            }
            nResp = JOptionPane.showConfirmDialog(null, "¿Desea Insertar otro valor?", "Responda",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } while (nResp == 0);

        salidaStr = "La suma de los pare es i gual a: " + suma + "\nLa cantidad de pares es igual a: " + cont;
        JOptionPane.showMessageDialog(null, salidaStr, "PROG-1", 3);
    }

    /*------------------------------------------------------ */
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
