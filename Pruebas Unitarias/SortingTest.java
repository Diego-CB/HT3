/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* SirtingTest.java
* @author Roberto Vallecillos & Diego Cordova
* @version 1.0
* Ultima modificacion: 2021-02-14
*
* Unitary test's for Sorting class
********************************************************/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import java.util.Random;
import java.util.Arrays;
    
public class SortingTest {

    private static Sorting sort = new Sorting();
    private static Random rand = new Random();

    @Test
    public void bubbleWithOneElementArray() {
        
        Comparable[] array = {1};
        assertEquals(array, sort.BubbleSort(array));
    }

    @Test
    public void QuickWithSameElementArray(){
        Comparable[] array = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        assertEquals(array, sort.QuickSort(array, 0, array.length - 1));
    }

    @Test
    public void radixWithLargeArray(){

        Comparable[] array = new Comparable[5000];
        int num;

        for (int i = 0; i < array.length;i++){

            array[i] = rand.nextInt(1000);
        }

        Comparable[] sortedArray = array;

        assertEquals(sort.BubbleSort(sortedArray), sort.RadixSort(array));
    }

    @Test
    public void MergeSortWithTernaryList(){

        Comparable[] ternary_array = new Comparable[3];

        for (int i = 0; i < 3;i++){

            ternary_array[i] = rand.nextInt(1000);
        }

        Comparable[] sortedArray = ternary_array;
        assertEquals(sort.BubbleSort(sortedArray), sort.MergeSort(ternary_array, 0, ternary_array.length - 1));
    }

    @Test
    public void gnomeWithEvenArray(){
        
        Comparable[] even_array = new Comparable[3];

        for (int i = 0; i < 3;i++){

            even_array[i] = rand.nextInt(1000);
        }

        Comparable[] sortedArray = even_array;
    }
}