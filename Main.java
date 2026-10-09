import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        GestorPilotos gestor = new GestorPilotos();
        int opcion;

        
        /*gestor.agregarPiloto(new Piloto("Andrea Kimi Antonelli", 12, "Mercedes", "Italia", 20, 1, 8));
        gestor.agregarPiloto(new Piloto("George Russell", 63, "Mercedes", "Reino Unido", 28, 2, 2));
        gestor.agregarPiloto(new Piloto("Lewis Hamilton", 44, "Ferrari", "Reino Unido", 41, 3, 1));
        gestor.agregarPiloto(new Piloto("Lando Norris", 4, "McLaren", "Reino Unido", 26, 4, 2));
        gestor.agregarPiloto(new Piloto("Charles Leclerc", 16, "Ferrari", "Mónaco", 28, 5, 1));
        gestor.agregarPiloto(new Piloto("Max Verstappen", 1, "Red Bull", "Países Bajos", 28, 6, 0));
        gestor.agregarPiloto(new Piloto("Oscar Piastri", 81, "McLaren", "Australia", 25, 7, 0));
        gestor.agregarPiloto(new Piloto("Isack Hadjar", 6, "Red Bull", "Francia", 21, 8, 0));
        gestor.agregarPiloto(new Piloto("Liam Lawson", 30, "Racing Bulls", "Nueva Zelanda", 24, 9, 0));
        gestor.agregarPiloto(new Piloto("Pierre Gasly", 10, "Alpine", "Francia", 30, 10, 0));
        gestor.agregarPiloto(new Piloto("Franco Colapinto", 43, "Alpine", "Argentina", 23, 12, 0));
        */    


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