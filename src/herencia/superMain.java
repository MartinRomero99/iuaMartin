package herencia;

// Romero Martín Alejandro
import javax.swing.JOptionPane;
import herencia.clases.Vehiculo;

public class superMain {
    public static void main(String[] args) {
        String[] opciones = { "Crear Auto", "Crear Camión", "Crear Colectivo", "Crear Vehiculo",
                "Mostrar cantidad de vehículos",
                "Salir" };
        boolean salir = false;

        do {
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                    "Gestión de Vehículos", JOptionPane.QUESTION_MESSAGE,
                    null, opciones, opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
            } else {
                switch (seleccion) {
                    case "Crear Auto":
                        demoAuto.main(args);
                        break;
                    case "Crear Camión":
                        demoCamion.main(args);
                        break;

                    case "Crear Colectivo":
                        demoColectivo.main(args);
                        break;
                    case "Crear Vehiculo":
                        demoVehiculo.main(args);
                        break;
                    case "Mostrar cantidad de vehículos":
                        JOptionPane.showMessageDialog(null,
                                "Cantidad de vehículos: " + Vehiculo.getCantidadVehiculos());
                        break;
                }
            }
        } while (!salir);
    }
}