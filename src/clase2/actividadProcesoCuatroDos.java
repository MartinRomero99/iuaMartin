package clase2;

import javax.swing.JOptionPane;

public class actividadProcesoCuatroDos {
    public static void main(String[] args) {
        int[] primeraDocena = { 0 };
        int[] segundaDocena = { 0 };
        int[] terceraDocena = { 0 };
        int[] numeroCero = { 0 };

        boolean jugar = true;
        int res = JOptionPane.showConfirmDialog(null, "Bienvenido a la Ruleta, desea comenzar?", "Casino Ruleta",
                JOptionPane.YES_NO_OPTION, 1);
        while (res == JOptionPane.YES_OPTION && jugar) {
            String[] opcionesAElegir = {
                    "Ingresar un número manualmente",
                    "Generar un número aleatorio",
                    "Mostrar las ocurrencias hasta el momento",
                    "Salir"
            };
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null,
                    "Seleccione una opción:", "Casino",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesAElegir, opcionesAElegir[0]);

            switch (opcionSeleccionada) {
                case "Ingresar un número manualmente":
                    String numS = JOptionPane.showInputDialog(null, "Ingrese un número desde el 0 al 36");
                    if (numS != null) {
                        try {
                            int num = Integer.parseInt(numS);
                            if (num >= 0 && num <= 36) {

                                determinarDocena(num, primeraDocena, segundaDocena, terceraDocena, numeroCero);

                            } else {
                                JOptionPane.showMessageDialog(null, "Número fuera de rango. Debe estar entre 0 y 36.");
                            }

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                        }

                    } else {
                        break;
                    }
                    break;
                case "Generar un número aleatorio":
                    int numeroRand = (int) (Math.random() * 37);
                    JOptionPane.showMessageDialog(null, "Número generado: " + numeroRand);
                    determinarDocena(numeroRand, primeraDocena, segundaDocena, terceraDocena, numeroCero);
                    break;
                case "Mostrar las ocurrencias hasta el momento":
                    mostrarEstadisticas(primeraDocena, segundaDocena, terceraDocena, numeroCero);
                    break;
                case "Salir":
                    jugar = false;
                    mostrarEstadisticas(primeraDocena, segundaDocena, terceraDocena, numeroCero);
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "Casino Ruleta", res);
                    break;
                default:
                    break;
            }

        }
        if (res == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Hasta pronto", "Casino Ruleta", res);
        }
    }

    private static void determinarDocena(int num, int[] primeraDocena, int[] segundaDocena, int[] terceraDocena,
            int[] numeroCero) {
        if (num >= 1 && num <= 12) {
            primeraDocena[0]++;
            JOptionPane.showMessageDialog(null, "El número pertenece a la Primera docena.");
        } else if (num >= 13 && num <= 24) {
            segundaDocena[0]++;
            JOptionPane.showMessageDialog(null, "El número pertenece a la Segunda docena.");
        } else if (num >= 25 && num <= 36) {
            terceraDocena[0]++;
            JOptionPane.showMessageDialog(null, "El número pertenece a la Tercera docena.");
        } else if (num == 0) {
            numeroCero[0]++;
            JOptionPane.showMessageDialog(null, "El número es 0 y no pertenece a ninguna docena.");
        }
    }

    private static void mostrarEstadisticas(int[] primeraDocena, int[] segundaDocena, int[] terceraDocena,
            int[] numeroCero) {
        String mensaje = "Estadísticas actuales:\n" +
                "Primera docena (1 a 12): " + primeraDocena[0] + "\n" +
                "Segunda docena (13 a 24): " + segundaDocena[0] + "\n" +
                "Tercera docena (25 a 36): " + terceraDocena[0] + "\n" +
                "Número 0: " + numeroCero[0];
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
