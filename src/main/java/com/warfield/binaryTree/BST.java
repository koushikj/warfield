package com.warfield.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {
    static class Node{
        private int data;
        Node left,right=null;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root=null;
        int noOfInput = scanner.nextInt();
        while(noOfInput-->0){
            root=insertData(scanner.nextInt(),root);
        }
        printBSTLevelOrder(root);
    }

    private static void printBSTLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null) {
            System.out.println("empty BST");
            return;
        }else{
            q.add(root);
        }
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
