/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Driver.java
* @author Roberto Vallecillos & Diego Cordova
* Ultima modificacion: 2021-02-10
*
* clase sortGenerator
* Generate a sorting type class using factory Design pattern
********************************************************/

public class SortGenerator {
    
    /**
     * Constructor methd, creates an iteration of the class
     */
    public SortGenerator(){

    }

    public Sort createSort(int type){

        if (type == 1){

            return new GnomeSort();

        } else if (type == 2){

            return new MergeSort();
            

        } else if (type == 3){

            return new QuickSort();

        } else if (type == 4){

            return new RadixSort();

        } else if (type == 5){

            //TODO
            return null;
        
        } else{
            return null;
        }

    }
}
