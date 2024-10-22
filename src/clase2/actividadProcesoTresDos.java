package clase2;

import java.util.Scanner;

public class actividadProcesoTresDos {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese una letra entre a y e");
            System.out.println("A : Excelente");
            System.out.println("B : Notable");
            System.out.println("C : Aprobado");
            System.out.println("D : Suspendido");
            System.out.println("E : Suspendido");
            String letra = sc.nextLine().toLowerCase();

            verificarNota(letra);
            sc.close();

        } catch (Exception e) {
            System.out.println("Es incorrecto. Caracter fuera del rango permitido");
        }
    }

    private static void verificarNota(String letra) {
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
    }
}
