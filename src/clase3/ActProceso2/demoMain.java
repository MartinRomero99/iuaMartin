package clase3.ActProceso2;

import javax.swing.JOptionPane;

import clase3.ActProceso2.clases.Publicacion;

public class demoMain {
    public static void main(String[] args) {
        Publicacion p1 = new Publicacion();
        p1.cargarInfo("Publicación");
        JOptionPane.showMessageDialog(null, p1.mostrarInfo(), "Información de la Publicación",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, Publicacion.getCantidadDePublicaciones(), "Cantidad de publicaciones",
                JOptionPane.INFORMATION_MESSAGE);

        //

    }
}
