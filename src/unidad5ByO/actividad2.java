package unidad5ByO;

import javax.swing.JOptionPane;

import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class actividad2 {
    public static void main(String[] args) {
        int n = ingresarElementos();

        String[] nombreYApellido = new String[n];
        cargarArraysString(nombreYApellido, n);
        int[] dni = new int[n];
        cargarArraysEntero(dni, n, nombreYApellido);
        buscarPersona(nombreYApellido, dni);
    }

    private static int ingresarElementos() {
        int n = 0;
        while (true) {
            try {
                n = Ingreso.datoEntero("Ingrese la cantidad de personas a ingresar:",
                        "Ingreso de datos", 1);
                if (n > 0) {
                    break;
                }
            } catch (Exception e) {
                Salida.mMensaje("No ingresaste un número válido.", "Error!");
            }
        }
        return n;
    }

    private static void cargarArraysEntero(int[] dni, int n, String[] nombreYApellido) {
        boolean error2;
        int input;
        for (int i = 0; i < n; i++) {
            do {
                error2 = false;
                try {
                    input = Ingreso.datoEntero("Ingrese el DNI de " + nombreYApellido[i] + ":",
                            "Ingreso de DNI", 1);
                    dni[i] = input;
                    if (dni[i] < 0) {
                        Salida.mMensaje("Debes ingresar un numero positivo", "ERROR");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "No ingresaste un número válido.");
                    error2 = true;
                }
            } while (error2);
        }
    }

    private static void cargarArraysString(String[] nombreYApellido, int n) {
        for (int i = 0; i < n; i++) {
            nombreYApellido[i] = Ingreso.datoString("Ingrese el Nombre y apellido " + (i + 1) + ":",
                    "Ingreso de datos", 1);
        }
    }

    public static void buscarPersona(String[] nombreYApellido, int[] dni) {

        int dniBuscado = Ingreso.datoEntero("Ingrese el DNI a buscar", "Encontrar persona", 1);
        boolean encontrado = false;

        for (int i = 0; i < dni.length; i++) {
            if (dni[i] == dniBuscado) {
                Salida.mMensaje("Nombre encontrado: " + nombreYApellido[i] + ", correspondiente al DNI " + dni[i],
                        "Resultado de búsqueda");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Salida.mMensaje("No se encontro o no existe la persona buscada", "Error!");
        }

    }
}
