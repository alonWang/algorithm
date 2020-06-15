package com.github.alonwang.sort

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/15 18:38
 * @detail
 */
class FindMedianSortedArraysSpecification extends Specification {
    def "test"() {
        expect:
        new FindMedianSortedArrays().findMedianSortedArrays(nums1 as int[], nums2 as int[]).doubleValue() == result
        where:
        nums1  | nums2  | result
        [1, 2] | [3, 4] | 2.5d
    }
}
