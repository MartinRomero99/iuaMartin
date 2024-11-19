package zclasArraysOrdenBusqueda;

public class OrdenamientoInsercion {
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
        ordenarPorInsercion(edades);
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
    /* Método Insercion */
    /*-------------------------------*/
    public static void ordenarPorInsercion(int vector[]) {
        int pasadas = 0;
        for (int i = 1; i < vector.length; i++) {
            int actual = vector[i];
            int j = i - 1;
            /*--------------------------------------------------*/
            /* Desplaza los elementos mayores hacia la derecha */
            /*--------------------------------------------------*/
            while (j >= 0 && vector[j] > actual) {
                vector[j + 1] = vector[j];
                j--;
            }
            /* Inserta el elemento en su posición correcta */
            vector[j + 1] = actual;
            pasadas++;
        }
        System.out.println("nro de pasadas " + pasadas);
    }
}
