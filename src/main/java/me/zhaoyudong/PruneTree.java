package me.zhaoyudong;

public class PruneTree {

    /**
     * https://leetcode-cn.com/problems/binary-tree-pruning/
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        return has1(root) ? root : null;
    }

    private boolean has1(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        boolean left = has1(treeNode.left);
        if (!left) {
            treeNode.left = null;
        }

        boolean right = has1(treeNode.right);
        if (!right) {
            treeNode.right = null;
        }

        return left || right || treeNode.val == 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
