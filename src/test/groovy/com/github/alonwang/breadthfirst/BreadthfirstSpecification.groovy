package com.github.alonwang.breadthfirst

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/16 18:29
 * @detail
 */
class BreadthfirstSpecification extends Specification {
    def "test shortestPathBinaryMatrix"() {
        expect:
        new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(matrix as int[][]) == result
        where:
        matrix                            | result
        [[0, 0, 0], [1, 1, 0], [1, 1, 0]] | 4

    }
}
