package frozen00000;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 */

class Node {
    int data;
    Node left;
    Node right;
}

public class BSTChecker {

    private boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node root, int min, int max) {
        return (root.left == null || root.left.data < root.data && root.left.data > min && checkBST(root.left, min, root.data))
                && (root.right == null || root.right.data > root.data && root.right.data < max && checkBST(root.right, root.data, max));
    }

}
