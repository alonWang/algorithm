package com.github.alonwang.tree

import com.github.alonwang.tree.Q110
import spock.lang.Specification


/**
 * @author alonwang* @date 2020/6/11 17:56
 * @detail
 */
class Q110Specification extends Specification {
    def "test"() {
        given:
        TreeNode root = new TreeNode(3)
        root.left = new TreeNode(9)
        root.right = new TreeNode(20)
        root.right.left = new TreeNode(15)
        root.right.right = new TreeNode(7)
        expect:
        new Q110().isBalanced(root)
    }
}
