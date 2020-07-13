package com.github.alonwang

import com.github.alonwang.dynamicprograming.Q1024
import com.github.alonwang.dynamicprograming.Q139
import com.github.alonwang.dynamicprograming.Q376
import com.github.alonwang.dynamicprograming.Q44
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
        clips                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | T  | result
        [[0, 2], [4, 6], [8, 10], [1, 9], [1, 5], [5, 9]]                                                                                                                                                                                                                                                                                                                                                                                                                                                     | 10 | 3
        [[0, 1], [1, 2]]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | 5  | -1
        [[0, 4], [2, 8]]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | 5  | 2
        [[0, 4], [2, 8]]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | 0  | -1
        [[0, 1], [6, 8], [0, 2], [5, 6], [0, 4], [0, 3], [6, 7], [1, 3], [4, 7], [1, 4], [2, 5], [2, 6], [3, 4], [4, 5], [5, 7], [6, 9]]                                                                                                                                                                                                                                                                                                                                                                      | 9  | 3
        [[0, 5], [1, 6], [2, 7], [3, 8], [4, 9], [5, 10], [6, 11], [7, 12], [8, 13], [9, 14], [10, 15], [11, 16], [12, 17], [13, 18], [14, 19], [15, 20], [16, 21], [17, 22], [18, 23], [19, 24], [20, 25], [21, 26], [22, 27], [23, 28], [24, 29], [25, 30], [26, 31], [27, 32], [28, 33], [29, 34], [30, 35], [31, 36], [32, 37], [33, 38], [34, 39], [35, 40], [36, 41], [37, 42], [38, 43], [39, 44], [40, 45], [41, 46], [42, 47], [43, 48], [44, 49], [45, 50], [46, 51], [47, 52], [48, 53], [49, 54]] | 50 | 10
        [[5, 7], [1, 8], [0, 0], [2, 3], [4, 5], [0, 6], [5, 10], [7, 10]]                                                                                                                                                                                                                                                                                                                                                                                                                                    | 5  | 1
    }

    def "test Q44"() {
        expect:
        new Q44().isMatch(s, p) == result
        where:
        s    | p   | result
        "aa" | "a" | false
    }
}
