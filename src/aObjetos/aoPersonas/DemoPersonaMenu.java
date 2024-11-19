package aObjetos.aoPersonas;

import java.util.Scanner;

import aObjetos.aoPersonas.clases.Persona;

public class DemoPersonaMenu {
    // Crear una Clase Persona con propiedades: Apellido, Nombre, DNI y Edad.
    // Crear un vector de N Objetos tipo Persona. Cargue los Datos y
    // Mediante un ciclo repetitivo obtenga los datos de las persona */
    // Obtenga la edad de una Persona a traves de los métodos Get de la clase //
    public static void main(String[] args) throws Exception {
        int n;
        int nPosicion;
        int nOpcion;
        String dniBusca;

        Scanner data = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de Personas: ");
        n = Integer.parseInt(data.nextLine());
        Persona[] aPersonas;
        // aPersonas = new Persona[n];
        aPersonas = new Persona[6];

        aPersonas[0] = new Persona("Ana", "99", 15);
        aPersonas[1] = new Persona("Julio", "22", 25);
        aPersonas[2] = new Persona("Beatriz", "77", 34);
        aPersonas[3] = new Persona("José", "55", 13);
        aPersonas[4] = new Persona("Hugo", "33", 40);
        aPersonas[5] = new Persona("Florencia", "44", 27);

        /* Iniciamos un ciclo para la carga del Vector */
        // cargaPersonas(aPersonas, data);
        /*------------------------------------------- */
        /* MENEU DE OPCIONES */
        /*------------------------------------------------ */
        do {
            System.out.println("\n -------------------------------");
            System.out.println("|       Menu de Opciones        |");
            System.out.println(" -------------------------------");
            System.out.println("  1) Datos Personas");
            System.out.println("  2) Promedio de edades");
            System.out.println("  3) Ordena por edad");
            System.out.println("  4) Modifica Edad");
            System.out.println("  5) Busca Persona por DNI");
            System.out.println("  6) Ordena por DNI");

            System.out.print("\nSeleccione una Opcion 0-> sale: ");
            nOpcion = Integer.parseInt(data.nextLine());

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            switch (nOpcion) {
                case 0:
                    System.out.print("Adios...\n");
                    break;

                case 1:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    /* Mostramos los elementos del vector */
                    mostrarDatos(aPersonas);
                    break;

                case 2:
                    /* Busca la edad Promedio de las persona ingresadas */
                    System.out.println("/nEl Promedio las edades es: " + calculaPromedio(aPersonas));
                    break;

                case 3:
                    /* Ordena el array por edad de la persona */
                    oPersEdad(aPersonas);
                    mostrarDatos(aPersonas);
                    break;

                case 4:
                    /* Modificamos la edad de la persona en la posición Ingresada por teclado */
                    nPosicion = modificaEdad(aPersonas, data);
                    break;

                case 5:
                    /* Busca una Persona por DNI */
                    System.out.print("Ingrese el DNI buscado: ");
                    dniBusca = data.nextLine();
                    nPosicion = buscaPersonaDniBinario(aPersonas, dniBusca);
                    if (nPosicion != -1) {
                        System.out.println("Persona con el DNI:" + dniBusca);
                        aPersonas[nPosicion].imprimirDatos();
                    } else {
                        System.out.println("El dni Buscado No se Encontró");
                    }
                    break;

                case 6:
                    /* Ordena el array por DNI de la persona */
                    oPersDni(aPersonas);
                    mostrarDatos(aPersonas);
                    break;

                default:
                    System.out.println("Seleción No Valida...");

            }
        } while (nOpcion != 0);
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

    /*----------------------------------*/
    /* Muestra los datos de las Persona */
    /*----------------------------------*/
    public static void mostrarDatos(Persona[] aPers) {
        System.out.println("-------------------------------");
        System.out.println("      DATOS DEL PERSONAL       ");
        System.out.println("-------------------------------");

        for (int i = 0; i < aPers.length; i++) {
            System.out.println("----------------------");
            System.out.println("Datos de la Persona: " + (i + 1));
            System.out.println("----------------------");
            aPers[i].imprimirDatos();
        }
    }

    /*------------------------------------*/
    /* Calcula el Promedio de las Peronas */
    /*------------------------------------*/
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

    /*------------------------------------*/
    /* Ordena las Peronas por edad */
    /*------------------------------------*/
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
                if (aPers[j].getEdad() > aPers[j + 1].getEdad()) {
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

    /*------------------------------------*/
    /* Ordena las Peronas por DNI */
    /*------------------------------------*/
    public static void oPersDni(Persona[] aPers) {
        boolean swapped;
        Persona aux;
        int nResulComp;

        for (int i = 1; i < aPers.length; i++) {
            swapped = false;
            /*--------------------------------------------- */
            /* Recorremos el array para comparar */
            /*--------------------------------------------- */
            for (int j = 0; j < aPers.length - i; j++) {
                /* Si el elemento actual es mayor que el posterior */
                /* se intercambian - Para cambiar el orden cambiar */
                /* ascendente cambiar > por < */
                if (Integer.parseInt(aPers[j].getDni()) > Integer.parseInt(aPers[j + 1].getDni())) {
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

    /*------------------------------------*/
    /* Modifica la Edad de una Persona */
    /*------------------------------------*/
    public static int modificaEdad(Persona[] aPers, Scanner data) {
        int nPos = 0;
        do {
            System.out.print("Ingrese la Posicion de la Persona a modificar: ");
            // nPos = Integer.parseInt(data.nextLine()) - 1;
            nPos = Integer.parseInt(data.nextLine()) - 1;

            if (nPos >= aPers.length || nPos < 0)
                System.out.println("Debe ingresar desde la posicion 1 a la " + (aPers.length));
        } while (nPos >= aPers.length || nPos < 0);

        System.out.print("Ingrese la nueva edad: ");
        aPers[nPos].setEdad(Integer.parseInt(data.nextLine()));
        return nPos;
    }

    /*------------------------------------*/
    /* Busca una Persona por su dni */
    /*------------------------------------*/
    public static int buscaPersonaDniBinario(Persona[] aPers, String dni) {
        int central, izquierda, derecha;
        int nResulComp;
        izquierda = 0;
        derecha = aPers.length - 1;
        while (izquierda <= derecha) {
            central = (izquierda + derecha) / 2;
            nResulComp = aPers[central].getDni().compareToIgnoreCase(dni);
            if (nResulComp == 0)
                return central;
            else if (nResulComp > 0)
                derecha = central - 1;
            else
                izquierda = central + 1;
        }
        return -1;
    }
}
