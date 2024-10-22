package herencia;

import javax.swing.JOptionPane;
import herencia.clases.Auto;

public class demoAuto {
    public static void main(String[] args) {
        Auto a1 = new Auto();
        a1.cargarAutomovil("Auto 1");

        String[] opciones = {
                "Mostrar información",
                "Leer cantidad de puertas",
                "Modificar la cantidad de puertas",
                "Acelerar",
                "Frenar",
                "Calcular Kilometros",
                "Modificar la cantidad de Pasajeros",
                "Salir"
        };

        boolean salir = false;
        double velocidad;

        do {
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "Menú Principal",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
            } else {
                switch (seleccion) {
                    case "Mostrar información":
                        mostrarMensajes(a1.mostrar(), "Datos del auto", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Leer cantidad de puertas":
                        mostrarMensajes("El auto tiene " + a1.getCantidadPuertas() + " puertas",
                                "Puertas del auto", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Modificar la cantidad de puertas":
                        int cantidadModificada = Integer
                                .parseInt(JOptionPane.showInputDialog("Modifica la cantidad de puertas"));
                        if (cantidadModificada < 2) {
                            mostrarMensajes("La cantidad de puertas debe ser mayor o igual a 2", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            a1.setCantidadPuertas(cantidadModificada);
                        }
                        break;

                    case "Acelerar":
                        velocidad = a1.ingresaDouble("Ingrese la velocidad a acelerar");
                        a1.acelerar(velocidad);
                        mostrarMensajes(a1.mostrar(), "Datos del auto", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Frenar":
                        velocidad = a1.ingresaDouble("Ingrese la velocidad a frenar");
                        a1.frenar(velocidad);
                        mostrarMensajes(a1.mostrar(), "Datos del auto", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Calcular Kilometros":
                        mostrarMensajes("El consumo en litros es: " + a1.calcularConsumoCombustible(), "Consumo",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Modificar la cantidad de Pasajeros":
                        int cantidadPasajeros = a1.getCantidadPasajero();
                        int cantidadModificadaP = Integer
                                .parseInt(JOptionPane.showInputDialog("Modifica la cantidad de pasajeros"));
                        cantidadPasajeros += cantidadModificadaP;
                        if (cantidadPasajeros < 0) {
                            mostrarMensajes("La cantidad de pasajeros debe ser mayor o igual a 0", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            a1.setCantidadPasajero(cantidadPasajeros);
                        }
                        break;
                }
            }
        } while (!salir);
    }

    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }
}
