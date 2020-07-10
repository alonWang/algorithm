package com.github.alonwang

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

    def "est Q376"() {
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
}
