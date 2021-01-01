package com.warfield.binaryTree;

public class TreeNode {

    private Integer data;

    TreeNode leftChild = null;

    TreeNode rightChild = null;

    public TreeNode(Integer i) {
        this.data=i;
    }

    public Integer getData() {
        return data;
    }

    public void insert(Integer i){
        if(i<=this.data) {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(i);
                System.out.println("inserted "+i+" to the left of "+this.data);


            } else {
                this.leftChild.insert(i);
            }
        }else if (i>this.data){
            if(this.rightChild==null){
                this.rightChild= new TreeNode(i);
                System.out.println("inserted "+i+" to the right of "+this.data);
            }else {
                this.rightChild.insert(i);
            }
        }
    }

    public void delete(Integer i){

    }
    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public String getDeepData(){
        StringBuffer allData = new StringBuffer();
        allData.append(this.getData());
        allData.append(",");
        if(this.leftChild!=null){
            allData.append(this.leftChild.getDeepData());
            allData.append(",");
        }
        if(this.rightChild!=null) {
            allData.append(this.rightChild.getDeepData());
            allData.append(",");
        }
        return allData.toString();
    }

    public TreeNode find(Integer i) {
        if(i<this.data && this.leftChild!=null){
            return this.leftChild.find(i);
        }else if (i>this.data && this.rightChild!=null){
            return this.rightChild.find(i);
        }else if(i==this.data){
            return this;
        }
        return null;
    }
/*
    @Override
    public String toString() {
        String result="TreeNode{{data=" + data + '}';
        if(leftChild!=null){
            result = result.concat("{left.data=").concat(String.valueOf(leftChild.getData())).concat("}");
        }
        if(rightChild!=null){
            result = result.concat("{right.data=").concat(String.valueOf(rightChild.getData())).concat("}");
        }
        return result.concat("}");
    }*/
}
