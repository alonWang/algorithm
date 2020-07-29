package com.github.alonwang

import com.github.alonwang.heap.KthLargest
import com.github.alonwang.heap.Q973
import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/3 9:30 下午
 * @detail
 */
class HeapSpecification extends Specification {
    def "KthLargest test"() {
        expect:
        def obj = new KthLargest(k as int, nums as int[])
        map.each { entry -> obj.add(entry.key) == entry.value }

        where:
        k | nums         | map
        3 | [4, 5, 8, 2] | [3: 4, 5: 5, 10: 5, 9: 8, 4: 8]
    }

    def "Q973 test"() {
        expect:
        new Q973().kClosest(points as int[][], k) == result
        new Q973().kClosest2(points as int[][], k) == result

        where:
        points            | k | result
        [[1, 3], [-2, 2]] | 1 | [[-2, 2]]
    }
}
