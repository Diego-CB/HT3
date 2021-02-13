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

import java.util.*;
import java.util.ArrayList;

public class Sorting {
    
    /**
     * Constructor methd, creates an iteration of the class
     */
    public Comparable[] BubbleSort(Comparable[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j <array.length; j++){
				if(array[i].compareTo(array[j]) > 0){
					Comparable temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	//TODO Ciclo infinito
	public Comparable[] QuickSort(Comparable[] array, int x, int y){
		int i = x;
		int j = y;
		Comparable temp;
		Comparable medio = array[(x+y)/2];
		while (x <= y){
			while(array[x].compareTo(medio) <= 0 && x < y) i++;
			while(array[y].compareTo(medio) > 0)j--;
			if (x < y){
				temp = array[x];
				array[x] = array[y];
				array[y] = temp;
				
			}
		}
		array[x] = array[j];
		array[j] = medio;
		if(x < j-1){
			QuickSort(array, x, j-1);
		}if(j+1 < y){
			QuickSort(array, j+1, y);
		}
		return array;
	}
	
	//TODO
	public Comparable[] RadixSort(Comparable[] array){
		
		Comparable max = 0;
		for (int i = 0; i < array.length;i++){

			if (array[i].compareTo(max) == 1){
				max = array[i];
			}
		}

		int digit_length = String.valueOf((int) max).length();
		for (int i = 1; i < digit_length + 1;i++){

			ArrayList[] bucket = new ArrayList[10];
			for (int j; i < 10; i++){
				bucket[i] = new ArrayList<Comparable>();
			}

			for (int j; i < 10; i++){
				bucket[i] = new ArrayList<Comparable>();
			}

		}
		return array;
	}
	
	public Comparable[] GnomeSort(Comparable[] array, int x){
		int ind = 0;
		while (ind < x){
			if (ind == 0){
				ind++;
			}
			if(array[ind].compareTo(array[ind-1]) > 0){
				ind++;
			}else{
				Comparable temp = 0;
				temp = array[ind];
				array[ind] = array[ind-1];
				array[ind-1] = temp;
				ind--;
			}
		}
			return array;
		
	}
	
	public Comparable[] MergeSort(Comparable[] array, int x, int y, int z){
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
			}while(i <= y){
				array[k++] = temp[i++];
			}
		
	return array;
	}	

	private Comparable digit(String[] num, int position){

		if (position > num.length){
			return 0;

		} else{
			return ((Comparable) Integer.parseInt(num[num.length - position]));
		}
	}
}