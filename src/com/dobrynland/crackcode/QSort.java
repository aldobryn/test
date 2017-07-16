package com.dobrynland.crackcode;

public class QSort {

    public int moveAndSwap(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if (i <= j) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i++;
                j--;
            }
        }
        return i;
    }

    public void quickSort(int[] arr, int left, int right) {
        int index = moveAndSwap(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    public void printArr(int arr[], int curr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == curr - 1)
                System.out.print("*");
            System.out.print(arr[i]);

            if (i == curr - 1)
                System.out.print("*");

            System.out.print(" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 9, 1, 3, 7, 0, 4, 5, 3, 4};
        QSort qs = new QSort();
        qs.quickSort(arr, 0, arr.length - 1);
        qs.printArr(arr, -1);
    }
}
