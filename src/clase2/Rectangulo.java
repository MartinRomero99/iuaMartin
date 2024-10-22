package clase2;

import javax.swing.JOptionPane;

public class Rectangulo {
    public double largo;
    public double corto;
    public String colorFondo;

    // sin argumentos
    public Rectangulo() {
        this.largo = 12;
        this.corto = 4;
        this.colorFondo = "rojo";
    }

    // con argumentos
    public Rectangulo(double ladoLargo, double ladoCorto, String cf) {
        this.corto = ladoCorto;
        this.largo = ladoLargo;
        this.colorFondo = cf;
    }

    // Muestra los atributos del objeto
    @Override
    public String toString() {
        return "Rectangulo [ largo=" + largo + ", ancho=" + corto + ", colorFondo=" + colorFondo + " ]";
    }

    public void cargaDatosRectangulo() {
        this.corto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado corto del rectángulo:"));
        this.largo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado largo del rectángulo:"));
    }

    public void modificarColor() {
        String nuevoColor = JOptionPane
                .showInputDialog("Ingrese el nuevo color de fondo (o deje en blanco para rojo):");
        if (nuevoColor == null || nuevoColor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingresó un color válido. Se mantiene el color rojo.");
            this.colorFondo = "rojo";
        } else {

            this.colorFondo = nuevoColor;
        }
    }

    public double calcularArea() {
        double area = this.corto * this.largo;
        return area;
    }

    public double calcularPerimetro() {
        double perimetro = 2 * (this.corto + this.largo);
        return perimetro;
    }

    public void mostrarDatos() {
        String mensaje = "Datos del Rectángulo:\n"
                + "Ancho: " + this.corto + "\n"
                + "Largo: " + this.largo + "\n"
                + "Color de fondo: " + this.colorFondo;
        JOptionPane.showMessageDialog(null, mensaje);

    }

    public static void main(String[] args) {
        // objeto sin argumentos
        JOptionPane.showMessageDialog(null, "Rectángulo número 1");
        Rectangulo r1 = new Rectangulo();
        r1.mostrarDatos();
        JOptionPane.showMessageDialog(null, "El área es: " + r1.calcularArea());
        JOptionPane.showMessageDialog(null, "El perímetro es: " + r1.calcularPerimetro());

        // objeto con argumentos
        double corto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado corto del rectángulo 2:"));
        double largo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el largo del rectángulo 2:"));
        Rectangulo r2 = new Rectangulo(largo, corto, "rojo");
        r2.mostrarDatos();
        JOptionPane.showMessageDialog(null, "El área es: " + r2.calcularArea());
        JOptionPane.showMessageDialog(null, "El perímetro es: " + r2.calcularPerimetro());

        // objeto con peticion de argumetos
        Rectangulo r3 = new Rectangulo();
        r3.cargaDatosRectangulo();
        r3.modificarColor();
        r3.mostrarDatos();
        JOptionPane.showMessageDialog(null, "El área es: " + r3.calcularArea());
        JOptionPane.showMessageDialog(null, "El perímetro es: " + r3.calcularPerimetro());
    }
}
