package com.duolingo.utilidades;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Diccionario {
    private Map<Character, Set<String>> palabrasPorInicial;

    public Diccionario() {
        palabrasPorInicial = new HashMap<>();
    }

    public void agregarPalabra(String palabra) {
        if (palabra.length() > 0) {
            palabra = sanitizarPalabra(palabra);
            char inicial = palabra.charAt(0);
            Set<String> palabras = palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
            palabras.add(palabra);
            palabrasPorInicial.put(inicial, palabras);
            System.out.println("Palabra agregada correctamente al diccionario.");
        } else {
            System.out.println("La palabra no puede estar vacía.");
        }
    }

    public void mostrarPalabrasPorInicial(char inicial) {
        Set<String> palabras = palabrasPorInicial.get(inicial);
        if (palabras != null) {
            System.out.println("Palabras con inicial '" + inicial + "':");
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        } else {
            System.out.println("No hay palabras con esa inicial en el diccionario.");
        }
    }

    private String sanitizarPalabra(String palabra) {
        palabra = palabra.trim(); // Eliminar espacios al inicio y final
        palabra = palabra.toLowerCase(); // Convertir a minúsculas
        return palabra;
    }


    public boolean eliminarPalabra(String palabra) {
        String palabraSanitizada = sanitizarPalabra(palabra);
        char inicial = palabraSanitizada.charAt(0);
        Set<String> palabrasIniciales = palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
        if (palabrasIniciales.remove(palabraSanitizada)) {
            if (palabrasIniciales.isEmpty()) {
                palabrasPorInicial.remove(inicial);
            }
            return true;
        }
        return false;
    }

    public boolean existePalabra(String palabra) {
        String palabraSanitizada = sanitizarPalabra(palabra);
        char inicial = palabraSanitizada.charAt(0);
        Set<String> palabrasIniciales = palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
        return palabrasIniciales.contains(palabraSanitizada);
    }

    public Set<Character> getInicialesDisponibles() {
        return palabrasPorInicial.keySet();
    }
    

    public List<String> getPalabrasPorInicial(char inicial) {
        Set<String> palabrasIniciales = palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
        return new ArrayList<>(palabrasIniciales);
    }
    
    
    
}
