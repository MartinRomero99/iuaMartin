package clase3.ActProceso2;

import javax.swing.JOptionPane;

import clase3.ActProceso2.clases.Libro;
import clase3.ActProceso2.clases.Publicacion;

public class demoLibro {
    public static void main(String[] args) {
        Libro l1 = new Libro();

        l1.cargarLibro("Libro");
        JOptionPane.showMessageDialog(null, l1.mostrarInfo(), "Información del libro",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "La cantidad de publicaciones es de: " + Publicacion.getCantidadDePublicaciones(),
                "Cantidad de publicaciones",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
