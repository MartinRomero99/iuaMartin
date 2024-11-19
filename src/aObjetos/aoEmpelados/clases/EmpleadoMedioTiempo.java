package aObjetos.aoEmpelados.clases;

/*--------------------------------------*/
/*  Clase derivada EmpleadoMedioTiempo  */
/*--------------------------------------*/
public class EmpleadoMedioTiempo extends Empleado {
    public EmpleadoMedioTiempo(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " (Empleado de medio tiempo) trabaja 4 horas al día.");
    }
}