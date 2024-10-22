package clase1;

import java.util.Scanner;

/*Desarrollar un programa que permita el ingreso de  la calificación de un alumno en una 
evaluación y muestre el concepto de la misma.. 
Se supone que la calificación puede ser una letra, en el rango de la ´A´ a la ´E´, con 
los siguientes conceptos: 
‘A’ : ‘Excelente’ 
‘B’ : ‘Notable’ 
‘C’: ‘Aprobado’ 
‘D’ y ‘E’: ‘Suspendido’.  */
public class calificacionAlumno {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una letra entre a y e");
        String letra = sc.nextLine();

        switch (letra) {
            case "a":
                System.out.println("Excelente");
                break;
            case "b":
                System.out.println("Notable");
                break;
            case "c":
                System.out.println("Aprobado");
                break;
            case "d":
            case "e":
                System.out.println("Suspendido");
                break;

            default:
                System.out.println("Es incorrecto. Letra fuera del rango permitido");
                break;
        }
        sc.close();
    }
}
