package com.github.alonwang.sort;

public class BubbleSorter implements Sorter {

    @Override
    public void sort(Comparable[] a) {
        if (a.length <= 1) {
            return;
        }
        boolean changeFlag = false;
        for (int i = a.length - 1; i > 0; i--) {
            changeFlag = false;
            for (int j = 0; j < i; j++) {
                if (less(a[j + 1], a[j])) {
                    swap(a, j + 1, j);
                    changeFlag = true;
                }
            }
            if (!changeFlag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new BubbleSorter().test();
    }
}
