package herencia.clases;

import javax.swing.JOptionPane;

public class Colectivo extends Vehiculo {
    private int cantidadPasajeros;
    private TipoColectivo tipoColectivo;

    public Colectivo() {
        super();
        this.cantidadPasajeros = 0;
        this.tipoColectivo = TipoColectivo.corta;
    }

    public Colectivo(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima,
            int cantidadPasajeros, TipoColectivo tipoColectivo) {
        super(marca, modelo, color, consumoCombustible, velocidadMaxima);
        this.cantidadPasajeros = cantidadPasajeros;
        this.tipoColectivo = tipoColectivo;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    /*---------------------------------*/
    /* Cargar Vehiculo con JOptionPane */
    /*---------------------------------*/
    public void cargarColectivoJOP(String nameObjeto) {
        super.cargarJOP(nameObjeto);
        String inputCantPasajeros = JOptionPane.showInputDialog("Ingrese la cantidad de pasajeros: ");
        this.cantidadPasajeros = super.ingresaInt(inputCantPasajeros);

        TipoColectivo[] opcionesColectivo = TipoColectivo.values();
        // 'values()' es correcto solo si TipoCombustible es un enum
        this.tipoColectivo = (TipoColectivo) JOptionPane.showInputDialog(null,
                "Seleccione el tipo de colectivo", "Tipo de Colectivo",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesColectivo, opcionesColectivo[0]);
    }

    public String mostrar() {
        String mensaje = super.mostrarVehiculo() + String.format("\nCantidad de pasajeros: %d \n" +
                "Tipo de colectivo: %s \n", this.cantidadPasajeros, this.tipoColectivo);
        return mensaje;
    }

    public double ingresaDouble(String cMensaje) {
        return super.ingresaDouble(cMensaje);
    }
}
