package com.Allura.Catalogo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GutendexService servicio = new GutendexService();
        BaseDeDatos baseDeDatos = new BaseDeDatos();

        System.out.println("¡Bienvenido al catálogo de libros LiterAlura!");

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Buscar libros");
            System.out.println("2. Ver libros guardados");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion == 1) {
                System.out.print("Ingresa el término de búsqueda: ");
                String termino = scanner.nextLine();
                var libros = servicio.buscarLibros(termino);
                System.out.println("Libros encontrados:");
                for (Libro libro : libros) {
                    System.out.println(libro);
                    baseDeDatos.guardarLibro(libro);
                }
            } else if (opcion == 2) {
                System.out.println("Libros guardados:");
                for (Libro libro : baseDeDatos.obtenerLibros()) {
                    System.out.println(libro);
                }
            } else if (opcion == 3) {
                System.out.println("¡Gracias por usar LiterAlura!");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}