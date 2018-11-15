package com.Proyecto.Lectura;

import java.io.*;

public class Escritura {
    FileWriter escritor;

    public Escritura() {
    }

    public void escribirTxt(String frase, String e) throws IOException {
        this.escritor = new FileWriter(e); // Donde voy a escribir.
        escritor.write(frase); // Lo que voy a escribir.
        escritor.close(); // Cierro el txt.
    }

    public boolean fileExistente(String e) throws IOException { // Funcion retorna si existe o no el txt de salida.
        File fileSalida = new File(e);
        return fileSalida.exists();
    }

    public void crearArchivo(String salida) throws IOException { // Funcion crea un archivo vacio.
        FileWriter escritor = new FileWriter(salida);
        escritor.write("");
        escritor.close();
    }
}