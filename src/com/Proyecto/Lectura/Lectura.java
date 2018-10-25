package com.Proyecto.Lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lectura {
    public String[] LevantarTxt(String txt) throws FileNotFoundException {
        Scanner f = new Scanner(new File(txt));
        String aux = f.useDelimiter("\\A").next();
        String[] a = aux.split("\n");
        return a;
    }
}
