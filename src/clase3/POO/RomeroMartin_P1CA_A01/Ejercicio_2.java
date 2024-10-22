package clase3.POO.RomeroMartin_P1CA_A01;

import javax.swing.JOptionPane;

public class Ejercicio_2 {
    public static void main(String[] args) {
        int n = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de artículos que desea comprar: "));
        procesoFor(n);

    }

    public static void procesoFor(int n) {
        double precio;
        double descuento;
        double precioConDescuento;
        double totalDescuento = 0;
        double totalPagar = 0;
        for (int i = 1; i <= n; i++) {
            try {
                precio = Double
                        .parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del artículo " + i + ": "));
                if (precio >= 2000) {
                    descuento = 0.15;
                } else if (precio > 1000 && precio < 2000) {
                    descuento = 0.12;
                } else {
                    descuento = 0.10;
                }
                precioConDescuento = precio - (precio * descuento);
                totalDescuento += (precio * descuento);
                totalPagar += precioConDescuento;

                JOptionPane.showMessageDialog(null, "Articulo " + i +
                        "\nPrecio original: $" + precio +
                        "\nDescuento aplicado: $" + (precio * descuento) +
                        "\nPrecio con descuento: $" + precioConDescuento);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar datos", "Error", 0);
            }

        }
        JOptionPane.showMessageDialog(null, "Total descuento aplicado: $" + String.format("%.2f", totalDescuento) +
                "\nTotal a pagar por todos los artículos: $" + String.format("%.2f", totalPagar));
    }
}
