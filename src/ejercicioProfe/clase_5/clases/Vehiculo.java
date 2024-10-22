package ejercicioProfe.clase_5.clases;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String color;
    private double consumoCombustible;
    private double velocidadMaxima;
    private double velocidadActual;
    private static int cantVehiculos = 0;

    /*--------------------------------*/
    /* CONSTRUCTOR SIN ARGUMENTOS */
    /*--------------------------------*/
    public Vehiculo() {
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.consumoCombustible = 0;
        this.velocidadMaxima = 0;
        this.velocidadActual = 0;
        Vehiculo.cantVehiculos++;
    }

    /*--------------------------------*/
    /* CONSTRUCTOR CON ARGUMENTOS */
    /*--------------------------------*/
    public Vehiculo(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.consumoCombustible = consumoCombustible;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
        Vehiculo.cantVehiculos++;
    }

    /*--------------------------------*/
    /* GETTERS */
    /*--------------------------------*/

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public double getConsumoCombustible() {
        return consumoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public static int getCantidadVehiculos() {
        return cantVehiculos;
    }

    /*--------------------------------*/
    /* SETTERS */
    /*--------------------------------*/
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConsumoCombustible(double consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    /*--------------------------------*/
    /* OTROS METODOS */
    /*--------------------------------*/
    /* Cargar Vehivulo con Scanner */
    /*--------------------------------*/
    public void cargar(Scanner sc) {
        System.out.print("Ingrese la marca del vehículo: ");
        this.marca = sc.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        this.modelo = sc.nextLine();
        System.out.print("Ingrese el color del vehículo: ");
        this.color = sc.nextLine();
        System.out.print("Ingrese la velocidad maxima del vehículo: ");
        this.velocidadMaxima = cargarDouble(sc);
        System.out.print("Ingrese el consumo combustible del vehículo cada 100km: ");
        this.consumoCombustible = cargarDouble(sc);
    }

    /*---------------------------------*/
    /* Cargar Vehiculo con JOptionPane */
    /*---------------------------------*/
    public void cargarJOP() {
        this.marca = ingresaString("Ingrese la marca del vehículo");
        this.modelo = ingresaString("Ingrese el modelo del vehículo");
        this.color = ingresaString("Ingrese el color del vehículo: ");
        this.velocidadMaxima = ingresaDouble("Ingrese la velocidad maxima del vehículo: ");
        this.consumoCombustible = ingresaDouble("Ingrese el consumo combustible en litros del vehículo cada 100km");
    }

    /*
     * public void mostrarVehiculo() {
     * String mensaje = String.format("Marca : %s \n" +
     * "Modelo: %s  \n" +
     * "Color: %s \n" +
     * "Velocidad Maxima: %.2f \n" +
     * "Consumo Combustible: %.2f \n Velocidad actual: %.2f", this.marca,
     * this.modelo, this.color,
     * this.velocidadMaxima,
     * this.consumoCombustible, this.velocidadActual);
     * 
     * JOptionPane.showMessageDialog(null, mensaje, "Mostrando datos", 1);
     * }
     */

    /*--------------------------------*/
    /* Mostrar Vehículo */
    /*--------------------------------*/
    public String mostrarVehiculo() {
        String mensaje = String.format("Marca : %s \n" +
                "Modelo: %s  \n" +
                "Color: %s \n" +
                "Velocidad Maxima: %.2f km/h \n" +
                "Consumo Combustible: %.2f l/100Km  \n" +
                "Velocidad actual: %.2f Km/h",
                this.marca,
                this.modelo,
                this.color,
                this.velocidadMaxima,
                this.consumoCombustible,
                this.velocidadActual);
        return mensaje;
    }

    /*--------------------------------*/
    /* CARGAR DOUBLE - Scanner */
    /*--------------------------------*/
    protected double cargarDouble(Scanner scan) {
        double dato = 0;
        boolean error = false;
        do {
            error = false;
            try {
                dato = Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                error = true;
                System.out.println("Debe ingresar un valor numerico");
            }
        } while (error);
        return dato;
    }

    /*------------------------------------------------ */
    /* Frenar el Vehiculo */
    /*------------------------------------------------ */
    public void frenar(double frenado) {
        double velocFinal;
        if (frenado <= 0) {
            mostrarMensajes("Debe ingresar un nivel de frenado positivo.", "Error", 2);
        } else {
            velocFinal = this.velocidadActual - frenado;

            if (velocFinal < 0) {
                mostrarMensajes("No puede tener velocidad negativa", "Error", 0);

            } else {
                this.velocidadActual = velocFinal;
                mostrarMensajes("Frenado exitoso!", "Detalle", 1);
                if (velocFinal == 0)
                    mostrarMensajes("El vehículo se detuvo", "Detalle", 1);
            }
        }
    }

    /*------------------------------------------------ */
    /* Acelera el Vehiculo */
    /*------------------------------------------------ */
    public void acelerar(double aceleracion) {
        double velocFinal;
        if (aceleracion <= 0) {
            mostrarMensajes("Debe ingresar una aceleracion positiva.", "Error", 2);
        } else {
            velocFinal = this.velocidadActual + aceleracion;

            if (velocFinal > velocidadMaxima) {
                mostrarMensajes("La velocidad supera el limite de: " + this.velocidadMaxima, "Error", 0);

            } else {
                this.velocidadActual = velocFinal;
                mostrarMensajes("Aceleracion exitosa!", "Detalle", 1);
            }
        }
    }

    /*-------------------------------------- */
    /* Método para ingresar Valores Double */
    /*-------------------------------------- */
    protected double ingresaDouble(String cMensaje) {
        boolean error = false;
        int valor = 0;
        do {
            try {
                error = false;
                valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                        cMensaje,
                        "Actividad 2",
                        JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                mostrarMensajes("Debe Ingresar un Double", "Error!!!", 0);
                error = true;
            }
        } while (error);
        return valor;
    }

    /*-------------------------------------- */
    /* Método para ingresar Valores String */
    /*-------------------------------------- */
    protected String ingresaString(String cMensaje) {
        return JOptionPane.showInputDialog(null,
                cMensaje,
                "Datos del Camión",
                JOptionPane.QUESTION_MESSAGE);
    }

    /*------------------------------------------------ */
    /* Metodo General de Mensajes de la clase */
    /*------------------------------------------------ */
    private void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }

    /*------------------------------------------------ */
    /* Metodo de combustible */
    /*------------------------------------------------ */
    public Double calcularConsumoCombustible(Double distancia) {
        Double distanciaKm = Double
                .parseDouble(JOptionPane.showInputDialog("Ingrese la distancia a recorrer (En km): "));

        return (distanciaKm * this.consumoCombustible) / 100;
    }
}
