package com.github.alonwang.sort;

public class ShellSorter implements Sorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            //各个子数组分别插入排序,i表示子数组的第二个元素下标
            for (int i = gap; i < 2 * gap; i++) {
                for (int j = i; j < arr.length; j += gap) {
                    int pos = j;
                    Comparable cmpVal = arr[j];
                    for (int k = j - gap; k >= 0; k -= gap) {
                        if (cmpVal.compareTo(arr[k]) < 0) {
                            arr[k + gap] = arr[k];
                            pos = k;
                        } else {
                            pos = k + gap;
                            break;
                        }
                    }
                    arr[pos] = cmpVal;
                }
            }

        }
    }

    @Override
    public String name() {
        return "shell";
    }

    public static void main(String[] args) {
        new ShellSorter().performanceTest();
    }
}
