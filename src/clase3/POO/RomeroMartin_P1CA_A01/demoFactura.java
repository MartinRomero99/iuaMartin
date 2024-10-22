package clase3.POO.RomeroMartin_P1CA_A01;

public class demoFactura {
    public static void main(String[] args) {
        Factura factura1 = new Factura(1, "Enrique Fuentes", 50);
        factura1.calcularImpuesto();
        factura1.mostrarDetalles();
        factura1.mostrarCuentaFacturas();

        Factura factura2 = Factura.crearFactura();
        factura2.mostrarDetalles();
        factura2.mostrarCuentaFacturas();
        // getCuentaFacturas();
    }
}
