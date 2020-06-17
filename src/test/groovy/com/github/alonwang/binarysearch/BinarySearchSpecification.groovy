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
}
