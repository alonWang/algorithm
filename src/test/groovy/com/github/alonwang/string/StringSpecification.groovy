package com.github.alonwang.string

import spock.lang.Specification

/** Q14
 * @author alonwang* @date 2020/6/15 18:54
 * @detail
 */
class StringSpecification extends Specification {
    def "test LengthOfLongestSubstring"() {
        expect:
        new LengthOfLongestSubstring().lengthOfLongestSubstring(str) == result
        where:
        str        | result
        "abcabcbb" | 3
        "bbbbb"    | 1
    }

    def "test LongestPalindrome"() {
        expect:
        new LongestPalindrome().longestPalindrome(str) == result
        new LongestPalindrome().longestPalindrome1(str) == result
        new LongestPalindrome().longestPalindrome2(str) == result
        where:
        str     | result
        "ababa" | "ababa"
    }

    def "test Q6"() {
        expect:
        new Q6().convert(str, row) == result
        where:
        str                | row | result
        "LEETCODEISHIRING" | 3   | "LCIRETOESIIGEDHN"


    }

    def "test LongestCommonPrefix"() {
        expect:
        new LongestCommonPrefix().longestCommonPrefix(strs as String[]) == prefix
        where:
        strs                         | prefix
        ["flower", "flow", "flight"] | "fl"
    }
}
