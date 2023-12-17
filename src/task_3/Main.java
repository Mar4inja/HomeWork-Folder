package task_3;

import static task_3.MyThread.countDivisiblesInRange;

public class Main {
    private static int count = 0;

    public static synchronized void increment(int localCount) {
        count += localCount;
    }

    public static void main(String[] args) {
        int number = 5;

        Thread thread1 = new Thread(() -> {
            int localCount = countDivisiblesInRange(number, Integer.MIN_VALUE, 0);
            increment(localCount);
        });

        Thread thread2 = new Thread(() -> {
            int localCount = countDivisiblesInRange(number, 0, Integer.MAX_VALUE);
            increment(localCount);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total divisible by " + number + ": " + count);
    }
}
