package com.bhavya;

import java.util.Arrays;

public class GenericSwap {
    //make a Generic Method to swap elements at given positions
    public static <T> void swap(T[] arr, int i, int j){
        //base case
        if(i<0 || j<0 || i>=arr.length || j>=arr.length){
            throw new IndexOutOfBoundsException("Invalid positions");
        }
        //otherwise swap
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //try on Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        swap(intArray, 1, 3);//expecting output [1,4,3,2,5]
        System.out.println(Arrays.toString(intArray));

        //try on String array
        String[] strArray = {"A", "B", "C", "D"};
        swap(strArray, 0, 2);//expecting output [C,B,A,D]
        System.out.println(Arrays.toString(strArray));
    }
}
