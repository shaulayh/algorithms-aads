package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FastSorting {

    private Random random = new Random();

    private int[] anArray;

    private String[] stringArray;


    public int[] getArray() {
        anArray = new int[128000];
        return anArray;
    }

    public void printArray() {
            System.out.println(Arrays.toString(anArray));

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

    private void quickSort(int l, int r) {
        if (l < r) {
            int pivot = anArray[l];
            int s = l;
            for (int i = l + 1; i <= r; i++) {
                if (anArray[i] < pivot) {
                    s = s + 1;
                    int temp = anArray[s];
                    anArray[s] = anArray[i];
                    anArray[i] = temp;
                }
            }
            int tempholder = anArray[s];
            anArray[s] = anArray[l];
            anArray[l] = tempholder;
            quickSort(l, s - 1);
            quickSort(s + 1, r);
        }
    }

    public void callQuickSortWithMedian() {
        quickSortWithMedian(0, anArray.length - 1);
    }

    // using the medain as the pivot
    private int partition(int arr[], int left, int right) {

        int i = left, j = right;

        int tmp;

        int pivot = arr[(left + right) / 2];


        while (i <= j) {

            while (arr[i] < pivot)

                i++;

            while (arr[j] > pivot)

                j--;

            if (i <= j) {

                tmp = arr[i];

                arr[i] = arr[j];

                arr[j] = tmp;

                i++;

                j--;

            }

        }
        ;


        return i;

    }

    private void quickSortWithMedian(int left, int right) {

        int index = partition(anArray, left, right);

        if (left < index - 1)

            quickSortWithMedian(left, index - 1);

        if (index < right)

            quickSortWithMedian(index, right);

    }

    public void callRandomizedQuickSort() {
        RandomizedQuickSort(anArray, 0, anArray.length - 1);
    }


    private static void RandomizedQuickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivot = randomizedPartition(array, startIndex, endIndex);
            RandomizedQuickSort(array, startIndex, pivot - 1);
            RandomizedQuickSort(array, pivot + 1, endIndex);
        }
    }

    private static int randomizedPartition(int[] array, int startIndex, int endIndex) {
        int randomEndIndex = randomNumberBetween(startIndex, endIndex);
        swap(array, endIndex, randomEndIndex);
        return partition_r(array, startIndex, endIndex);
    }

    private static int randomNumberBetween(int startNumber, int endNumber) {
        return (int) Math.floor(Math.random() * (endNumber - startNumber + 1) + startNumber);
    }

    private static int partition_r(int[] array, int startIndex, int endIndex) {
        int pivotValue = array[endIndex];
        int pivotIndex = startIndex;

        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= pivotValue) {
                swap(array, pivotIndex, j);
                pivotIndex = pivotIndex + 1;
            }
        }
        swap(array, pivotIndex, endIndex);
        return pivotIndex;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


    public void shellSort() {
        int h = 1;
        while (h < anArray.length / 9) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < anArray.length; i++) {
                int x = anArray[i];
                int j = i;
                while (j > h - 1 && x < anArray[j - h]) {
                    anArray[j] = anArray[j - h];
                    j -= h;
                }
                anArray[j] = x;
            }
            h /= 3;
        }
    }

    public void shellSortm() {
        int n = anArray.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = anArray[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && anArray[j - gap] > temp; j -= gap)
                    anArray[j] = anArray[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                anArray[j] = temp;
            }
        }
    }

    public void shellSortFabian() {
        // 2^k + 1 is the pivot
        int i, j, x, h, k;
        h = 1;
        k = 1;


        while (h == 1) {
            for (j = anArray.length - h - 1; j >= 0; j--) {
                x = anArray[j];
                i = j + h;
                while ((i < anArray.length && (x > anArray[i]))) {
                    anArray[i - h] = anArray[i];
                    i += h;
                }
                anArray[i - h] = x;
            }
            k++;
            h = (int) Math.pow(2, k) + 1;
        }
    }

    public int[] callQuickInsertion() {
        return quickInsertion(0, anArray.length - 1);
    }

    private int[] insertionSort(int l, int n) {
        for (int i = l; i <= n; i++) {

            int value_min = anArray[i];
            int j = i - 1;
            while (j >= 0 && value_min < anArray[j]) {
                anArray[j + 1] = anArray[j];
                j = j - 1;
            }
            anArray[j + 1] = value_min;
        }
        return anArray;
    }

    private int[] quickInsertion(int l, int r) {
        // do insertion sort if 10 or smaller
        if (r - l < 100) {
            int[] arryt = insertionSort(l, r);
            return arryt;
        } else {

            int pivot = anArray[l];
            int s = l;
            for (int i = l + 1; i <= r; i++) {
                if (anArray[i] < pivot) {
                    s += 1;
                    int index = anArray[s];
                    anArray[s] = anArray[i];
                    anArray[i] = index;
                }
            }
            int index2 = anArray[s];
            anArray[s] = anArray[l];
            anArray[l] = index2;

            quickInsertion(l, s - 1);
            quickInsertion(s + 1, r);
        }
        return anArray;
    }
}
