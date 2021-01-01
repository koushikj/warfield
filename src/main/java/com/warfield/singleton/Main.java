package com.warfield.singleton;

public class Main {
    public static void main(String[] args) {
        SingletonInstance instance = SingletonInstance.getInstance();
        SingletonInstance instance2 = SingletonInstance.getInstance();

        if(instance==instance2){
            System.out.println("single instances");
        }

    }
}
