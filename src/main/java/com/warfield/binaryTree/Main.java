package com.warfield.binaryTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20);
        binarySearchTree.insert(34);
        binarySearchTree.insert(12);
        binarySearchTree.insert(35);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(90);
        binarySearchTree.insert(29);

        TreeNode node = binarySearchTree.find(41);
        if(node!=null)
            System.out.println(node.getData());
        else
            System.out.println("not found");
        System.out.println(binarySearchTree);
    }
}
