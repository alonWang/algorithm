package com.github.alonwang.breadthfirst;

import com.github.alonwang.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author alonwang
 * @date 2020/6/14 3:08 下午
 * @detail
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
