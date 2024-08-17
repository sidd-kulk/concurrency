package org.sid.oneOone;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SimpleVirtualThread {
    public static void main(String[] args) throws InterruptedException {
        final int THREAD_COUNT = 100000;
        Thread[] threads = new Thread[THREAD_COUNT];
        IntStream.range(0, THREAD_COUNT).forEach(i -> threads[i] = spawnThread((x) -> x + i, i, false));
        for (Thread t : threads) {
            t.join();
        }
    }

    private static Thread spawnThread(Function<Integer, Integer> f, int i, boolean isVirtual) {
        var t = isVirtual ? Thread.ofVirtual().name("Virtual Thread-"+i) : Thread.ofPlatform().name("Platform Thread-"+i);
        var t1 = t.unstarted(() -> {
            try {
                f.apply((int) (Math.random() * 100));
                Thread.sleep(1);
                System.out.println("Running " + Thread.currentThread().getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        return t1;
    }
}
