package practicosDeClase;

import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class Estudiantes {
    public static void main(String[] args) {
        String[] aNombres;
        int[] aLegajos;
        int[] aNotas;
        int n = Ingreso.datoEntero("Ingrese la cantidad de estudiantes", "Ingreso de datos", 1);
        aNombres = new String[n];
        aLegajos = new int[n];
        aNotas = new int[n];

        cargarEstudiante(aNombres, aLegajos, aNotas);
        mostrarEstudiantes(aNombres, aLegajos, aNotas);

        int iTemp = posicionMayorNota(aNotas);
        Salida.mMensaje("El alumno con mayor nota es: " + aNombres[iTemp] + " con el número de legajo: "
                + aLegajos[iTemp] + " con la nota: " + aNotas[iTemp], "Mejor alumno");
    }

    // cargar array
    public static void cargarEstudiante(String[] aName, int[] aLeg, int[] aNota) {
        String cTitulo = "Ingreso estudiante ";
        for (int i = 0; i < aName.length; i++) {
            cTitulo = cTitulo + " " + (i + 1);
            aName[i] = Ingreso.datoString("Ingrese el nombre del estudiante: ", cTitulo, 1);
            aLeg[i] = Ingreso.datoEntero("Ingrese el número del legajo: ", cTitulo, 1);
            aNota[i] = Ingreso.datoEntero("Ingrese la nota del estudiantes: ", cTitulo, 1);
        }
    }

    public static void mostrarEstudiantes(String[] aName, int[] aLeg, int[] aNota) {
        StringBuilder sData = new StringBuilder();
        String mensaje;
        for (int i = 0; i < aName.length; i++) {
            mensaje = String.format("Nombre del estudiante: %s \nLegajo: %d \nNota: %d\n======\n", aName[i], aLeg[i],
                    aNota[i]);
            System.out.println(mensaje);
            sData.append(mensaje);
        }
        Salida.mMensaje(sData.toString(), "Datos de estudiantes");
    }

    public static int posicionMayorNota(int[] aNota) {
        int notaMayor = 0;
        int nPos = 0;
        for (int i = 0; i < aNota.length; i++) {
            if (aNota[i] > notaMayor) {
                notaMayor = aNota[i];
                nPos = i;
            }
        }
        return nPos;
    }

    /*--------------------------------------------------------- */
    /* Ordena de mayor a menor las notas de los alumnos */
    /*
     * Si cambiamos el orden de las notas debemos cambiar tambien el de los alumnos
     * /* Utilizamos el Método de la Burbuja
     */
    public static void ordenaNotasAlumnos(int aLegajos[], String aAlumnos[], int aNotas[]) {
        boolean interruptor = true;
        for (int pasada = 0; pasada < aNotas.length - 1 && interruptor; pasada++) { // bucle externo controla la
                                                                                    // cantidad
                                                                                    // de pasadas
            interruptor = false; // no se han hecho intercambios todavía
            for (int j = 0; j < aNotas.length - pasada - 1; j++)
                // bucle interno controla cada pasada
                if (aNotas[j] < aNotas[j + 1]) {
                    // elementos desordenados: es necesario intercambio
                    int Iaux;
                    String Saux;
                    interruptor = true;
                    /* CAMBIA EL ORDEN DEL VECTOR NOTAS */
                    Iaux = aNotas[j];
                    aNotas[j] = aNotas[j + 1];
                    aNotas[j + 1] = Iaux;
                    /* CAMBIA EL ORDEN DEL VECTOR LEGAJOS */
                    Iaux = aLegajos[j];
                    aLegajos[j] = aLegajos[j + 1];
                    aLegajos[j + 1] = Iaux;
                    /* CAMBIA EL ORDEN DEL VECTOR NOMBRES */
                    Saux = aAlumnos[j];
                    aAlumnos[j] = aAlumnos[j + 1];
                    aAlumnos[j + 1] = Saux;
                }
        }
    }
}