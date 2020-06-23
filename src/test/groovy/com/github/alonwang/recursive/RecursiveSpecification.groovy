package com.github.alonwang.recursive

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/18 18:26
 * @detail
 */
class RecursiveSpecification extends Specification {
    def "test Q39"() {
        expect:
        new Q39().combinationSum(candidates as int[], target) == result
        where:
        candidates   | target | result

        [2, 3, 6, 7] | 7      | [[7], [2, 2, 3]]
    }

    def "test Q40"() {
        expect:
        new CombinationSum2().combinationSum2(nums as int[], target) == result
        where:
        nums                   | target | result
        [10, 1, 2, 7, 6, 1, 5] | 8      | [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }
}
