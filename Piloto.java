// Piloto hereda nombre y edad de Persona y agrega los datos propios de la F1
public class Piloto extends Persona {

    private int numero;
    private String equipo;
    private String pais;
    private int posicionActual;
    private int cantidadVictorias;

    // constructor: nombre y edad se los pasa a Persona con super
    public Piloto(String nombre, int numero, String equipo, String pais, int edad, int posicionActual, int cantidadVictorias) {
        super(nombre, edad);
        this.numero = numero;
        this.equipo = equipo;
        this.pais = pais;
        this.posicionActual = posicionActual;
        this.cantidadVictorias = cantidadVictorias;
    }

    // getters y settetrs (los de nombre y edad se heredan de Persona)
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
    public int getPosicionActual() {
        return posicionActual;
    }
    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }
    public int getCantidadVictorias() {
        return cantidadVictorias;
    }
    public void setCantidadVictorias(int cantidadVictorias) {
        this.cantidadVictorias = cantidadVictorias;
    }

    // mostrar informaion del piloto. sobreescribe el metodo de Persona
    @Override
    public void mostrarInformacion() {
        System.out.println("===== INFORMACION DEL PILOTO =====");
        System.out.println("");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Número: " + numero);
        System.out.println("Equipo: " + equipo);
        System.out.println("País: " + pais);
        System.out.println("Edad: " + getEdad());
        System.out.println("Posición actual: " + posicionActual);
        System.out.println("Cantidad de victorias: " + cantidadVictorias);
        System.out.println("");
        System.out.println("=================================");
        System.out.println("");
    }

    // Devuelve los datos separados por comas para guardarlos en un archivo

    public String aLineaArchivo() {
        return getNombre() + "," + numero + "," + equipo + "," + pais + ","
                + getEdad() + "," + posicionActual + "," + cantidadVictorias;
    }
}