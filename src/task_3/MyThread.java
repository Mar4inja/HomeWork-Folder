package task_3;

public class MyThread extends  Thread{
    public static int countDivisiblesInRange(int number, int start, int end) {
        int localCount = 0;
        for (int i = start; i < end; i++) {
            if (i % number == 0) {
                localCount++;
            }
        }
        return localCount;
    }
}
