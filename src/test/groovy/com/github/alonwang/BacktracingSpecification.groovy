package com.github.alonwang


import com.github.alonwang.backtracing.SubSets
import spock.lang.Specification

class BacktracingSpecification extends Specification {
    def "test subsets"() {
        given:
        def subsets = new SubSets().subsets(nums as int[])
        subsets = subsets.toSorted()
        result = result.toSorted()
        expect:
        result == subsets
        where:
        nums      | result
        [1, 2, 3] | [[3], [1], [2], [1, 2, 3], [1, 3], [2, 3], [1, 2], []]
    }
}
