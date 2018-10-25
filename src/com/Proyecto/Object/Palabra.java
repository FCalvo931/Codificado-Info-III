package com.Proyecto.Object;

import java.util.Objects;

public class Palabra implements Comparable {
    private String palabra;
    private String traduccion;

    public Palabra() {
    }

    public Palabra(String palabra, String traduccion) {
        this.palabra = palabra;
        this.traduccion = traduccion;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palabra other = (Palabra) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object t) {
        return palabra.compareTo(t.toString());
    }

}

