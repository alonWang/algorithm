package com.github.alonwang.sort;

public class BubbleSorter implements Sorter {

    @Override
    public void sort(Comparable[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = a.length - 1; i > 0; i--) {
            boolean changeFlag = false;
            for (int j = 0; j < i; j++) {
                if (a[j + 1].compareTo(a[j]) < 0) {
                    swap(a, j + 1, j);
                    changeFlag = true;
                }
            }
            if (!changeFlag) {
                break;
            }
        }
    }

    @Override
    public String name() {
        return "bubble";
    }

    public static void main(String[] args) {
        new BubbleSorter().performanceTest();
    }
}
