import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        GestorPilotos gestor = new GestorPilotos();
        GestorArchivos archivos = new GestorArchivos();

        for (Piloto piloto : archivos.cargarPilotosDesdeArchivo("pilotos_f1.txt")) {
            gestor.agregarPiloto(piloto);
        }

        System.out.println();

        int opcion = 0;

        do {
            mostrarMenu();
            try {
                opcion = lector.nextInt();
                lector.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                lector.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    buscarPorPais(lector, gestor, archivos);
                    break;
                case 2:
                    buscarPorEquipo(lector, gestor, archivos);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("===== LISTADO DE PILOTOS =====");
                    gestor.mostrarPilotos();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida. Elija entre 1 y 4.");
            }
        } while (opcion != 4);

        lector.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("================================");
        System.out.println("      PILOTOS DE FÓRMULA 1");
        System.out.println("================================");
        System.out.println("1. Buscar pilotos por país");
        System.out.println("2. Buscar pilotos por equipo");
        System.out.println("3. Listar todos los pilotos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Pide un texto y repite la pregunta mientras esté vacío
    private static String pedirTexto(Scanner scanner, String mensaje) {
        String texto;

        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Error: la búsqueda no puede estar vacía.");
            }

        } while (texto.isEmpty());

        return texto;
    }

    // ===== BÚSQUEDA 1: POR PAÍS =====
    private static void buscarPorPais(Scanner lector, GestorPilotos gestor, GestorArchivos archivos) {
        System.out.println();
        System.out.println("===== BUSCAR POR PAÍS =====");

        String pais = pedirTexto(lector, "Ingrese el país: ");
        ArrayList<Piloto> resultados = gestor.buscarPorPais(pais);

        mostrarYGuardar(lector, archivos, resultados, "pais_" + pais);

    }

    // ===== BÚSQUEDA 2: POR EQUIPO =====
    private static void buscarPorEquipo(Scanner lector, GestorPilotos gestor, GestorArchivos archivos) {
        System.out.println();
        System.out.println("===== BUSCAR POR EQUIPO =====");

        String equipo = pedirTexto(lector, "Ingrese el equipo: ");
        ArrayList<Piloto> resultados = gestor.buscarPorEquipo(equipo);

        mostrarYGuardar(lector, archivos, resultados, "equipo_" + equipo);
        
    }
    // Muestra los resultados y pregunta si se quieren guardar
    private static void mostrarYGuardar(Scanner lector, GestorArchivos archivos,
                                    ArrayList<Piloto> resultados,
                                    String nombreConsulta) {
    // Caso: no se encontró nada                                    
    if (resultados.isEmpty()) {
        System.out.println("No se encontraron pilotos con ese dato.");
        return;
    }

    System.out.println("Se encontraron " + resultados.size() + " piloto(s):");
    System.out.println();
    
    for (Piloto piloto : resultados) {
        piloto.mostrarInformacion();
    }
    // Preguntamos si desea guardar (repite hasta recibir s o n)
    String respuesta;
    do {
        System.out.print("¿Desea guardar los resultados en un archivo? (s/n): ");
        respuesta = lector.nextLine().trim();

        if (!respuesta.equalsIgnoreCase("s")
                && !respuesta.equalsIgnoreCase("n")) {
            System.out.println("Error: escriba 's' para sí o 'n' para no.");
        }

    } while (!respuesta.equalsIgnoreCase("s")
            && !respuesta.equalsIgnoreCase("n"));

    if (respuesta.equalsIgnoreCase("s")) {
        // Armamos el nombre: "pais_Reino Unido" -> "resultados_pais_reino_unido.txt"
        String nombreArchivo =
                "resultados_" + nombreConsulta.toLowerCase().replace(" ", "_") + ".txt";
        archivos.guardarResultadosEnArchivo(nombreArchivo, resultados);
    }
}

}