package com.Proyecto.EstructuraDeDatos;

import com.Proyecto.Object.Palabra;

public  class HashTable<AnyKey, AnyType> {

    /* Decidimos utilizar una tabla hash la cual resuelve las posibles colisiones con arboles avl.
    Consideramos utilizar avl ya que nos brinda un buen tiempo de respuesta y consideramos,
    que no es relevante implementar un rojo y negro a pesar de que el tiempo de inserción de sus elementos se ve reducida a la mitad. */

    private AvlTree<Palabra>[] table; /* El único atributo que tendrá nuestra estructura de datos será un arreglo de arboles avl
                                            que contendrán un objeto de tipo palabra definido previamente. */

    public HashTable() {
        table = new AvlTree[10001];} /* Constructor por defecto donde se instancia tabla con un arreglo de tamaño = 10.0001
        este tamaño nos parecio lo suficientemente grande para realizar un balance entre uso de memoria y
        posibles colisiones (mas tiempo de insercion arbol avl) utilizamos un número primo en el tamaño debido
        a la utilización del operadorn % en la funcion, lo que permite minimizar colisiones.  */


    public HashTable(int size) {
        table = new AvlTree[size];} // Otro constructor por si se necesita un tamaño específico o más chico que el por defecto (No lo usamos).


    public Palabra get(String k) throws Exception { // Esta función toma un String que será la palabra o su codificación y busca en el árbol si se encuentra.
        Palabra pa=new Palabra(); // En caso de encontrarla la retorna.
        pa.setPalabra(k); // Transformo el string en un objeto palabra para poder buscarla en el árbol posteriormente.
        int index = hashFn(k,10001)% table.length; // Obtengo el indice de la posicion del arreglo en el que se debería encontrar dicha palabra.
        if (table[index] == null) // Este if comprueba si la posición del arreglo contiene null (es decir, no hay ningún elemento) y en dicho caso lanza una exepción.
            throw new Exception("404");
        else if(table[index].contains(pa).compareTo(pa)!=0) // Si paso la comprobación quiere decir que hay elementos, pero este if se encarga de ver si se encuntran en dicho árbol.
            throw new Exception("No Encontrado");
        else
            return  (Palabra) table[index].contains(pa); // Finalmente si la encuentra la retorna.
    }

    public void set(Palabra j) throws Exception { // Esta función le llega una palabra como argumento.
        int index = (int) hashFn(j.getPalabra(),10001); // Esta linea se encarga de obtener el índice de la palabra correspondiente.
        if (table[index] == null){
            table[index] = new AvlTree();} // Compruebo si hay un árbol creado en esa posición, en caso de que no lo haya lo crea.

        table[index].insert(j); // Finalmente inserta el objeto palabra en el árbol avl.

    }

    public int hashFn(String s,int M){ // Función hash adecuada para garantizar una mejor disperción de los datos (obtenida vía web)
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char c[] = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char c[] = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return(int) (Math.abs(sum) % M);
    }

}
