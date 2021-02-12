/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Vista.java
* @author Roberto Vallecillos & Diego Cordova
* @version 1.0
* Ultima modificacion: 2021-02-12
*
* Vista del programa
********************************************************/

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Vista {

    // Atributos
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    /** 
     * simplification of System.out.println()
     * @param o
     * @return void
     */
    public void print(Object o){
        System.out.println(o);
    }

    /** 
     * It prints a mesage, ask for an input and aplies defenssive programming
     * @param size size of menu
     * @return boolean
     */
    public int input(int size){

        print("\nCon que algoritmo quiere ordenar la lista?:\n1. Gnome-Sort\n2. Merge-Sort\n3. Quick-Sort\n4.Radix-Sort\n5.//TODO\n");
        while (true) { //Se repite hasta que se logre el return

            try { 

              int opcion = Integer.parseInt(scan.next());
              if (opcion > 0 && opcion < (size + 1)) {

                return opcion;

              } else {

                throw new NumberFormatException();
              }

            } catch (NumberFormatException e) {
                print("\nERROR: Escoja una opcion valida\n");
            }
        }
    }

    /**
     * @return returns true if input is 1 and false input is 2
     */
    public boolean input(){

        print("\nQue hara?\n1. Ordenar otra lista\n2. Salir\n");
        while (true) { //Se repite hasta que se logre el return

            try { 

              int opcion = Integer.parseInt(scan.next());
              if (opcion > 0 && opcion < (3)) {

                if (opcion == 1){

                    return true;

                } else{
                    return false;
                }

              } else {

                throw new NumberFormatException();
              }

            } catch (NumberFormatException e) {
                print("\nERROR: Escoja una opcion valida\n");
            }
        }
    }

    /**
     * It reads a txt file and turns it members into a Comparable type list
     * @return a Comparable list with members on readed ttx file
     */
    public Comparable[] newList(){
        
        File file = new File("list.txt");
        try {
            
            print("\nLeyendo archivo list.txt");
            Scanner scanFile = new Scanner(file);
            String temp_stringList = scanFile.nextLine();
            Comparable[] new_list = temp_stringList.split(" ");
            return new_list;

        } catch (FileNotFoundException e) {
            
            print("ERROR: NO se encontro el archivo \"list.txt\"\n");
            return null;
        }
    }

    /**
     * Write a random size list (10 - 3000) of random numbers in a txt file
     * @return void
     */
    public void writeList(){

        int num, listSize = rand.nextInt(2091) + 10;
        int[] newList = new int[listSize];

        for (int i = 0; i < newList.length;i++){

            num = rand.nextInt(1000);
            newList[i] = num;
        }

        String temp_list = "";

        for (int i = 0; i < newList.length;i++){

            temp_list += newList[i] + " ";
        }

        print("\nLa lista original es:\n" + temp_list);

        try {

            print("\nEscribiendo lista en archivo \"list.txt\"");
            FileWriter writer = new FileWriter("list.txt");
            writer.write(temp_list);
            writer.close();
            print("La lista se ha escrito exitosamente en el archivo \"list.txt\"");
            
        } catch (IOException e) {
            print("ERROR: No se encontro el archivo \"list.txt\"\n");
        }
    }
}