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
}
