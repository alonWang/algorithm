package com.github.alonwang

import com.github.alonwang.backtracing.Permutation
import com.github.alonwang.backtracing.Q79
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

    def "test Q79"() {
        expect:
        new Q79().exist(board as char[][], word) == result
        where:
        board                                                              | word     | result
        [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']] | "ABCCED" | true
        [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']] | "SEE"    | true
        [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']] | "ABCB"   | false
        [["a", "a"]]                                                       | "aaa"    | false
        [
                ["F", "Y", "C", "E", "N", "R", "D"],
                ["K", "L", "N", "F", "I", "N", "U"],
                ["A", "A", "A", "R", "A", "H", "R"],
                ["N", "D", "K", "L", "P", "N", "E"],
                ["A", "L", "A", "N", "S", "A", "P"],
                ["O", "O", "G", "O", "T", "P", "N"],
                ["H", "P", "O", "L", "A", "N", "O"]]                       | "USA"    | false
    }
}
