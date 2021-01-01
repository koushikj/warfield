package com.warfield.singleton;

public enum  SingletonInstance {
    INSTANCE;
    private static String info="im a singleton";

    public static SingletonInstance getInstance(){
        return INSTANCE;
    }
    public String getInfo(){
        return info;
    }
}
