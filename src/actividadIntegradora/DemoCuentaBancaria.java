package actividadIntegradora;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DemoCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("1234", TipoCuenta.CAJA_AHORRO);
        cuenta1.mostrarDatosCuenta();

        cuenta1.depositar(leerMontoJOP("Depositar"));
        cuenta1.retirar(leerMontoJOP("Retitar"));
        cuenta1.desactivarCuenta();
        cuenta1.mostrarDatosCuenta();

        CuentaBancaria cuenta2 = new CuentaBancaria();

        cuenta2.cargarCuenta();
        // cuenta2.mostrarDatosCuenta();
        cuenta2.depositar(leerMontoJOP("Depositar"));
        cuenta2.mostrarDatosCuenta();

        CuentaBancaria cuenta3 = new CuentaBancaria();
        cuenta3.cargarCuenta();
        cuenta3.retirar(leerMontoJOP("Depositar"));
        cuenta3.desactivarCuenta();

        List<CuentaBancaria> listaCuentas = new ArrayList<>();
        listaCuentas.add(cuenta1);
        listaCuentas.add(cuenta2);
        listaCuentas.add(cuenta3);

        CuentaBancaria.mostrarCuentaMayorSaldo(listaCuentas);
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
