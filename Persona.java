// clase base. La hice para usar herencia en Piloto
public class Persona {

    private String nombre;
    private int edad;
    private String pais;

    // constructor
    public Persona(String nombre, int edad, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    // metodo para mostrar la persona y Piloto lo sobrescribe
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("País: " + pais);
    }
}