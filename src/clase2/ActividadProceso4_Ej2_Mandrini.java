package clase2;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*	Diseñar un programa en Java que permita al usuario determinar la docena correspondiente a un número 
obtenido en una jugada de ruleta (del 0 al 36) y contar las veces de ocurrencias.

El algoritmo debe ofrecer un menú con las siguientes opciones:

1-Ingrese un Número (manual): El usuario ingresa un número entre 0 y 36 (Validar que los números ingresados
 estén en ese rango).

2-Generar un número Aleatorio: Utilizar la librería correspondiente.

3-Estadísticas: Mostrar las ocurrencias en ese momento de acuerdo a la siguiente tabla
* Primera docena: 1 a 12
* Segunda docena: 13 a 24
* Tercera docena: 25 a 36
* Número 0: El número 0 no pertenece a ninguna docena

4-Salir: Finaliza la ejecución del programa.
* El programa debe repetir el menú hasta que el usuario decida salir.
* Al finalizar mostrar la estadística final, obtener y mostrar la docena con más ocurrencias.

Requerimientos:
* Validar que el número ingresado esté dentro del rango permitido, opciones 1 y 2 (0 a 36).
* Mostrar mensajes claros y adecuados al usuario para cada una de las opciones.
* Debe Utilizar métodos para cada operatoria. */

public class ActividadProceso4_Ej2_Mandrini {
    public static void main(String[] args) {

        String seleccion;
        Estadisticas estadisticas = new Estadisticas(); // Creamos una instancia para almacenar los contadores

        do {

            /* Lista desplegable con Titulo e Icono */
            String[] opciones = { "Ingrese un numero manual", "Generar un numero aleatorio", "Estadisticas", "Salir" };
            ImageIcon icon = new ImageIcon("D:\\PERSONAL\\TUDAI\\logo-transparente.png"); // LOGO IUA de adornito ;P

            seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una de las opciones a ejecutar ",
                    "LA RULETA ANDA DICIENDO...",
                    JOptionPane.QUESTION_MESSAGE, icon, opciones, opciones[0]);

            JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);

            opcionesSeguir(seleccion, estadisticas);

        } while (!seleccion.equals("Salir"));

        // mostrar las estadisticas finales al final del programa.
        mostrarEstadisticasFinales(estadisticas);

    }

    public static void opcionesSeguir(String seleccion, Estadisticas estadisticas) {
        int numeroFinal = -1; // numero que se va a utilizar para las estadisticas.

        try {
            switch (seleccion) {

                // Solicitar un número por teclado
                case "Ingrese un numero manual":
                    String inputNumero = JOptionPane.showInputDialog(null, "Introduce un número del 0 al 36");
                    numeroFinal = Integer.parseInt(inputNumero);
                    if (numeroFinal < 0 || numeroFinal > 36) {
                        throw new Exception("Numero fuera de Rango");
                    }
                    break;

                // generar un numero aleatorio
                case "Generar un numero aleatorio":
                    numeroFinal = imprimirNumeroAleatorio();
                    break;

                // ESTADISTICAS
                case "Estadisticas":
                    // opciones desplegable para seleccionar la estadistica por docena.
                    String[] opcionEst = { "Primera Docena", "Segunda Docena", "Tercera Docena", "Cero" };
                    String selecEst = (String) JOptionPane.showInputDialog(null,
                            "Seleccione una de las opciones a ejecutar ",
                            "ESTADISTICAS ", JOptionPane.QUESTION_MESSAGE, null, opcionEst, opcionEst[0]);
                    estadisticas(selecEst, estadisticas);
                    return; // salir de la funcion sin actualizar estadisticas

                case "Salir":
                    break;

                default:
                    throw new AssertionError("Opcion no Válida");
            }

            // calcular las estadisticas del numero ingresado o generado
            calcularEstadisticas(numeroFinal, estadisticas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor ingresado no válido");
        }
    }

    private static void calcularEstadisticas(int numero, Estadisticas estadisticas) {

        if (numero == 0) {
            estadisticas.incrementarCero();
        } else if (numero > 0 && numero <= 12) {
            estadisticas.incrementarPrimera();
        } else if (numero > 12 && numero <= 24) {
            estadisticas.incrementarSegunda();
        } else if (numero > 24 && numero <= 36) {
            estadisticas.incrementarTercera();
        }
    }

    public static int imprimirNumeroAleatorio() {
        // Imprimir el número aleatorio generado
        Random random = new Random();
        return random.nextInt(37);// 37 es exclusivo, por lo que el rango es 0-37
    }

    public static void estadisticas(String selecEst, Estadisticas estadisticas) {

        if (selecEst.equals("Cero")) {
            JOptionPane.showMessageDialog(null,
                    "La cantidad de veces que va saliendo el CERO es de: " + estadisticas.getContadorCero());
        } else if (selecEst.equals("Primera Docena")) {
            JOptionPane.showMessageDialog(null,
                    "La cantidad de veces que va saliendo la PRIMER DOCENA es de: "
                            + estadisticas.getContadorPrimera());
        } else if (selecEst.equals("Segunda Docena")) {
            JOptionPane.showMessageDialog(null,
                    "La cantidad de veces que va saliendo la SEGUNDA DOCENA es de: "
                            + estadisticas.getContadorSegunda());
        } else if (selecEst.equals("Tercera Docena")) {
            JOptionPane.showMessageDialog(null,
                    "La cantidad de veces que va saliendo la TERCERA DOCENA es de: "
                            + estadisticas.getContadorTercera());
        }

    }

    public static void mostrarEstadisticasFinales(Estadisticas estadisticas) {
        String docenaMasFrecuente;
        int maxOcurrencias = Math.max(Math.max(estadisticas.getContadorPrimera(), estadisticas.getContadorSegunda()),
                Math.max(estadisticas.getContadorTercera(), estadisticas.getContadorCero()));

        if (maxOcurrencias == estadisticas.getContadorPrimera()) {
            docenaMasFrecuente = "Primera Docena";
        } else if (maxOcurrencias == estadisticas.getContadorSegunda()) {
            docenaMasFrecuente = "Segunda Docena";
        } else if (maxOcurrencias == estadisticas.getContadorTercera()) {
            docenaMasFrecuente = "Tercera Docena";
        } else {
            docenaMasFrecuente = "Cero";
        }

        JOptionPane.showMessageDialog(null, "La docena con más ocurrencias es: " + docenaMasFrecuente +
                " con " + maxOcurrencias + " ocurrencias.");
    }

}

// Clase para almacenar las estadisticas
class Estadisticas {
    public int contadorPrimera = 0;
    public int contadorSegunda = 0;
    public int contadorTercera = 0;
    public int contadorCero = 0;

    public void incrementarPrimera() {
        contadorPrimera++;
    }

    public void incrementarSegunda() {
        contadorSegunda++;
    }

    public void incrementarTercera() {
        contadorTercera++;
    }

    public void incrementarCero() {
        contadorCero++;
    }

    public int getContadorPrimera() {
        return contadorPrimera;
    }

    public int getContadorSegunda() {
        return contadorSegunda;
    }

    public int getContadorTercera() {
        return contadorTercera;
    }

    public int getContadorCero() {
        return contadorCero;
    }
}