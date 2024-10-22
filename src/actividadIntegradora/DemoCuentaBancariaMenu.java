package actividadIntegradora;

import javax.swing.JOptionPane;

public class DemoCuentaBancariaMenu {

    private static CuentaBancaria cuenta = null;

    public static void main(String[] args) {
        cuenta = new CuentaBancaria();
        String[] opciones = { "depositar", "retirar", "desactivarCuenta", "activarCuenta", "cargarCuenta",
                "mostrarDatosCuenta", "Salir" };
        int menuDesplegar;
        do {
            menuDesplegar = JOptionPane.showOptionDialog(null,
                    "Seleccione qué desea hacer", "Menú Cuenta Bancaria",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (menuDesplegar) {
                case 0:
                    double montoDepositar = leerMontoJOP("Depositar");
                    cuenta.depositar(montoDepositar);
                    break;
                case 1:
                    double montoRetirar = leerMontoJOP("Retirar");
                    cuenta.retirar(montoRetirar);
                    break;
                case 2:
                    cuenta.desactivarCuenta();
                    break;
                case 3:
                    cuenta.activarCuenta();

                case 4:
                    cuenta.cargarCuenta();
                    break;
                case 5:
                    cuenta.mostrarDatosCuenta();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error inesperado, saliendo del menú.");
                    break;
            }
        } while (menuDesplegar != 6);
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
                JOptionPane.showMessageDialog(null, "Debe Ingresar un valor numérico", "Error!!!", 0);
                repetir = true;
            }
        } while (repetir);
        return valor;
    }
}
