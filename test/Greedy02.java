package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Greedy02 {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {

        int output[] = new int[3];
        boolean yn = false;
        // Integer sticks2[]
        //     = Arrays.stream(sticks).boxed().toArray(Integer[]::new);
        // Arrays.sort(sticks2, Collections.reverseOrder());
        Arrays.sort(sticks);
        for(int i = sticks.length-1; i >= 2; i--) {
            if(sticks[i] < sticks[i-1] + sticks[i-2]) {
                output[0] = sticks[i-2];
                output[1] = sticks[i-1];
                output[2] = sticks[i];
                yn = true;
                break;
            }  
        }
        
        if(!yn){
            output = new int[1];
            output[0] = -1;
        }
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            // bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
                // bufferedWriter.write(" ");
            }
        }

        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
