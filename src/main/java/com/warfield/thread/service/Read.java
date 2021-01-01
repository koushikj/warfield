package com.warfield.thread.service;

import java.util.concurrent.ConcurrentHashMap;

public class Read implements Runnable {
    private int name;
    private ConcurrentHashMap<Integer, Integer> db = new ConcurrentHashMap<Integer, Integer>();

    public Read(int str, ConcurrentHashMap<Integer, Integer> db){
        name = str;
        this.db = db;
    }

    public void run() {
        process();
    }

    private synchronized void process() {
        synchronized (db) {
            System.out.println("Read-"+name + " : "+db +" -  : " + db.remove((name+1)%10) +" , db :"+db);
        }
    }
}
