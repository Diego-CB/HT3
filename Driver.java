/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Driver.java
* @author Roberto Vallecillos & Diego Cordova
* Ultima modificacion: 2021-02-10
*
* Driver Program
********************************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Driver {
    
    // Atributos
    private static Scanner scan = new Scanner(System.in);
    private static Sort sorting;
    private static SortGenerator creator = new SortGenerator();
    private static ArrayList<Integer> listToSort = new ArrayList<Integer>();
    private static Random rand = new Random();

    /** 
     * simplification of System.out.println()
     * @param o
     */
    private static void print(Object o){
        System.out.println(o);
    }

    /** 
     * It prints a mesage, ask for an input and aplies defenssive programming
     * @param size size of menu
     * @return boolean
     */
    private static int input(int size){

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
    private static boolean input(){

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
     * It fills listToSort field with random numbers and random number of members
     */
    private static void mix(){
        
        listToSort.clear();
        int num, listSize = rand.nextInt(20);

        for (int i = 0; i < listSize;i++){

            num = rand.nextInt(1000);
            listToSort.add(num);
        }

        print("\nLa lista original es:\n");
        String temp_list = "";

        for (int i = 0; i < listToSort.size();i++){

            temp_list += listToSort.get(i) + " ";
        }
        print(temp_list + "\n");
    }

    /**
     * main method
     * @param args String arguments
     */
    public static void main(String[] args)
    {

        print("\n\nBienvenido al sorting App!!\n");
        boolean menu_p = true;

        while (menu_p){

            mix();
            sorting = creator.createSort(input(5));
            print("\nEsta es la lista ordenada: \n" + sorting.sort(listToSort));
            menu_p = input();
        }
        print("\n\nGracias por usar el Sorting App!!\n");
    }
}
