package practicosDeClase;

import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class actividad511 {
    public static void main(String[] args) {
        int filas = Ingreso.datoEntero("Ingrese el numero de filas", "Número de filas", 1);
        int columnas = Ingreso.datoEntero("Ingrese el numero de columnas", "Número de columnas", 1);
        int arreglo[][] = new int[filas][columnas];
        cargarArreglo(arreglo);
        Salida.mMensaje("" + promedio(arreglo), "Promedio");
    }

    public static void cargarArreglo(int arreglo[][]) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo[i][j] = Ingreso.datoEntero("Ingrese la posicion" + i + ", " + j, "Ingreso de datos", 1);

            }
        }
    }

    public static void mostrarArreglo(int arreglo[][]) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                data.append("El numero en la posición " + i + ", " + j + " es: " + arreglo[i][j] + "\n");
            }
        }
        Salida.mMensaje(data.toString(), "resultado");
    }

    public static void encontrarMaximo(int arreglo[][]) {
        int maxValor = arreglo[0][0];
        int maxFila = 0;
        int maxColumna = 0;

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j] > maxValor) {
                    maxValor = arreglo[i][j];
                    maxFila = i;
                    maxColumna = j;
                }
            }
        }

        String mensaje = "El número más grande es " + maxValor + " en la posición (" + maxFila + ", " + maxColumna
                + ")";
        Salida.mMensaje(mensaje, "Resultado del máximo");
    }

    public static double promedio(int arreglo[][]) {

        double promedio = 0;
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                suma += arreglo[i][j];
            }

        }
        promedio = (double) suma / arreglo.length;
        return promedio;
    }
}
