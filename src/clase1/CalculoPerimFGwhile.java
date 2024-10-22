package clase1;

import java.util.Scanner;

/* --------------------------------------------------------------------------- */
/* Ingrese un valor 'x' por teclado, calcule y muestre por pantalla   
 * el perimetro de un cuadrado de lado 'x' y la long. de una circunferencia
 * Calcule Area del cuadrado de lado 'x' y Area Circunferencia de radio 'x'. 
 * Utilice métodos y la clase scanner para el ingreso de datos   */
/*
Entrada:
    Variables: x-> int/float/double
Salida: 
    Perimetro de cuadrado
    long. de la circunferencia
    Area de cuadrado
    Area de la circunferencia    
Proceso:
    Calcula y muestra de Perimetro del cuandrado y Long de la Circunferencia
    Calcula y muestra el Area del cuandrado y la Circunferencia  
/* -----------------------------------------------------------*/
public class CalculoPerimFGwhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Ingrese el valor de X: ");
        x = sc.nextInt();

        while (x != 0) {
            System.out.println("\nEl perimetro de un cuadrado de lado " + x + " es igual a " + calcPerimCuadr(x));
            System.out.println("la Longitud de la circunferencia de radio " + x + " es igual a " + calcLongCirc(x));
            System.out.println("El área del cuadrado es: " + areaCuadrado(x));
            System.out.println("El área del círculo es: " + areaCircunferencia(x));

            System.out.print("Ingrese el valor de X: (Ingrese 0 para finalizar)");
            x = sc.nextInt();
        }
        sc.close();
    }

    /************************************************** */
    /* METODO UTILIZADOS */
    /************************************************** */
    public static int calcPerimCuadr(int lc) {
        int pc;
        pc = lc * 4;
        return pc;
    }

    public static double calcLongCirc(int rc) {
        double lc;
        lc = (double) 2 * Math.PI * rc;
        return lc;
    }

    public static int areaCuadrado(int lado) {
        return lado * lado;
    }

    public static double areaCircunferencia(int radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}