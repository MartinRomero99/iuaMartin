package zclasArraysOrdenBusqueda;

import zinputOuput.*;

public class Busqueda {
    public static void main(String[] args) {
        /*--------------------------------*/
        /* Generamos un Vector de Enteros */
        /*--------------------------------*/
        int[] edades = { 18, 21, 33, 45, 30, 15, 32, 23, 38 };
        int nBuscar, nEncontrado;

        /*----------------------------------------*/
        /* Mostramos el vector antes de ordenarlo */
        /*----------------------------------------*/
        System.out.println("Vector original:");
        imprimirVector(edades);

        /*------------------------------------------*/
        /* Buscamos un entero en el vector - lineal */
        /*------------------------------------------*/
        nBuscar = Ingreso.datoEntero("Ingrese el entero a buscar", "Busqueda Lineal", 1);
        nEncontrado = buscaLineal(edades, nBuscar);
        if (nEncontrado < 0)
            Salida.mError("No se encontró el Entero", "Busqueda Lineal");
        else
            Salida.mMensaje("El valor se encontró en la posicion " + nEncontrado, "Busqueda Lineal");

        /*-----------------------------------------------------*/
        /* Ordenar el Vecto e Imprimir el después de ordenarlo */
        /*-----------------------------------------------------*/
        ordenarPorInsercion(edades);
        System.out.println("Vector ordenado:");
        imprimirVector(edades);

        /*--------------------------------------*/
        /* Buscamos Utilizando Busqueda Binaria */
        /* Debe estar ordenado el Vector */
        /*--------------------------------------*/
        nBuscar = Ingreso.datoEntero("Ingrese el entero a buscar", "Busqueda Lineal", 1);
        nEncontrado = buscaBinaria(edades, nBuscar);
        if (nEncontrado < 0)
            Salida.mError("No se encontró el Entero", "Busqueda Lineal");
        else
            Salida.mMensaje("El valor se encontró en la posicion " + nEncontrado, "Busqueda Lineal");

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
        }
    }

    /*-------------------------------*/
    /* Metodo para Buscar Lineal */
    /*-------------------------------*/
    public static int buscaLineal(int aEdades[], int nBuscar) {
        for (int i = 0; i < aEdades.length; i++) {
            if (aEdades[i] == nBuscar)
                return i;
        }
        return -1;
    }

    /*-------------------------------------------- */
    /* Busca un entero utilizando Busqueda Binaria */
    /* Se puede hacer con For o While */
    /*-------------------------------------------- */
    public static int buscaBinaria(int aVector[], int nBusca) {
        int central, bajo, alto;
        int valorCentral;
        bajo = 0;
        alto = aVector.length - 1;
        while (bajo <= alto) {
            /*-----------------------------*/
            /* índice de elemento central */
            /*-----------------------------*/
            central = (bajo + alto) / 2;
            /*-----------------------------*/
            /* valor del índice central */
            /*-----------------------------*/
            valorCentral = aVector[central];
            if (nBusca == valorCentral)
                return central; /* encontrado valor, retorna la posición */
            else if (nBusca < valorCentral)
                alto = central - 1; /* ir a subaLegajos inferior */
            else
                bajo = central + 1; /* ir a subaLegajos superior */
        }
        return -1;
    }
}
