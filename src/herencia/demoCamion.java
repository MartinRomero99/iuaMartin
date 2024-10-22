package herencia;

import javax.swing.JOptionPane;
import herencia.clases.Camion;

public class demoCamion {

    public static void main(String[] args) {
        int seleccion = 0;
        double velocidad;

        // mostrarMensajes("Hola!", "Bienvenido", 1);
        Camion c1 = new Camion();
        c1.cargarCamionJOP("Camion");
        mostrarMensajes(c1.mostrar(), "Datos del camión", 2);
        // c1.acelerar(40);
        // c1.frenar(30);
        // mostrarMensajes(c1.mostrar(), "Datos del camión", 2);

        /*--------------------------------------------------*/
        /* Ménu de Opciones para trabajar con Camiones */
        /*--------------------------------------------------*/
        String[] opciones = {
                "Mostrar información",
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
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);
                    break;
                case 1:
                    velocidad = c1.ingresaDouble("Ingrese la Velocidad a Acelerar");
                    c1.acelerar(velocidad);
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);
                    break;
                case 2:
                    velocidad = c1.ingresaDouble("Ingrese la Velocidad a Frenar");
                    c1.frenar(velocidad);
                    mostrarMensajes(c1.mostrar(), "Datos del Camión", 2);
                    break;
                case 3:
                    mostrarMensajes("El consumo en litros es: " + c1.calcularConsumoCombustible(), "Datos", 1);
                    break;
            }
        } while (seleccion != 4);
    }

    /*------------------------------------------------ */
    /* Metodo General de Mensajes del main */
    /*------------------------------------------------ */
    public static void mostrarMensajes(String cMensaje, String cTitulo, int nIcono) {
        JOptionPane.showMessageDialog(null, cMensaje, cTitulo, nIcono);
    }
}
