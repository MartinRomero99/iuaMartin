package unidad5ByO;

import java.util.Arrays;

import javax.swing.JOptionPane;

import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class actividad1 {
    public static void main(String[] args) {
        int n = ingresarElementos();

        String[] descripcionArticulos = new String[n];
        cargarArraysString(descripcionArticulos, n);
        double[] preciosUnitarios = new double[n];
        cargarArraysDouble(preciosUnitarios, n, descripcionArticulos);

        ordenAscendente(descripcionArticulos, preciosUnitarios);
    }

    private static int ingresarElementos() {
        int n = 0;
        while (true) {
            try {
                n = Ingreso.datoEntero("Ingrese la cantidad de elementos que va a tener el vector:",
                        "Elementos de", 1);
                if (n > 0) {
                    break;
                }
            } catch (Exception e) {
                Salida.mMensaje("No ingresaste un número válido.", "Error!");
            }
        }
        return n;
    }

    private static void cargarArraysString(String[] descripcionArticulos, int n) {
        for (int i = 0; i < n; i++) {
            descripcionArticulos[i] = Ingreso.datoString("Ingrese la descripción de Artículo " + (i + 1) + ":",
                    "Descripción del artículo", 1);
        }
    }

    private static void cargarArraysDouble(double[] preciosUnitarios, int n, String[] descripcionArticulos) {
        boolean error2;
        Double input;
        for (int i = 0; i < n; i++) {
            do {
                error2 = false;
                try {
                    input = Ingreso.datoDoble("Ingrese el precio de " + descripcionArticulos[i] + ":",
                            "PRECIO UNITARIO POR ARTICULO", 1);
                    preciosUnitarios[i] = input;
                    if (preciosUnitarios[i] < 0) {
                        Salida.mMensaje("Debes ingresar un numero positivo", "ERROR");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "No ingresaste un número válido.");
                    error2 = true;
                }
            } while (error2);
        }
    }

    private static void ordenAscendente(String[] descripcionArticulos, double[] preciosUnitarios) {
        Integer[] indices = new Integer[preciosUnitarios.length];

        for (int i = 0; i < preciosUnitarios.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i1, i2) -> Double.compare(preciosUnitarios[i1], preciosUnitarios[i2]));

        StringBuilder sb = new StringBuilder();
        sb.append("Artículos ordenados de manera ascendente o de menor a mayor\n");
        for (int orden : indices) {
            sb.append("Descripción: ").append(descripcionArticulos[orden]);
            sb.append("\nPrecio Unitario: $").append(preciosUnitarios[orden]);
            sb.append("\n-------------------------");
            sb.append("\n");
        }
        Salida.mMensaje(sb.toString(), "Resultado");
    }
}
