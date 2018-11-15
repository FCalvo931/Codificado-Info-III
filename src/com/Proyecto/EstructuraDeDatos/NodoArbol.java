package com.Proyecto.EstructuraDeDatos;

public class NodoArbol<AnyType extends Comparable<AnyType>> {
    private NodoArbol<AnyType> izq;
    private NodoArbol<AnyType> der;
    private AnyType dato;
    private int balanceo;


    public NodoArbol(AnyType dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
        this.balanceo = 0;
    }

    public NodoArbol<AnyType> getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol<AnyType> getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public AnyType getDato() {
        return dato;
    }

    public void setDato(AnyType dato) {
        this.dato = dato;
    }

    public int getBalanceo() {
        return balanceo;
    }

    public void setBalanceo(int al) {
        this.balanceo = al;
    }


}

