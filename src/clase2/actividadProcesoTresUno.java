package clase2;

public class actividadProcesoTresUno {
    public static void main(String[] args) {
        int sumatoriaMultiplos = 0;
        try {
            laSumaDoWhile();
            System.out.println("-------------------------------------");
            sumatoriaMultiplos = laSumaFor();
            System.out.println("La sumatoria de todos los múltiplos de 5 hasta 100 es de: " + sumatoriaMultiplos);

        } catch (Exception e) {
            System.out.println("Error en la introducción de datos");
        }
    }

    public static void laSumaDoWhile() {
        int num = 5;
        int suma = 0;
        do {
            if (num % 5 == 0) {
                suma += num;
                num += 5;
                System.out.println(num);
            }
        } while (num <= 100);
        System.out.println("La sumatoria de todos los múltiplos de 5 hasta 100 es de: " + suma);
    }

    public static int laSumaFor() {
        int sumatoria = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                sumatoria += i;
                System.out.println(i);
            }
        }
        return sumatoria;
    }
}
