package aObjetos.aoPersonas;

import java.util.Scanner;

import aObjetos.aoPersonas.clases.Persona;

public class DemoPersona {
    // Crear una Clase Persona con propiedades: Apellido, Nombre, DNI y Edad.
    // Crear un vector de N Objetos tipo Persona. Cargue los Datos y
    // Mediante un ciclo repetitivo obtenga los datos de las persona */
    // Obtenga la edad de una Persona a traves de los métodos Get de la clase //
    public static void main(String[] args) throws Exception {
        int n;
        int nPosicion;

        Scanner data = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de Personas: ");
        n = Integer.parseInt(data.nextLine());
        Persona[] aPersonas;
        aPersonas = new Persona[n];

        /* Iniciamos un ciclo para la carga del Vector */
        cargaPersonas(aPersonas, data);

        /* Mostramos los elementos del vector */
        mostrarDatos(aPersonas);

        /* Busca la edad Promedio de las persona ingresadas */
        System.out.println("/nEl Promedio las edades es: " + calculaPromedio(aPersonas));

        /* Ordena el Array por Edad de las Personas */
        oPersEdad(aPersonas);
        mostrarDatos(aPersonas);

        /* Modificamos la edad de la persona en la posición Ingresada por teclado */
        nPosicion = modificaEdad(aPersonas, data);
        mostrarDatos(aPersonas);

        data.close();
    }

    /*-----------------------------------------*/
    /* METODOS DEL ARRAY PERSONA */
    /*-----------------------------------------*/
    /* Carga del Vector */
    /*-----------------------------------------*/
    public static void cargaPersonas(Persona[] aPers, Scanner data) {
        System.out.println("---------------------------------");
        System.out.println("        CARGA DEL VECTOR         ");
        System.out.println("---------------------------------");
        for (int i = 0; i < aPers.length; i++) {
            aPers[i] = new Persona();
            System.out.println("\nIngrese los datos de la Persona: " + (i + 1));
            System.out.println("----------------------------------");
            aPers[i].AsignarDatos(data);
        }
    }

    public static void mostrarDatos(Persona[] aPers) {
        System.out.println("---------------------------------");
        System.out.println("      LECTURA DEL VECTOR         ");
        System.out.println("---------------------------------");
        for (int i = 0; i < aPers.length; i++) {
            System.out.println("----------------------");
            System.out.println("Datos de la Persona: " + (i + 1));
            System.out.println("----------------------");
            aPers[i].imprimirDatos();
        }
    }

    public static float calculaPromedio(Persona[] aPers) {
        System.out.println("---------------------------------");
        System.out.println("      PROMEDIO DE LAS EDADES     ");
        System.out.println("---------------------------------");
        int acumEdades = 0;
        for (int i = 0; i < aPers.length; i++) {
            acumEdades += aPers[i].getEdad();
        }
        return (float) acumEdades / aPers.length;
    }

    public static void oPersEdad(Persona[] aPers) {
        boolean swapped;
        Persona aux;

        for (int i = 1; i < aPers.length; i++) {
            swapped = false;
            /*--------------------------------------------- */
            /* Recorremos el array para comparar */
            /*--------------------------------------------- */
            for (int j = 0; j < aPers.length - i; j++) {
                /* Si el elemento actual es mayor que el posterior */
                /* se intercambian - Para cambiar el orden cambiar */
                /* ascendente cambiar > por < */
                if (aPers[j].getEdad() < aPers[j + 1].getEdad()) {
                    aux = aPers[j];
                    aPers[j] = aPers[j + 1];
                    aPers[j + 1] = aux;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static int modificaEdad(Persona[] aPers, Scanner data) {
        int nPos = 0;
        do {
            System.out.print("Ingrese la Posicion de la Persona a modificar: ");
            // String aaa =data.nextLine();
            nPos = Integer.parseInt(data.nextLine()) - 1;
            if (nPos >= aPers.length || nPos < 1)
                System.out.println("Debe ingresar desde la posicion 1 a la " + (aPers.length));
        } while (nPos >= aPers.length || nPos < 1);

        System.out.print("Ingrese la nueva edad: ");
        aPers[nPos].setEdad(Integer.parseInt(data.nextLine()));
        return nPos;
    }
}
