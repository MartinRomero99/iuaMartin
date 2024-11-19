package AO.act2;

import javax.swing.JOptionPane;

import AO.act2.Clases.Curso;

//MENU OPCIONES
// metodo para cargar cursos
// listar los cursos registrados. Mostrar con un get
// calcular y mostrar el costo total de cada curso - METOS INDIVIUALES POR CURSO. 
// mostrar cursos (con sus datos) ordenados por matricula (cantidad alumnos inscriptos) en orden ascendente
// buscar curso por su nombre
// mostrar recaudado por curso de manera ordenada y el total entre todos.
// inventar una opcion
public class demoCurso {

    public static void main(String[] args) {

        // int n = Ingreso.datoEntero("Ingrese la cantidad de cursos a cargar", "Ingreso
        // de datos", 1);
        // Curso[] listaCursos = new Curso[n];

        boolean salir = false;
        while (!salir) {
            String[] opciones = { "Registrar un nuevo curso", "Listar cursos registrados",
                    "Calcular costo final de cada curso", "Mostrar cursos ordenados por cantidad de matricula",
                    "Buscar curso por nombre", "Mostrar total recaudado", "Borrar curso", "Salir" };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Gestión de Cursos",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                salir = true;
            } else {
                switch (seleccion) {

                    case "Registrar un nuevo curso":
                        Curso.registrarCurso();
                        break;

                    case "Listar cursos registrados":
                        Curso.listarCursos();
                        break;

                    case "Calcular costo final de cada curso":
                        Curso.calcularCostoFinal();
                        break;

                    case "Mostrar cursos ordenados por cantidad de matricula":
                        Curso.mostrarCursosOrdenados();
                        break;

                    case "Buscar curso por nombre":
                        Curso.buscarCursoPorNombre();
                        break;

                    case "Mostrar total recaudado":
                        Curso.mostrarTotalRecaudado();
                        break;
                    case "Borrar curso":
                        Curso.eliminarCursoPorNombre();
                    case "Salir":
                        break;
                }
            }
        }
    }

}
