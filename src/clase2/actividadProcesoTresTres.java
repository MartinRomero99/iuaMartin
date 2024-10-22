package clase2;

import javax.swing.JOptionPane;

public class actividadProcesoTresTres {
    public static void main(String[] args) {

        String numero = JOptionPane.showInputDialog("Introduce un número en metros:");
        if (numero != null && !numero.isEmpty()) {
            try {
                double metros = Double.parseDouble(numero);

                String[] optionsToChoose = {
                        "Mostrar valor en metros",
                        "Convertir a Kilómetros (Km)",
                        "Convertir a centímetros (cm)",
                        "Convertir a milímetros (mm)",
                        "Salir"
                };

                String opcionSeleccionada = (String) JOptionPane.showInputDialog(null,
                        "Seleccione una opción:", "Convertidor de unidades",
                        JOptionPane.QUESTION_MESSAGE, null,
                        optionsToChoose, optionsToChoose[0]);

                switch (opcionSeleccionada) {
                    case "Mostrar valor en metros":
                        JOptionPane.showMessageDialog(null, "Valor en metros: " + metros);
                        break;

                    case "Convertir a Kilómetros (Km)":
                        double km = metros / 1000;
                        JOptionPane.showMessageDialog(null, metros + " metros son " + km + " kilómetros.");
                        break;

                    case "Convertir a centímetros (cm)":
                        double cm = metros * 100;
                        JOptionPane.showMessageDialog(null, metros + " metros son " + cm + " centímetros.");
                        break;

                    case "Convertir a milímetros (mm)":
                        double mm = metros * 1000;
                        JOptionPane.showMessageDialog(null, metros + " metros son " + mm + " milímetros.");
                        break;

                    case "Salir":
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, ingrese un valor numérico válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor para continuar");
        }
    }

}
