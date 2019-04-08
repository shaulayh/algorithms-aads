package com.company;

public class Main {

    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

//        sortingAlgorithms.getArray();
//        sortingAlgorithms.fillArrayWithRandomInt();
//
//        long startTime = System.currentTimeMillis();
//        // sortingAlgorithms.insertionSortWithGuard();
//        // sortingAlgorithms.insertionSortWithGuard2();
//        /// sortingAlgorithms.bubbleSort2();
//        sortingAlgorithms.bubbleSort();
//        // sortingAlgorithms.bubbleSort3();
//        long endTime = System.currentTimeMillis();
//
//        sortingAlgorithms.printArray();
//        System.out.println();
//        System.out.println(sortingAlgorithms.ifSorted());
//
//
//        System.out.println("it took " + (endTime - startTime) + " milli seconds");

//        sortingAlgorithms.getStringArray();
//        sortingAlgorithms.fillArrayOfStringWithRandomPhrase();
//
//        //    sortingAlgorithms.printStringArray();
//        System.out.println();
//        long startTime = System.currentTimeMillis();
//        //  sortingAlgorithms.insertionSortString1();
//         //  sortingAlgorithms.selectionSortString();
//        // sortingAlgorithms.bubbleSortStringArray();
//        //   sortingAlgorithms.bubleSortString2();
//       //      sortingAlgorithms.insertionSortString2();
//        sortingAlgorithms.bubble_int3_sting_new();
//        //      sortingAlgorithms.bubbleSortString3();
//        long endTime = System.currentTimeMillis();
//        System.out.println("***********************************************");
//     //   sortingAlgorithms.printStringArray();
//
//
//        System.out.println(sortingAlgorithms.ifSortedString());
//
//        System.out.println("it took " + (endTime - startTime) + " milli seconds");

        FastSorting fastSorting = new FastSorting();
        fastSorting.getArray();
        fastSorting.fillArrayWithRandomInt();

        long startTime = System.currentTimeMillis();
        fastSorting.callQuickSort();
        long endTime = System.currentTimeMillis();
        fastSorting.printArray();


        fastSorting.ifSorted();

    }
}
