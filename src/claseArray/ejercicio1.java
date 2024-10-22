package claseArray;

import javax.swing.JOptionPane;

public class ejercicio1 {
    public static void main(String[] args) throws Exception {

        int[] edades, notas;
        @SuppressWarnings("unused")
        int n, edad;
        @SuppressWarnings("unused")
        StringBuilder cData = new StringBuilder("Datos del Vector:\n------------------------------------");

        n = ingresaInt("Ingrese la cantidad de Alumnos", "Ingreso de Datos");
        edades = new int[n];

        notas = new int[n];

        /*----------------------------------------------------- */
        /* Iniciamos un ciclo para la carga del Vector */
        /*----------------------------------------------------- */
        cargaVector(edades);
        cargaVector(notas);

        mostrarVector(edades);
        mostrarVector(notas);

        /*----------------------------------------------------- */
        /* Busca y muestra la mayor de las edades */
        /*----------------------------------------------------- */
        int mayor = 0;
        for (int i = 0; i < n; i++) {
            if (edades[i] > mayor)
                mayor = edades[i];
        }
        System.out.println("La edad Mayor es: " + mayor + "\n");

    }

    /*----------------------------------------------- */

    public static void cargaVector(int[] datos) {
        int edad;
        for (int i = 0; i < datos.length; i++) {
            edad = ingresaInt("Ingrese la edad deL Alumno" + (i + 1), "CARGA DEL VECTOR ");
            datos[i] = edad;
        }
    }

    public static void mostrarVector(int[] otrosDatos) {
        StringBuilder cData = new StringBuilder("Muestro desde el metodo");

        for (int i = 0; i < otrosDatos.length; i++) {
            cData.append("\nedad de la posicion: " + i + " = " + otrosDatos[i]);
        }
        mostrarMensajes(cData.toString(), "Info", 2);
    }

    /*-------------------------------------- */
    /* Método para ingresar Valores Enteros */
    /*-------------------------------------- */
    public static int ingresaInt(String cMensaje, String cTitulo) {
        boolean error = false;
        int valor = 0;
        do {
            try {
                error = false;
                valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                        cMensaje,
                        cTitulo,
                        JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                mostrarMensajes("Debe Ingresar un Entero", "Error!!!", 0);
                error = true;
            }
        } while (error);
        return valor;
    }

    /*--------------------------------- */
    /* METODO GENERAL PARA MENSAJES */
    /*--------------------------------- */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }
}
