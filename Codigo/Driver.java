/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Driver.java
* @author Roberto Vallecillos & Diego Cordova
* @version 1.0
* Ultima modificacion: 2021-02-14
*
* Driver Program
* Contains main method
********************************************************/

public class Driver {
    
    // Atributos
    private static Comparable[] listToSort;
    private static Vista v = new Vista();
    private static Sorting sort = new Sorting();
    
    /**
     * main method
     * @param args String arguments
     * @return void
     */
    public static void main(String[] args)
    {

        v.print("\n\nBienvenido al sorting App!!\n");
        boolean menu_p = true;
        int opcion;
        Comparable[] list = {0, 295, 31, 3};

        while (menu_p){

            v.writeList();
            listToSort = v.newList();

            if (listToSort[0] instanceof Comparable){

                opcion = v.input(5);
                
                // Gnome Sort
                if (opcion == 1){

                    listToSort = sort.GnomeSort(listToSort, listToSort.length);

                // Merge sort
                } else if (opcion == 2){

                    listToSort = sort.MergeSort(listToSort, 0, listToSort.length - 1);
                    
                // Quick Sort
                } else if (opcion == 3){

                    listToSort = sort.QuickSort(listToSort, 0, listToSort.length - 1);
                
                // radix Sort
                } else if (opcion == 4){

                    listToSort = sort.RadixSort(listToSort);
                    
                //Bubble sort
                } else if (opcion == 5){

                    listToSort = sort.BubbleSort(listToSort);
                }

                v.orderedList(listToSort);
            } 
            
            menu_p = v.input();

            if (menu_p){
                v.clearFile();
            }
        }
        v.print("\n\nGracias por usar el Sorting App!!\n");
    }
}
