package com.github.alonwang.binarysearch

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/17 16:19
 * @detail
 */
class BinarySearchSpecification extends Specification {
    def "test Q33"() {
        expect:
        new Q33().search(nums as int[], target) == result
        where:
        nums                  | target | result
        [4, 5, 6, 7, 0, 1, 2] | 0      | 4
        [1]                   | 1      | 0
    }

    def "test Q34"() {
        expect:
        new Q34().searchRange(nums as int[], target) == result as int[]
        where:
        nums                | target | result
        [5, 7, 7, 8, 8, 10] | 8      | [3, 4]
        [5, 7, 7, 8, 8, 10] | 6      | [-1, -1]
    }

    def "test Q35"() {
        expect:
        new Q35().searchInsert(nums as int[], target) == result
        where:
        nums         | target | result
        [1, 3, 5, 6] | 7      | 4
    }
}
