package com.github.alonwang.tree;

/**
 * @author alonwang
 * @date 2020/6/11 18:08
 * @detail
 */
public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /*抓住二叉搜索树的特点,当前节点左子树的所有节点都必须小于当前节点,
    当前节点右子树都必须大于当前节点.这样在检查某个节点时,只要限制其值范围即可
    所有节点都会搜索一遍遍历到   O(n)*/
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }
}
