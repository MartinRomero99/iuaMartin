package clase1;

public class actividadProcesoDosDos {
    static int sumatoria = 0;
    static int contadorCeros = 0;
    static int sumaDeNum = 0;
    static int sumaMenores = 0;
    static int contadorMenores = 0;
    static int elMayor = 0;
    static int vueltaDelMayor = 0;
    static int posicion = 0;

    public static void main(String[] args) {
        while (sumatoria <= 500) {
            int numero = generarNumeros();
            procesarNumero(numero);
        }
        mostrarResultados();
    }

    public static int generarNumeros() {
        int numero = (int) (Math.random() * 201);
        posicion++;
        System.out.println(numero);
        System.out.println("Sumatoria actual: " + sumatoria);
        sumatoria += numero;
        return numero;
    }

    public static void procesarNumero(int numero) {
        if (numero == 0) {
            contadorCeros++;
        }

        if (numero >= 10 && numero <= 100) {
            sumaDeNum += numero;
        }

        if (numero < 150) {
            sumaMenores += numero;
            contadorMenores++;
        }

        if (numero > elMayor) {
            elMayor = numero;
            vueltaDelMayor = posicion;
        }
    }

    public static void mostrarResultados() {
        double promedioMenores = contadorMenores > 0 ? (double) sumaMenores / contadorMenores : 0;

        System.out.println("Cantidad de ceros leídos: " + contadorCeros);
        System.out.println("Sumatoria de números entre 10 y 100 (incluidos): " + sumaDeNum);
        System.out.println("Promedio de números menores a 150: " + promedioMenores);
        System.out.println("El número mayor es: " + elMayor + " y se generó en la posición: " + vueltaDelMayor);
    }
}