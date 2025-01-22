package com.Allura.Catalogo;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private List<Libro> libros = new ArrayList<>();

    public void guardarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro guardado: " + libro);
    }

    public List<Libro> obtenerLibros() {
        return libros;
    }
}