package AO.act2.Clases;

import java.util.Arrays;
import javax.swing.JOptionPane;
import zinputOuput.Ingreso;
import zinputOuput.Salida;

public class Curso {
    // ATRIBUTOS
    public String nombreCurso;
    public int duracion; // en meses
    public int matriculaAlumnos;
    public double costoPorEstudiante;

    private static Curso[] listaCursos = new Curso[100]; // capacidad maxima de carga de cursos: 100
    private static int contadorCursos = 0; // llevara el numero de cursos creados
    private static double totalRecaudado = 0;

    // constructores
    public Curso(String nombreCurso, int duracion, int matriculaAlumnos, double costoPorEstudiante) {
        this.nombreCurso = nombreCurso;
        this.duracion = duracion;
        this.matriculaAlumnos = matriculaAlumnos;
        this.costoPorEstudiante = costoPorEstudiante;
    }

    public Curso() {
    }

    // getters y setters
    public String getNombreCurso() {
        return nombreCurso;
    }

    // public void setNombreCurso(String nombreCurso) {
    // this.nombreCurso = nombreCurso;
    // }

    public int getDuracion() {
        return duracion;
    }

    // public void setDuracion(int duracion) {
    // this.duracion = duracion;
    // }

    public int getMatriculaAlumnos() {
        return matriculaAlumnos;
    }

    // public void setMatriculaAlumnos(int matriculaAlumnos) {
    // this.matriculaAlumnos = matriculaAlumnos;
    // }

    public double getCostoPorEstudiante() {
        return costoPorEstudiante;
    }

    // public void setCostoPorEstudiante(double costoPorEstudiante) {
    // this.costoPorEstudiante = costoPorEstudiante;
    // }

    /*------------------------------------- */
    /* CARGAR CUENTA */
    /*------------------------------------- */
    public Curso cargarCurso() {
        String nombreCurso = null;
        int duracion = 0; // en meses
        int matriculaAlumnos = 0;
        double costoPorEstudiante = 0.0;
        boolean error = false;

        do {
            error = false;
            try {
                // cargar nombre del curso
                nombreCurso = Ingreso.datoString("Ingrese el nombre del curso", "Registro de curso", 1);

                // cargar duracion en dias del curso
                duracion = Ingreso.datoEntero("Ingrese la duracion del curso en meses", "Registro de curso",
                        1);

                // cargar matricula de alumnos del curso
                matriculaAlumnos = Ingreso.datoEntero("Ingrese la matricula del curso", "Registro de curso", 1);

                // cargar costo por estudiante
                costoPorEstudiante = Ingreso.datoDoble("Ingrese el costo por alumno", "Registro de curso", 1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos", "DATOS INCORRECTOS", 0);
                error = true;
            }
        } while (error);
        return new Curso(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante);
    }

    // METODO PARA AGREGAR CURSOS A LA LISTA

    public static boolean esVacio(Curso[] listaCursos) {
        for (Curso curso : listaCursos) {
            if (curso != null) {
                return false;
            }
        }
        return true;
    }

    // Mostrar un CURSO con JOptionPane
    public void mostrarJOP() {
        String datos = "Nombre: " + nombreCurso +
                "\nDuración: " + duracion +
                " horas\nMatrícula: " + matriculaAlumnos +
                "\nCosto por Estudiante: $" + costoPorEstudiante;
        JOptionPane.showMessageDialog(null, datos);

    }

    public double costoFinal() {
        return costoPorEstudiante * matriculaAlumnos;
    }

    // METODO PARA REGISTRAR LOS CURSOS
    public static void registrarCurso() {
        if (contadorCursos >= listaCursos.length) {
            Salida.mMensaje("No hay cursos registrados", "LISTA VACIA");
            return;
        }

        String nombreCurso = Ingreso.datoString("Ingrese el nombre del curso: ", "DATOS DEL INGRESO DEL CURSO", 1);
        int duracion = Ingreso.datoEntero("Ingrese la duración del curso en meses: ", "DATOS DEL INGRESO DEL CURSO", 1);
        int matriculaAlumnos = Ingreso.datoEntero("Ingrese la cantidad de alumnos inscriptos: ",
                "DATOS DEL INGRESO DEL CURSO", 1);
        double costoPorEstudiante = Ingreso.datoDoble("Ingrese el costo del curso : ", "DATOS DEL INGRESO DEL CURSO",
                1);
        String modalidad = (String) JOptionPane.showInputDialog(null, "Seleccione la modalidad", "Modalidad",
                JOptionPane.PLAIN_MESSAGE, null, new String[] { "Presencial", "Online", "Híbrido" }, "Presencial");

        Curso curso = null;
        switch (modalidad) {
            case "Presencial":
                String ubicacion = Ingreso.datoString("Ingrese la ubicación del curso", "DATOS DEL INGRESO DEL CURSO",
                        1);
                Double horario = Ingreso.datoDoble("Ingrese el horario del curso", "DATOS DEL INGRESO DEL CURSO", 1);
                curso = new CursoPresencial(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante, ubicacion,
                        horario);
                break;

            case "Online":
                horario = Ingreso.datoDoble("Ingrese el horario del curso : ", "DATOS DEL INGRESO DEL CURSO", 1);
                String plataforma = Ingreso.datoString("Ingrese la plataforma donde se va a dictar el curso",
                        "DATOS DEL INGRESO DEL CURSO", 1);
                curso = new CursoOnline(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante,
                        plataforma, horario);
                break;

            case "Híbrido":
                ubicacion = Ingreso.datoString("Ingrese la ubicación del curso", "DATOS DEL INGRESO DEL CURSO", 1);
                plataforma = Ingreso.datoString("Ingrese la plataforma donde se va a dictar el curso",
                        "DATOS DEL INGRESO DEL CURSO", 1);
                horario = Ingreso.datoDoble("Ingrese el horario del curso : ", "DATOS DEL INGRESO DEL CURSO", 1);
                curso = new CursoHibrido(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante, ubicacion,
                        plataforma, horario);
                break;
        }
        if (curso != null) {
            listaCursos[contadorCursos++] = curso; // agregamos un curso a la lista y suma uno en el contador para no
                                                   // exceder la capacidad maxima.
            totalRecaudado += curso.costoFinal(); // la multiplicacion por matricula debe ir aca porq
                                                  // es propia de cada curso.
            Salida.mMensaje("¡¡Curso regitrado con Exito!!", "FELICITACIONES");
        }
    }

    public static void listarCursos() {
        if (contadorCursos == 0) {
            Salida.mMensaje("No hay cursos que mostrar, primero debe crearlos", "LISTA VACIA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorCursos; i++) {
            sb.append(listaCursos[i].getNombreCurso()).append("\n");
        }
        Salida.mMensaje(sb.toString(), "Lista de cursos creados");
    }

    public static void calcularCostoFinal() {
        if (contadorCursos == 0) {
            Salida.mMensaje("No hay cursos que mostrar, primero debe crearlos", "LISTA VACIA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorCursos; i++) {
            sb.append(listaCursos[i].getNombreCurso()).append(": $").append(listaCursos[i].costoFinal()).append("\n");
        }
        Salida.mMensaje(sb.toString(), "Costo Final de Cursos");
    }

    // METODO MOSTRAR CURSOS CON DATOS ORDENADOS POR CANTIDAD DE MATRICULA DE MANERA
    // ASCENDENTE
    public static void mostrarCursosOrdenados() {
        Curso[] cursosOrdenados = Arrays.copyOf(listaCursos, contadorCursos);
        Arrays.sort(cursosOrdenados, (a, b) -> Integer.compare(a.getMatriculaAlumnos(), b.getMatriculaAlumnos()));

        StringBuilder sb = new StringBuilder();
        for (Curso curso : cursosOrdenados) {
            sb.append(curso.getNombreCurso()).append("Matricula: ").append(curso.getMatriculaAlumnos()).append("\n");
        }
        Salida.mMensaje(sb.toString(), "Cursos ordenados de manera ascendente por número de matricula");
    }

    public static void buscarCursoPorNombre() {
        if (contadorCursos == 0) {
            Salida.mMensaje("No hay cursos registrados. Primero debe crearlos.", "LISTA VACIA");
            return;
        }
        String nombreBuscado = Ingreso.datoString("Ingrese el nombre del curso que desea buscar", "Buscar Curso", 1);
        boolean cursoEncontrado = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorCursos; i++) {
            if (listaCursos[i].getNombreCurso().equalsIgnoreCase(nombreBuscado)) {
                sb.append("Curso encontrado:\n")
                        .append("Nombre: ").append(listaCursos[i].getNombreCurso()).append("\n")
                        .append("Duración: ").append(listaCursos[i].getDuracion()).append(" meses\n")
                        .append("Cantidad de alumnos: ").append(listaCursos[i].getMatriculaAlumnos()).append("\n")
                        .append("Costo por estudiante: $").append(listaCursos[i].getCostoPorEstudiante()).append("\n")
                        .append("Costo final: $").append(listaCursos[i].costoFinal()).append("\n");
                cursoEncontrado = true;
                Salida.mMensaje(sb.toString(), "Curso Encontrado");
                break;
            }
        }
        if (cursoEncontrado == false) {
            Salida.mMensaje("No se encontró un curso con el nombre: " + nombreBuscado, "Resultado de la búsqueda");
        }
    }

    public static void mostrarTotalRecaudado() {
        Salida.mMensaje("El total recaudado entre todos los cursos es: $" + totalRecaudado, "TOTAL RECAUDADO");
    }

    public static void eliminarCursoPorNombre() {
        if (contadorCursos == 0) {
            Salida.mMensaje("No hay cursos registrados. Primero debe crearlos.", "LISTA VACIA");
            return;
        }
        String nombreAEliminar = Ingreso.datoString("Ingrese el nombre del curso que desea buscar", "Buscar Curso", 1);
        boolean cursoEliminado = false;

        for (int i = 0; i < contadorCursos; i++) {
            if (listaCursos[i].getNombreCurso().equalsIgnoreCase(nombreAEliminar)) {
                for (int j = i; j < contadorCursos - 1; j++) {
                    listaCursos[j] = listaCursos[j + 1];
                }
                listaCursos[contadorCursos - 1] = null; // convertir al ultimo array en un null vacio
                contadorCursos--;
                cursoEliminado = true;
                Salida.mMensaje("El curso '" + nombreAEliminar + "' ha sido eliminado con éxito.", "Curso Eliminado");
                break;
            }
        }
        if (cursoEliminado == false) {
            Salida.mMensaje("No se encontró un curso con el nombre: " + nombreAEliminar, "Resultado de la búsqueda");
        }
    }
}
