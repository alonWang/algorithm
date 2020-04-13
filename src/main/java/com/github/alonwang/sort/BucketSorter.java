package com.github.alonwang.sort;

import com.github.alonwang.util.RandomUtil;
import com.github.alonwang.util.SortUtil;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author alonwang
 * @date 2020/4/13 10:59
 * @description 桶排序演示
 * @detail 桶排序基于数据范围在可控范围内这个特点, 将这个范围划分成较小的区间, 再对各个小区间分别排序(一般是快速排序),
 * 如果数据分布的**相对均匀**, 那么桶排序的时间复杂度趋近于O(n),下面是推导过程:
 * 数组大小为n,划分为k个桶,每个桶中额数据量为n/k,那么对每个小区间的排序使用快速排序,
 * 时间复杂度为O((n/k)log(n/k)),k个区间总的时间复杂度为k*O((n/k)log(n/k)) =O(nlog(n/k))  k越大,越趋近于O(n)
 * 实现代码中为了方便效率不会很高.
 */
public class BucketSorter implements Sorter<Integer> {
    private static final double MIN_BUCKET_GAP = 10000.0;

    @Override
    public void sort(Integer[] arr) {
        if (arr.length <= 1) {
            return;
        }
        Integer min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min.compareTo(arr[i]) > 0) {
                min = arr[i];
            }
            if (max.compareTo(arr[i]) < 0) {
                max = arr[i];
            }
        }
        int gap = max - min + 1;
        int bucketNum = (int) Math.ceil(gap / MIN_BUCKET_GAP);
        List<Integer>[] buckets = new ArrayList[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Integer value : arr) {
            buckets[(value - min) / gap].add(value);
        }
        List<Integer> total = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            total.addAll(bucket);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = total.get(i);
        }
    }

    @Override
    public SorterType type() {
        return SorterType.Bucket;
    }

    @Override
    public void benchmark() {
        List<Integer[]> lists = RandomUtil.batchGenerateRandomIntArray(1000, 1000, 5000000);
        lists.forEach(this::sort);
        lists.forEach(arr -> Preconditions.checkArgument(SortUtil.isOrdered(arr, true), "sort failed"));
        System.out.println(type() + " sort all success");
    }

    public static void main(String[] args) {
        new BucketSorter().benchmark();
    }
}

