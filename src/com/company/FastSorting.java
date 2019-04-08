package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FastSorting {

    private Random random = new Random();

    private int[] anArray;

    private String[] stringArray;


    public int[] getArray() {
        anArray = new int[8000];
        return anArray;
    }

    public void printArray() {
        for (int n : anArray) {
            System.out.println(n + " ");
        }
    }

    public void fillArrayWithRandomInt() {
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = random.nextInt(100000) + 10;
        }
    }

    public String[] getStringArray() {
        stringArray = new String[1000];
        return stringArray;
    }

    public void fillArrayOfStringWithRandomPhrase() {
        File file = new File("20k.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert sc != null;
        int i = 0;
        while (sc.hasNextLine() && (stringArray.length != i)) {
            stringArray[i] = sc.nextLine();
            System.out.println(stringArray[i]);
            i++;
        }
    }

    public void printStringArray() {
        for (String string : stringArray) {
            System.out.println(string);
        }
    }


    public boolean ifSorted() {
        int i = 1;
        boolean is_sorted = true;
        int length = anArray.length;

        while ((i < length) && is_sorted) {
            if (anArray[i - 1] > anArray[i]) {
                is_sorted = false;
            }

            i++;
        }
        return is_sorted;
    }


    public boolean ifSortedString() {
        printStringArray();
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, stringArray);
        int i = 1;
        boolean is_sorted = true;
        int N = arrayList.size();
        while ((i < N) && is_sorted) {
            if (arrayList.get(i - 1).compareTo(arrayList.get(i)) < 0) {
                is_sorted = false;
            }
            i++;
        }

//        boolean ascending = true, descending = true;
//        for (int i = 1; i < arrayList.length && (ascending || descending); i++) {
//            ascending = ascending && arrayList[i] >= arrayList[i-1];
//            descending = descending && arrayList[i] <= arrayList[i-1];
//        }
        return (is_sorted);
    }


    public void callQuickSort() {
        quickSort(0, anArray.length - 1);
    }

    private void quickSort(int first, int last) {

        if (first < last) {
            int pivot = anArray[first];
            int s = first;
            for (int i = first +1; i < last; i++) {
                if (anArray[i] < pivot) {
                    s = s + 1;
                    int temp = anArray[s];
                    anArray[s] = anArray[i];
                    anArray[i] = temp;
                    //    swap(anArray[s], anArray[i]);
                }
            }
            int temphold = anArray[s];
            anArray[s] = anArray[first];
            anArray[first] = temphold;

          //  swap(anArray[s], anArray[first]);
            quickSort(first, s - 1);
            quickSort(s + 1, last);

        }

    }

    public void swap(int first, int last) {
        System.out.println("first " + first + " last " + last);
        int temp = first;
        first = last;
        last = temp;
        System.out.println("first " + first + " last " + last);
    }
}
