package clase3.ActProceso2.clases;

import javax.swing.JOptionPane;

public class Articulo extends Publicacion {
    Idioma idioma;
    private int numPaginas;

    public Articulo(String título, String autor, int anioPublicación, Idioma idioma, int numPaginas) {
        super(título, autor, anioPublicación);
        this.idioma = idioma;
        this.numPaginas = numPaginas;
    }

    public Articulo() {
    }

    public Idioma getIdioma() {
        return idioma;
    }

    // public void setIdioma(Idioma idioma) {
    // this.idioma = idioma;
    // }

    public int getNumPaginas() {
        return numPaginas;
    }

    // public void setNumPaginas(int numPaginas) {
    // this.numPaginas = numPaginas;
    // }

    public void cargarArticulo(String nombreObjeto) {
        super.cargarInfo(nombreObjeto);
        Idioma[] opcionesIdiomas = Idioma.values();
        this.idioma = (Idioma) JOptionPane.showInputDialog(null,
                "Seleccione el tipo de categoria", "Categoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesIdiomas, opcionesIdiomas[0]);
        this.numPaginas = super.ingresaInt("Ingrese la cantidad de páginas");
    }

    public String mostrarInfo() {
        String mensaje = super.mostrarInfo() + String.format("\nIdioma: %s \n" +
                "Número de páginas: %d",
                this.idioma,
                this.numPaginas);
        return mensaje;
    }
}
