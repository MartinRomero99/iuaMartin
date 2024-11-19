package AO.act2.Clases;

import javax.swing.JOptionPane;
import zinputOuput.Ingreso;

public class CursoHibrido extends Curso {

    // ATRIBUTOS PARTICULARES DE LA CLASE
    public String ubicacion;
    public String plataforma;
    public double horario;

    public CursoHibrido(String nombreCurso, int duracion, int matriculaAlumnos, double costoPorEstudiante,
            String ubicacion, String plataforma, double horario) {
        super(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante);
        this.ubicacion = ubicacion;
        this.plataforma = plataforma;
        this.horario = horario;
    }

    public CursoHibrido() {

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getHorario() {
        return horario;
    }

    // METODO PARA CARGAR EL CURSO HIBRIDO
    public CursoHibrido cargarCursoHibrido() {
        boolean error;
        super.cargarCurso();
        do {
            error = false;
            try {
                // cargar la ubicacion
                this.ubicacion = Ingreso.datoString("Ingrese la ubicación del curso", "Registro de curso", 1);
                // cargar la plataforma en la que se va a llevar a cabo el curso
                this.plataforma = Ingreso.datoString("Ingrese la plataforma donde se dictará", "Registro de curso",
                        1);
                // cargar el horario en el que se dictara el curso
                this.horario = Ingreso.datoDoble("Ingrese el horario en el que se dictará el curso",
                        "Registro de curso", 1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos", "DATOS INCORRECTOS", 0);
                error = true;
            }

        } while (error);
        return this;
    }

    /* --- Mostrar Curso Hibrido con JOptionPane ---- */
    @Override
    public void mostrarJOP() {
        super.mostrarJOP();
        JOptionPane.showMessageDialog(null,
                "Plataforma: " + plataforma + "\nHorario: " + horario + "\nUbicación: " + ubicacion);
    }

    @Override
    public double costoFinal() {
        if (matriculaAlumnos > 40) {
            return super.costoFinal() * .80;
        } else if (matriculaAlumnos > 20 && matriculaAlumnos <= 40) {
            return super.costoFinal() * 0.90;
        } else {
            return super.costoFinal();
        }
    }

}
