package za.co.ukhoba;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static za.co.ukhoba.Main.paths;

public class CollatzMainThread implements Runnable {

    private long start;
    public boolean isRunning;

    public CollatzMainThread(long start) {
        this.start = start;
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.isRunning = true;
        long currentNumber = start;
        List<Long> path = new ArrayList<>();

        while (currentNumber > 1) {
            if (currentNumber % 2 != 0) {
                currentNumber = (currentNumber * 3) + 1;
            } else {
                currentNumber /= 2;
            }
            path.add(currentNumber);
        }
        paths.put(start, path);
        this.isRunning = false;
    }
}
