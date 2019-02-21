import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

    /*
    input
    2 5
    1 0 5
    1 1 7
    1 0 3
    2 1 0
    2 1 1

    output
    7
    3

    첫번째 input = N (배열의 길이)
    두번째 input = Q (operations, 행)

    operation에서
    1번 input = query type을 의미
    2번 input = x
    3번 input = y
    */

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        // n개의 list 생성
        List<Integer>[]  ns = new ArrayList[n];
        for(int i = 0; i < ns.length; i++) {
            ns[i] = new ArrayList<>();
        }
        List<Integer> returnValue = new ArrayList<>();

        int queryType = 0;
        int x = 0;
        int y = 0;
        int lastAnswer = 0;
        int subIdx = 0;
        int size = 0;

        // queries를 돌면서 각 operation 실행
        for(List<Integer> row : queries) {
            queryType = row.get(0);
            x = row.get(1);
            y = row.get(2);

            subIdx = (x^lastAnswer) % n;
            if(queryType == 1) {
                ns[subIdx].add(y);
            } else {
                if(ns == null || ns.length == 0) {
                    returnValue.add(lastAnswer);
                } else {
                    size = ns[subIdx].size();
                    lastAnswer = ns[subIdx].get(y % size);
                    returnValue.add(lastAnswer);
                }
            }
        }

        // operation이 1인 경우, 생성된 배열에 계산해서 y값을 넣는다

        // operation이 2인 경우, lastAnswer 을 구하고, 그 값을 return list에 추가 한다


        return returnValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> queries = new ArrayList<>();
        //int[][] queries = new int[m][3];
        List<Integer> row = null;
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                row.add(queriesItem);
            }
            queries.add(row);
        }

        List<Integer> result = dynamicArray(n, queries);

        for(Integer integer : result) {
            System.out.println(integer);
        }
    }
}
