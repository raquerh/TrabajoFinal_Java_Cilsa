public class Piloto {
    
    private String nombre;
    private int numero;
    private String equipo;
    private String pais;
    private int edad;
    private int posicionActual; 
    private int cantidadVictorias;

    // CONSTRUCTOR
    public Piloto(String nombre, int numero, String equipo, String pais, int edad, int posicionActual, int cantidadVictorias) {
        this.nombre = nombre;
        this.numero = numero;
        this.equipo = equipo;
        this.pais = pais;
        this.edad = edad;
        this.posicionActual = posicionActual;
        this.cantidadVictorias = cantidadVictorias;
    }
	
    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPosicionActual() {
        return posicionActual;
    }
    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }
    public void setCantidadVictorias(int cantidadVictorias) {
        this.cantidadVictorias = cantidadVictorias;
    }
    public int getCantidadVictorias() {
        return cantidadVictorias;
    }

    // MÉTODO PARA MOSTRAR INFORMACIÓN DEL PILOTO
    public void mostrarInformacion() {
        System.out.println("===== INFORMACION DEL PILOTO =====");
        System.out.println("");
        System.out.println("Nombre: " + nombre);
        System.out.println("Numero: " + numero);
        System.out.println("Equipo: " + equipo);
        System.out.println("País: " + pais);
        System.out.println("Edad: " + edad);
        System.out.println("Posición actual: " + posicionActual);
        System.out.println("Cantidad de victorias: " + cantidadVictorias);
        System.out.println("");
        System.out.println("=================================");
        System.out.println("");
    }

}