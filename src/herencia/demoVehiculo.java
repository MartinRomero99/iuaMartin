package herencia;

import javax.swing.JOptionPane;

import herencia.clases.Vehiculo;;

public class demoVehiculo {
    public static void main(String[] args) {
        // Vehiculo 1
        Vehiculo v1 = new Vehiculo();
        v1.cargarJOP("Vehiculo 1");
        v1.acelerar(80);
        v1.frenar(65);
        v1.mostrarVehiculo();
        mostrarMensajes(v1.mostrarVehiculo(), "Informe del vehiculo 1", 1);
        JOptionPane.showMessageDialog(null, "Cantidad de vehiculos: " + Vehiculo.getCantidadVehiculos());

        // Vehiculo 2
        Vehiculo v2 = new Vehiculo("bmw", "e30", "rojo", 12, 235);
        mostrarMensajes(v2.mostrarVehiculo(), "Informe del vehiculo 2", 1);
        v2.setColor("negro");
        JOptionPane.showMessageDialog(null, "Cantidad de vehiculos: " + Vehiculo.getCantidadVehiculos());

        // Vehiculo 3
        Vehiculo v3 = new Vehiculo();
        mostrarMensajes(v3.mostrarVehiculo(), "Informe del vehiculo 3", 1);
        JOptionPane.showMessageDialog(null, "Cantidad de vehiculos: " + Vehiculo.getCantidadVehiculos());
    }

    /*------------------------------------------------ */
    /* Metodo General de Mensajes del main */
    /*------------------------------------------------ */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }
}
