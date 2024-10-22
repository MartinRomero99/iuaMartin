package herencia;

import javax.swing.JOptionPane;
import herencia.clases.Colectivo;

public class demoColectivo {

    public static void main(String[] args) {
        int seleccion = 0;
        double velocidad;
        Colectivo colectivo1 = new Colectivo();
        colectivo1.cargarColectivoJOP("Colectivo");

        /*--------------------------------------------------*/
        /* Ménu de Opciones para trabajar con Camiones */
        /*--------------------------------------------------*/
        String[] opciones = {
                "Mostrar información",
                "Leer cantidad de pasajeros",
                "Modificar la cantidad de Pasajeros",
                "Acelerar",
                "Frenar",
                "Calcular Kilometros",
                "Salir"
        };
        do {
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (seleccion) {
                case 0:
                    mostrarMensajes(colectivo1.mostrar(), "Datos del colectivo", 2);
                    break;
                case 1:
                    mostrarMensajes("El colectivo tiene " + colectivo1.getCantidadPasajeros() + " pasajeros",
                            "Pasajeros del colectivo", 2);
                    break;
                case 2:
                    int cantidadPasajeros = 0;
                    cantidadPasajeros = colectivo1.getCantidadPasajeros();
                    int cantidadModificada = Integer
                            .parseInt(JOptionPane.showInputDialog("Modifica la cantidad de pasajeros"));
                    cantidadPasajeros += cantidadModificada;
                    if (cantidadPasajeros < 0) {
                        mostrarMensajes("La cantidad de pasajeros debe ser mayor o igual a 0", "Error", 0);
                    } else {
                        colectivo1.setCantidadPasajeros(cantidadPasajeros);
                    }
                    break;
                case 3:
                    velocidad = colectivo1.ingresaDouble("Ingrese la Velocidad a Acelerar");
                    colectivo1.acelerar(velocidad);
                    mostrarMensajes(colectivo1.mostrar(), "Datos del colectivo", 2);
                    break;
                case 4:
                    velocidad = colectivo1.ingresaDouble("Ingrese la Velocidad a Frenar");
                    colectivo1.frenar(velocidad);
                    mostrarMensajes(colectivo1.mostrar(), "Datos del colectivo", 2);
                    break;
                case 5:
                    mostrarMensajes("El consumo en litros es: " + colectivo1.calcularConsumoCombustible(), "Datos", 1);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (seleccion != 7);
    }

    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }

}