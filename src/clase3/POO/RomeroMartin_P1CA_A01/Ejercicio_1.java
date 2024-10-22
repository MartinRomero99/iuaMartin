package clase3.POO.RomeroMartin_P1CA_A01;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio_1 {
    public static void main(String[] args) {
        calcularTotal();
        calcularTotalScanner();

    }

    public static void calcularTotal() {
        double pagoTotal = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un numero"));
        double sumaParcialMensual = 0.0;
        double sumaFinal = 0.0;
        String mensaje = "";

        try {
            for (int meses = 1; meses <= 20; meses++) {
                if (meses == 1) {
                    sumaParcialMensual = pagoTotal;
                    sumaFinal += sumaParcialMensual;
                } else {
                    sumaParcialMensual = sumaParcialMensual * 2;
                    sumaFinal += sumaParcialMensual;
                }
                mensaje += "En el mes " + meses + " el pago es de: $" + sumaParcialMensual + "\n";
            }
            mensaje += "\nEl pago total es de: $" + sumaFinal;

            JOptionPane.showMessageDialog(null, mensaje, "Detalle de pagos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error", 0);
        }

    }

    public static void calcularTotalScanner() {
        System.out.println("Ingrese un numero");
        Scanner sc = new Scanner(System.in);
        double pagoTotal = sc.nextDouble();
        double sumaParcialMensual = 0.0;
        double sumaFinal = 0.0;
        try {
            for (int meses = 1; meses <= 20; meses++) {
                if (meses == 1) {
                    sumaParcialMensual = pagoTotal;
                    sumaFinal += sumaParcialMensual;
                    System.out.println("En el mes " + meses + " debe pagar " + sumaParcialMensual);
                } else {
                    sumaParcialMensual = sumaParcialMensual * 2;
                    sumaFinal += sumaParcialMensual;
                    System.out.println("En el mes " + meses + " debe pagar " + sumaParcialMensual);
                }
            }
            System.out.println("El pago total es de: " + sumaFinal);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }
        sc.close();
    }
}
