package actividadIntegradora;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class CuentaBancaria {
    // atributos
    protected static int totalCuentas = 0;
    protected String titularCuenta;
    protected String numeroCuenta;
    protected double saldo;
    protected boolean estado;
    protected TipoCuenta tipoCuenta;

    // constructores
    public CuentaBancaria() {
        this.estado = true;
    }

    public CuentaBancaria(String titularCuenta, String numeroCuenta, double saldo, TipoCuenta tipoCuenta) {
        this.titularCuenta = titularCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        totalCuentas++;
    }

    public CuentaBancaria(String numeroCuenta, TipoCuenta tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0;
        this.estado = true;
        totalCuentas++;
    }

    // getters y setters
    // public static int getTotalCuentas() {
    // return totalCuentas; NO MODIFICAR
    // }

    @Override
    public String toString() {
        return "CuentaBancaria [titularCuenta=" + titularCuenta + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo
                + ", estado=" + estado + ", tipoCuenta=" + tipoCuenta + "]";
    }

    public static void setTotalCuentas(int totalCuentas) {
        CuentaBancaria.totalCuentas = totalCuentas;
    }

    public String getTitularCuenta() {
        return titularCuenta;
    }

    public void setTitularCuenta(String titularCuenta) {
        this.titularCuenta = titularCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    // public void setNumeroCuenta(String numeroCuenta) {
    // this.numeroCuenta = numeroCuenta;
    // }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    // metodos comunes
    public void depositar(double monto) {
        if (this.estado) {
            this.saldo += monto;
            mostrarDatosCuenta();
            ;
        } else {
            mostrarMensaje("La cuenta está inactiva.", "Error", 1);
        }
    }

    public void retirar(double monto) {
        if (this.estado && this.saldo >= monto) {
            this.saldo -= monto;
            mostrarMensaje("Extrajo el monto $ " + monto, "Operacion exitosa", 1);
        } else if (!this.estado) {
            mostrarMensaje("cuenta inactiva", "Error", 0);
        } else {
            mostrarMensaje("Saldo insuficiente", "Error", 0);
        }
    }

    public void desactivarCuenta() {
        if (this.estado && this.saldo == 0) {
            this.estado = false;
            mostrarMensaje("La cuenta ha sido desactivada exitosamente", "Operacion exitosa", 0);
        } else {
            if (!this.estado) {
                mostrarMensaje("La cuenta ya está desactivada", "Error", 0);
            } else {
                int resp = JOptionPane.showConfirmDialog(null,
                        "Su cuenta tiene dinero, ¿Desea desactivar su cuenta de todas formas?",
                        "Desactivación de cuenta",
                        JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    this.estado = false;
                    mostrarMensaje("Cuenta Desactivada \nTotal de cuentas " + totalCuentas, "Operación exitosa", 1);
                } else {
                    mostrarMensaje("Saliendo de la operación", "", 1);
                }
            }
        }
    }

    public void activarCuenta() {
        if (!this.estado && this.numeroCuenta.contains(numeroCuenta)) {
            try {
                int resp = JOptionPane.showConfirmDialog(null,
                        "Su cuenta está desactivada, ¿Desea activarla nuevamente?",
                        "Activación de cuenta",
                        JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    this.estado = true;
                    mostrarMensaje("Cuenta activada exitosamente \nTotal de cuentas " + totalCuentas,
                            "Operación exitosa", 1);
                    totalCuentas++;
                }
            } catch (Exception e) {
                mostrarMensaje("Se ha producido un error", "Error", 0);
            }
        }
    }

    public void cargarCuenta() {
        try {
            titularCuenta = JOptionPane.showInputDialog("Ingrese el nombre del titular:");
            Random random = new Random();
            int numeroAleatorio = random.nextInt(100);
            numeroCuenta = String.valueOf(numeroAleatorio);
            JOptionPane.showMessageDialog(null, "El numero de cuenta es: " + numeroCuenta, "Numero de cuenta",
                    JOptionPane.INFORMATION_MESSAGE);
            saldo = Double.parseDouble(
                    JOptionPane.showInputDialog("Ingrese el saldo inicial: \nIngrese un número entero o saldrá error"));
            String[] opciones = { "CAJA_AHORRO", "CUENTA_CORRIENTE", "CUENTA_SUELDO" };
            tipoCuenta = TipoCuenta.valueOf(JOptionPane.showInputDialog(null, "Seleccione el tipo de cuenta", "Cuenta",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]).toString());
            estado = true;
            mostrarMensaje("Cuenta creada exitosamente", "Operación exitosa", 1);
            // String datosNuevaCuenta = String.format(titularCuenta, numeroCuenta, saldo,
            // tipoCuenta);
            // mostrarMensaje(datosNuevaCuenta, "Resumen de la cuenta", 1);
            totalCuentas++;
            mostrarDatosCuenta();
        } catch (Exception e) {
            mostrarMensaje("Se ha producido un error", "Error", 0);
        }
    }

    public void mostrarDatosCuenta() {
        String datos = String.format(
                "El titular de la cuenta es %s \nEl número de la cuenta es %s \nEl saldo de la cuenta es %,.2f \nLa cuenta es de tipo %s \nLa cuenta está en estado %b \nLa cantidad de cuentas es de %d",
                titularCuenta, numeroCuenta, saldo, tipoCuenta, estado, totalCuentas);
        mostrarMensaje(datos, "Resumen de la cuenta", 1);
    }

    private void mostrarMensaje(String cMensaje, String cTitulo, int cNum) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, cNum);
    }

    public static CuentaBancaria buscarCuentaSaldo(List<CuentaBancaria> listaCuentas) {
        CuentaBancaria cuentaMayorSaldo = null;
        for (CuentaBancaria cuenta : listaCuentas) {
            if (cuentaMayorSaldo == null || cuenta.getSaldo() > cuentaMayorSaldo.getSaldo()) {
                cuentaMayorSaldo = cuenta;
            }
        }
        return cuentaMayorSaldo;
    }

    public static void mostrarCuentaMayorSaldo(List<CuentaBancaria> listaCuentas) {
        CuentaBancaria cuentaMayorSaldo = buscarCuentaSaldo(listaCuentas);
        if (cuentaMayorSaldo != null) {
            cuentaMayorSaldo.mostrarDatosCuenta();
            // JOptionPane.showMessageDialog(null,
            // "El titular de la cuenta con mayor saldo es: " +
            // cuentaMayorSaldo.getTitularCuenta() + " "
            // + cuentaMayorSaldo.getSaldo(),
            // "Mayor saldo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay autos en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
