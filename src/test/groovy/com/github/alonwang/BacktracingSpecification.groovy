package com.github.alonwang


import com.github.alonwang.backtracing.SubSets
import spock.lang.Specification

class BacktracingSpecification extends Specification {
    def "test subsets"() {
        expect:
        def subsets = new SubSets().subsets(nums as int[])
        //简化一下,先只比较数量
        subsets.size() == size
        where:
        nums      | size
        [1, 2, 3] | 8
    }
}
