package com.github.alonwang.breadthfirst

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/12 8:55 下午
 * @detail
 */
class Q127Specification extends Specification {
    def "test"() {
        expect:
        new Q127().ladderLength(beginWord, endWord, wordList) == result
        where:
        beginWord | endWord | wordList                                   | result
        "hit"     | "cog"   | ["hot", "dot", "dog", "lot", "log", "cog"] | 5
    }
}
