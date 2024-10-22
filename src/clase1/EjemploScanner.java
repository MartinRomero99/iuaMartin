package clase1;

import java.util.Scanner;

/*Para leer datos desde teclado con Scanner podemos usar los métodos nextXxx() donde Xxx indica el tipo de dato a leer:
nextByte()      para leer un dato de tipo byte.
nextShort()     para leer un dato de tipo short.
nextInt()       para leer un dato de tipo int.
nextLong()      para leer un dato de tipo long. 
nextFloat()     para leer un dato de tipo float. 
nextDouble()    para leer un dato de tipo double. 
nextBoolean()   para leer un dato de tipo boolean.
nextLine()      para leer un String hasta encontrar un salto de línea.
next()          para leer un String hasta el primer delimitador, generalmente hasta un espacio en blanco o hasta un salto de línea.   */

public class EjemploScanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre;
        double radio;
        int n;

        System.out.print("Introduzca su nombre: ");
        nombre = sc.nextLine();

        System.out.println("Hola " + nombre + "!!!");
        System.out.print("Introduzca el radio de la circunferencia: ");

        radio = sc.nextDouble();
        System.out.println("Longitud de la circunferencia: " + 2 * Math.PI * radio);

        System.out.print("Introduzca un número entero: ");
        n = sc.nextInt();
        System.out.println("El cuadrado es: " + Math.pow(n, 2));
        sc.close();
    }
}
