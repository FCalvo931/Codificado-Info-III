package com.Proyecto.Lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Lectura {
    public String[] levantarTxt(String txt) throws FileNotFoundException {
        Scanner f = new Scanner(new File(txt));
        String aux = f.useDelimiter("\\A").next();
        String[] a = aux.split("\n");
        return a;
    }

    public String levantarE (String txt) throws FileNotFoundException {
        String asd="";
        try {
            BufferedReader leer = new BufferedReader(new FileReader(txt)); // Donde va a leer.
            String linea = leer.readLine(); // Llee linea por linea.
            while (linea != null) { // Lo va leer hasta que la linea sea igual a null.
                asd = asd + linea; // Creo el String de entrada.
                linea = leer.readLine(); // Leo linea por linea.
            }
        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
        return asd;
    }

}
