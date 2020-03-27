package com.github.alonwang.sort;

import java.util.Arrays;

public class MergeSorter implements Sorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length);
    }

    @Override
    public String name() {
        return "merge";
    }

    private void mergeSort(Comparable[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private void merge(Comparable[] arr, int low, int mid, int high) {
        Comparable[] left = Arrays.copyOfRange(arr, low, mid);
        Comparable[] right = Arrays.copyOfRange(arr, mid, high);
        int l = 0, r = 0;
        int pos = low;
        for (int i = 0; i < (high - low); i++) {
            Comparable next = null;
            if (l == left.length) {
                next = right[r++];
            } else if (r == right.length) {
                next = left[l++];
            } else if (left[l].compareTo(right[r]) <= 0) {
                next = left[l++];
            } else {
                next = right[r++];
            }
            arr[pos++] = next;
        }
    }

    public static void main(String[] args) {
        new MergeSorter().performanceTest();
    }
}
