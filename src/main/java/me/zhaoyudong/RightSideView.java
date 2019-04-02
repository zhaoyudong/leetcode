package me.zhaoyudong;

import java.util.*;

/**
 * 广度优先搜索
 */
public class RightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> array = new ArrayList<>();

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        num(treeNodes, array);

        return array;
    }

    public void num(Queue<TreeNode> treeNodes, List<Integer> array) {
        Queue<TreeNode> nodes = new LinkedList<>();

        for (; ; ) {
            TreeNode treeNode = treeNodes.poll();

            if (treeNode.left != null) {
                nodes.add(treeNode.left);
            }

            if (treeNode.right != null) {
                nodes.add(treeNode.right);
            }

            if (treeNodes.isEmpty()) {
                array.add(treeNode.val);
                break;
            }
        }

        if (nodes.size() > 0) {
            num(nodes, array);
        }
    }
}
