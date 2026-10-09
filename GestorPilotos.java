import java.util.ArrayList;

// guarda todos los pilotos en un ArrayList. Se accede a la lista usando esta clase
public class GestorPilotos {

    private ArrayList<Piloto> pilotos;

    // CONSTRUCTOR: arranca con la lista vacía
    public GestorPilotos() {
        this.pilotos = new ArrayList<>();
    }

    public void agregarPiloto(Piloto piloto) {
        pilotos.add(piloto);
    }

    // lista para de pilotos para las búsquedas o guardar en archivo
    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }

    public int cantidadPilotos() {
        return pilotos.size();
    }

    public boolean estaVacia() {
        return pilotos.isEmpty();
    }

    // borra todos los pilotos (no se si es necesaria)
    public void vaciar() {
        pilotos.clear();
    }

    public void mostrarPilotos() {
        if (pilotos.isEmpty()) {
            System.out.println("No hay pilotos registrados.");
            return;
        }

        for (Piloto p : pilotos) {
            p.mostrarInformacion();
        }
        System.out.println("Total: " + pilotos.size() + " piloto(s).");
    }
}