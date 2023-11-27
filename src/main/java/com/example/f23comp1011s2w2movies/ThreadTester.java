package com.example.f23comp1011s2w2movies;

public class ThreadTester {
    public static void main(String[] args) {
        Thread thread1 = new Thread("Thread 1"){
            @Override
            public void run() {
                for(int i = 1; i < 6; i++) {
                    System.out.printf("Thread: %s, i: %d%n", Thread.currentThread().getName(), i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable = () -> {
            for(int i = 1; i < 6; i++) {
                System.out.printf("Thread: %s, i: %d%n", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread runnableThread1 = new Thread(runnable, "Runnable Thread 1");
        Thread runnableThread2 = new Thread(runnable, "Runnable Thread 2");
        Thread runnableThread3 = new Thread(runnable, "Runnable Thread 3");
        Thread runnableThread4 = new Thread(runnable, "Runnable Thread 1");
        Thread runnableThread5 = new Thread(runnable, "Runnable Thread 5");

        runnableThread1.start();
        runnableThread2.start();
        runnableThread3.start();
        runnableThread4.start();
        runnableThread5.start();
        thread1.start();

    }
}
