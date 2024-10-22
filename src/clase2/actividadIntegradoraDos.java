package clase2;

import java.util.Scanner;

public class actividadIntegradoraDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double suma = 0;
        int multiplosSeis = 0;
        double sumaUnoDiez = 0;
        double numeroMenor = Double.MAX_VALUE;
        double numeroMayor = Double.MIN_VALUE;
        int contador = 0;
        int posicionMayor = 0;
        int posicionMenor = 0;
        try {
            do {
                System.out.println("Ingrese un número:");
                double novoNum = sc.nextDouble();
                suma += novoNum;
                contador++;

                multiplosSeis = numerosSeis(novoNum, multiplosSeis);
                sumaUnoDiez = numerosUnosDiez(novoNum, sumaUnoDiez);

                int[] mayor = numerosGrandes(novoNum, numeroMayor, posicionMayor, contador);
                numeroMayor = mayor[0];
                posicionMayor = mayor[1];

                int[] menor = numerosChicos(novoNum, numeroMenor, posicionMenor, contador);
                numeroMenor = menor[0];
                posicionMenor = menor[1];

            } while (suma <= 1000);

            System.out.println("Cantidad de múltiplos de 6: " + multiplosSeis);
            System.out.println("La suma de los números entre 1 y 10: " + sumaUnoDiez);
            System.out.println("El mayor es: " + numeroMayor + " en la posición " + posicionMayor);
            System.out.println("El menor es: " + numeroMenor + " en la posición " + posicionMenor);
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            sc.close();
        }
    }

    public static int numerosSeis(double novoNum, int multiplosSeis) {
        if (novoNum % 6 == 0) {
            multiplosSeis++;
        }
        return multiplosSeis;
    }

    public static double numerosUnosDiez(double novoNum, double sumaUnoDiez) {
        if (novoNum >= 1 && novoNum <= 10) {
            sumaUnoDiez += novoNum;
        }
        return sumaUnoDiez;
    }

    public static int[] numerosGrandes(double novoNum, double numeroMayor, int posicionMayor, int contador) {
        if (novoNum > numeroMayor) {
            numeroMayor = novoNum;
            posicionMayor = contador;
        }
        return new int[] { (int) numeroMayor, posicionMayor };
    }

    public static int[] numerosChicos(double novoNum, double numeroMenor, int posicionMenor, int contador) {
        if (novoNum < numeroMenor) {
            numeroMenor = novoNum;
            posicionMenor = contador;
        }
        return new int[] { (int) numeroMenor, posicionMenor };
    }
}
