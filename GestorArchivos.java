
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivos {

    // Lee los pilotos desde un archivo TXT
    public ArrayList<Piloto> cargarPilotosDesdeArchivo(String ruta)
    {

        ArrayList<Piloto> pilotos = new ArrayList<>();

        try (BufferedReader lector =
                new BufferedReader(new FileReader(ruta))) {

            String linea;

            // Saltamos la primera línea (encabezado)
            lector.readLine();

            while ((linea = lector.readLine()) != null) 
            {

                String[] datos = linea.split(";");

                //Valida la cantidad de campos
                if (datos.length != 7) {
                    System.out.println("Registro inválido: " + linea);
                    continue;
                }

                try {
                    //trim elimina los espacios al inicio y al final
                    //Integer.parseInt() convierte una cadena que representa un número entero en un int
                    String nombre = datos[0].trim();
                    int edad = Integer.parseInt(datos[1].trim());
                    String pais = datos[2].trim();
                    int numero = Integer.parseInt(datos[3].trim());
                    String equipo = datos[4].trim();
                    int posicion = Integer.parseInt(datos[5].trim());
                    int victorias = Integer.parseInt(datos[6].trim());

                    //Creamos el objeto piloto
                    Piloto piloto = new Piloto(
                        nombre, numero, equipo, pais,
                        edad, posicion, victorias
                    );

                    pilotos.add(piloto);

                } catch (NumberFormatException e) {
                    System.out.println("Error en datos: " + linea);
                }
            }

            System.out.println("Pilotos cargados: " + pilotos.size());

        }
        //se utiliza para manejar problemas relacionados con operaciones de entrada y salida
        catch (IOException e) 
        { 
            System.out.println("Error al leer archivo: "
                    + e.getMessage());
        }

        return pilotos;
    }

    // Guarda los resultados de una búsqueda en un TXT
    public void guardarResultadosEnArchivo(
            String nombreArchivo, ArrayList<Piloto> resultados) {

        if (resultados == null || resultados.isEmpty()) {
            System.out.println("No hay resultados para guardar.");
            return;
        }

        try (FileWriter escritor = new FileWriter(nombreArchivo)) {

            escritor.write(
                "nombreApellido;edad;pais;numero;equipo;"
                + "posicionActual;cantidadVictorias\n"
            );

            for (Piloto piloto : resultados) {

                escritor.write(
                    piloto.getNombre() + ";" +
                    piloto.getEdad() + ";" +
                    piloto.getPais() + ";" +
                    piloto.getNumero() + ";" +
                    piloto.getEquipo() + ";" +
                    piloto.getPosicionActual() + ";" +
                    piloto.getCantidadVictorias() + "\n"
                );
            }

            System.out.println("Archivo guardado: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al guardar archivo: "
                    + e.getMessage());
        }
    }
}
