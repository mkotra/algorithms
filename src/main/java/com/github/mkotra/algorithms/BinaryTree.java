package com.github.mkotra.algorithms;

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println("Preorder Traversal (NLR):");
        preorderTraversal(root);
        System.out.println(System.lineSeparator() + "Inorder Traversal (LNR):");
        inorderTraversal(root);
        System.out.println(System.lineSeparator() + "Postorder Traversal (LRN):");
        postorderTraversal(root);
    }

    static void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // N (Visit the node)
        System.out.print(node.value  + " ");
        // L (Traverse the left subtree)
        preorderTraversal(node.left);
        // R (Traverse the right subtree)
        preorderTraversal(node.right);
    }

    static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // L (Traverse the left subtree)
        inorderTraversal(node.left);
        // N (Visit the node)
        System.out.print(node.value + " ");
        // R (Traverse the right subtree)
        inorderTraversal(node.right);
    }

    static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // L (Traverse the left subtree)
        preorderTraversal(node.left);
        // R (Traverse the right subtree)
        preorderTraversal(node.right);
        // N (Visit the node)
        System.out.print(node.value  + " ");
    }

    static TreeNode createTree() {
        TreeNode root = null;
        root = insert(root, 4);
        root = insert(root, 2);
        root = insert(root, 7);
        root = insert(root, 1);
        root = insert(root, 8);
        root = insert(root, 5);
        root = insert(root, 6);
        root = insert(root, 3);
        return root;
    }

    static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
