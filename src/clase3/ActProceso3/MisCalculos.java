package clase3.ActProceso3;

import javax.swing.JOptionPane;

import clase3.ActProceso3.clases.Calculos;

public class MisCalculos {

    public static void main(String[] args) {
        boolean salir = false;

        do {
            String num1 = JOptionPane.showInputDialog(null, "Ingrese el primer número");
            String num2 = JOptionPane.showInputDialog(null, "Ingrese el segundo número");

            if (num1 == null || num2 == null) {
                JOptionPane.showMessageDialog(null, "Error en la carga de datos", "Error", 0);
                return;
            }

            double numero1 = Double.parseDouble(num1);
            double numero2 = Double.parseDouble(num2);

            String[] opciones = { "Suma", "Resta", "Producto", "Cociente", "Potencia", "Salir" };
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una operación",
                    "Menú de Operaciones", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
            } else {
                Double resultado = 0.0;
                try {
                    switch (seleccion) {
                        case "Suma":
                            resultado = Calculos.suma(numero1, numero2);
                            break;
                        case "Resta":
                            resultado = Calculos.resta(numero1, numero2);
                            break;
                        case "Producto":
                            resultado = Calculos.producto(numero1, numero2);
                            break;
                        case "Cociente":
                            resultado = Calculos.cociente(numero1, numero2);
                            break;
                        case "Potencia":
                            resultado = Calculos.potencia(numero1, numero2);
                            break;
                    }
                    JOptionPane.showMessageDialog(null, "El resultado de la " + seleccion + " es: " + resultado);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } while (!salir);
    }
}
