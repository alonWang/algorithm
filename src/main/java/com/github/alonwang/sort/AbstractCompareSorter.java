package com.github.alonwang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class AbstractCompareSorter implements Sorter<Comparable> {
    protected void doBenchmark(Comparable[]... customs) {
        long startMill = System.currentTimeMillis();
        List<Comparable[]> arrays = new ArrayList<>();
        if (customs != null) {
            arrays.addAll(Arrays.asList(customs));
        }

        for (int i = 0; i < 5000; i++) {
            int len = ThreadLocalRandom.current().nextInt(1000);
            Comparable[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(1000);
            }
            arrays.add(arr);

        }
        arrays.forEach(arr -> {
            String origin = show(arr);
            sort(arr);
            boolean isSorted = true;
            for (int k = 1; k < arr.length; k++) {
                if (arr[k].compareTo(arr[k - 1]) < 0) {
                    isSorted = false;
                    break;
                }
            }
            if (!isSorted) {
                System.err.println(type() + " sort failed,original arr: \n" + origin
                        + "\n sorted arr: \n" + show(arr));
                throw new IllegalStateException("Sort failed!");
            }
        });
        long gapMill = System.currentTimeMillis() - startMill;
        System.out.println(type() + " sort all success, avgMills: " + gapMill);
    }

    String show(Comparable[] arr) {
        return Arrays.stream(arr).map(Object::toString)
                .collect(Collectors.joining(" -> ", " [ ", " ] "));

    }

    @Override
    public void benchmark() {
        doBenchmark();
    }
}
