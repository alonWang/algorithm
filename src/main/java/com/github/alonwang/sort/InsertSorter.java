package com.github.alonwang.sort;

public class InsertSorter implements Sorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            Comparable insertValue = arr[i];
            int insertPos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (insertValue.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                    insertPos = j;
                } else {
                    insertPos = j + 1;
                    break;
                }
            }
            arr[insertPos] = insertValue;
        }
    }

    public static void main(String[] args) {
        new InsertSorter().performanceTest();
    }
}
