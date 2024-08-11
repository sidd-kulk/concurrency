package org.sid.oneOone;


// Simple ways to run a thread
public class SimpleThread {
    public static void main(String[] args) {
        Runnable anonymousRunnable = () -> {
            System.out.println("Running thread" + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread101();
        Thread thread2 = new Thread(new Runnable101());
        Thread thread3 = new Thread(anonymousRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Thread101 extends Thread {
    @Override
    public void run() {
        System.out.println("Running thread" + Thread.currentThread().getName());
    }
}

class Runnable101 implements Runnable {
    @Override
    public void run() {
        System.out.println("Running thread" + Thread.currentThread().getName());
    }
}


