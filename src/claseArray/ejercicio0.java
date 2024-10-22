package claseArray;

import javax.swing.JOptionPane;

public class ejercicio0 {

    public static void main(String[] args) throws Exception {
        /*--------------------------------------*/
        /* DISTINTOS TIPO DE DECLARACIONES */
        /* ------------------------------------ */
        // char cad[], p; //cad es un array de tipo char ; p es una variable de tipo
        // char.
        // int [] v, w ; //tanto v como w son declarados arrays unidimensionales de tipo
        // int.
        // double []m, t[], x ; //m y x son array de tipo double, t es un array de array
        // con elementos de tipo double.
        // edades = new int[10]; /* Asignamos al vector edades el nro de elementos */
        // int []edades = new int[30] ; /* Se podría Declarar todo en una misma
        // sentencia */

        /*-------------------------------------*/
        /* CARGAMOS LAS EDADES EN FORMA MANUAL */
        /*-------------------------------------*/
        int edades[] = { 10, 15, 21, 55 };

        /*-------------------------------------*/
        /* Mostramos la edad del elemento i */
        /*-------------------------------------*/
        int indice;

        try {
            indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice del valor a leer",
                    "Trabajamos con Vectores", 1));
            mostrarMensajes("El valor de la posición " + indice + " es: " + edades[indice], "Info", 1);
        } catch (Exception e) {
            mostrarMensajes("Posicion Fuera de Rago", "Error", 0);
        }
    }

    /*--------------------------------- */
    /* METODO GENERAL PARA MENSAJES */
    /*--------------------------------- */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);

    }
}
