package AO.act2.Clases;

public class CursoOnline extends Curso {

    // ATRIBUTOS PARTICULARES DE LA CLASE

    public String plataforma;
    public double horario;

    public CursoOnline(String nombreCurso, int duracion, int matriculaAlumnos, double costoPorEstudiante,
            String plataforma, double horario) {
        super(nombreCurso, duracion, matriculaAlumnos, costoPorEstudiante);
        this.plataforma = plataforma;
        this.horario = horario;
    }

    public CursoOnline() {
    }

    // getters
    public String getPlataforma() {
        return plataforma;
    }

    public double getHorario() {
        return horario;
    }

    @Override
    public double costoFinal() {
        return super.costoFinal() * 0.85;
    }

}
