package com.warfield.binaryTree;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(Integer data){
        if(this.root!=null){
            root.insert(data);
        }else {
            root = new TreeNode(data);
            System.out.println("created root "+data);
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root.getDeepData() +
                '}';
    }

    public TreeNode find(Integer i) {
        if(this.root!=null){
            return root.find(i);
        }
        return null;
    }

/*    public TreeNode find(Integer data){
    }

    public void delete(Integer data){

    }*/
}
