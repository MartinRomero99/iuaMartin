package herencia.clases;

public class Camion extends Vehiculo {
    private double tara;
    private double pesoCarga;
    private String numeroEjes;

    public Camion(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima,
            double tara, double pesoCarga, String numeroEjes) {
        super(marca, modelo, color, consumoCombustible, velocidadMaxima);
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

    /*---------------------------------*/
    /* Cargar Vehiculo con JOptionPane */
    /*---------------------------------*/
    public void cargarCamionJOP(String nameObjeto) {
        super.cargarJOP(nameObjeto);
        this.tara = super.ingresaDouble("Ingrese la tara del camión:");
        this.pesoCarga = super.ingresaDouble("Ingrese la carga del camión:");
        this.numeroEjes = ingresaString("Ingrese el número de ejes del camion: ");
    }

    public double ingresaDouble(String cMensaje) {
        return super.ingresaDouble(cMensaje);
    }

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
