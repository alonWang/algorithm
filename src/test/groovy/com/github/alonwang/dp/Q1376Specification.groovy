package com.github.alonwang.dp

import com.github.alonwang.deepsearch.Q1376
import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/12 17:29
 * @detail
 */
class Q1376Specification extends Specification {
    def "test"() {
        expect:
        new Q1376().numOfMinutes(managers.size(), headerId, managers as int[], informTime as int[]) == result
        where:
        managers               | headerId | informTime            | result
        [-1]                   | 0        | [0]                   | 0
        [2, 2, -1, 2, 2, 2]    | 2        | [0, 0, 1, 0, 0, 0]    | 1
        [1, 2, 3, 4, 5, 6, -1] | 6        | [0, 6, 5, 4, 3, 2, 1] | 21


    }
}
