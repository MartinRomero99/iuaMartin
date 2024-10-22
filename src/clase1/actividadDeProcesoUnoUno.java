package clase1;
/*Escribir un programa en Java que permita ingresar 10 enteros 
positivos por teclado (validar que sea positivo), determine y 
muestre un mensaje «Correcto» si el numero N es múltiplo de 5 
y se encuentra entre los 25 primeros números decimales. 
Al finalizar mostrar la cantidad de Enteros que cumplen la 
condición y su promedio. Utilice el ciclo más apropiado. */

import java.io.IOException;
import java.util.Scanner;

public class actividadDeProcesoUnoUno {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cuentaCorrectos = 0;
        int sumaCorrectos = 0;

        for (int i = 1; i <= 10; i++) {
            int entero;
            do {
                System.out.println("Ingrese un entero");
                entero = sc.nextInt();
                if (entero <= 0) {
                    System.out.println("El numero debe ser positivo");
                }
            } while (entero <= 0);
            if (entero % 5 == 0 && entero > 0 && entero <= 25) {
                System.out.println("Correcto");
                cuentaCorrectos++;
                sumaCorrectos = sumaCorrectos + entero;
            }
        }
        if (cuentaCorrectos > 0) {
            double promedio = prom(sumaCorrectos, cuentaCorrectos);
            System.out.println("La cantidad de divisibles por 5 son de: " + cuentaCorrectos);
            System.out.println("El promedio de los que cumplen las normas es de: " + promedio);
            sc.close();
        } else {
            System.out.println("No es correcto");
        }
        sc.close();
    }

    private static double prom(int sumaCorrectos, int cuentaCorrectos) {
        return (double) sumaCorrectos / cuentaCorrectos;
    }
}
