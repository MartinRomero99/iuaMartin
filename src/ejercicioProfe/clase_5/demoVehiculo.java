package ejercicioProfe.clase_5;

import javax.swing.JOptionPane;
import java.util.Scanner;
import ejercicioProfe.clase_5.clases.Vehiculo;
//import javax.swing.JFrame;

public class demoVehiculo {

    public static void main(String[] args) {
        mostrarMensajes("Hola....", "", 0);

        Scanner sc = new Scanner(System.in);
        Vehiculo v1 = new Vehiculo();
        // v1.cargar(sc);
        v1.cargarJOP();
        v1.mostrarVehiculo();

        mostrarMensajes("Cantidad de vehiculos: " + Vehiculo.getCantidadVehiculos(), "Mensaje", 1);
        JOptionPane.showMessageDialog(null, "Cantidad de vehiculos: " +
                Vehiculo.getCantidadVehiculos(), "Mensaje", 1);

        v1.acelerar(50);
        mostrarMensajes(v1.mostrarVehiculo(), "Informe del Vehículo", 2);

        v1.acelerar(80);
        // v1.mostrarVehiculo();

        // v1.frenar(90);
        // v1.frenar(40);
        // v1.mostrarVehiculo();

        sc.close();

    }

    /*------------------------------------------------ */
    /* Metodo General de Mensajes del main */
    /*------------------------------------------------ */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
        // JOptionPane.showMessageDialog(frameParam, cMensaje, cTitulo, nIcono);
    }
}
