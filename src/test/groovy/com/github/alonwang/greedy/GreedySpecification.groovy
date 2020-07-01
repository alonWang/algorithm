package com.github.alonwang.greedy

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/29 17:10
 * @detail
 */
class GreedySpecification extends Specification {
    def "test RobotSim"() {
        expect:
        new RobotSim().robotSim(commands as int[], obstacles as int[][]) == result
        where:
        commands          | obstacles                                                                                | result
        [4, -1, 3]        | []                                                                                       | 25
        [4, -1, 4, -2, 4] | [[2, 4]]                                                                                 | 65
        [7, -2, -2, 7, 5] | [[-3, 2], [-2, 1], [0, 1], [-2, 4], [-1, 0], [-2, -3], [0, -3], [4, 4], [-3, 3], [2, 2]] | 4

    }

    def "test twoCitySchedCost"() {
        expect:
        new TwoCitySchedCost().twoCitySchedCost(costs as int[][]) == result
        where:
        costs                                      | result
        [[10, 20], [30, 200], [400, 50], [30, 20]] | 110
    }

    def "test leastInterval"() {
        expect:
        new LeastInterval().leastInterval(tasks as char[], n) == result
        where:
        tasks                                                        | n | result
        ["A", "A", "A", "B", "B", "B"]                               | 2 | 8
        ["A", "A", "A", "B", "B", "B"]                               | 0 | 6
        ["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"] | 2 | 16
    }

    def "test strWithout3a3b"() {
        expect:
        new StrWithout3a3b().strWithout3a3b(A, B) == result
        where:
        A | B | result
        1 | 2 | "bba"
        3 | 3 | "aabbab"

    }
}
