package com.Allura.Catalogo;

import org.apache.hc.client5.http.fluent.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GutendexService {

    private static final String API_URL = "https://gutendex.com/books/";

    public List<Libro> buscarLibros(String query) {
        List<Libro> libros = new ArrayList<>();
        try {
            String respuesta = Request.get(API_URL + "?search=" + query).execute().returnContent().asString();
            JSONObject json = new JSONObject(respuesta);
            JSONArray resultados = json.getJSONArray("results");

            for (int i = 0; i < resultados.length(); i++) {
                JSONObject libroJson = resultados.getJSONObject(i);
                String titulo = libroJson.getString("title");
                JSONArray autores = libroJson.getJSONArray("authors");
                String autor = autores.length() > 0 ? autores.getJSONObject(0).getString("name") : "Desconocido";

                libros.add(new Libro(titulo, autor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }
}