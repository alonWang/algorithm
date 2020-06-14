package com.github.alonwang.breadthfirst;

import com.github.alonwang.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author alonwang
 * @date 2020/6/14 3:08 下午
 * @detail
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        int i = 0;
        List<TreeNode> list = new ArrayList<>(2 << (i++));
        list.add(root);
        while (list.size() > 0) {

            for (int j = 0, k = list.size() - 1; j < k; j++, k--) {
                //都为空
                if (list.get(j) == null && list.get(k) == null) {
                    continue;
                }
                //都不为空且相等
                if (list.get(j) != null && list.get(k) != null && list.get(j).val == list.get(k).val) {
                    continue;
                }
                return false;
            }

            List<TreeNode> temp = new ArrayList<>(2 << i++);
            boolean hasNode = false;
            for (TreeNode treeNode : list) {
                if (treeNode == null) {
                    continue;
                }
                temp.add(treeNode.left);
                temp.add(treeNode.right);
                if (!hasNode && (treeNode.left != null || treeNode.right != null)) {
                    hasNode = true;
                }
            }
            list = hasNode ? temp : Collections.emptyList();
        }
        return true;
    }
}
