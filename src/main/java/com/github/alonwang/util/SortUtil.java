package com.github.alonwang.util;

import com.github.alonwang.sort.Sorter;
import com.github.alonwang.sort.SorterFactory;
import com.github.alonwang.sort.SorterType;

public class SortUtil {

    public static void sort(Comparable[] arr, boolean stable) {
        Sorter sorter = stable ? SorterFactory.get(SorterType.Merge) : SorterFactory.get(SorterType.Quick);
        sorter.sort(arr);
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isOrdered(Comparable[] arr) {
        return isOrdered(arr, true);
    }

    public static boolean isOrdered(Comparable[] arr, boolean asc) {
        if (arr.length <= 1) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (asc && arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            } else if (!asc && arr[i].compareTo(arr[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
