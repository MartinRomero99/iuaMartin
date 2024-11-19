package aObjetos.aoEmpelados.clases;

/*------------------------------ */
/* Clase Base| Padre -> Empleado */
/*------------------------------ */
public class Empleado {
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void trabajar() {
        System.out.println(nombre + " está trabajando.");
    }
}