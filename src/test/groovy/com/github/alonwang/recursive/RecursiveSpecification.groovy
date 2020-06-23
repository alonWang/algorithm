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
}
