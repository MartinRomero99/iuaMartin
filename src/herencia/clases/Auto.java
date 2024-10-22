package herencia.clases;

import javax.swing.JOptionPane;

public class Auto extends Vehiculo {
    private int cantidadPasajero;
    private int cantidadPuertas;
    private String tipoCombustible;

    public Auto(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima,
            int cantidadPasajero, int cantidadPuertas, String tipoCombustible) {
        super(marca, modelo, color, consumoCombustible, velocidadMaxima);
        this.cantidadPasajero = cantidadPasajero;
        this.cantidadPuertas = cantidadPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public Auto() {
        super();
        this.cantidadPasajero = 0;
        this.cantidadPuertas = 4;
        this.tipoCombustible = "";
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public void setCantidadPasajero(int cantidadPasajero) {
        this.cantidadPasajero = cantidadPasajero;
    }

    public int getCantidadPasajero() {
        return cantidadPasajero;
    }

    public void cargarAutomovil(String nameObjeto) {
        super.cargarJOP(nameObjeto);
        try {
            String inputCantPasajeros = JOptionPane.showInputDialog("Ingrese la cantidad de pasajeros:");
            this.cantidadPasajero = Integer.parseInt(inputCantPasajeros);
            String inputCantPuertas = JOptionPane.showInputDialog("Ingrese la cantidad de puertas:");
            this.cantidadPuertas = Integer.parseInt(inputCantPuertas);
        } catch (NumberFormatException e) {
            mostrarMensajes("Por favor ingresa un número válido.", "Error", 0);
            this.cantidadPasajero = 0;
            this.cantidadPuertas = 4;
        }
        this.tipoCombustible = JOptionPane.showInputDialog("Ingrese el tipo de combustible: ");
    }

    public String mostrar() {
        String mensaje = super.mostrarVehiculo() + String.format("\nCantidad de pasajeros: %d \n" +
                "Cantidad de puertas: %d \n" +
                "Tipo de combustible: %s\n",
                this.cantidadPasajero,
                this.cantidadPuertas,
                this.tipoCombustible);
        return mensaje;
    }

    public double ingresaDouble(String cMensaje) {
        return super.ingresaDouble(cMensaje);
    }
}
