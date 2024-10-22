package clase3.ActProceso2.clases;

import javax.swing.JOptionPane;

public class Libro extends Publicacion {
    private int numeroCopias;
    private String editorial;

    public Libro(String título, String autor, int anioPublicación, int numeroCopias, String editorial) {
        super(título, autor, anioPublicación);
        this.numeroCopias = numeroCopias;
        this.editorial = editorial;
    }

    public Libro() {
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    // public void setNumeroCopias(int numeroCopias) {
    // this.numeroCopias = numeroCopias;
    // }

    public String getEditorial() {
        return editorial;
    }

    // public void setEditorial(String editorial) {
    // this.editorial = editorial;
    // }

    public void cargarLibro(String nombreObjeto) {
        super.cargarInfo(nombreObjeto);
        this.numeroCopias = super.ingresaInt("Ingrese el número de copias: ");
        while (this.editorial == null || this.editorial.trim().isEmpty()) {
            this.editorial = ingresaString("Ingrese la editorial:" + nombreObjeto);
            if (this.editorial == null || this.editorial.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La editorial no puede estar vacía.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public String mostrarInfo() {
        String mensaje = super.mostrarInfo() + String.format(
                "\nNúmero de copias: %d\nEditorial: %s",
                this.numeroCopias, this.editorial);
        return mensaje;

    }

}
