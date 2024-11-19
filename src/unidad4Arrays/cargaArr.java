package unidad4Arrays;

import javax.swing.JOptionPane;

/*Escribir un programa en Java que luego de cargar un array unidimensional (vector) 
de n elementos, imprima la cantidad de elementos mayores al promedio. */
public class cargaArr {
    public static void main(String[] args) {

        String ciclosST = JOptionPane.showInputDialog("Ingrese la cantidad de números que desea cargar");
        int ciclos = Integer.parseInt(ciclosST);

        double[] numeros = cargarNumero(ciclos);

        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        double promedio = suma / ciclos;

        double contadorMayores = mayoresAlPromedio(numeros, promedio);

        JOptionPane.showMessageDialog(null, "El promedio es: " + promedio +
                "\nCantidad de elementos mayores al promedio: " + contadorMayores, "Arrays", 1);
    }

    public static double[] cargarNumero(int cantidad) {
        double[] numeros = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = Double.parseDouble(
                    JOptionPane.showInputDialog("Ingrese el número para la posición " + (i + 1)));
        }
        return numeros;
    }

    public static double mayoresAlPromedio(double[] numeros, double promedio) {
        int contadorMayores = 0;
        for (double numero : numeros) {
            if (numero > promedio) {
                contadorMayores++;
            }
        }
        return contadorMayores;
    }
}
