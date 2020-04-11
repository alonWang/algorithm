package com.github.alonwang.sort;

public class ShellSorter implements Sorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int subArrsNum = arr.length / 2; subArrsNum >= 1; subArrsNum /= 2) {
            //处理每个子数组
            for (int secondElePos = subArrsNum; secondElePos < 2 * subArrsNum; secondElePos++) {
                for (int elePos = secondElePos; elePos < arr.length; elePos += subArrsNum) {
                    int toInsertELePos = elePos;
                    Comparable toInsertEleVal = arr[elePos];
                    for (int orderedElePos = elePos - subArrsNum; orderedElePos >= 0; orderedElePos -= subArrsNum) {
                        if (toInsertEleVal.compareTo(arr[orderedElePos]) < 0) {
                            arr[orderedElePos + subArrsNum] = arr[orderedElePos];
                            toInsertELePos = orderedElePos;
                        } else {
                            toInsertELePos = orderedElePos + subArrsNum;
                            break;
                        }
                    }
                    arr[toInsertELePos] = toInsertEleVal;
                }
            }

        }
    }

    @Override
    public SorterType type() {
        return SorterType.Shell;
    }

    public static void main(String[] args) {
        new ShellSorter().performanceTest();
    }
}
