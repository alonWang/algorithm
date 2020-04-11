package com.github.alonwang.sort;

import com.github.alonwang.util.SortUtil;

public class QuickSorter extends AbstractCompareSorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(Comparable[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = partition(arr, low, high);
        quickSort(arr, low, mid);
        quickSort(arr, mid + 1, high);
    }

    private int partition(Comparable[] arr, int low, int high) {
        Comparable cmpValue = arr[high - 1];
        int i = low;
        for (int j = low; j < high - 1; j++) {
            if (arr[j].compareTo(cmpValue) <= 0) {
                SortUtil.swap(arr, i++, j);
            }
        }
        SortUtil.swap(arr, i, high - 1);
        return i;
    }

    @Override
    public SorterType type() {
        return SorterType.Quick;
    }

    public static void main(String[] args) {
        new QuickSorter().doBenchmark(new Integer[]{1, 2, 3, 4, 0}, new Integer[]{1, 0}, new Integer[]{0, 1}, new Integer[]{1, 1, 2}, new Integer[]{2, 2, 1});
    }
}
