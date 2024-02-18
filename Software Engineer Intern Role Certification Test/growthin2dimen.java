import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countMax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING_ARRAY upRight as parameter.
     */

   public static long countMax(List<String> upRight) {
        // Initialize variables to keep track of minimum row and column values
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        // Iterate through each string in the input list
        for (String s : upRight) {
            // Split the string into row and column values
            String[] split = s.split(" ");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            
            // Update the minimum row and column values
            minRow = Math.min(minRow, row);
            minCol = Math.min(minCol, col);
        }
        
        // Calculate and return the maximum number of cells covered by all rectangles
        return (long) minRow * minCol;
    }
}




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int upRightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> upRight = IntStream.range(0, upRightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        long result = Result.countMax(upRight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
