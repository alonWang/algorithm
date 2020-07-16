package com.github.alonwang

import com.github.alonwang.divideandconquer.Q932
import spock.lang.Specification

/**
 * @author alonwang* @date 2020/7/16 10:39
 * @detail
 */
class DivideAndConquerSpecification extends Specification {
    def "test Q932"() {
        expect:
        new Q932().beautifulArray(N) == result as int[]
        where:
        N | result
        5 | [1, 5, 3, 2, 4]
    }
}
