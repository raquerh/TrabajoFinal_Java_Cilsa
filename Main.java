import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        GestorPilotos gestor = new GestorPilotos();
        int opcion;
        
        GestorArchivos archivos = new GestorArchivos();
        // Cargamos los pilotos desde el archivo TXT2
        for (Piloto piloto : archivos.cargarPilotosDesdeArchivo("pilotos_f1.txt")) 
         {gestor.agregarPiloto(piloto);}
        //gestor.cargarPilotosDesdeArchivo("pilotos_f1.txt");

        archivos.guardarResultadosEnArchivo(
          "resultados_prueba.txt",
        gestor.getPilotos()
        );
        
        do {
            System.out.println("===== MENU =====");
            System.out.println("");
            System.out.println("1. Registrar piloto");
            System.out.println("2. Mostrar pilotos");
            System.out.println("3. Salir");
            System.out.println("");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();
            System.out.println("");
            lector.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del piloto: ");
                    String nombre = lector.nextLine();
                    System.out.print("Ingrese el número del piloto: ");
                    int numero = lector.nextInt();
                    lector.nextLine(); 
                    System.out.print("Ingrese el equipo del piloto: ");
                    String equipo = lector.nextLine();
                    System.out.println("");
                    System.out.print("Ingrese el país del piloto: ");
                    String pais = lector.nextLine();
                    System.out.print("Ingrese la edad del piloto: ");
                    int edad = lector.nextInt();
                    System.out.print("Ingrese la posición actual del piloto: ");
                    int posicionActual = lector.nextInt();
                    System.out.print("Ingrese la cantidad de victorias del piloto: ");
                    int cantidadVictorias = lector.nextInt();
                    lector.nextLine();
                    
                    Piloto piloto = new Piloto(nombre, numero, equipo, pais, edad, posicionActual, cantidadVictorias);
                    gestor.agregarPiloto(piloto);
                    System.out.println("Piloto registrado exitosamente.");
                    break;
                case 2:
                    gestor.mostrarPilotos();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);

        lector.close();
    }
}