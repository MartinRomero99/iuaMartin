package clase3.ActProceso2.clases;

import javax.swing.JOptionPane;

public class Revista extends Publicacion {
    private int mesDePublicacion;
    private String paisOrigen;
    Categoria categoria;

    public Revista(String título, String autor, int anioPublicación, int mesDePublicacion, String paisOrigen,
            Categoria categoria) {
        super(título, autor, anioPublicación);
        this.mesDePublicacion = mesDePublicacion;
        this.paisOrigen = paisOrigen;
        this.categoria = categoria;
    }

    public Revista() {
    }

    public int getMesDePublicacion() {
        return mesDePublicacion;
    }

    // public void setMesDePublicacion(int mesDePublicacion) {
    // this.mesDePublicacion = mesDePublicacion;
    // }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    // public void setPaisOrigen(String paisOrigen) {
    // this.paisOrigen = paisOrigen;
    // }

    public Categoria getCategoria() {
        return categoria;
    }

    // public void setCategoria(Categoria categoria) {
    // this.categoria = categoria;
    // }

    public void cargarRevista(String nombreObjeto) {
        super.cargarInfo(nombreObjeto);
        do {
            this.mesDePublicacion = super.ingresaInt("Ingrese el mes de publicación (1-12): ");
            if (this.mesDePublicacion < 1 || this.mesDePublicacion > 12) {
                JOptionPane.showMessageDialog(null, "Mes inválido. Debe estar entre 1 y 12.");
            }
        } while (this.mesDePublicacion < 1 || this.mesDePublicacion > 12);
        while (this.paisOrigen == null || this.paisOrigen.trim().isEmpty()) {
            this.paisOrigen = ingresaString("Ingrese el pais de origen: " + nombreObjeto);
            if (this.paisOrigen == null || this.paisOrigen.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El país de origen no puede estar vacío.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        Categoria[] opcionesCategorias = Categoria.values();
        this.categoria = (Categoria) JOptionPane.showInputDialog(null,
                "Seleccione el tipo de categoria", "Categoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesCategorias, opcionesCategorias[0]);
    }

    @Override
    public String mostrarInfo() {
        String mensaje = super.mostrarInfo() + String.format("\nMes de publicación: %d \n" +
                "Pais  de origen: %s \nCategoría: %s",
                this.mesDePublicacion,
                this.paisOrigen,
                this.categoria);
        return mensaje;
    }
}
