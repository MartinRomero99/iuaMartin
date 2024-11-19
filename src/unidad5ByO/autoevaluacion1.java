package unidad5ByO;

import java.util.Arrays;
import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class autoevaluacion1 {
    public static void main(String[] args) {
        Salida.mMensaje("Hola, luego del ingreso de datos, se cambiará el orden para una mejor búsqueda",
                "Bienvenido");
        int n = ingresarElementos();
        String[] ingresoDatos = new String[n];
        cargarArraysString(ingresoDatos, n);
        Arrays.sort(ingresoDatos);
        buscarElementos(ingresoDatos);
    }

    private static int ingresarElementos() {
        int n = 0;
        while (true) {
            try {
                n = Ingreso.datoEntero("Ingrese la cantidad de elementos que desea cargar:",
                        "Cantidad de elementos", 1);
                if (n > 0) {
                    break;
                }
            } catch (Exception e) {
                Salida.mMensaje("No ingresaste un número válido.", "Error!");
            }
        }
        return n;
    }

    private static void cargarArraysString(String[] ingresoDatos, int n) {
        for (int i = 0; i < n; i++) {
            ingresoDatos[i] = Ingreso.datoString("Cargue datos del elemento " + (i + 1) + ":",
                    "Carga de elementos", 1);
        }
    }

    public static void buscarElementos(String[] ingresoDatos) {
        String elementoBuscado = Ingreso.datoString("Ingrese elemento a buscar", "Encontrar elementos", 1);
        int resultado = Arrays.binarySearch(ingresoDatos, elementoBuscado);
        if (resultado >= 0) {
            Salida.mMensaje("Elemento encontrado en la posición " + (resultado + 1),
                    "Resultado de búsqueda");
        } else {
            Salida.mMensaje("No se encontró el elemento buscado", "Error!");
        }

    }
}
