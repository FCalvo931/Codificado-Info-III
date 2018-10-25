package com.Proyecto.EstructuraDeDatos;

import com.Proyecto.Object.Palabra;

public class ArbolAVL<AnyType extends Comparable<AnyType>> {
    private NodoArbol raiz;


    public void insertar(Palabra d) throws Exception {
        raiz = insertar(d, raiz);
    }

    public String buscar(String d) throws Exception {
        return buscar(d, raiz);
    }

    public void borrar(String d) throws Exception {
        borrar(d, raiz);
    }

    public void inOrder() {
        inOrder(raiz);
    }

    public void preOrder() {
        preOrder(raiz);
    }

    public void postOrder() {
        postOrder(raiz);
    }

    public void print() {
        print(false, "", raiz);
    }

    private NodoArbol insertar(Palabra d, NodoArbol r) throws Exception {


        if (r == null)
            return new NodoArbol(d);
        System.out.println("Dato del nodo actual: "+r.getDato().getPalabra());
        System.out.println("Inserto : "+d.getPalabra());
        System.out.println("Comparo : "+d.compareTo(r.getDato()));



        if (d.compareTo(r.getDato()) > 0) {
            r.setDer(insertar(d, r.getDer()));
        } else if (d.compareTo(r.getDato()) < 0) {
            r.setIzq(insertar(d, r.getIzq()));
        }

        balanceo(r);

        // RSI (rotación simple Izquierda)
        if (r.getBalanceo() > 1 && r.getDer().getBalanceo() > 0)
            return rotacionIzq(r);

        // RSD
        if (r.getBalanceo() < -1 && r.getIzq().getBalanceo() < 0)
            return rotacionDer(r);

        // RDI
        if (r.getBalanceo() < -1 && r.getIzq().getBalanceo() > 0) {
            r.setIzq(rotacionIzq(r.getIzq()));
            return rotacionDer(r);
        }
        // RDD
        if (r.getBalanceo() > 1 && r.getDer().getBalanceo() < 0) {
            r.setDer(rotacionDer(r.getDer()));
            return rotacionIzq(r);
        }

        return r;
    }

    private void balanceo(NodoArbol r) {
        int aDer = altura(r.getDer());
        int aIzq = altura(r.getIzq());

        r.setBalanceo(aDer - aIzq);
    }

    private NodoArbol rotacionIzq(NodoArbol r) {
        NodoArbol der = r.getDer();
        der.setIzq(r);
        r.setDer(null);

        balanceo(r);
        balanceo(der);

        return der;

    }

    private NodoArbol rotacionDer(NodoArbol r) {
        NodoArbol izq = r.getIzq();
        izq.setDer(r);
        r.setIzq(null);

        balanceo(r);
        balanceo(izq);

        return izq;
    }


    private String buscar(String d, NodoArbol r) throws Exception {

        if (r == null)
            throw new Exception("404");

        int comp = d.compareTo(r.getDato().getPalabra());
        System.out.println("Dato del nodo buscado: "+r.getDato().getPalabra()+"\n resultaod comrpare: "+comp);
        if (comp == 0)
            return r.getDato().getTraduccion();

        if (comp > 0)
            return (String) buscar(d, r.getDer());
        else
            return (String) buscar(d, r.getIzq());
    }

    private NodoArbol borrar(String d, NodoArbol<AnyType> r) throws Exception {
        if (r == null)
            throw new Exception("404");

        int comp = d.compareTo(r.getDato().getPalabra());
        if (comp == 0) {
            insertar(r.getDer(), r.getIzq());
            return r.getDer();
        }

        if (comp > 0) {
            r.setDer(borrar(d, r.getDer()));
            return r;
        } else {
            r.setIzq(borrar(d, r.getIzq()));
            return r;
        }
    }


    private void insertar(NodoArbol r, NodoArbol h) throws Exception {

        int comp = r.getDato().compareTo(h.getDato());

        if (comp > 0) {
            if (r.getDer() != null) {
                insertar(r.getDer(), h);
            } else {
                r.setDer(h);
            }
            return;
        }


        if (comp < 0) {
            if (h.getIzq() != null) {
                insertar(r.getIzq(), h);
            } else {
                r.setIzq(h);
            }
            return;
        }
        throw new Exception("El nodo ya existe");
    }
//
//    public int altura() {
//        return altura(raiz);
//    }
//
//    public int profundidad(AnyType d) {
//        return profundidad(d, raiz);
//    }


    private void inOrder(NodoArbol<AnyType> r) {

        if (r == null)
            return;

        inOrder(r.getIzq());
        System.out.println(r.getDato());
        inOrder(r.getDer());

        /*

        if (r.getIzq() != null)
            inOrder(r.getIzq());

        System.out.println(r.getDato());

        if (r.getDer() != null)
            inOrder(r.getDer());

        */
    }


    private void preOrder(NodoArbol r) {
        if (r == null)
            return;

        System.out.println(r.getDato());
        preOrder(r.getIzq());
        preOrder(r.getDer());
    }


    private void postOrder(NodoArbol r) {
        if (r == null)
            return;

        preOrder(r.getIzq());
        preOrder(r.getDer());
        System.out.println(r.getDato());
    }


    private void print(boolean esDerecho, String identacion, NodoArbol<AnyType> r) {
        if (r.getDer() != null) {
            print(true, identacion + (esDerecho ? "     " : "|    "), r.getDer());
        }
        System.out.print(identacion);
        if (esDerecho) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("-- ");
        System.out.println(r.getDato() + "|" + r.getBalanceo());
        if (r.getIzq() != null) {
            print(false, identacion + (esDerecho ? "|    " : "     "), r.getIzq());
        }
    }

    private int altura(NodoArbol r) {
        if (r == null)
            return 0;

        int ai = altura(r.getIzq());
        int ad = altura(r.getDer());

        if (ai > ad) {
            return ai + 1;
        } else
            return ad + 1;
    }


}


/*
https://github.com/IUA-Informatica3/Estructuras
http://lain.marku.me/
 */
