package com.Proyecto.Main;

import com.Proyecto.Lectura.*;
import com.Proyecto.EstructuraDeDatos.*;
import com.Proyecto.Object.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {
    private static String diccionario[]=null,entrada=null;
    private static Lectura lectura = new Lectura();
    private static Escritura escritura = new Escritura();
    private static Scanner in = new Scanner(System.in);
    private static HashTable hashTable = new HashTable();
    private static long startTime, finishTime;
    public static void main(String[] args) throws Exception {

        // Declaro las variables:
        long startTime1, finishTime1;
        String crearNuevo = null;
        boolean validacion;

        // Menu de seleccion:

        // Ingresar el diccionario:

        do {
            System.out.println("Ingrese el nombre del diccionario, ej: \"diccionario2.txt\".");
            args[0] = in.nextLine();
            try {
                startTime = System.currentTimeMillis();
                diccionario = lectura.levantarTxt(args[0]); // Guardo el txt como un String
                finishTime = System.currentTimeMillis();
                System.out.println("El diccionario es valido, y se leyo en: " + (finishTime - startTime) +" ms.");
                validacion = true;
            } catch (Exception e) {
                System.out.println("El diccionario ingresado no existe o tuvo un error de lectura. Intente nuevamente.");
                validacion = false;
            }
        }while(validacion == false);

        //Ingresar la entrada:

        do{
        System.out.println("Ingrese el nombre del texto de entrada, ej: \"entrada.txt\".");
        args[1] = in.nextLine();
            try {
                startTime = System.currentTimeMillis();
                entrada = lectura.levantarE(args[1]); // Guardo el txt como un String
                finishTime = System.currentTimeMillis();
                System.out.println("La entrada es valida, y se leyo en: " + (finishTime - startTime) +" ms.");
                validacion = true;
            } catch (Exception e) {
                System.out.println("la entrada ingresada no existe o tuvo un error de lectura. Intente nuevamente.");
                validacion = false;
            }
        }while(validacion == false);

        // Ingresar la salida:

        do {
            System.out.println("Ingrese el nombre del texto de salida, ej: \"salida.txt\".");
            args[2] = in.nextLine();
            if (!escritura.fileExistente(args[2])){ // Verifico si el texto de salida existe o no.
                System.out.println("El texto de salida no existe, ¿Desea crear uno?, si o no.");
                crearNuevo=in.nextLine();
                if (crearNuevo.contains("si")){
                    escritura.crearArchivo(args[2]);    // Creo el archivo.
                    validacion = true;
                }
                else validacion = false;    // Vuelvo a preguntar para que seleccione otro texto de salida.
            }else {
                System.out.println("El texto de salida fue correctamente seteado.");
                validacion = true;
            }
        }while (validacion == false);

        // Codificacion o decodificacion:

        do {
            System.out.println("Ingrese si quiere codificar de la forma -c o decodificar de la forma -d.");
            args[3] = in.nextLine();
            startTime1 = System.currentTimeMillis();
            validacion = llenarhash(args[3]); // Lleno hash
            if (validacion=true){ // Si se lleno correctamente el hash
                startTime = System.currentTimeMillis();
                String frase=signos(); // A codificar.
                finishTime = System.currentTimeMillis();
                System.out.println("La codificacion, tarda: " + (finishTime - startTime) +" ms.");
                escritura.escribirTxt(frase,args[2]); // Escribo la codificacion en la salida.
                finishTime1 = System.currentTimeMillis();
                System.out.println("Su texto esta traducido al 100% tras: "+ (finishTime1 - startTime1) +" ms."); // Fin programa.
            }
        }while (validacion == false);
    }

    public static boolean llenarhash(String e) throws Exception {
        String aux[]=null;
        if (e.equals("-c")){ // Me fijo si codifico o decodifico.
            startTime = System.currentTimeMillis();
            for (int i = 0; i < diccionario.length; i++){
                Palabra palabra = new Palabra();
                aux = diccionario[i].split("\t"); // Separo cada renglon en un String de 2 partes.
                palabra.setPalabra(aux[0]); // Ala primera la guardo como palabra.
                palabra.setTraduccion(aux[1]); // Ala segunda como traduccion.
                hashTable.set(palabra); // Guardo mi objeto palabra. (Ingresa por la parte de "palabra")
            }
            finishTime = System.currentTimeMillis();
            System.out.println("El hash se cargo en: " + (finishTime - startTime) +" ms.");
            System.out.println("Preparado para la codificacion.");
            return true;
        }
        else if (e.equals("-d")){ // Me fijo si codifico o decodifico.
            startTime = System.currentTimeMillis();
            for (int i = 0; i < diccionario.length;i++){
                Palabra palabra = new Palabra();
                aux = diccionario[i].split("\t"); // Separo cada renglon en un String de 2 partes.
                palabra.setPalabra(aux[1]); // Ala primera la guardo como palabra. Al ser decodificacion es alrevez de la codificacion.
                palabra.setTraduccion(aux[0]); // Ala segunda como traduccion.
                hashTable.set(palabra); // Guardo mi objeto palabra. (Ingresa por la parte de "palabra")
            }
            finishTime = System.currentTimeMillis();
            System.out.println("El hash se cargo en: " + (finishTime - startTime) +" ms.");
            System.out.println("Preparado para la decodificacion.");
            return true;
        }
        else{
            System.out.println("Codigo no valido. Intente nuevamente.");
            return false;
        }
    }

    private static String signos() throws Exception {
        String auxiliar=entrada.toString();
        char[] fInicial=auxiliar.toCharArray(); // Creo mi Frase inicia con el String de entrada.
        int i = 0;
        String fFinal = "";
        String palabra = "";
        while (i<fInicial.length) {
            palabra = "";
            while (!Character.isAlphabetic(fInicial[i])) { // Me fijo que me entran signos.
                fFinal = fFinal + fInicial[i]; // Voy metiendo los signos de primera a mi frase final.
                if (fInicial.length==(i+1)) return fFinal; // Si entra aca es que el i termino de recorrer el fInicial.
                else i++; // Aumento el i.
            }
            while (Character.isAlphabetic(fInicial[i])) { // Me fijo que entran letras.
                palabra = palabra + fInicial[i]; // Creo una palabra.
                if (fInicial.length==(i+1)){ // Si entra aca es que el i termino de recorrer el fInicial.
                    palabra = Codificar (palabra); // Codifico la oración ingresada.
                    fFinal = fFinal + palabra;
                    return fFinal;
                }
                else i++;
            }
            palabra = Codificar(palabra); // Codifico la oración ingresada//
            fFinal = fFinal + palabra; // Armo la frase final con las palabras codificadas.
        }
        return fFinal;
    }

    private static int pMayusMinus(String e) { // Funcion para saber si las palabras son mayusculas o minusculas.
        char[] ax = e.toCharArray();
        String aux = e.toUpperCase();
        char[] ax2 = aux.toCharArray();
        if (ax[0] == ax2[0]) {
            if (ax[1] == ax2[1]) {
                return 2; // Devuelvo 2 si toda la palabra es mayuscula.
            }
            return 1; // Devuelvo 1 si solo la primera letra es minuscula.
        } else {
            return 0; // Devuelvo 0 si toda la palabra es minuscula.
        }
    }

    private static String Codificar(String a) throws Exception {
        String aux2 = a.toLowerCase(); // El palabra a codificar en minuscula.
        String au[] = new String[] {aux2};
        String au2[] = new String[] {a};
        for (int i = 0; i < au.length; i++) {
            try {
                Palabra aux = new Palabra(); // Creo objeto Palabra.
                aux.setPalabra(au[i]); // Pongo au[i] como palabra.
                aux = hashTable.get(aux.getPalabra()); // Busco la palabra en el hash.
                aux2 = aux.getTraduccion(); // Guardo su Traduccion.
                int mayusMinus = pMayusMinus(au2[i]); // Guardo la "bandera" devuelta por la funcion.
                if (mayusMinus == 2) { // Si entro aca es que toda la palabra estaba en mayuscuala.
                    aux2 = aux2.toUpperCase(); // Paso su traduccion a mayuscula.
                } else if (mayusMinus == 1) { // Si entro aca es que la primera letra es mayuscula, las demas no.
                    char[] ax = aux2.toCharArray();
                    String ax1 = "" + ax[0]; // Vacio aCase y le pongo la primera letra.
                    String ax2 = "";
                    ax1 = ax1.toUpperCase(); // Paso la primera letra a mayuscula.
                    for (int l = 1; l < ax.length; l++) {
                        ax2 = ax2 + "" + ax[l]; // Empiezo a armar de nuevo mi palabra traducida con la primera letra en mayuscula.
                    }
                    aux2 = ax1 + ax2; // Vuelvo a armar mi palabra.
                }
                au[i] = aux2;
            } catch (Exception e) {
                return au2[0];
            }
        }
        aux2 = au[0];
        for (int i = 1; i < au.length; i++) {
            aux2 = aux2 + " " + au[i];
        }
        return aux2;
    }
}
