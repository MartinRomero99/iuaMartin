package clase3.ActProceso2;

import javax.swing.JOptionPane;

import clase3.ActProceso2.clases.Articulo;
import clase3.ActProceso2.clases.Publicacion;

public class demoArticulo {
    public static void main(String[] args) {
        Articulo a1 = new Articulo();

        a1.cargarArticulo("Artículo");
        JOptionPane.showMessageDialog(null, a1.mostrarInfo(), "Información del Artículo",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "La cantidad de publicaciones es de: " + Publicacion.getCantidadDePublicaciones(),
                "Cantidad de publicaciones", JOptionPane.INFORMATION_MESSAGE);
    }
}
