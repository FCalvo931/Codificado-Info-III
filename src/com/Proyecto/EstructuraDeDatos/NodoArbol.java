package com.Proyecto.EstructuraDeDatos;

import com.Proyecto.Object.Palabra;

class NodoArbol<AnyType> {
    int balanceo;
    private Palabra dato;
    private NodoArbol der;
    private NodoArbol izq;

    public NodoArbol() {
    }

    public NodoArbol(Palabra dato, NodoArbol der, NodoArbol izq, int balanceo) {
        this.dato = dato;
        this.der = der;
        this.izq = izq;
        this.balanceo = balanceo;
    }

    public NodoArbol(Palabra dato, int balanceo) {
        this.dato = dato;
        this.balanceo = balanceo;
    }


    public NodoArbol(Palabra dato) {
        this.dato = dato;
    }

    public Palabra getDato() {
        return dato;
    }

    public void setDato(Palabra dato) {
        this.dato = dato;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public int getBalanceo() {
        return balanceo;
    }

    public void setBalanceo(int balanceo) {
        this.balanceo = balanceo;
    }


}

