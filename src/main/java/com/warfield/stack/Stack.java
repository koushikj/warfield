package com.warfield.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> stackObj = null;

    Stack(){
       stackObj = new ArrayList<E>();
    }

    public void push(E o){
        stackObj.add(o);
    }

    public Object pop(){
        E o = stackObj.get(stackObj.size()-1);
        remove(o);
        return o;
    }

    public void remove(E o){
        stackObj.remove(o);
    }
    public E peek(){
        return stackObj.get(stackObj.size()-1);
    }

    public int size(){
        return stackObj.size();
    }

    public boolean empty(){
        return stackObj.size()==0;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stackObj=" + stackObj.toString() +
                '}';
    }

    public void clear(){
        stackObj.clear();
    }
}
