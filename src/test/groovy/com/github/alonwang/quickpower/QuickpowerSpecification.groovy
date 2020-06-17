package com.github.alonwang.quickpower

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/17 15:29
 * @detail
 */
class QuickpowerSpecification extends Specification {
    def "test Q29"() {
        expect:
        new Q29().divide(dividend, divisor) == result
        where:
        dividend          | divisor | result
        Integer.MIN_VALUE | -1      | Integer.MAX_VALUE
    }
}
