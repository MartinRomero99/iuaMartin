package clase2;

import javax.swing.JOptionPane;

public class actividadIntegradoraUno {

    public static void main(String[] args) {

        int res = JOptionPane.showConfirmDialog(null, "¿Desea comenzar con el cálculo del bono mensual?",
                "Empresa Gastronómica",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        try {
            while (res == JOptionPane.YES_OPTION) {
                int antiguedad = pedirAntiguedad();
                double sueldo = pedirSueldo();

                double bonoAntiguedad = calcularBonoAntiguedad(antiguedad, sueldo);
                double bonoSueldo = calcularBonoSueldo(sueldo);
                double antiguedadFinal = antiguedad * 500;
                if (antiguedadFinal > sueldo) {
                    JOptionPane.showMessageDialog(null,
                            "El bono que se calculo en base a su antiguedad es de " + bonoAntiguedad, null, res);
                } else if (antiguedadFinal < sueldo) {
                    JOptionPane.showMessageDialog(null,
                            "El bono que se calculo en base a su sueldo es de " + bonoSueldo, null, res);
                } else {
                    JOptionPane.showMessageDialog(null, "La antiguedad y el sueldo son similares");
                }

                res = JOptionPane.showConfirmDialog(null, "¿Desea calcular el bono de otro empleado?",
                        "Empresa Gastronómica",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            }
            if (res == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Hasta pronto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error, hasta pronto.");
        }
    }

    public static double pedirSueldo() {
        while (true) {
            String sueldoString = JOptionPane.showInputDialog(null, "Ingrese el sueldo: ");
            if (sueldoString != null) {
                try {
                    return Double.parseDouble(sueldoString);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Ingrese un valor numérico entero válido para el sueldo.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hasta pronto");
                System.exit(0);
            }
        }
    }

    public static int pedirAntiguedad() {
        while (true) {
            String antiguedadString = JOptionPane.showInputDialog(null,
                    "Ingrese la antigüedad en años y como un entero: ");
            if (antiguedadString != null) {
                try {
                    return Integer.parseInt(antiguedadString);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido para la antigüedad.");
                }
            }
        }
    }

    public static double calcularBonoAntiguedad(int antiguedad, double sueldo) {
        if (antiguedad >= 2 && antiguedad < 5) {
            return sueldo * 0.20;
        } else if (antiguedad >= 5) {
            return sueldo * 0.30;
        }
        return antiguedad * 500;
    }

    public static double calcularBonoSueldo(double sueldo) {
        if (sueldo <= 1000) {
            return sueldo * 0.25;
        } else if (sueldo > 1000 && sueldo <= 3500) {
            return sueldo * 0.15;
        } else {
            return sueldo * 0.10;
        }
    }
}