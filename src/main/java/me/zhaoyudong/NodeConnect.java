package me.zhaoyudong;

/**
 *
 */
public class NodeConnect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }
        //必须先处理right要不然队列遍历不完
        connect0(root.right);
        connect0(root.left);

        return root;
    }

    private void connect0(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
            } else {
                node.left.next = nextNode(node.next);
            }
        }

        if (node.right != null) {
            node.right.next = nextNode(node.next);
        }
        //必须先处理right要不然队列遍历不完
        connect0(node.right);
        connect0(node.left);

    }

    private Node nextNode(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
