package com.github.alonwang.breadthfirst

import com.github.alonwang.tree.TreeNode
import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/14 3:27 下午
 * @detail
 */
class Q101Specification extends Specification {
    def "test"() {
        given:
        def root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(2)
        root.left.left = new TreeNode(3)
        root.left.right = new TreeNode(4)
        root.right.left = new TreeNode(4)
        root.right.right = new TreeNode(3)
        def result = true
        expect:
        new Q101().isSymmetric(root) == result
    }
}
