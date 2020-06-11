package com.github.alonwang.dp

import com.github.alonwang.deepsearch.Q494
import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/11 20:54
 * @detail
 */
class Q494Specification extends Specification {
    def "test"() {
        expect:
        new Q494().findTargetSumWays(nums as int[], s) == count
        where:
        nums            | s | count
        [1, 1, 1, 1, 1] | 3 | 5
    }
}
