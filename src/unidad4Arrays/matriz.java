package unidad4Arrays;

import javax.swing.JOptionPane;

/*Escribir un programa en Java que permita cargar una matriz de NxM elementos enteros. 
Obtener y mostrar los elementos mayores y su posición del promedio de la fila J ingresada por teclado. */
public class matriz {
    public static void main(String[] args) {

        try {
            int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas"));
            int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas"));

            int[][] matriz = cargarMatriz(filas, columnas);
            int filaJ = Integer
                    .parseInt(JOptionPane.showInputDialog("Ingrese el número de la fila desde 0 a " + (filas - 1)));

            try {
                if (filaJ < 0 || filaJ >= filas) {
                    JOptionPane.showMessageDialog(null, "Número de fila inválido.");
                    return;
                }
                double promedio = calcularPromedioFila(matriz, filaJ, columnas);
                mostrarMayoresAlPromedio(matriz, filaJ, promedio, columnas);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inconsistencia en los datos", "Error", 0);
        }

    }

    public static int[][] cargarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese el valor para [" + i + "][" + j + "]"));
            }
        }
        return matriz;
    }

    public static double calcularPromedioFila(int[][] matriz, int fila, int columnas) {
        double suma = 0;
        for (int j = 0; j < columnas; j++) {
            suma += matriz[fila][j];
        }
        return suma / columnas;
    }

    public static void mostrarMayoresAlPromedio(int[][] matriz, int fila, double promedio, int columnas) {
        StringBuilder resultado = new StringBuilder(
                "Elementos mayores al promedio (" + promedio + ") en la fila " + fila + ":\n");
        for (int j = 0; j < columnas; j++) {
            if (matriz[fila][j] > promedio) {
                resultado.append("Elemento: ").append(matriz[fila][j]).append(" en posición [")
                        .append(fila).append("][").append(j).append("]\n");
            }
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}