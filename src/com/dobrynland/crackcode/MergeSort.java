package com.dobrynland.crackcode;

/**
 * Created by adobryn on 17.02.2017.
 */
public class MergeSort {
    void merge(int[] arr, int l, int m, int r) {
        int i, j;

        int len_l = m - l + 1;
        int len_r = r - m;
        int[] subarr_l = new int[len_l];
        int[] subarr_r = new int[len_r];

        for (i = 0; i < len_l; i++)
            subarr_l[i] = arr[l + i];

        for (i = 0; i < len_r; i++)
            subarr_r[i] = arr[m + 1 + i];

        i = 0;
        j = 0;
        int curr = l;
        while (i < len_l && j < len_r) {
            if (subarr_l[i] > subarr_r[j]) {
                arr[curr] = subarr_r[j];
                j++;
            } else {
                arr[curr] = subarr_l[i];
                i++;
            }
            curr++;
        }

        while (i < len_l) {
            arr[curr] = subarr_l[i];
            i++;
            curr++;
        }
        while (j < len_r) {
            arr[curr] = subarr_r[j];
            j++;
            curr++;
        }
    }

    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        MergeSort m = new MergeSort();
        m.sort(arr, 0, arr.length - 1);

        printArray(arr);
    }
}
