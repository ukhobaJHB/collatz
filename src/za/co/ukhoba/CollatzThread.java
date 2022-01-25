package za.co.ukhoba;

import java.util.ArrayList;
import java.util.List;

import static za.co.ukhoba.Main.paths;

public class CollatzThread implements Runnable {

    final long start, end, initialNumber;
    public boolean isRunning;


    public CollatzThread(long start, long end, long initialNumber) {
        this.start = start;
        this.end = end;
        this.initialNumber = initialNumber;
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.isRunning = true;
        long currentBranch = start;

        while (currentBranch >= end && currentBranch <= start) {

            long currentNumber = currentBranch;
            List<Long> path = new ArrayList<>();

            while (currentBranch <= currentNumber && currentNumber > 1) {
                if (currentNumber % 2 != 0) {
                    currentNumber = (currentNumber * 3) + 1;
                } else {
                    currentNumber /= 2;
                }
                path.add(currentNumber);
            }
            if (!paths.isEmpty()) paths.put(currentBranch, path);

            currentBranch--;
        }

        this.isRunning = false;
    }
}
