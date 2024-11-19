package aObjetos.aoAnimales;

import aObjetos.aoAnimales.clases.*;

public class DemoPolimorfismo {
    public static void main(String[] args) {
        /*------------------------------------- */
        /* Creamos un Array de objetos Animales */
        /*------------------------------------- */
        Animales[] animales = new Animales[3];

        /*------------------------------------------------ */
        /* Creamos distintos tipos de Animales en el array */
        /*------------------------------------------------ */
        animales[0] = new Perro();
        animales[1] = new Gato();
        animales[2] = new Pajaro();

        /*------------------------------------------------ */
        /* Uso de polimorfismo para llamar al método 
        /* hacerSonido() de cada Objeto*/
        /*------------------------------------------------ */
        for (Animales animal : animales) {
            animal.hacerSonido();
        }
    }
}
