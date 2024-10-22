package clase3.ActProceso2.clases;

import javax.swing.JOptionPane;

public class Publicacion {
    private String titulo;
    private String autor;
    private int anioPublicación;
    private int numeroId;
    private static int cantidadDePublicaciones = 0;
    private static int contadorID = 1;

    public Publicacion() {
        this.titulo = "";
        this.autor = "";
        this.anioPublicación = 0;
        this.numeroId = contadorID++;
        Publicacion.cantidadDePublicaciones++;
    }

    public Publicacion(String título, String autor, int anioPublicación) {
        this.titulo = título;
        this.autor = autor;
        this.anioPublicación = anioPublicación;
        this.numeroId = contadorID++;
        Publicacion.cantidadDePublicaciones++;
    }

    // getters y setters
    public String getTitulo() {
        return titulo;
    }

    // public void setTitulo(String título) {
    // this.titulo = título;
    // }

    public String getAutor() {
        return autor;
    }

    // public void setAutor(String autor) {
    // this.autor = autor;
    // }

    public int getAnioPublicación() {
        return anioPublicación;
    }

    // public void setAnioPublicación(int anioPublicación) {
    // this.anioPublicación = anioPublicación;
    // }

    public int getNumeroId() {
        return numeroId;
    }

    // public void setNumeroId(int numeroId) {
    // this.numeroId = numeroId;
    // }

    public static int getCantidadDePublicaciones() {
        return cantidadDePublicaciones;
    }

    // metodos generales
    public String mostrarInfo() {
        String mensaje = String.format("Título: %s \nAutor: %s \nAño de Publicación: %d \nID: %d",
                this.titulo, this.autor, this.anioPublicación, this.numeroId);
        return mensaje;
    }

    public void cargarInfo(String nombreObjeto) {
        while (this.titulo == null || this.titulo.trim().isEmpty()) {
            this.titulo = ingresaString("Ingrese el título: " + nombreObjeto);
            if (this.titulo == null || this.titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El título no puede estar vacío.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        while (this.autor == null || this.autor.trim().isEmpty()) {
            this.autor = ingresaString("Ingrese el autor: " + nombreObjeto);
            if (this.autor == null || this.autor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El autor no puede estar vacío.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        this.anioPublicación = ingresaInt("Ingrese el año de publicación: " + nombreObjeto);
        JOptionPane.showMessageDialog(null, "El número de id será: " + numeroId);
    }

    protected String ingresaString(String nombreObjeto) {
        return JOptionPane.showInputDialog(null, nombreObjeto,
                "Ingreso de datos",
                JOptionPane.QUESTION_MESSAGE);
    }

    protected int ingresaInt(String mensaje) {
        int dato = 0;
        boolean error = false;
        do {
            error = false;
            try {
                String input = JOptionPane.showInputDialog(null, mensaje, "Ingreso de datos",
                        JOptionPane.QUESTION_MESSAGE);
                dato = Integer.parseInt(input);
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (error);
        return dato;
    }
}
