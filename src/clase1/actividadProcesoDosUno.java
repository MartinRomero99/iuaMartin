package clase1;

import java.util.Scanner;

public class actividadProcesoDosUno {

    static int totalMujeres = 0;
    static int totalHombres = 0;
    static int sumaAlturaMujeres = 0;
    static int sumaAlturaHombres = 0;
    static int sumaEdades = 0;
    static int totalParticipantes = 0;

    static String nombreJoven = "";
    static int edadJoven = Integer.MAX_VALUE;
    static String sexoJoven = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            ingresarDatosParticipante(sc);
            continuar = preguntarContinuar(sc);
        }

        sc.close();

        mostrarResultados();
    }

    // Método para ingresar los datos de un participante
    public static void ingresarDatosParticipante(Scanner sc) {
        System.out.println("Ingrese el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su altura en centímetros:");
        int altura = sc.nextInt();
        System.out.println("Ingrese su edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el sexo (f o m):");
        String sexo = sc.nextLine();

        if (sexo.equalsIgnoreCase("f")) {
            sumaAlturaMujeres += altura;
            totalMujeres++;
        } else if (sexo.equalsIgnoreCase("m")) {
            sumaAlturaHombres += altura;
            totalHombres++;
        }

        sumaEdades += edad;
        totalParticipantes++;

        if (edad < edadJoven) {
            edadJoven = edad;
            nombreJoven = nombre;
            sexoJoven = sexo;
        }
    }

    public static boolean preguntarContinuar(Scanner sc) {
        System.out.println("¿Desea ingresar otra persona? (true para sí, false para no):");
        return sc.nextBoolean();
    }

    public static void mostrarResultados() {
        double promedioAMujeres = calcularPromedioAltura(totalMujeres, sumaAlturaMujeres);
        double promedioAHombres = calcularPromedioAltura(totalHombres, sumaAlturaHombres);
        double promedioEdad = calcularPromedioEdad();

        System.out.println("Promedio de altura de las mujeres: " + promedioAMujeres + " cm");
        System.out.println("Promedio de altura de los varones: " + promedioAHombres + " cm");
        System.out.println("Promedio de edad de los participantes: " + promedioEdad + " años");
        System.out
                .println("La persona más joven es " + nombreJoven + " con " + edadJoven + " años y sexo " + sexoJoven);
    }

    public static double calcularPromedioAltura(int totalPersonas, int sumaAltura) {
        if (totalPersonas > 0) {
            return (double) sumaAltura / totalPersonas;
        } else {
            return 0;
        }
    }

    public static double calcularPromedioEdad() {
        if (totalParticipantes > 0) {
            return (double) sumaEdades / totalParticipantes;
        } else {
            return 0;
        }
    }
}
