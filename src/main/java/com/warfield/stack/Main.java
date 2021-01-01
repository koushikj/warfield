package com.warfield.stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<String>();
        myStack.push("one");
        myStack.push("two");
        System.out.println(myStack);
        System.out.println("is Empty:"+myStack.empty());
        System.out.println("Size:"+myStack.size());
        System.out.println(myStack.pop());
        System.out.println("Size:"+myStack.size());
        System.out.println(myStack);
        myStack.push("three");
        System.out.println("Peek:"+myStack.peek());
        myStack.remove("three");
        System.out.println("Peek:"+myStack.peek());
        myStack.clear();
        System.out.println(myStack);


        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(12);
        integerStack.push(22);
        System.out.println(integerStack);



    }
}
