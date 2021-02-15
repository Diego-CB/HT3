/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Sorting.java
* @author Roberto Vallecillos & Diego Cordova
* @version 1.0
* Ultima modificacion: 2021-02-14
*
* Clase Sorting
* Implementation of sorting algorithms
********************************************************/

import java.util.*;
import java.util.ArrayList;

public class Sorting {
    
    /**
	 * It sorts an array using bubble sort algorithm
	 * @param array unsorted Comparable array to sort
	 * @return the sorted array
	 */
    public Comparable[] BubbleSort(Comparable[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j <array.length; j++){
				if(array[i].compareTo(array[j]) < 0){
					Comparable temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	
	/**
	 * It sorts an array using Quick sort algorithm
	 * @param array unsorted array
	 * @param fisrt fisrt element of the list to sorted
	 * @param last last element of the list to sorted
	 * @return the sorted array
	 **/
  	public Comparable[] QuickSort(Comparable[] array, int first, int last){
    	
		/**
		 * the pivot, left and righ peek are difined
		 */
    	int left_peek = first;
    	int right_peek = last;
    	Comparable pivot = array[(left_peek + right_peek) / 2]; 

		// while the left peek is not equal to the right peek
		while( left_peek <= right_peek){

			/**
			 * if the pivot is grater than the left peek (the left peek is in its position)
			 * then the left peek change to the next element in the array
			 */
			while(compareTo(pivot, array[left_peek])){
				left_peek++;
			} 

			/**
			 * if the right peek is grater than the pivot (the right peek is in its position)
			 * then the right peek change to the previous element in the array
			 */
			while(compareTo(array[right_peek], pivot)){
				right_peek--;
			}

			/**
			 * if right peek is grater or equal to the left peek
			 * ten we swap the left and right peek in the array
			 */
			if(left_peek <= right_peek){

				Comparable temp = array[left_peek];
				array[left_peek] = array[right_peek];
				array[right_peek] = temp;
				left_peek++;
				right_peek--;
			}
		}

		/**
		 * The higher part of the array is sorted using recursivity
		 * until the array size is 1
		 */
		if(first < right_peek){

			QuickSort(array, first, right_peek);
		}
		
		/**
		 * The lower part of the array is sorted using recursivity
		 * until the array size is 1
		 */
		if(left_peek < last){

			QuickSort(array, left_peek, last);
		}

		return array;
	}
	
	/**
	 * It sorts an array using radix sort algorithm
	 * @param array unsorted Comparable array to sort
	 * @return the sorted array
	 */
	public Comparable[] RadixSort(Comparable[] array){
		
		/**
		 * get the max number in the array to sort
		 */
		Comparable max = 0;
		for (int i = 0; i < array.length;i++){

			if (array[i].compareTo(max) == 1){
				max = array[i];
			}
		}

		int digit_length = String.valueOf((int) max).length(); // number of digits in the max number
		
		/**
		 * Repit sorting the number of diigits in max number
		 */
		for (int i = 1; i < digit_length + 1;i++){

			/**
			 * create a bucket list of list's of comparable objects "Bucket"
			 * with size 10 (one for each digit in decimal)
			 */
			ArrayList<Comparable>[] bucket = new ArrayList[10];
			for (int j = 0; j < 10; j++){
				bucket[j] = new ArrayList<Comparable>();
			}

			/**
			 * evaluate the i digit of ecery number 
			 * and place them into the corresponding bucket array
			 */
			for (int j = 0; j < array.length; j++){
				
				Comparable temp = digit(String.valueOf(array[j]).split(""), i);
				bucket[(int) temp].add(array[j]);
			}

			/**
			 * Create a linear array based on the bucket
			 * thats the new array
			 */
			ArrayList<Comparable> temp_array = new ArrayList<Comparable>();
			for (int j = 0; j < 10; j++){
				for (int k = 0; k < bucket[j].size(); k++){

					temp_array.add(bucket[j].get(k));
				}
			}

			for (int j = 0; j < temp_array.size() ;j++){
				array[j] = temp_array.get(j);
			}
		}
		return array;
	}
	
	/**
	 * It sorts an array using Gnome sort algorithm
	 * @param array unsorted Comparable array to sort
	 * @param x size of the unsorted Comparable array to sort 
	 * @return the sorted array
	 */
	//TODO arreglar sorting
	public Comparable[] GnomeSort(Comparable[] array, int x){
		int ind = 0;
		while (ind < x){
			if (ind == 0){
				ind++;
			}
			if(array[ind].compareTo(array[ind-1]) >= 0){
				ind++;
			}else{
				Comparable temp;
				temp = array[ind];
				array[ind] = array[ind-1];
				array[ind-1] = temp;
				ind--;
			}
		}
			return array;
		
	}

	/**
	 * Auxilary method that helps with the different arays for Sortinh
	 * @param array unsorted Comparable array to sort
	 * @return the half of sorted array
	 */
	public Comparable[] SortM(Comparable[] array, int x, int y, int z){
		int i, j, k;
		Comparable[] temp = new Comparable[array.length];
		for (i = x; i <= z; i++){
			temp[i] = array[i];
		}
		i = x;
		j = y+1;
		k = x;
		while(i <= y && j <= z){
			if (temp[i].compareTo(temp[j]) <= 0){
				array[k++] = temp[i++];
			}else{
				array[k++] = temp[j++];	
			}
			}
		while(i <= y){
				array[k++] = temp[i++];
		}
		
	return array;
	}	
	
	/**
	 * It sorts an array using Merge sort algorithm
	 * @param array unsorted Comparable array to sort
	 * @param x a base number, it has to be equal to 0
	 * @return the sorted array
	 */
	public Comparable[] MergeSort(Comparable[] array, int x, int z){
		if (x < z){
			int y = x + (z-x)/2;
			MergeSort(array, x, y);
			MergeSort(array, y+1, z);
			array = SortM(array, x, y, z);
		}
		return array;
	}
	
	/**
	 * It returns the digit in the given position of a number
	 * @param num String with number digits
	 * @param position requested position of the number
	 * @return If the number has the position wanted it return the digit in that position, if not returns 0
	 */
	private Comparable digit(String[] num, int position){

		if (position > num.length){
			return 0;

		} else{
			return ((Comparable) Integer.parseInt(num[num.length - position]));
		}
	}

	/**
	 * Compares 2 comparables
	 * @param x Comparable to evaluate
	 * @param y Comparable to compare
	 * @return returns true if x > y, and false if not
	 */
	private boolean compareTo(Comparable x, Comparable y){

		if ((x.compareTo(y)) == 1){

			return true;
		} else{
			return false;
		}
	}

}