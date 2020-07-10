package com.github.alonwang

import com.github.alonwang.dynamicprograming.Q1024
import com.github.alonwang.dynamicprograming.Q139
import com.github.alonwang.dynamicprograming.Q376
import spock.lang.Specification

class DynamicprogramingSpecification extends Specification {
    def "test wordbreak"() {
        expect:
        new Q139().wordBreak(s, wordDict) == result
        where:
        s                                                                                                                                                         | wordDict                                                                                        | result
        "leetcode"                                                                                                                                                | ["leet", "code"]                                                                                | true
        "catsandog"                                                                                                                                               | ["cats", "dog", "sand", "and", "cat"]                                                           | false
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" | ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"] | false
    }

    def "test Q376"() {
        expect:
        new Q376().wiggleMaxLength(nums as int[]) == result
        where:
        nums                                 | result
        [1, 7, 4, 9, 2, 5]                   | 6
        [1, 17, 5, 10, 13, 15, 10, 5, 16, 8] | 7
        [1]                                  | 1
        [1, 1]                               | 1
        []                                   | 0
    }

    def "test Q1024"() {
        expect:
        new Q1024().videoStitching(clips as int[][], T) == result
        where:
        clips                                                                                                                            | T  | result
        [[0, 2], [4, 6], [8, 10], [1, 9], [1, 5], [5, 9]]                                                                                | 10 | 3
        [[0, 1], [1, 2]]                                                                                                                 | 5  | -1
        [[0, 4], [2, 8]]                                                                                                                 | 5  | 2
        [[0, 4], [2, 8]]                                                                                                                 | 0  | -1
        [[0, 1], [6, 8], [0, 2], [5, 6], [0, 4], [0, 3], [6, 7], [1, 3], [4, 7], [1, 4], [2, 5], [2, 6], [3, 4], [4, 5], [5, 7], [6, 9]] | 9  | 3
    }
}
