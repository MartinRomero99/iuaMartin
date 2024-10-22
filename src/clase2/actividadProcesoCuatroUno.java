/* Escriba un Programa en Java que permita determinar qué cantidad de 
dinero hay en una caja registradora, considerando que se tienen monedas 
de diez, cinco y un peso, y billetes de cien, doscientos y quinientos pesos.
 */

package clase2;

import javax.swing.JOptionPane;

public class actividadProcesoCuatroUno {

    public static void main(String[] args) {
        int cant10 = 0, cant5 = 0, cant1 = 0, cant100 = 0, cant200 = 0, cant500 = 0;

        JOptionPane.showMessageDialog(null,
                "¡Bienvenidos!\nSistema de conteo y suma de dinero automatico para una caja registradora",
                "Caja registradora", JOptionPane.QUESTION_MESSAGE);

        boolean datosCorrectos = false;
        while (!datosCorrectos) {
            try {
                int[] cantidades = ingresoCantidadesDinero();
                cant5 = cantidades[0];
                cant10 = cantidades[1];
                cant1 = cantidades[2];
                cant100 = cantidades[3];
                cant200 = cantidades[4];
                cant500 = cantidades[5];

                int respuesta = JOptionPane.showConfirmDialog(null,
                        "Los datos ingresados son los siguientes:\n5 centavos: " + cant5 + "\n10 centavos: " + cant10
                                + "\n1 peso: " + cant1 + "\n100 pesos: " + cant100 + "\n 200 pesos: " + cant200
                                + "\n500 pesos: " + cant500 + "\n¿Son Correctos?");

                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Seleccionaste SI");
                    datosCorrectos = true;
                    realizarResultados(cant5, cant10, cant1, cant100, cant200, cant500);

                } else {
                    JOptionPane.showMessageDialog(null, "Seleccionaste NO, vuelva a comenzar desde el principio");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No ingresaste un números válido.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR NUESTRO SISTEMA AUTOMATICO\n¡Nos vemos pronto!");
    }

    public static int[] ingresoCantidadesDinero() {
        int[] cantidades = new int[6];

        cantidades[0] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de monedad de 5 centavos:"));
        cantidades[1] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de monedad de 10 centavos:"));
        cantidades[2] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de monedad de 1 peso:"));
        cantidades[3] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de billetes de 100 pesos:"));
        cantidades[4] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de billetes de 200 pesos:"));
        cantidades[5] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de billetes de 500 pesos:"));

        return cantidades;
    }

    public static void realizarResultados(int cant10, int cant5, int cant1, int cant100, int cant200,
            int cant500) {

        double resultado5, resultado10, resultado1, resultado100, resultado200, resultado500;
        resultado5 = cant5 * 0.05;
        resultado10 = cant10 * 0.10;
        resultado1 = cant1;
        resultado100 = cant100 * 100;
        resultado200 = cant200 * 200;
        resultado500 = cant500 * 500;

        double total = resultado5 + resultado10 + resultado1 + resultado100 + resultado200 + resultado500;
        JOptionPane.showMessageDialog(null, "El total de dinero en la caja registradora es de: " + total);
    }

}
