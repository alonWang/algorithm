package com.github.alonwang.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/15 19:12
 * @description
 * @detail
 */
public abstract class AbstractBinarySearcher implements Searcher<Comparable> {
    @Override
    public int search(Comparable[] arr, Comparable target) {
        return 0;
    }

    public void validate() {
        List<Integer[]> arrs = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            int len = ThreadLocalRandom.current().nextInt(2000);
            Integer[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(2000);
            }
            Arrays.sort(arr);
            arrs.add(arr);
        }
        doValidate(arrs);
    }

    protected abstract void doValidate(List<Integer[]> arrs);
}
