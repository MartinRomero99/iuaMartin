package aObjetos.aoEmpelados.clases;

/*-----------------------------------------*/
/*  Clase derivada EmpleadoTiempoCompleto  */
/*-----------------------------------------*/
public class EmpleadoTiempoCompleto extends Empleado {
    public EmpleadoTiempoCompleto(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " (Empleado de tiempo completo) trabaja 8 horas al día.");
    }
}