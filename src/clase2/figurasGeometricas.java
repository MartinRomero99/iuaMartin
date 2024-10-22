
/*Escribir un programa que permita calcular el perímetro y la superficie de distintas figuras geométricas 
(Círculos, triángulos (ojo), rectángulos, cuadrados, heptagono y octógono) mediante procedimientos. 
Crear un menú que permita seleccionar la figura y de acuerdo a la selección llamar a los procedimientos 
para el calculo correspondiente. 
Para los métodos deben utilizar distintos tipos de retorno void, float, double, según corresponda al 
llamado del método.    */
package clase2;

import java.io.IOException;
import java.util.Scanner;

public class figurasGeometricas {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = -1;

        Scanner sc = new Scanner(System.in);

        do {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("╔═════════════════════════╗");
                System.out.println("║   Seleccione la opcion  ║");
                System.out.println("╚═════════════════════════╝");
                System.out.println("\t1.circulo");
                System.out.println("\t2.triangulo");
                System.out.println("\t3.rectangulo");
                System.out.println("\t4.cuadrado");
                System.out.println("\t5.heptagono");
                System.out.println("\t6.octogono");
                System.out.println("\t0.salir");

                System.out.println("Ingrese un número");
                opcion = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Error al intentar ingresar, son letras");
            }

            switch (opcion) {
                case 1:
                    System.out.println("Seleccionado circulo");
                    calcularCirculo(sc);
                    break;
                case 2:
                    System.out.println("Seleccionado triángulos");
                    calcularTriangulo(sc);
                    break;
                case 3:
                    System.out.println("Seleccionado rectangulo");
                    calcularPerYSupRectangulo(sc);
                    break;
                case 4:
                    System.out.println("Seleccionado cuadrados");
                    calcularPerYSupCuadrado(sc);
                    break;

                case 5:
                    System.out.println("Seleccionado heptagono ");
                    calcularPerimetroHeptagono(sc);
                    break;
                case 6:
                    System.out.println("Seleccionado octogono");
                    calcularSuperficieOctogono(sc);
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
            }
            System.out.println("Presione una tecla para continuar...");
            sc.nextLine();

        } while (opcion != 0);
        sc.close();
    }

    public static void calcularCirculo(Scanner sc) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = Double.parseDouble(sc.nextLine());

        double perimetro = 2 * Math.PI * radio;
        double superficie = Math.PI * Math.pow(radio, 2);

        System.out.printf("Perímetro del círculo: %.2f%n ", perimetro);
        System.out.printf("Superficie del círculo: %.2f%n ", superficie);
    }

    public static void calcularPerYSupRectangulo(Scanner sc) {
        System.out.println("Ingrese lado largo");
        double lado1 = Double.parseDouble(sc.nextLine());
        System.out.println("Ingrese lado corto");
        double lado2 = Double.parseDouble(sc.nextLine());

        double perimetro = 2 * (lado1 + lado2);
        double superficie = lado1 * lado2;

        System.out.printf("Perímetro del rectangulo: %.2f%n ", perimetro);
        System.out.printf("Superficie del rectangulo: %.2f%n ", superficie);
    }

    public static void calcularPerYSupCuadrado(Scanner sc) {
        System.out.println("Ingrese un lado del cuadrado");
        double lado1 = Double.parseDouble(sc.nextLine());

        double perimetro = lado1 * 4;
        double superficie = lado1 * lado1;

        System.out.printf("Perímetro del cuadrado: %.2f%n ", perimetro);
        System.out.printf("Superficie del cuadrado: %.2f%n ", superficie);
    }

    public static void calcularPerimetroHeptagono(Scanner sc) {
        System.out.println("Ingrese un lado ");
        double lado1 = Double.parseDouble(sc.nextLine());

        double perimetro = lado1 * 7;
        double superficie = (7 * Math.pow(lado1, 2)) / (4 * Math.tan(Math.PI / 7));

        System.out.printf("Perímetro del heptagono: %.2f%n ", perimetro);
        System.out.printf("Superficie del heptagono: %.2f%n ", superficie);
    }

    public static void calcularSuperficieOctogono(Scanner sc) {
        System.out.println("Ingrese lado 1");
        double lado1 = Double.parseDouble(sc.nextLine());

        double perimetro = lado1 * 8;
        double superficie = (8 * Math.pow(lado1, 2)) / (4 * Math.tan(Math.PI / 8));

        System.out.printf("Perímetro del octogono: %.2f%n ", perimetro);
        System.out.printf("Superficie del octogono: %.2f%n ", superficie);
    }

    public static void calcularTriangulo(Scanner sc) {
        System.out.println("Seleccione el tipo de triángulo: ");
        System.out.println("1: Escaleno (tres lados desiguales)");
        System.out.println("2: Isósceles (dos iguales y uno desigual)");
        System.out.println("3: Equilátero (tres lados iguales)");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                System.out.println("Eligió el triángulo ESCALENO");
                System.out.println("Ingrese el lado 1");
                double lado1 = Double.parseDouble(sc.nextLine());
                System.out.println("Ingrese el lado 2");
                double lado2 = Double.parseDouble(sc.nextLine());
                System.out.println("Ingrese el lado 3");
                double lado3 = Double.parseDouble(sc.nextLine());

                if (esTrianguloValido(lado1, lado2, lado3)) {
                    double perim = lado1 + lado2 + lado3;
                    System.out.printf("Perímetro del Triángulo Escaleno: %.2f%n", perim);
                    System.out.printf("Superficie del Triángulo Escaleno: %.2f%n",
                            calcAreaTriangulos(lado1, lado2, lado3, perim));
                } else {
                    System.out.println("Los lados ingresados no forman un triángulo válido.");
                }
                break;

            case 2:
                System.out.println("Eligió el triángulo ISÓSCELES");
                System.out.println("Ingrese el lado 1 (desigual)");
                lado1 = Double.parseDouble(sc.nextLine());
                System.out.println("Ingrese el lado 2 y 3 (iguales)");
                lado2 = Double.parseDouble(sc.nextLine());

                if (esTrianguloValido(lado1, lado2, lado2)) {
                    double perimetroIso = lado1 + lado2 * 2;
                    System.out.printf("Perímetro del Triángulo Isósceles: %.2f%n", perimetroIso);
                    System.out.printf("Superficie del Triángulo Isósceles: %.2f%n",
                            calcAreaTriangulos(lado1, lado2, lado2, perimetroIso));
                } else {
                    System.out.println("Los lados ingresados no forman un triángulo válido.");
                }
                break;

            case 3:
                System.out.println("Eligió el triángulo EQUILÁTERO");
                System.out.println("Ingrese la medida de los lados (todos iguales)");
                double lado = Double.parseDouble(sc.nextLine());

                if (esTrianguloValido(lado, lado, lado)) {
                    double perimetro = lado * 3;
                    System.out.printf("Perímetro del Triángulo Equilátero: %.2f%n", perimetro);
                    System.out.printf("Superficie del Triángulo Equilátero: %.2f%n",
                            calcAreaTriangulos(lado, lado, lado, perimetro));
                } else {
                    System.out.println("Los lados ingresados no forman un triángulo válido.");
                }
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static boolean esTrianguloValido(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }

    public static Double calcAreaTriangulos(double lado1, double lado2, double lado3, double perim) {
        double s = perim / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

}