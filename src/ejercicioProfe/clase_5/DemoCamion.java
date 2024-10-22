package ejercicioProfe.clase_5;

import java.util.Scanner;
import javax.swing.JOptionPane;

import ejercicioProfe.clase_5.clases.Camion;

public class DemoCamion {

    public static void main(String[] args) {
        int seleccion = 0;
        double velocidad;

        mostrarMensajes("Hola....", "", 0);
        Scanner sc = new Scanner(System.in);
        Camion c1 = new Camion();
        // c1.cargar(sc);
        c1.cargarJOP();
        c1.mostrar();

        c1.acelerar(40);
        c1.frenar(30);

        mostrarMensajes(c1.mostrar(), "Datos Camión", 2);
        Double consumo = c1.calcularConsumoCombustible(300.00);
        JOptionPane.showMessageDialog(null, consumo, "Consumo de Combustible", 1);
        sc.close();

        /*--------------------------------------------------*/
        /* Ménu de Opciones para trabajar con Camiones */
        /*--------------------------------------------------*/
        String[] opciones = {
                "Mostrar Info Auto",
                "Acelerar",
                "Frenar",
                "Calcular Kilometros",
                "Salir"
        };
        do {
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (seleccion) {
                case 0:
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);
                    break;

                case 1:
                    velocidad = c1.ingresaDouble("Ingrese la Velocidad a Acelerar");
                    c1.acelerar(velocidad);
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);

                    break;

                case 2:
                    velocidad = c1.ingresaDouble("Ingrese la Velocidad a Frenar");
                    c1.frenar(velocidad);
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);
                    break;

                case 3:
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);
                    break;
            }

        } while (seleccion != 4);

    }

    /*------------------------------------------------ */
    /* Metodo General de Mensajes del main */
    /*------------------------------------------------ */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }
}
