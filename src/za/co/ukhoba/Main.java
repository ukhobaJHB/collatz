package za.co.ukhoba;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    static ConcurrentHashMap<Long, List<Long>> paths;

    public Main() {
        this.paths = new ConcurrentHashMap<>();
    }

    public void start(long start) {

        CollatzMainThread mainPath = new CollatzMainThread(start);
//        CollatzThread quarter4 = new CollatzThread(start - 1, (start / 4) * 3, start);
//        CollatzThread quarter3 = new CollatzThread((start / 4) * 3, start / 2, start);
//        CollatzThread quarter2 = new CollatzThread(start - 1, start / 2, start);
//        CollatzThread quarter1 = new CollatzThread(start / 2, 1, start);

        mainPath.run();
//        quarter4.run();
//        quarter3.run();
//        quarter2.run();
//        quarter1.run();

//        while(mainPath.isRunning && quarter2.isRunning && quarter1.isRunning) {
        while(mainPath.isRunning) {

        }
        long steps = calculateSteps(start, 0);
        System.out.println(steps);
    }

    public static void main(String[] args) {

         Main main = new Main();

         if (args.length == 0 || args.length > 1) {
             System.out.println("Please enter a number (2 - 999999999999999):");
             System.exit(1);
         }

         main.start(verifyParam(args[0]));
    }

    private static long verifyParam(String arg) {

//        Scanner input = new Scanner(System.in);
        try {
//            String start = input.next();
            return Long.parseLong(arg);
        } catch (Exception e) {
            System.out.println("Please enter a number (2 - 999999999999999):");
            System.exit(1);
        }
        return 0;
    }

    private long calculateSteps(long start, long steps){
        if (start == 1) {
            return steps;
        }
        int pathSize = this.paths.get(start).size();
        steps += pathSize;
        return calculateSteps(this.paths.get(start).get(pathSize - 1), steps);
    }
}
