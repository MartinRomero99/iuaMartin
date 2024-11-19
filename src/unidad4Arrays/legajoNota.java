package unidad4Arrays;

import javax.swing.JOptionPane;

/*Escribir un programa que permita cargar dos arreglos unidimensionales (vectores) de n elementos cada uno,
 el primero conteniendo el legajo y el segundo la nota de cada alumno. Se quiere saber que alumnos tienen una 
 nota mayor al número K ingresado desde el teclado. */
public class legajoNota {
    public static void main(String[] args) {
        int alumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumnos"));

        int[] legajos = new int[alumnos];
        double[] notas = new double[alumnos];
        cargarDatosAlumnos(alumnos, legajos, notas);
        double minimo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota mínima para listar alumnos:"));
        String resultado = listarAlumnosConNotaMayor(alumnos, legajos, notas, minimo);
        mostrarResultado(resultado, minimo);
    }

    public static void cargarDatosAlumnos(int alumnos, int[] legajos, double[] notas) {
        for (int i = 0; i < alumnos; i++) {
            legajos[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el legajo del alumno " + (i + 1) + ":"));
            notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno " + (i + 1) + ":"));
        }
    }

    public static String listarAlumnosConNotaMayor(int alumnos, int[] legajos, double[] notas, double minimo) {
        StringBuilder resultado = new StringBuilder("Alumnos con nota mayor a " + minimo + ":\n");
        boolean hayAlumnosConNotaMayor = false;

        for (int i = 0; i < alumnos; i++) {
            if (notas[i] > minimo) {
                resultado.append("Legajo: ").append(legajos[i]).append(", Nota: ").append(notas[i]).append("\n");
                hayAlumnosConNotaMayor = true;
            }
        }
        return hayAlumnosConNotaMayor ? resultado.toString() : null;
    }

    public static void mostrarResultado(String resultado, double minimo) {
        if (resultado != null) {
            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Ningún alumno tiene una nota mayor a " + minimo);
        }
    }
}