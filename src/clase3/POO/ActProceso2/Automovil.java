package clase3.POO.ActProceso2;

import java.util.List;
import javax.swing.JOptionPane;

// Romero Martín Alejandro

public class Automovil {

    // ATRIBUTOS
    private String marca;
    private String modelo;
    private double precio;
    private static int cantidadAutos = 0;
    private boolean importado;
    private double velocidadMaxima;
    private TipoCombustible tipoCombustible;
    private double velocidadActual = 0.0;

    // constructor 1
    public Automovil() {
        this.marca = "sin marca";
        this.modelo = "sin modelo";
        this.tipoCombustible = TipoCombustible.DIESEL;
        cantidadAutos++;
    }

    // constructor 2
    public Automovil(String marca, String modelo, TipoCombustible tipoCombustible, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.velocidadMaxima = velocidadMaxima;
        cantidadAutos++;
    }

    // constructor 3
    public Automovil(String marca, String modelo, TipoCombustible tipoCombustible, double velocidadMaxima,
            double precio, boolean importado) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.velocidadMaxima = velocidadMaxima;
        if (this.precio < 500000) {
            this.precio = precio;
        } else if (this.precio >= 500000) {
            JOptionPane.showMessageDialog(null, "El precio no puede superar los $500,000. Inténtelo de nuevo.");
        }
        this.importado = importado;
        cantidadAutos++;
    }

    // metodos getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static int getCantidadAutos() {
        return cantidadAutos;

    }

    // public static void setCantidadAutos(int cantidadAutos) {
    // Automovil.cantidadAutos = cantidadAutos;
    // }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    // metodos
    public void cargarAutos() {
        try {
            this.marca = JOptionPane.showInputDialog(null, "ingrese la marca del auto", "marca", 1);
            this.modelo = JOptionPane.showInputDialog(null, "ingrese el modelo del auto", "modelo", 1);

            String[] opciones = { "GASOLINA", "DIESEL", "ELECTRICO" };
            this.tipoCombustible = TipoCombustible.valueOf(
                    JOptionPane.showInputDialog(null, "Seleccione el tipo de combustible", "Combustible",
                            JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]).toString());

            do {
                this.precio = Double
                        .parseDouble(JOptionPane.showInputDialog(null, "ingrese el precio del auto", "precio", 1));
                if (this.precio >= 500000) {
                    JOptionPane.showMessageDialog(null, "El precio no puede superar los $500,000. Inténtelo de nuevo.");
                }
            } while (this.precio > 500000);

            int respuestaImportado = JOptionPane.showConfirmDialog(null, "¿Es el auto importado?", "Importado",
                    JOptionPane.YES_NO_OPTION);
            this.importado = (respuestaImportado == JOptionPane.YES_OPTION);
            this.velocidadMaxima = Double.parseDouble(
                    JOptionPane.showInputDialog(null, "ingrese la velocidad máxima del auto", "velocidad máxima", 1));

            imprimirDetalles();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el auto", "error", 0);
        }
    }

    public void acelerar() {
        try {
            double siAcelera = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Ingrese cuanto hasta cuanto quiere acelerar \nVelocidad actual= " + velocidadActual
                            + "\nVelocidad máxima= " + velocidadMaxima));
            if (velocidadActual + siAcelera <= velocidadMaxima) {
                velocidadActual += siAcelera;
            } else {
                JOptionPane.showMessageDialog(null,
                        "No puedes superar la velocidad máxima de " + velocidadMaxima);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void frenar() {
        try {
            double siFrena = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Ingrese cuanto hasta cuanto quiere acelerar \nVelocidad actual= " + velocidadActual
                            + "\nVelocidad máxima= " + velocidadMaxima));
            if (velocidadActual - siFrena >= 0) {
                velocidadActual -= siFrena;
            } else {
                velocidadActual = 0;
                JOptionPane.showMessageDialog(null, "El automóvil está completamente detenido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarMensaje(String cMensaje, String cTitulo, int cNum) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, cNum);
    }

    public void imprimirDetalles() {
        String datos = String.format(
                "La marca es: %s \nEl modelo es %s \nEl tipo de combustible es %s \nEl precio es %.2f \nLa velocidad máxima alcanzada es de: %.2f \nEs auto es importado %b",
                marca, modelo, tipoCombustible, precio, velocidadMaxima, importado);

        mostrarMensaje(datos, "Detalles del automovil", 1);
        JOptionPane.showMessageDialog(null, "la cantidad de autos hasta el momento es de: " + cantidadAutos);
    }

    public void manejar() {
        String[] opciones = { "acelerar", "frenar", "imprimir detalles", "salir" };
        int menuDesplegar;
        do {
            menuDesplegar = JOptionPane.showOptionDialog(null,
                    "Seleccione qué desea hacer \nVelocidad actual:" + velocidadActual,
                    "Manejar", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (menuDesplegar) {
                case 0:
                    acelerar();
                    break;
                case 1:
                    frenar();
                    break;
                case 2:
                    imprimirDetalles();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error: entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (menuDesplegar != 3);
    }

    public static Automovil buscarAutoMasCaro(List<Automovil> listaAutos) {
        Automovil autoMasCaro = null;
        for (Automovil auto : listaAutos) {
            if (autoMasCaro == null || auto.getPrecio() > autoMasCaro.getPrecio()) {
                autoMasCaro = auto;
            }
        }
        return autoMasCaro;
    }

    public static void mostrarAutoMasCaro(List<Automovil> listaAutos) {
        Automovil autoMasCaro = buscarAutoMasCaro(listaAutos);
        if (autoMasCaro != null) {
            JOptionPane.showMessageDialog(null,
                    "El auto más caro es: " + autoMasCaro.getMarca() + " " + autoMasCaro.getModelo(),
                    "El más caro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay autos en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
