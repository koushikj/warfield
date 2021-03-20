package com.warfield.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {
    static class Node{
        private final int data;
        Node left,right=null;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root=null;
        System.out.println("no. of elements?");
        int noOfInput = scanner.nextInt();
        int total = noOfInput;
        while(noOfInput-->0){
            System.out.printf("element-%d ?\n",(total-noOfInput));
            root=insertData(scanner.nextInt(),root);
        }
        System.out.println("height : "+printBSTHeight(root));
        printBSTLevelOrder(root);
    }

    private static int printBSTHeight(Node root) {
        if(root==null){
            return 0;
        }
        int leftTree=0;
        int rightTree=0;
        if(root.left!=null){
            leftTree = printBSTHeight(root.left)+1;
        }
        if(root.right!=null){
            rightTree = printBSTHeight(root.right)+1;
        }
        return Math.max(leftTree, rightTree);
    }

    private static void printBSTLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null) {
            System.out.println("empty BST");
            return;
        }else{
            q.add(root);
        }
        System.out.println("Level Order (or Breadth first search) of BST :");
        while (!q.isEmpty()){
            Node current = q.remove();
            System.out.print(current.data+" ");
            if(current.left!=null){
                q.add(current.left);
            }
            if(current.right!=null) {
                q.add(current.right);
            }
        }
    }

    private static Node insertData(int data, Node node) {
        if(node==null){
            node = new Node(data);
        }else if(data<= node.data){
            node.left=insertData(data,node.left);
        }else {
            node.right=insertData(data,node.right);
        }
        return node;
    }
}
