package com.github.alonwang.search;

/**
 * @author alonwang
 * @date 2020/4/13 11:49 下午
 * @description
 * @detail
 */
public interface Searcher<T> {
    /**
     * 查找target在arr中的下标
     *
     * @param arr
     * @param target
     * @return target在arr中的下标  or -1
     */
    int search(T[] arr, T target);
}
