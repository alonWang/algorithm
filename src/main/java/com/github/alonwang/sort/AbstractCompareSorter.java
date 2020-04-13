package com.github.alonwang.sort;

import com.github.alonwang.util.SortUtil;
import com.google.common.base.Preconditions;

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
        arrays.forEach(this::sort);
        long gapMill = System.currentTimeMillis() - startMill;
        arrays.forEach(arr -> Preconditions.checkArgument(SortUtil.isOrdered(arr), "%s sort failed", type()));
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
