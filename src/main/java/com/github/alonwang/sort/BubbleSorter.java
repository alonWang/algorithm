package com.github.alonwang.sort;

import com.github.alonwang.util.SortUtil;

public class BubbleSorter extends AbstractCompareSorter {

    @Override
    public void sort(Comparable[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = a.length - 1; i > 0; i--) {
            boolean changeFlag = false;
            for (int j = 0; j < i; j++) {
                if (a[j + 1].compareTo(a[j]) < 0) {
                    SortUtil.swap(a, j + 1, j);
                    changeFlag = true;
                }
            }
            if (!changeFlag) {
                break;
            }
        }
    }

    @Override
    public SorterType type() {
        return SorterType.Bubble;
    }

    public static void main(String[] args) {
        new BubbleSorter().benchmark();
    }
}
