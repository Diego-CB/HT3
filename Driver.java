/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Driver.java
* @author Roberto Vallecillos & Diego Cordova
* @version 1.0
* Ultima modificacion: 2021-02-12
*
* Driver Program
********************************************************/

public class Driver {
    
    // Atributos
    private static Comparable[] listToSort;
    private static Vista v = new Vista();
    
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

        while (menu_p){

            v.writeList();
            listToSort = v.newList();

            if (listToSort[0] instanceof Comparable){

                opcion = v.input(5);
                v.print("\nEsta es la lista ordenada: \n");

                if (opcion == 1){
 
                } else if (opcion == 2){

                } else if (opcion == 3){

                } else if (opcion == 4){

                } else if (opcion == 5){

                }
            } 
            
            menu_p = v.input();
        }
        v.print("\n\nGracias por usar el Sorting App!!\n");
    }
}