package ejercicioProfe.clase_5.clases;

import java.util.Scanner;

public class Camion extends Vehiculo {
    private double tara;
    private double pesoCarga;
    private String numeroEjes;

    public Camion(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima,
            double tara, double pesoCarga, String numeroEjes) {

        super(marca, modelo, color, consumoCombustible, velocidadMaxima); // reutiliza el constructor padre
        this.tara = tara;
        this.pesoCarga = pesoCarga;
        this.numeroEjes = numeroEjes;
    }

    public Camion() {
        super();
        this.tara = 0;
        this.pesoCarga = 0;
        this.numeroEjes = "2";
    }

    /*------------------------------------------------*/
    /* Carga los datos del Camión */
    /*------------------------------------------------*/
    public void cargar(Scanner sc) {
        super.cargar(sc); // reutiliza el metodo padre
        System.out.print("Cargue tara (Kg): ");
        this.tara = super.cargarDouble(sc);
        System.out.print("Cargue peso (Kg): ");
        this.pesoCarga = super.cargarDouble(sc);
        System.out.print("Cargue número de ejes: ");
        this.numeroEjes = sc.nextLine();
    }

    /*---------------------------------*/
    /* Cargar Vehiculo con JOptionPane */
    /*---------------------------------*/
    public void cargarJOP() {
        super.cargarJOP();
        this.tara = super.ingresaDouble("Ingrese la Tara del camión");
        this.pesoCarga = super.ingresaDouble("Ingrese la Carga del camión");
        this.numeroEjes = ingresaString("Ingrese el Número de Ejes del vehículo: ");
    }

    public double ingresaDouble(String cMensaje) {
        return super.ingresaDouble(cMensaje);
    }

    /*
     * public void mostrar() {
     * String mensaje = String.format("Marca : %s \n" +
     * "Modelo: %s  \n" +
     * "Color: %s \n" +
     * "Velocidad Maxima: %.2f \n" +
     * "Consumo Combustible: %.2f \n" +
     * "Tara: %f \n" +
     * "Peso: %s  \n" +
     * "Número de ejes: %s \n \n Velocidad Actual: %.2f", super.getMarca(),
     * super.getModelo(), super.getColor(),
     * super.getVelocidadMaxima(),
     * super.getConsumoCombustible(), this.tara, this.pesoCarga, this.numeroEjes,
     * super.getVelocidadActual());
     * 
     * JOptionPane.showMessageDialog(null, mensaje, "Mostrando datos",
     * JOptionPane.INFORMATION_MESSAGE);
     * }
     */

    /*------------------------------------------------*/
    /* Muestra los datos del Camión */
    /*------------------------------------------------*/
    public String mostrar() {
        String mensaje = super.mostrarVehiculo() + String.format("\nNumero de Ejes: %s \n" +
                "Tara: %.2f Kg\n" +
                "Peso Carga: %.2f Kg\n",
                this.numeroEjes,
                this.tara,
                this.pesoCarga);
        return mensaje;
    }
}
