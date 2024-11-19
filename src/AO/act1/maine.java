package AO.act1;
/*Descripción Detallada del Juego:
1. Ingreso del Número de Jugadores:
2. Intentos y Registro de Errores:
número aleatorio entre 1 y 100
proporcionar una retroalimentación si el número ingresado es mayor, menor o igual:
o Si el número ingresado es mayor que el número secreto, el programa debe mostrar un
mensaje indicando que el número es "demasiado alto".
o Si el número ingresado es menor que el número secreto, el programa debe mostrar un
mensaje indicando que el número es "demasiado bajo".
o Si el número ingresado es igual al número secreto, el programa debe felicitar al usuario por
haber adivinado correctamente y finalizar la ejecución. (TERMINA PARA TODOS?)
o Por cada intento incorrecto, el jugador acumulará un error.
3. Tiempo de Juego por Jugador:
o Se registrará el tiempo en segundos que tardó cada jugador en completar la adivinanza.
4. Cálculo de Resultados:
el menor número de intentos.
el menor tiempo posible
El promedio de errores será calculado dividiendo el total de errores cometidos entre todos los
jugadores por el número de jugadores.
El premio se otorgará al jugador que haya adivinado el número en el menor número de
intentos y con el menor número de errores. */

import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class maine {
    public static void main(String[] args) {
        /* --------------- MENSAJE BIENVENIDA Y REGLAS DEL JUEGO ------------- */
        Salida.mMensaje(
                "Bienvenidos a The Secret Number, el juego donde debera adivinar el numero secreto genereado por la PC",
                "A JUGAR");
        Salida.mMensaje(
                "El juego consiste en ingresar un numero del 1-100.\n\nMediante mensajes orientativos que ejecutará el ordenador,\n debera guiarse e ir ingresando numeros repetidas veces hasta que llegue al número secreto",
                "REGLAS DEL JUEGO");

        Salida.mMensaje("Ahora si, comencemos!!!", "");

        /* --------------- INGRESO CANTIDAD DE PARTICIPANTES --------------- */
        int cantJug;
        cantJug = Ingreso.datoEntero("Ingrese la cantidad de jugadores",
                "NÚMERO DE PARTICIPANTES", 1);

        // CREAR arrayS NOMBRES
        String[] participantes = new String[cantJug];
        // CARGAR arraysNombres
        cargarNombresParticipantes(cantJug, participantes);

        // CREAR ARRAYS INTENTOS Y TIEMPOS E IR CARGANDO A MEDIDA QUE SE VA JUGANDO
        int[] cantIntentos = new int[cantJug];
        long[] tiempos = new long[cantJug];
        adivinarElNumero(cantJug, participantes, cantIntentos, tiempos);

        // crear arreglo errores
        int[] errores = new int[cantJug];
        cargarCantErrores(cantJug, cantIntentos, errores);

        Salida.mMensaje(
                "El juego ha finalizado, a continuación podra encontrar un menú de opciones para leer los resultados",
                "GRACIAS POR PARTICIPAR");

        // MENU DE OPCIONES
        menuOpciones(cantJug, participantes, cantIntentos, tiempos, errores);
    } // FIN DEL MAIN

    // METODO PRINCIPAL - CANTIDAD DE INTENTOS.
    public static void adivinarElNumero(int cantJug, String[] participantes, int[] cantIntentos, long[] tiempos) {

        Instant inicio;
        int datoIngresado;
        int totalIntentos;

        for (int i = 0; i < cantJug; i++) {

            int aleatorio = (int) ((Math.random() * 100) + 1);
            totalIntentos = 1;
            inicio = Instant.now();

            do {

                datoIngresado = Ingreso.datoEntero("Ingrese un número, Jugador " + participantes[i],
                        "Adivina el número", 1);
                if (aleatorio == datoIngresado) {
                    Salida.mMensaje("¡Has acertado! \n el número a encontrar era: " + aleatorio
                            + "\n Total de intentos realizados: " + totalIntentos, "Adivina el número");
                    break;
                } else if (aleatorio > datoIngresado)
                    Salida.mMensaje("El número secreto es MAYOR que " + datoIngresado + "\nVuelva a intentarlo",
                            "Adivina el número");
                else if (aleatorio < datoIngresado)
                    Salida.mMensaje("El número secreto es MENOR que " + datoIngresado + "\nVuelva a intentarlo",
                            "Adivina el número");

                totalIntentos++;

            } while (datoIngresado != aleatorio);

            cantIntentos[i] = totalIntentos; // se guarda la cantidad de intentos generados por cada participante

            // medimos el tiempo que transcurrio en ingresar los intentos.
            Instant fin = Instant.now();
            Duration tiempoTranscurrido = Duration.between(inicio, fin);
            Salida.mMensaje("El tiempo trascurrido fue de: " + tiempoTranscurrido.toSeconds() + " segundos",
                    "TIEMPO TRANSCURRIDO");
            tiempos[i] = (int) tiempoTranscurrido.toSeconds();
        }
    }

    // METODO PARA CARGAR EL ARRAYS NOMBRES
    public static void cargarNombresParticipantes(int cantJug, String[] participantes) {
        for (int i = 0; i < cantJug; i++) {
            participantes[i] = Ingreso.datoString("Ingrese el Nombre del participante N° " + (i + 1) + ":",
                    "INGRESAR PARTICIPANTES", 1);
        }
    }

    // METODO PARA CARGAR EL ARRAYS ERRORES
    public static void cargarCantErrores(int cantJug, int[] cantIntentos, int[] errores) {
        for (int i = 0; i < cantJug; i++) {
            errores[i] = (cantIntentos[i] - 1);
        }
    }

    // METODO MENU DE OPCIONES
    public static void menuOpciones(int cantJug, String[] participantes, int[] cantIntentos, long[] tiempos,
            int[] errores) {

        boolean salir = false;
        while (!salir) {
            String[] opciones = { "Nombre del Ganador", "Nombre del Jugador más Rápido", "Nombre del Jugador más Lento",
                    "Promedio", "Informe Final", "Salir" };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Gestión de Cursos",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
            } else {
                switch (seleccion) {

                    case "Nombre del Ganador" -> {
                        String mensaje = nombreGanador(cantIntentos, participantes, tiempos);
                        Salida.mMensaje(mensaje, "GANADOR DEL JUEGO");
                        break;
                    }

                    case "Nombre del Jugador más Rápido" -> {
                        String mensaje = jugadorMasRapido(cantJug, errores, participantes);
                        Salida.mMensaje(mensaje, "JUGADOR MAS RAPIDO");
                        break;
                    }

                    case "Nombre del Jugador más Lento" -> {
                        String mensaje = jugadorMasLento(cantJug, errores, participantes);
                        Salida.mMensaje(mensaje, "JUGADOR MAS LENTO");
                        break;
                    }

                    case "Promedio" -> {
                        String mensaje = promedio(cantJug, errores);
                        Salida.mMensaje(mensaje, "PROMEDIO DE ERRORES");
                        break;
                    }

                    case "Informe Final" -> {
                        String mensajeGanador = nombreGanador(cantIntentos, participantes, tiempos);
                        String mensajePromedio = promedio(cantJug, errores);
                        String mensajeRapido = jugadorMasRapido(cantJug, cantIntentos, participantes);

                        StringBuilder sb = new StringBuilder();
                        sb.append("Informe final del juego\n")
                                .append("-----------------------------------\n")
                                .append(mensajeGanador).append("\n")
                                .append(mensajePromedio).append("\n")
                                .append(mensajeRapido).append("\n");
                        Salida.mMensaje(sb.toString(), "INFORME FINAL");
                    }

                    case "Salir" -> {
                        break;
                    }
                }
            }
        }
    }

    // metodo opcion Ganador (jugador con menos intentos, desempata por tiempo si es
    // necesario)
    public static String nombreGanador(int[] cantIntentos, String[] participantes, long[] tiempos) {

        int i;
        int ganador = 0;
        int minimoIntentos = Integer.MAX_VALUE; // se inicializa con el valor mas alto posible.

        for (i = 0; i < cantIntentos.length; i++) {
            if (cantIntentos[i] < minimoIntentos) {
                // si encontramos un jugador con menos intentos, lo elegimos como ganador.
                minimoIntentos = cantIntentos[i];
                ganador = i;
            } else if (cantIntentos[i] == minimoIntentos && tiempos[i] < tiempos[ganador]) {
                ganador = i;
            }
        }
        return "El participante ganador es: " + participantes[ganador] +
                "\nCantidad de intentos: " + cantIntentos[ganador] +
                "\nTiempo: " + (double) tiempos[ganador] + " segundos";
    }

    public static String jugadorMasRapido(int cantJug, int[] tiempos, String[] participantes) {
        int indiceMasRapido = 0;
        for (int i = 1; i < cantJug; i++) {
            if (tiempos[i] < tiempos[indiceMasRapido]) {
                indiceMasRapido = i;
            }
        }
        return "El jugador más rápido es: " + participantes[indiceMasRapido] + "\nTiempo: " + tiempos[indiceMasRapido]
                + " segundos";
    }

    public static String jugadorMasLento(int cantJug, int[] tiempos, String[] participantes) {
        int indiceMasLento = 0;
        for (int i = 1; i < cantJug; i++) {
            if (tiempos[i] > tiempos[indiceMasLento]) {
                indiceMasLento = i;
            }
        }
        return "El jugador más lento es: " + participantes[indiceMasLento] + "\nTiempo: " + tiempos[indiceMasLento]
                + " segundos";
    }

    // metodo promedio
    public static String promedio(int cantJug, int[] errores) {
        int sumaErrores = 0;
        for (int i = 0; i < cantJug; i++) {
            sumaErrores += errores[i];
        }
        double promedio = (double) sumaErrores / cantJug;

        return "El promedio de errores entre la totalidad de jugadores es de: " + promedio;

    }
}
