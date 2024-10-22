package ejercicioProfe.POO_CB;

import javax.swing.JOptionPane;

public class DemoCuentaBancaria {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cb1 = new CuentaBancaria("Juan Ignacio", "Cuenta1", TipoCuentas.CAJA_AHORRO);
        System.out.println(cb1.toString());
        cb1.mostrarDatosCuenta();

        cb1.depositar(leerMontoJOP("Depositar"));
        cb1.mostrarDatosCuenta();

        cb1.retirar(leerMontoJOP("Retirar"));
        cb1.mostrarDatosCuenta();

        CuentaBancaria cb2 = new CuentaBancaria("Juan", "Cuenta2", TipoCuentas.CAJA_AHORRO);
        cb2.depositar(leerMontoJOP("Depositar"));
        cb2.mostrarDatosCuenta();

        cb2.desactivarCuenta();
        cb2.mostrarDatosCuenta();
        /*-------------------------------------------------------- */

        if (cb1.getSaldo() > cb2.getSaldo()) {
            System.out.println("La cuenta n° " + cb1.getNumeroCuenta() + " tiene mas fondos " + "que la cuenta n°"
                    + cb2.getNumeroCuenta());
        } else {
            System.out.println("La cuenta n° " + cb2.getNumeroCuenta() + " tiene mas fondos " + "que la cuenta n°"
                    + cb1.getNumeroCuenta());
        }

        System.out.println("cuentas Creadas: " + CuentaBancaria.getTotalCuentas());
    }

    /*-----------------------------------------------------*/
    /* INGRESAR MONTOS A CUENTA */
    /*-----------------------------------------------------*/
    public static double leerMontoJOP(String mensaje) {
        boolean repetir;
        double valor = 0;
        do {
            repetir = false;
            try {
                valor = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a " + mensaje + " $:"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un valor Double ", "Error!!!", 0);
                repetir = true;
            }
        } while (repetir);
        return valor;
    }
}
