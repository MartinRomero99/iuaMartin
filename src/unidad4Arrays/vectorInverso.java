package unidad4Arrays;

import javax.swing.JOptionPane;

/*Realice un programa en Java que lea un vector de enteros y a partir de él forme 
un segundo vector, con los mismos datos pero en el orden inverso, mostrar. Obtener a 
partir del primer vector el promedio y luego mostrar solo los enteros que sean mayores 
que el promedio. Utilizar métodos para las distintas operaciones. */
public class vectorInverso {
    public static void main(String[] args) {
        try {
            int cantValores = Integer
                    .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de valores que desea cargar"));

            int[] valores = new int[cantValores];
            for (int i = 0; i < cantValores; i++) {
                valores[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor N°: " + (i + 1)));
            }
            mostrarVector(valores, "Valores obtenidos");

            double suma = 0;
            for (int num : valores) {
                suma += num;
            }
            double promedio = suma / valores.length;

            int[] vectorInverso = new int[valores.length];
            for (int i = 0; i < valores.length; i++) {
                vectorInverso[i] = valores[valores.length - 1 - i];
            }
            mostrarVector(vectorInverso, "Valores en orde inverso");

            StringBuilder mayoresQuePromedio = new StringBuilder("Valores mayores al promedio (" + promedio + "):\n");
            for (int num : valores) {
                if (num > promedio) {
                    mayoresQuePromedio.append(num).append(" ");
                }
            }
            JOptionPane.showMessageDialog(null, mayoresQuePromedio.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inconsistencia en los datos", "Error", 0);
        }

    }

    public static void mostrarVector(int[] valores, String mensaje) {
        StringBuilder contenido = new StringBuilder(mensaje + "\n");
        for (int num : valores) {
            contenido.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, contenido.toString());
    }
}
