package clase3.POO.ActProceso2;

import java.util.ArrayList;
import java.util.List;

// Romero Martín Alejandro
public class demoAutomovil {

    public static void main(String[] args) {

        Automovil auto1 = new Automovil();
        auto1.imprimirDetalles();
        Automovil auto2 = new Automovil("bmw", "m3", TipoCombustible.DIESEL, 350, 45000, true);
        auto2.manejar();
        auto2.imprimirDetalles();
        Automovil auto3 = new Automovil();
        auto3.cargarAutos();
        auto3.manejar();
        Automovil auto4 = new Automovil();
        auto4.cargarAutos();

        Automovil.getCantidadAutos();

        List<Automovil> listaAutos = new ArrayList<>();
        listaAutos.add(auto1);
        listaAutos.add(auto2);
        listaAutos.add(auto3);
        listaAutos.add(auto4);
        Automovil.mostrarAutoMasCaro(listaAutos);
    }

}
