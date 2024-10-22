package clase3.ActProceso3.clases;

public class Calculos {

    public static Double resta(Double numero1, Double numero2) {
        return numero1 - numero2;
    }

    public static Double suma(Double numero1, Double numero2) {
        return numero1 + numero2;
    }

    public static Double producto(Double numero1, Double numero2) {
        Double resultado = 0.0;
        boolean esNegativo = false;

        if (numero2 < 0) {
            numero2 = -numero2;
            esNegativo = true;
        }

        for (Double i = 0.0; i < numero2; i++) {
            resultado += numero1;
        }

        if (esNegativo) {
            resultado = -resultado;
        }

        return resultado;
    }

    public static Double cociente(Double numero1, Double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }

        Double resultado = 0.0;
        boolean esResultadoNegativo = false;

        if (numero1 < 0 && numero2 > 0 || numero1 > 0 && numero2 < 0) {
            esResultadoNegativo = true;
        }

        if (numero1 < 0)
            numero1 = -numero1;
        if (numero2 < 0)
            numero2 = -numero2;

        while (numero1 >= numero2) {
            numero1 -= numero2;
            resultado++;
        }
        if (esResultadoNegativo) {
            resultado = -resultado;
        }
        return resultado;
    }

    public static Double potencia(Double numero1, Double numero2) {
        Double resultado = 1.0;
        for (Double i = 0.0; i < numero2; i++) {
            resultado *= numero1;
        }
        return resultado;
    }

}
