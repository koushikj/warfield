package com.warfield.thread.service;

import java.util.concurrent.ConcurrentHashMap;

public class Write implements Runnable {
    private int name;
    private ConcurrentHashMap<Integer, Integer> db = new ConcurrentHashMap<Integer, Integer>();
    private int counter;

    public Write(int name, ConcurrentHashMap<Integer, Integer> db, int counter) {
        this.name = name;
        this.db = db;
        this.counter = counter;
    }

    public void run() {
        try {
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void process() throws InterruptedException {
        synchronized (db) {
            db.put(name, counter);
            System.out.println("Write-"+name + " - size is : " + db.size());
            Thread.sleep(1000);
        }
    }
}
