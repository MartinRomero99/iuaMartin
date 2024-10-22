package claseArray;

import javax.swing.JOptionPane;

public class ejercicio0A {
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

        /* CARGAMOS LAS EDADES EN FORMA MANUAL */
        int edades[] = { 10, 15, 21, 55, 88 };

        /* Mostramos la edad del elemento i */
        int indice;
        indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice del valor a leer",
                "Trabajamos con Vectores", 1));

        if (indice > edades.length)
            mostrarMensajes("No se puede accedder a la posición " + indice + " Fuera de Rango", "Error", 0);
        else
            mostrarMensajes("El valor de la posición " + indice + " es: " + edades[indice], "Info", 1);
    }

    /* METODO GENERAL PARA MENSAJES */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);

    }
}
