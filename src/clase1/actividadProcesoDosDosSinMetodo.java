package clase1;

public class actividadProcesoDosDosSinMetodo {
    public static void main(String[] args) {

        int sumatoria = 0;
        int contadorCeros = 0;
        int sumaDeNum = 0;
        int contadorMenores = 0;
        int vueltaMenores = 0;
        int elMayor = 0;
        int vueltaDelMayor = 0;
        int posicion = 0;
        while (sumatoria < 500) {

            int numero = (int) (Math.random() * 201);
            posicion++;

            System.out.println(numero);
            // System.out.println(sumatoria);

            sumatoria += numero;

            if (numero == 0) {
                contadorCeros++;
            }

            if (numero > 9 && numero <= 100) {
                sumaDeNum += numero;
            }
            if (numero < 150) {
                contadorMenores += numero;
                vueltaMenores++;
            }

            if (elMayor < numero) {
                elMayor = numero;
                vueltaDelMayor = posicion;
            }

        }
        double promedioMenores = contadorMenores > 0 ? (double) contadorMenores / vueltaMenores : 0;

        System.out.println("Los ceros son " + contadorCeros);
        System.out.println("la suma entre 10 y 100 " + sumaDeNum);
        System.out.println("El promedio de menores a 150 es " + promedioMenores);
        System.out.println("El mayor es: " + elMayor + " salió en la posición " + vueltaDelMayor);
    }
}
