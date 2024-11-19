package aObjetos.aoEmpelados;

import aObjetos.aoEmpelados.clases.*;

public class DemoEmpleados {
    public static void main(String[] args) {
        // Array de objetos de tipo Empleado
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new EmpleadoTiempoCompleto("Ana");
        empleados[1] = new EmpleadoMedioTiempo("Juan");
        empleados[2] = new EmpleadoTiempoCompleto("Luis");

        /*------------------------------------*/
        /* Usando polimorfismo con instanceof */
        /*------------------------------------*/
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoTiempoCompleto) {
                System.out.println(empleado.getNombre() + ": es un empleado de tiempo completo.");
            }
            if (empleado instanceof EmpleadoMedioTiempo) {
                System.out.println(empleado.getNombre() + ": es un empleado de medio tiempo.");
            }
            /*--------------------------------*/
            /* Llamada al método POLIMORFICA */
            /*--------------------------------*/
            empleado.trabajar();
            System.out.println("\n");
        }

        String nameClase, nameComplet;
        /*--------------------------------*/
        /* Obtiene el nombre de la clase */
        /*--------------------------------*/
        for (Empleado empleado : empleados) {
            nameClase = empleado.getClass().getSimpleName(); /*Obtiene el nombre de la clase instanciada */
            nameComplet = empleado.getClass().getName(); /*Obtiene el nombre completo de la clase*/ 
            System.out.println("\n"+nameClase);
            System.out.println(nameComplet);
        }
    }
}