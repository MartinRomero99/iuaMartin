package AO.act2.Clases;

import javax.swing.JOptionPane;
import zinputOuput.Ingreso;

public class CursoPresencial extends Curso {

    // ATRIBUTOS PARTICULARES DE LA CLASE
    public String ubicacion;
    public double horario;

    public CursoPresencial(String nombreCurso, int duracion, int matriculaAlumnos, double costoPorEstudiante,
            String ubicacion, Double horario) {
        super(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante);
    }

    public CursoPresencial() {
    }

    // GETTERS
    public String getUbicacion() {
        return ubicacion;
    }

    public Double getHorario() {
        return horario;
    }

    // METODO PARA CARGAR EL CURSO PRSENCIAL
    public void cargarCursoPresencial() {
        boolean error;
        super.cargarCurso();
        do {
            error = false;
            try {
                // cargar la ubicacion
                this.ubicacion = Ingreso.datoString("Ingrese la ubicación del curso", "Registro de curso", 1);
                // cargar el horario en el que se dictara el curso
                this.horario = Ingreso.datoDoble("Ingrese el horario en el que se dictará el curso",
                        "Registro de curso", 1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos", "DATOS INCORRECTOS", 0);
                error = true;
            }

        } while (error);
    }

    // metodo Calculo costo
    @Override
    public double costoFinal() {
        return super.costoFinal();
    }
}
