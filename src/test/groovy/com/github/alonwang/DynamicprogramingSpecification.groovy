package com.github.alonwang

import com.github.alonwang.dynamicprograming.Q139
import spock.lang.Specification

class DynamicprogramingSpecification extends Specification {
    def "test wordbreak"() {
        expect:
        new Q139().wordBreak(s, wordDict) == result
        where:
        s           | wordDict                              | result
        "leetcode"  | ["leet", "code"]                      | true
        "catsandog" | ["cats", "dog", "sand", "and", "cat"] | false
    }
}
