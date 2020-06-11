package com.github.alonwang.graph

import spock.lang.Specification


/**
 * @author alonwang* @date 2020/6/11 17:56
 * @detail
 */
class Q110Specification extends Specification {
    def "test"() {
        given:
        Q110.TreeNode root = new Q110.TreeNode(3)
        root.left = new Q110.TreeNode(9)
        root.right = new Q110.TreeNode(20)
        root.right.left = new Q110.TreeNode(15)
        root.right.right = new Q110.TreeNode(7)
        expect:
        new Q110().isBalanced(root)
    }
}
