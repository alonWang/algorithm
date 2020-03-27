package com.github.alonwang.sort;

public class SelectSorter implements Sorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int minPos = i - 1;
            Comparable minValue = arr[i - 1];
            for (int j = i; j < arr.length; j++) {
                if (minValue.compareTo(arr[j]) > 0) {
                    minPos = j;
                    minValue = arr[j];
                }
            }
            swap(arr, minPos, i - 1);
        }
    }

    @Override
    public String name() {
        return "select";
    }

    public static void main(String[] args) {
        new SelectSorter().performanceTest();
    }
}
