# Pilotos de Fórmula 1

Trabajo final del curso de Programación en Java de Cilsa (2026).

Este proyecto es una aplicación de consola desarrollada en Java bajo el paradigma de Programación Orientada a Objetos (POO). Su propósito principal es permitir la gestión, consulta y filtrado de información sobre pilotos de Formula 1 almacenada en un archivo de texto , integrando estructuras de colecciones, validaciones y manejo de excepciones.

## Integrantes

| Integrante | Parte del trabajo |
|---|---|
| Fabián Castillo | Lectura, escritura y manejo de archivos |
| Sabrina Rodriguez | Menú principal, búsquedas y validaciones |
| Raquel Rodriguez Herlein | Modelo POO y estructura de datos |

## Herramientas

- Java
- Eclipse IDE
- Visual Studio Code
- Git y GitHub para trabajar en ramas y unir las partes


## Cómo ejecutarlo

Hace falta tener instalado el JDK.

Desde la carpeta del proyecto:

```bash
javac *.java
java Main
```

El archivo `pilotos_f1.txt` tiene que estar en la misma carpeta desde la que se ejecuta el programa. Si no lo encuentra, muestra un mensaje de error y el menú arranca sin datos.

## Archivo de datos

`pilotos_f1.txt` tiene 20 pilotos. La primera línea es el encabezado y los campos van separados por punto y coma:

```
nombreApellido;edad;pais;numero;equipo;posicionActual;cantidadVictorias
Max Verstappen;27;Paises Bajos;1;Red Bull Racing;1;65
Lando Norris;25;Reino Unido;4;McLaren;2;9
```

Al leerlo, el programa saltea las líneas que no tienen siete campos o que tienen texto donde va un número, y avisa cuál fue la línea con problemas.

## Menú

```
1. Buscar pilotos por país
2. Buscar pilotos por equipo
3. Listar todos los pilotos
4. Salir
```

Después de cada búsqueda con resultados, el programa pregunta si se quieren guardar. Si la respuesta es `s`, crea un archivo con el nombre de la consulta, por ejemplo `resultados_pais_reino_unido.txt` o `resultados_equipo_ferrari.txt`, con el mismo formato que el archivo original.

## Clases

**Persona**: clase base con nombre, edad y país. Los atributos son privados y se acceden con getters y setters.

**Piloto**: hereda de `Persona` (`extends`) y agrega número, equipo, posición actual y cantidad de victorias. El constructor le pasa nombre, edad y país a `Persona` con `super`. Sobrescribe `mostrarInformacion()` con `@Override` para mostrar todos los datos del piloto.

**GestorPilotos**: guarda los pilotos en un `ArrayList<Piloto>` y tiene los métodos para agregarlos, listarlos y buscarlos por país o por equipo.

**GestorArchivos**: lee `pilotos_f1.txt` con `BufferedReader` y guarda los resultados de una búsqueda con `FileWriter`. Maneja `IOException` y `NumberFormatException`.

**Main**: muestra el menú, pide los datos al usuario y llama a los demás métodos.

## Validaciones

- Si en el menú se ingresa texto en lugar de un número, se captura la `InputMismatchException` y se vuelve a mostrar el menú.
- Si se elige una opción que no existe, avisa que no es válida.
- No se permiten búsquedas vacías.
- Si una búsqueda no encuentra pilotos, lo informa.
- A la pregunta de guardar solo se acepta `s` o `n`.
- Las búsquedas no distinguen mayúsculas y minúsculas.

## Cosas que no se implementaron

- Los setters de las clases: porque el programa no tiene una opción para modificar o cargar pilotos.
