package com.github.alonwang.depthfirst


import com.github.alonwang.tree.TreeNode
import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/11 19:33
 * @detail
 */
class Q98Specification extends Specification {
    def "test"() {
        given:
        TreeNode root = new TreeNode(5)
        root.left = new TreeNode(1)
        root.right = new TreeNode(4)
        root.right.left = new TreeNode(3)
        root.right.right = new TreeNode(6)
        expect:
        new Q98().isValidBST(root) == false
    }
}
