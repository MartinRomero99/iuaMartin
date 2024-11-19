package zclasArraysOrdenBusqueda;

public class OrdenamientoBurbuja {
    public static void main(String[] args) {
        /*--------------------------------*/
        /* Generamos un Vector de Enteros */
        /*--------------------------------*/
        // int[] edades = { 15, 30, 18, 14, 20 };

        int[] edades = { 14, 15, 18, 20, 30 };

        /*----------------------------------------*/
        /* Mostramos el vector antes de ordenarlo */
        /*----------------------------------------*/
        System.out.println("Vector original:");
        imprimirVector(edades);

        /*-----------------------------------------------------*/
        /* Ordenar el Vecto e Imprimir el después de ordenarlo */
        /*-----------------------------------------------------*/
        ordenBurbujaControl(edades);
        System.out.println("Vector ordenado:");
        imprimirVector(edades);
    }

    /*-------------------------------*/
    /* Metodo para Mostrar el Vector */
    /*-------------------------------*/
    public static void imprimirVector(int[] aEdades) {
        for (int num : aEdades) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /*-------------------------------*/
    /* Metodo para Ordenar el Array */
    /* Método Burbuja */
    /*-------------------------------*/
    public static void ordenBurbuja(int aEdades[]) {
        int pasadas = 0;
        int intercambios = 0;
        for (int paso = 0; paso < aEdades.length - 1; paso++) {
            for (int j = 0; j < aEdades.length - 1 - paso; j++) {
                if (aEdades[j] > aEdades[j + 1]) {
                    /*---------------------------*/
                    /* Se Intercambian Elementos */
                    /*---------------------------*/
                    intercambios++;
                    int temp = aEdades[j];
                    aEdades[j] = aEdades[j + 1];
                    aEdades[j + 1] = temp;
                }
                pasadas++;
            }
        }
        System.out.println("nro de pasadas " + pasadas);
        System.out.println("nro de Intercambios " + intercambios);
    }

    /*--------------------------------------*/
    /* Metodo para Ordenar el Array */
    /* Método Burbuja con Control de OPrden */
    /*--------------------------------------*/
    public static void ordenBurbujaControl(int aEdades[]) {
        int pasadas = 0;
        int intercambios = 0;
        boolean ordenado = false;
        for (int paso = 0; paso < aEdades.length - 1 && !ordenado; paso++) {
            ordenado = true;
            for (int j = 0; j < aEdades.length - 1 - paso; j++) {
                if (aEdades[j] > aEdades[j + 1]) {
                    ordenado = false;
                    intercambios++;
                    /*---------------------------*/
                    /* Se Intercambian Elementos */
                    /*---------------------------*/
                    int temp = aEdades[j];
                    aEdades[j] = aEdades[j + 1];
                    aEdades[j + 1] = temp;
                }
                pasadas++;
            }
        }
        System.out.println("nro de pasadas " + pasadas);
        System.out.println("nro de Intercambios " + intercambios);
    }
}
