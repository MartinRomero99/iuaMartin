package clase3.Matematica;

// Martín Romero
import javax.swing.JOptionPane;
import clase3.Matematica.clases.MisCalculos;

public class demoCalculos {

    public static void main(String[] args) {
        boolean salir = false;
        do {
            double numero1 = MisCalculos.ingresaNumero("Ingrese el primer número:");
            double numero2 = MisCalculos.ingresaNumero("Ingrese el segundo número:");
            try {
                double suma = MisCalculos.suma(numero1, numero2);
                double resta = MisCalculos.resta(numero1, numero2);
                double producto = MisCalculos.producto(numero1, numero2);
                double cociente = MisCalculos.cociente(numero1, numero2);
                double potencia = MisCalculos.potencia(numero1, numero2);

                String mensaje = "Resultados:\n"
                        + "Suma: " + suma + "\n"
                        + "Resta: " + resta + "\n"
                        + "Producto: " + producto + "\n"
                        + "Cociente: " + cociente + "\n"
                        + "Potencia: " + potencia;

                JOptionPane.showMessageDialog(null, mensaje, "Resultados", JOptionPane.INFORMATION_MESSAGE);
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            }

            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?", "Continuar",
                    JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                salir = true;
            }
        } while (!salir);
    }
}