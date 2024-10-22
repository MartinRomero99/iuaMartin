package clase3.POO;

import java.util.Scanner;

public class Circulo {
    /* Atributos de la clase */
    public double radio;
    public String colorBorde;
    public String colorFondo;

    /* constructores */
    // sin argumentos
    public Circulo() {
        this.radio = 0;
        this.colorBorde = "";
        this.colorFondo = "";
    }

    // con argumentos
    public Circulo(double r, String cb, String cf) {
        this.radio = r;
        this.colorBorde = cb;
        this.colorFondo = cf;
    }

    // Muestra los atributos del objeto
    @Override
    public String toString() {
        return "Circulo [radio=" + radio + ", colorBorde=" + colorBorde + ", colorFondo=" + colorFondo + "]";
    }

    public void mostrarDatos() {
        System.out.println("Datos del circulo");
        System.out.println("El radio es: " + this.radio);
        System.out.println("El color del borde es: " + this.colorBorde);
        System.out.println("El color del fondo es: " + this.colorFondo);
    }

    public double calculaPerimetro() {
        double perim;
        perim = 2 * Math.PI * this.radio;
        return perim;
    }

    public double calcularArea() {
        double area;
        area = Math.PI * Math.pow(this.radio, 2);
        return area;
    }

    public void cargaDatosCirculo(Scanner sc) {
        // Ingresar por teclado
        System.out.println("Ingrese el radio ");
        this.radio = Double.parseDouble(sc.nextLine());
        System.out.println("Ingrese el color del borde");
        this.colorBorde = sc.nextLine();
        System.out.println("Ingrese el color del fondo");
        this.colorFondo = sc.nextLine();

    }

    /*------------------------------------------- */
    /* Comienza el main */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circulo c1 = new Circulo();
        System.out.println("Circulo 1");
        System.out.println(c1.toString());
        System.out.println("");

        Circulo c2 = new Circulo(10, "Rojo", "Negro");
        // System.out.println(c2.toString());
        // mostrar con métodos
        System.out.println("Circulo 2");
        c2.mostrarDatos();
        System.out.printf("El perimetro es: %.2f%n", c2.calculaPerimetro());
        System.out.printf("El area es: %.2f%n", c2.calcularArea());
        System.out.println("");

        System.out.println("Circulo 3");
        Circulo c3 = new Circulo();
        c3.cargaDatosCirculo(sc);
        System.out.println("");
        c3.mostrarDatos();

        System.out.println("El perimetro es: " + c3.calculaPerimetro());
        System.out.println("El area es: " + c3.calcularArea());
        sc.close();
    }
}
