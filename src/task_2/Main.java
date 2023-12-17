package task_2;

import task_3.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// *** // Есть три потока.
// 1 поток выводит в консоль пять раз букву А (без переноса строки)
// 2 поток выводит в консоль пять раз букву В (без переноса строки)
// 3 поток выводит в консоль пять раз букву С (без переноса строки)
// Запустить потоки одновременно, но добиться такого результата,
// чтобы получить вывод в консоль -> ABCABCABCABCABC
// Результат должен выводиться моментально,
// то есть sleep использовать нельзя.
// Без пулов потоков (при помощи стандартных способов с первого урока по многопоточности).
public class Main {

    private static volatile int turn = 1; // Shared turn variable

    public static void main(String[] args) {
        MyThread_1 myThread1 = new MyThread_1();
        MyThread_2 myThread2 = new MyThread_2();
        MyThread_3 myThread3 = new MyThread_3();

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    public static class MyThread_1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                while (turn != 1) {}
                System.out.print("A");
                turn = 2;
            }
        }
    }

    public static class MyThread_2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                while (turn != 2) {}
                System.out.print("B");
                turn = 3;
            }
        }
    }

    public static class MyThread_3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                while (turn != 3) {}
                System.out.print("C");
                turn = 1;
            }
        }
    }
}

