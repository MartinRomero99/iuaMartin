package clase3.ActProceso2;

import javax.swing.JOptionPane;

import clase3.ActProceso2.clases.Publicacion;
import clase3.ActProceso2.clases.Revista;

public class demoRevista {
    public static void main(String[] args) {
        Revista re1 = new Revista();
        re1.cargarRevista("Revista");
        JOptionPane.showMessageDialog(null, re1.mostrarInfo(), "Información del libro",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "La cantidad de publicaciones es de: " + Publicacion.getCantidadDePublicaciones(),
                "Cantidad de publicaciones",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
