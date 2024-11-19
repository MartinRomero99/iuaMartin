package unidad5ByO;

import java.util.Arrays;

import javax.swing.JOptionPane;

import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class autoevaluacion2 {

    public static void main(String[] args) {
        int[] codigos = new int[100];
        String[] nombres = new String[100];
        double[] precios = new double[100];
        int cantidadProductos = 0;
        boolean salir = false;

        while (!salir) {
            String[] opciones = { "Ingresar Datos", "Mostrar Lista", "Ordenar por número de código",
                    "Búsqueda lineal por N° de código", "Búsqueda binaria por N° de código",
                    "Producto con mayor precio", "Salir" };
            String selecOpcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                    "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (selecOpcion == null || selecOpcion.equals("Salir")) {
                salir = true;
            } else {
                switch (selecOpcion) {
                    case "Ingresar Datos":
                        cantidadProductos = ingresoDatos(codigos, nombres, precios, cantidadProductos);
                        break;
                    case "Mostrar Lista":
                        if (cantidadProductos == 0) {
                            noHayCursosDisponibles();
                        } else {
                            imprimirVector(codigos, nombres, precios, cantidadProductos);
                        }
                        break;

                    case "Ordenar por número de código":
                        if (cantidadProductos == 0) {
                            noHayCursosDisponibles();
                        } else {
                            ordenarProductos(codigos, nombres, precios, cantidadProductos);
                            imprimirVector(codigos, nombres, precios, cantidadProductos);
                        }
                        break;

                    case "Búsqueda lineal por N° de código":
                        if (cantidadProductos == 0) {
                            noHayCursosDisponibles();
                        } else {
                            busquedaLineal(codigos, nombres, precios, cantidadProductos);
                        }
                        break;

                    case "Búsqueda binaria por N° de código":
                        if (cantidadProductos == 0) {
                            noHayCursosDisponibles();
                        } else {
                            ordenarProductos(codigos, nombres, precios, cantidadProductos);
                            busquedaBinaria(codigos, nombres, precios, cantidadProductos);
                        }
                        break;

                    case "Producto con mayor precio":
                        if (cantidadProductos == 0) {
                            noHayCursosDisponibles();
                        } else {
                            productoMayorPrecio(codigos, nombres, precios, cantidadProductos);
                        }
                        break;
                }
            }
        }
    }

    public static int ingresoDatos(int[] codigos, String[] nombres, double[] precios, int cantidadProductos) {
        try {
            while (cantidadProductos < codigos.length) {
                int codigo = Ingreso.datoEntero(
                        "Ingrese el código del producto " + (cantidadProductos + 1)
                                + ". Si desea salir, ingrese 0 o número menor",
                        "Código", 1);
                if (codigo <= 0) {
                    break;
                }
                String nombre = Ingreso.datoString("Ingrese el nombre del producto", "Nombre", 1);
                double precio = 0;
                boolean precioValido = false;
                while (!precioValido) {
                    try {
                        precio = Ingreso.datoDoble("Ingrese el precio del producto", "Precio", 1);
                        if (precio < 0) {
                            Salida.mError("No es posible cargar un precio negativo, intente nuevamente", "Error");
                        } else {
                            precioValido = true;
                        }
                    } catch (NumberFormatException e) {
                        Salida.mError("Ingrese un número válido para el precio.", "Error");
                    }
                }
                codigos[cantidadProductos] = codigo;
                nombres[cantidadProductos] = nombre;
                precios[cantidadProductos] = precio;
                cantidadProductos++;
            }
        } catch (NumberFormatException e) {
            Salida.mError("Error en el ingreso de datos. Por favor, ingrese valores válidos.",
                    "Error");
        }
        return cantidadProductos;
    }

    public static void ordenarProductos(int[] codigos, String[] nombres, double[] precios, int cantidadProductos) {
        for (int i = 1; i < cantidadProductos; i++) {
            int actualCodigo = codigos[i];
            String actualNombre = nombres[i];
            double actualPrecio = precios[i];
            int j = i - 1;
            while (j >= 0 && codigos[j] > actualCodigo) {
                codigos[j + 1] = codigos[j];
                nombres[j + 1] = nombres[j];
                precios[j + 1] = precios[j];
                j--;
            }
            codigos[j + 1] = actualCodigo;
            nombres[j + 1] = actualNombre;
            precios[j + 1] = actualPrecio;
        }
    }

    public static void busquedaBinaria(int[] codigos, String[] nombres, double[] precios, int cantidadProductos) {
        ordenarProductos(codigos, nombres, precios, cantidadProductos);
        int elementoBuscado = Ingreso.datoEntero("Ingrese elemento a buscar", "Encontrar elemento", 1);
        int resultado = Arrays.binarySearch(codigos, 0, cantidadProductos, elementoBuscado);
        if (resultado >= 0) {
            JOptionPane.showMessageDialog(null,
                    "Producto encontrado:\nCódigo: " + codigos[resultado] + "\nNombre: " + nombres[resultado]
                            + "\nPrecio: $" + precios[resultado],
                    "Resultado de búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto con el código ingresado.", "No encontrado",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void busquedaLineal(int[] codigos, String[] nombres, double[] precios, int cantidadProductos) {
        int codigoBuscado = Ingreso.datoEntero("Ingrese el elemento a buscar", "Encontrar elemento", 1);
        boolean encontrado = false;

        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i] == codigoBuscado) {
                Salida.mMensaje(
                        "Código encontrado: " + codigos[i] + "\nCon nombre: " + nombres[i]
                                + "\nPrecio: $" + precios[i],
                        "Resultado de búsqueda");
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            Salida.mError("Código no encontrado o producto inexistente ", "Error");
        }
    }

    public static void productoMayorPrecio(int[] codigos, String[] nombres, double[] precios, int cantidadProductos) {
        if (cantidadProductos > 0) {
            int indiceMayor = 0;
            for (int i = 1; i < cantidadProductos; i++) {
                if (precios[i] > precios[indiceMayor]) {
                    indiceMayor = i;
                }
            }
            JOptionPane.showMessageDialog(null,
                    "El producto con mayor precio es:\nCódigo: " + codigos[indiceMayor] + "\nNombre: "
                            + nombres[indiceMayor] + "\nPrecio: $" + precios[indiceMayor],
                    "Producto con mayor precio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void imprimirVector(int[] codigoProducto, String[] nombreProducto, double[] precios,
            int contador) {

        StringBuilder mensaje = new StringBuilder("Productos ordenados por Código:\n");
        for (int i = 0; i < contador; i++) {
            mensaje.append("Codigo: ").append(codigoProducto[i]).append(", Nombre: ").append(nombreProducto[i])
                    .append(", Precio: ").append(precios[i]).append("\n");
        }
        Salida.mMensaje(mensaje.toString(), "Resultado");
    }

    public static void noHayCursosDisponibles() {
        Salida.mMensaje("No hay elementos registrados, primero debe crearlos.", "Error");
    }
}