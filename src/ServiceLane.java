import java.util.Scanner;

// https://www.hackerrank.com/challenges/service-lane/problem

public class ServiceLane {

    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int[][] cases, int[] width) { // [row][col]

        int[] rtValArr = new int[cases.length];
        int firstIdx = 0;
        int secondIdx = 0;
        int min = 0;
        for (int i = 0; i < cases.length; i++) {
            firstIdx = cases[i][0];
            secondIdx = cases[i][1];
            min = 100000;
            for(int j = firstIdx; j < secondIdx + 1; j++) {
                if(width[j] < min) {
                    min = width[j];
                    if(min == 1) break;
                }
            }
            rtValArr[i] = min;
        }

        return rtValArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, cases, width);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
