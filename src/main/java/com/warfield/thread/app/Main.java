package com.warfield.thread.app;

import com.warfield.thread.service.Read;
import com.warfield.thread.service.Write;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    private static ConcurrentHashMap<Integer,Integer> db = new ConcurrentHashMap<Integer, Integer>();

    //private static AutomicI counter = 0;
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String args[]) throws InterruptedException {
        System.out.println("welcome!");
        for(int i=0;i<10;i++){
            new Thread((new Write(i,db,counter.getAndIncrement()))).start();
            new Thread((new Read(i,db))).start();
        }


       // using ExecutorService

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future=null;
        for(int i=0;i<10;i++) {
            executorService.submit((new Write(i, db, counter.getAndIncrement())));
            future = executorService.submit((new Read(i, db)));
            System.out.println("Future :"+future);
        }
        executorService.shutdown();


        System.out.println("Final map is : "+db);

    }
}
