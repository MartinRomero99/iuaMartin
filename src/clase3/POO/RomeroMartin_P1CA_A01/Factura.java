package clase3.POO.RomeroMartin_P1CA_A01;

import javax.swing.JOptionPane;

public class Factura {

    private int númeroFactura;
    private String cliente;
    private double total;
    private static int cuentaFacturas = 0;

    public Factura() {
    }

    public Factura(int númeroFactura, String cliente, double total) {
        this.númeroFactura = ++cuentaFacturas;
        this.cliente = cliente;
        this.total = total;
    }

    public int getNúmeroFactura() {
        return númeroFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    // public void setTotal(double total) {
    // this.total = total;
    // }

    public static int getCuentaFacturas() {
        return cuentaFacturas;
    }

    public static void setCuentaFacturas(int cuentaFacturas) {
        Factura.cuentaFacturas = cuentaFacturas;
    }

    // metodos
    public double calcularImpuesto() {
        double impuesto = total * 0.21;
        // JOptionPane.showMessageDialog(null, "El monto del impuesto es de: $" +
        // impuesto);
        return impuesto;
    }

    public static Factura crearFactura() {
        String cliente = null;
        double total = 0;
        try {
            cliente = JOptionPane.showInputDialog(null, "Introduce el Apellido y Nombre del cliente:");
            total = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca el total para pagar"));
            JOptionPane.showMessageDialog(null, "El numero de factura generado automáticamente es: " + cuentaFacturas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error", 0);
            return null;
        }
        return new Factura(cuentaFacturas, cliente, total);
    }

    public void mostrarDetalles() {
        double impuesto = calcularImpuesto();
        String mensaje = String.format(
                "Número de Factura: %d\nCliente: %s\nTotal: $%.2f\nImpuesto: $%.2f\nTotal con Impuesto: $%.2f",
                númeroFactura, cliente, total, impuesto, total + impuesto);
        JOptionPane.showMessageDialog(null, mensaje, "Detalles de la Factura", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarCuentaFacturas() {
        JOptionPane.showMessageDialog(null, "La cantidad de facturas creadas hasta el momento es de: " + cuentaFacturas,
                "Cantidad de facturas", 1);
    }
}
