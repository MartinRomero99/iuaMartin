package clase3.ActProceso2;

import javax.swing.JOptionPane;

public class superMain {
        public static void main(String[] args) {
                String[] opcion = { "Publicacion", "Libro", "Revista", "Artículo", "Salir" };
                boolean salir = false;
                do {
                        String seleccion = (String) JOptionPane.showInputDialog(null,
                                        "Seleccione una opción",
                                        "Gestión de Publicaciones",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcion,
                                        opcion[0]);
                        if (seleccion == null || seleccion.equals("Salir")) {
                                salir = true;
                        } else {
                                switch (seleccion) {
                                        case "Publicacion":
                                                demoMain.main(args);
                                                break;
                                        case "Libro":
                                                demoLibro.main(args);
                                                break;
                                        case "Revista":
                                                demoRevista.main(args);
                                                break;
                                        case "Artículo":
                                                demoArticulo.main(args);
                                                break;
                                }
                        }
                } while (!salir);
        }
}