import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MaximizingXOR {

    // Complete the maximizingXor function below.
    static int maximizingXor(int l, int r) {

        if(r == 1) return 0;

        int max = 512;

        if(l > max) {

        }

        int i = 0;
        for(i = r; i >= l; i--) {
            if(r == max) break;

            if(r < max) max /= 2;
        }
        return (i-1)^i;
    }

    static int maximizingXor2(int l, int r) {
        int max = 0;
        int cur = 0;
        for(int i = l; i < r; i++) {
            for(int j = i; j < r; j++) {
                cur = j^(j+1);
                if(max < cur) max = cur;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor2(l, r);
        //int result = l^r;
        //int result = maximizingXor(l, r);

        System.out.println(result);

        scanner.close();
    }
}