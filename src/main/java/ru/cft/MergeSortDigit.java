package ru.cft;

import static ru.cft.Constants.asc;

public class MergeSortDigit {

    public static boolean marker;

    public static void mergeSort(int[] src, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);
        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(src, left, right, mid, n - mid);
    }

    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0;
        int i = 0, j = 0;
        while (i < leftLength && j < rightLength) {
            initMarker(asc, left, right, i, j);
            if (marker) {
                src[k++] = left[i++];
            } else {
                src[k++] = right[j++];
            }
        }
        while (i < leftLength) {
            src[k++] = left[i++];
        }
        while (j < rightLength) {
            src[k++] = right[j++];
        }
    }

    private static void initMarker(boolean asc, int[] left, int[] right, int i, int j) {
        marker = asc ? (left[i] <= right[j]) : (left[i] >= right[j]);
    }
}