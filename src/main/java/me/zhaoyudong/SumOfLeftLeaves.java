package me.zhaoyudong;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(RightSideView.TreeNode root) {
        int val = 0;
        if (root == null) {
            return val;
        }
        Queue<RightSideView.TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            RightSideView.TreeNode treeNode = treeNodes.poll();

            if (treeNode == null) {
                continue;
            }

            if (isLeaf(treeNode.left)) {
                val += treeNode.left.val;
            } else {
                treeNodes.add(treeNode.left);
            }

            treeNodes.add(treeNode.right);
        }

        return val;
    }

    private boolean isLeaf(RightSideView.TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }
}
