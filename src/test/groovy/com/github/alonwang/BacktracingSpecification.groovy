package com.github.alonwang

import com.github.alonwang.backtracing.Permutation
import com.github.alonwang.backtracing.SubSets
import com.github.alonwang.greedy.SplitIntoFibonacci
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

    def "test splitIntoFibonacci"() {
        expect:
        new SplitIntoFibonacci().splitIntoFibonacci(s) == result
        where:
        s           | result
        "123456579" | [123, 456, 579]
        "0000"      | [0, 0, 0, 0]
    }

    def "test permutation"() {
        given:
        def arrays = new Permutation().permutation(s)
        arrays = arrays.toSorted()
        result = result.toSorted()
        expect:
        arrays == result
        where:
        s     | result
        "abc" | ["abc", "acb", "bac", "bca", "cab", "cba"]
        "aab" | ["aba", "aab", "baa"]
    }
}
