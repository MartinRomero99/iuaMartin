package clase2;

import java.io.IOException;
import java.util.Scanner;

/* Escribir un programa que permita calcular el perímetro y la superficie de distintas figuras geométricas 
(Círculos, triángulos (ojo), rectángulos, cuadrados, heptagono y octógono) mediante procedimientos. 

Crear un menú que permita seleccionar la figura y de acuerdo a la selección llamar a los procedimientos 
para el calculo correspondiente. 

Para los métodos deben utilizar distintos tipos de retorno void, float, double, según corresponda al llamado 
del método*/

public class EVS1_Mandrini {

    public static void main(String[] args) throws IOException, InterruptedException {
        // VARIABLES //
        int option = -1;
        double lado1, lado2, lado;
        Scanner sc = new Scanner(System.in);

        // COMIENZO DE EJERCICIO //
        do {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia lo anterior para que
                                                                                      // nose repitan las opciones y
                                                                                      // vallan quedando

                System.out.println("╔═════════════════════════╗");
                System.out.println("║   Seleccione la opcion  ║");
                System.out.println("╚═════════════════════════╝");
                System.out.println("\t1.Circulo");
                System.out.println("\t2.Triangulo");
                System.out.println("\t3.Rectangulo"); // SOLO MUESTRA LAS OPCIONES DISPONIBLES
                System.out.println("\t4.Cuadrado");
                System.out.println("\t5.Heptagono");
                System.out.println("\t6.Octogono");
                System.out.println("\t0.Salir");
                option = Integer.parseInt(sc.nextLine()); // aqui se ingresa el numero de opcion al cual va a responder
                                                          // el SWITCH
            } catch (Exception e) {
                System.out.println("Error de Ingreso de datos");
            }
            switch (option) {
                case 1:
                    System.out.println("Seleccionado Circulo");
                    calcularCirculo(sc);
                    break;

                case 2:
                    System.out.println("Seleccionado Triángulo");
                    calcularTriangulo(sc);
                    break;

                case 3:
                    System.out.println("Seleccionado Rectángulo");
                    System.out.println("Ingrese la medida de los lados largos: ");
                    lado1 = Double.parseDouble(sc.nextLine());
                    System.out.println("Ingrese la medida de los lados cortos: ");
                    lado2 = Double.parseDouble(sc.nextLine());
                    System.out.printf("Perímetro del rectángulo: %.2f%n", calcularPerimetro(lado1, lado2));
                    System.out.printf("Superficie del rectángulo: %.2f%n", calcularSuperficie(lado1, lado2));
                    break;

                case 4:
                    System.out.println("Seleccionado Cuadrado");
                    System.out.println("Ingrese el lado del cuadrado: ");
                    lado = Double.parseDouble(sc.nextLine());
                    System.out.printf("Perímetro del rectángulo: %.2f%n", perimetroPoligReg(lado, 4));
                    System.out.printf("Superficie del rectángulo: %.2f%n", areaPoligReg(lado, 4));
                    break;

                case 5:
                    System.out.println("Seleccionado Heptágono");
                    System.out.println("Ingrese el lado del Heptágono: ");
                    lado = Double.parseDouble(sc.nextLine());
                    System.out.printf("Perímetro del Heptagono: %.2f%n", perimetroPoligReg(lado, 7));
                    System.out.printf("Superficie del Heptagono: %.2f%n", areaPoligReg(lado, 7));
                    break;

                case 6:
                    System.out.println("Seleccionado Octógono");
                    System.out.println("Ingrese el lado del Octógono: ");
                    lado = Double.parseDouble(sc.nextLine());
                    System.out.printf("Perímetro del Octógono: %.2f%n", perimetroPoligReg(lado, 8));
                    System.out.printf("Superficie del Octógono: %.2f%n", areaPoligReg(lado, 8));
                    break;

                case 0:
                    System.out.println("Hasta luego"); // FINALIZA CON EL CERO.
                    break;

                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
            if (option != 0) {
                System.out.print("\nPresione una tecla para continuar...");
                sc.nextLine();
            }

        } while (option != 0);
        sc.close();
    }

    // METODO PRA CALCULAR EL CIRCULO
    public static void calcularCirculo(Scanner ext) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = Double.parseDouble(ext.nextLine());

        double perimetro = 2 * Math.PI * radio;
        double superficie = Math.PI * Math.pow(radio, 2);

        System.out.printf("Perímetro del círculo: %.2f%n ", perimetro);
        System.out.printf("Superficie del círculo: %.2f%n", superficie);
    }

    // METODO PARA CALCULAR LOS TRIANGULOS
    public static void calcularTriangulo(Scanner ext) {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║ Seleccione El Triángulo ║");
        System.out.println("╚═════════════════════════╝");
        System.out.println("\t1.Escaleno (tres lados distintos)");
        System.out.println("\t2.Isósceles (dos lados iguales y uno distinto)");
        System.out.println("\t3.Equilátero (tres lados iguales)");
        int optionTriangulo = Integer.parseInt(ext.nextLine());

        switch (optionTriangulo) {
            case 1: // TRIANGULO ESCALENO (tres lados diferentes)
                System.out.println("Eligio el triángulo ESCALENO");
                System.out.println("Ingrese el lado 1");
                double lado1 = Double.parseDouble(ext.nextLine());
                System.out.println("Ingrese el lado 2");
                double lado2 = Double.parseDouble(ext.nextLine());
                System.out.println("Ingrese el lado 3");
                double lado3 = Double.parseDouble(ext.nextLine());

                double perim = lado1 + lado2 + lado3;

                System.out.printf("Perímetro del Triangulo Escaleno: %.2f%n" + perim);
                System.out.printf("Superficie del Triangulo Escaleno: %.2f%n",
                        calcAreaTriangulos(lado1, lado2, lado3, perim));
                break;

            case 2: // TRIANGULO ISOSCELES
                System.out.println("Eligio el triángulo ISOSCELES");
                System.out.println("Ingrese el lado 1 (desigual)");
                lado1 = Double.parseDouble(ext.nextLine());
                System.out.println("Ingrese el lado 2 y 3 (iguales)");
                lado2 = Double.parseDouble(ext.nextLine());

                double perimetroIso = lado1 + lado2 * 2;

                System.out.println("Perímetro del triángulo: " + perimetroIso);
                System.out.printf("Superficie del Triangulo Isóceles: %.2f%n",
                        calcAreaTriangulos(lado1, lado2, lado2, perimetroIso));
                break;

            case 3: // TRIANGULO EQUILATERO
                System.out.println("Eligio el triángulo EQUILATERO");
                System.out.println("Ingrese la medida de los lados (todos iguales)");
                double lado = Double.parseDouble(ext.nextLine());

                System.out.printf("Perímetro del Triangulo Equilatero: %.2f%n", perimetroPoligReg(lado, 3));
                System.out.printf("Superficie del Triangulo Equilatero: %.2f%n",
                        calcAreaTriangulos(lado, lado, lado, perimetroPoligReg(lado, 3)));
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    // perimetro del rectangulo
    public static Double calcularPerimetro(double lado1, double lado2) { // metodos dentro del metodo anterior
        return 2 * (lado1 + lado2);
    }

    // superficie del rectangulo
    public static Double calcularSuperficie(double lado1, double lado2) { // metodos dentro del metodo anterior
        return lado1 * lado2;
    }

    // METODO PERIMETRO PARA POLIGONOS REGULARES
    public static double perimetroPoligReg(double lado, double nlados) {
        return nlados * lado;
    }

    // METODO SUPERFICIE PARA POLIGONOS REGULARES
    public static double areaPoligReg(double lado, double nlados) {
        return (nlados * Math.pow(lado, 2)) / (4 * Math.tan(Math.PI / nlados));
    }

    // Superficie/Area Triangulos
    public static Double calcAreaTriangulos(double lado1, double lado2, double lado3, double perim) {
        double s = perim / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
}
