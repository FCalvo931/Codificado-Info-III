package com.Proyecto.Main;

import com.Proyecto.EstructuraDeDatos.ArbolAVL;
import com.Proyecto.Lectura.Lectura;
import com.Proyecto.Object.Palabra;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //------------Declaracion de variables--------------//
        String a[] = null, aux2[], dic[], aux[], txt = "dic.dic", au;
        Palabra pa = new Palabra();
        ArbolAVL av = new ArbolAVL();
        Lectura l = new Lectura();
        Scanner in = new Scanner(System.in);
        long startTime, finishTime;
        char q[];
        //-------------------------------------------------//

        //--------------------Levantar txt----------------//
        try {
            startTime = System.currentTimeMillis();
            a = l.LevantarTxt(txt);
            finishTime = System.currentTimeMillis();
            System.out.println("//El archivo se levanto en " + (finishTime - startTime) + " MilisSeg//\n");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo: " + txt + "\n\nFin del Programa");
            System.exit(1);

        }
        //-----------------------------------------------//
        System.out.println("Encriptacion de archivos v1.021\n");


        //---------------------Paso todas las lineas a un objeto palabra------------------//

        startTime = System.currentTimeMillis();

        for (int i = 0; i < a.length; i++) {
            aux2 = a[i].split("\t");
            pa.setPalabra(aux2[0]);
            pa.setTraduccion(aux2[1]);

            //----------------Queremos agrupar las palabras según la letra inicial---------------//

            //---------------------------------------------------------------------------------//

            av.insertar(pa);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("//El arbol se cargo en " + (finishTime - startTime) + " MilisSeg//\n");

        //-------------------------------------------------------------------------------//


        System.out.println("");
        System.out.println("Ingrese una oración:");
        au = in.nextLine();

        // aux=Rstring(au);

        String aux3 = Codif(au, av);//Codifico la oración ingresada//
        System.out.println("Codificación: \n");
        System.out.println(aux3);
    }

    private static String[] Rstring(String aux) {
        String a[] = aux.split("\\s");
        return a;
    }

    private static String[] Rstring(String aux, ArbolAVL av) {//Funcion que tiene el codificar//
        String a[] = aux.split("\\s");
        return a;
    }

    private static String Codif(String a, ArbolAVL av) throws Exception {
        String aux;
        String au[] = Rstring(a);

        for (int i = 0; i < au.length; i++) {
            try {
                System.out.println("Busco: " + au[i]);
                aux = av.buscar(au[i]);
                au[i] = aux;
            } catch (Exception e) {
                au[i] = e.getMessage();
            }
        }
        aux = au[0];
        for (int i = 1; i < au.length; i++) {
            aux = aux + " " + au[i];
        }

        return aux;
    }


    private static int pMayusMinus(String a) {//Funciona//
        char[] ax = a.toCharArray();
        String aux = a.toUpperCase();
        char[] ax2 = aux.toCharArray();
        if (ax[0] == ax2[0]) {

            if (ax[1] == ax2[1]) {
                //toda la palabra en mayuscula;
                return 2;
            }
            System.out.println("");
            return 1;
        } else {
            return 0;
        }
    }



    //Estructura Propia//
    /*
    private static int insertarE(Palabra a){
        char aux[]=a.getPalabra().toCharArray();
        ArrayList ae[]=new ArrayList[27];
        String aux2=""+aux[0];
        for(int i=0;i<27;i++){
            if(ae[i]==null){
                ae[i]=new ArrayList<Palabra>();
            }else{
                Palabra aux3=(Palabra) ae[i].get(0);
               char aux4[]=aux3.getPalabra().toCharArray();
               String aux0=""+aux4[0];
                if(aux0.compareTo(aux2)==0){
                    ae[i].add(a);
                }
            }
        }

        return 0;
    }*/
}

