package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SortingAlgorithms {

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

    public void selectionSort() {
        int n = anArray.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (anArray[j] < anArray[min_idx])
                    min_idx = j;
            // Swap the found minimum element with the first
            // element
            int temp = anArray[min_idx];
            anArray[min_idx] = anArray[i];
            anArray[i] = temp;
        }
    }

    public void insertionSort() {
        int tmpHolder, i, j;
        for (i = 1; i < anArray.length; ++i) {
            tmpHolder = anArray[i];
            //j = i;
            for (j = i; (j > 0 && (anArray[j - 1] > tmpHolder)); j--) {
                anArray[j] = anArray[j - 1];
                //j = j - 1;
                anArray[j - 1] = tmpHolder;
            }
        }
    }

    public void insertionSortWithGuard2() {
        int[] newArray = new int[anArray.length + 1];

        newArray[0] = 0;

        System.arraycopy(anArray, 0, newArray, 1, newArray.length - 1);

        int minValue;
        for (int k = 2; k < newArray.length; k++) {
            minValue = newArray[k];
            // anArray[0] = minValue;
            int j = k - 1;
            while (minValue < newArray[j]) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = minValue;
        }

        anArray = Arrays.copyOfRange(newArray, 1, newArray.length);
    }

    public void insertionSortWithGuard() {
        int minValue;
        //    int newArray[] = new int[anArray.length + 1];
        //  minValue = anArray[0];
        for (int i = 1; i < anArray.length; i++) {
            if (anArray[i] < anArray[0]) {
                int temp = anArray[0];
                anArray[0] = anArray[i];
                anArray[i] = temp;
            }
        }

        for (int i = 2; i < anArray.length; i++) {
            minValue = anArray[i];
            // anArray[0] = minValue;
            int j = i - 1;
            while (minValue < anArray[j]) {
                anArray[j + 1] = anArray[j];
                j = j - 1;
            }
            anArray[j + 1] = minValue;
        }
    }

    public void insertionSortString2() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, stringArray);
        int n = arrayList.size();
        //version with binary search
        for (int i = 1; i < n; i++) {

            if (arrayList.get(i).compareTo(arrayList.get(0)) > 0) {
                String temp = arrayList.get(0);
                arrayList.set(i, arrayList.get(0));
                arrayList.set(0, temp);

            }
        }
        String minValue;
        for (int i = 2; i < n; i++) {
            minValue = arrayList.get(i);
            // anArray[0] = minValue;
            int j = i - 1;
            while (minValue.compareTo(arrayList.get(j)) > 0) {

                arrayList.set(j + 1, arrayList.get(j));
                j = j - 1;
            }
            arrayList.set(j + 1, minValue);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            stringArray[i] = arrayList.get(i);
        }
    }


    public void bubbleSort() {
        for (int i = 0; i < anArray.length; i++) {
            for (int j = 1; j < anArray.length; j++) {
                if (anArray[j - 1] > anArray[j]) {
                    int temp = anArray[j - 1];
                    anArray[j - 1] = anArray[j];
                    anArray[j] = temp;
                }

            }

        }
    }

    public void bubbleSortStringArray() {
        ArrayList<String> arrayList = new ArrayList<String>();

        Collections.addAll(arrayList, stringArray);
        int n = arrayList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    // swap arr[j+1] and arr[i]
                    //int temp = anArray[j];
                    String temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }

        for (int i = 0; i < arrayList.size(); i++) {
            stringArray[i] = arrayList.get(i);
        }
    }


    public void bubbleSort2() //last element after one cycle is always the biggest one
    {
        int tmpHolder;
        for (int j = anArray.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (anArray[i] > anArray[i + 1]) {
                    tmpHolder = anArray[i];
                    anArray[i] = anArray[i + 1];
                    anArray[i + 1] = tmpHolder;
                }
            }
        }

    }

    public void bubbleSort3() //limiting the no of checking operations    CORRECT
    {
        int tmpHolder, p;

        for (int j = anArray.length - 1; j > 0; j--) {
            p = 1; //checker
            for (int i = 0; i < j; i++) {
                if (anArray[i] > anArray[i + 1]) {
                    tmpHolder = anArray[i];
                    anArray[i] = anArray[i + 1];
                    anArray[i + 1] = tmpHolder;
                    p = 0;
                }
            }
            if (p == 1) break;
        }

    }

    public void insertionSortString1() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, stringArray);
        int n = arrayList.size();
        for (int i = 0; i < n; i++) {
            String valuemin;
            valuemin = arrayList.get(i);
            int j = i - 1;
            while (j >= 0 && arrayList.get(j).compareTo(valuemin) > 0) {
                arrayList.set((j + 1), arrayList.get(j));
                j = j - 1;
            }
            arrayList.set((j + 1), valuemin);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            stringArray[i] = arrayList.get(i);
        }
    }

    public void selectionSortString() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, stringArray);

        int n = arrayList.size();
        String temp;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            int index_min = i;
            String valuemin = arrayList.get(i);
            for (j = i + 1; j < n; j++) {
                if (!(valuemin.compareTo(arrayList.get(j)) < 0)) {
                    index_min = j;
                    valuemin = arrayList.get(j);
                }
            }
            temp = arrayList.get(i);
            arrayList.set((i), arrayList.get(index_min));
            arrayList.set((index_min), temp);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            stringArray[i] = arrayList.get(i);
        }
    }

    public void bubbleSortString3() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, stringArray);
        int n = arrayList.size();
        String temp;
        String temp2;
        int start = 0;
        System.out.println(n);
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = start; i < n; i++) {
                if (arrayList.get(i + 1).compareTo(arrayList.get(i)) > 0) {

                    temp = arrayList.get(i + 1);
                    arrayList.set((i + 1), arrayList.get(i));
                    arrayList.set((i), temp);
                    swapped = true;

                }
            }
            if (!swapped)
                break;
            swapped = false;
            --n;
            for (int i = n - 1; i >= start; i--) {
                if (arrayList.get(i + 1).compareTo(arrayList.get(i)) > 0) {
                    temp2 = arrayList.get(i + 1);
                    arrayList.set((i + 1), arrayList.get(i));
                    arrayList.set((i), temp2);
                    swapped = true;
                }
            }
            ++start;

        }
    }

    public void bubleSortString2() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, stringArray);
        int n = arrayList.size();
        String temp;
        System.out.println(n);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j - 1)) > 0) {
                    temp = arrayList.get(j);
                    arrayList.set((j), arrayList.get(j - 1));
                    arrayList.set((j - 1), temp);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            stringArray[i] = arrayList.get(i);
        }
    }

   public void bubble_int3_sting_new(){
        ArrayList<String> arr= new ArrayList<String>();
        Collections.addAll(arr, stringArray);

        for(int j=arr.size()-1;j>0;j-- ){
            int flag=1;
            for (int i= 0; i<j;i++){
                if(!(arr.get(i ).compareTo(arr.get(i+1)) > 0)){
                    String temp= arr.get(i);
                    arr.set((i),arr.get(i+1));
                    arr.set((i+1),temp);
                    flag=0;
                }
            }
            if (flag ==1) break;
        }

       for (int i = 0; i < arr.size(); i++) {
           stringArray[i] = arr.get(i);
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
}