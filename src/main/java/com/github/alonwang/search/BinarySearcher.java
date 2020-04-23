package com.github.alonwang.search;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author alonwang
 * @date 2020/4/13 11:48 下午
 * @description 二分查找的最简单形式
 * @detail 几个注意点
 * * low<=high  low==high时,mid==low==high,需要判定mid是否符合要求
 * * mid计算使用low+(high-low)/2而不是(low+high)/2避免溢出
 * * 是low=mid+1 和high=mid-1 ,经过判定之后mid位置是确定不需要的
 * * high是包含的
 * 因为每次范围都减半,比较次数 x=log(n),时间复杂度为O(logn)
 */
public class BinarySearcher extends AbstractBinarySearcher {

    public int search(Comparable[] arr, Comparable target) {
        if (arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmpVal = arr[mid].compareTo(target);
            if (cmpVal < 0) {
                low = mid + 1;
            } else if (cmpVal == 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    @Override
    protected void doValidate(List<Integer[]> arrs) {
        arrs.forEach(arr -> {
            int randomVal = ThreadLocalRandom.current().nextInt(1500);
            arr = Arrays.stream(arr).distinct().collect(Collectors.toList()).toArray(new Integer[0]);
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == randomVal) {
                    index = i;
                    break;
                }
            }
            int searchIndex = search(arr, randomVal);
            assert searchIndex == index;
        });
    }
}

