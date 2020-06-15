package com.github.alonwang.string

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/15 18:54
 * @detail
 */
class StringSpecification extends Specification {
    def "test"() {
        expect:
        new LengthOfLongestSubstring().lengthOfLongestSubstring(str) == result
        where:
        str        | result
        "abcabcbb" | 3
        "bbbbb"    | 1
    }
}
