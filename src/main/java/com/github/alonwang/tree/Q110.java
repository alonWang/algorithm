package com.github.alonwang.tree;

/**
 * @author alonwang
 * @date 2020/6/11 16:27
 * @detail
 */
public class Q110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 节点高度
     * <p>
     * 不要将自己代入一层又一层的调用,仅看目前的逻辑
     *
     * @param node
     * @return 节点不平衡 -1 节点为空 0    >0 节点高度
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = height(node.left);
        int r = height(node.right);
        //左右节点不平衡或者当前节点不平衡,总的树也是不平衡的
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

}
