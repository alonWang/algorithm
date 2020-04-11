package com.github.alonwang.sort;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public interface Sorter {
    void sort(Comparable[] arr);

    SorterType type();

    default String show(Comparable[] arr) {
        return Arrays.stream(arr).map(Object::toString)
                .collect(Collectors.joining(" -> ", " [ ", " ] "));

    }

    default void performanceTest(Comparable[]... customs) {
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

    public static void main(String[] args) {
        Reflections reflections = new Reflections(Sorter.class.getPackage().getName());
        Set<Class<? extends Sorter>> sorters = reflections.getSubTypesOf(Sorter.class);
        sorters.forEach(sorterClazz -> {
            try {
                //TODO refactor with Constructor
                Sorter sorter = sorterClazz.newInstance();
                sorter.performanceTest();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
