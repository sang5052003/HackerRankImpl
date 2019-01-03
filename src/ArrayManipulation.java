import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ArrayManipulation {

    /*
    n = 10,
    n은 '0'으로 이루어진 배열 길이 (ex: [0,0,0,0,0,0,0,0,0,0])
    숫자 범위는 input으로 주어짐 (ex : 아래 예제는 1 ~ 9)
    오퍼레이션은 행의 수 (ex : 아래 예제는 3행)
    오퍼레이션 : k의 값을 a ~ b 배열 인덱스에 더해준다, 이 과정을 오퍼레이션 수만큼 실행
    return 값은 배열 요소 중 최대 값

    //주어진 값
    a b k
    1 5 3 // 1 ~ 5 인덱스에 3을 더함
    4 8 7 // 4 ~ 8인덱스에 7을 더함
    6 9 1

    // 결과
    index->	 1 2 3  4  5 6 7 8 9 10
            [0,0,0, 0, 0,0,0,0,0, 0] // 0부터 시작
            [3,3,3, 3, 3,0,0,0,0, 0]
            [3,3,3,10,10,7,7,7,0, 0]
            [3,3,3,10,10,8,8,8,1, 0]

    // 최대 값은 10
    */

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        int arrayLen = n;
        int operationCount = queries.length;
        int startIdx = 0;
        int endIdx = 0;
        long addValue = 0;
        long[] oneRowArr = new long[arrayLen];
        long maxValue = 0;
        for(int i = 0; i < operationCount; i++) {
            startIdx = queries[i][0];
            endIdx = queries[i][1];
            addValue = queries[i][2];

            for(int j = startIdx - 1; j < endIdx; j++) {
                oneRowArr[j] += addValue;
                if(maxValue < oneRowArr[j]) {
                    maxValue = oneRowArr[j];
                }
            }
        }

        return maxValue;
    }

    /*
    1 5 3 // 1 ~ 5 인덱스에 3을 더함
    4 8 7 // 4 ~ 8인덱스에 7을 더함
    6 9 1

    첫번째 row의 index가 두번째 row index와 겹치는지 검출
     - 첫row의 두번째 index - 두번째row 첫번째 index 결과가 0이상이면 겹침
    겹치면 피가수를 더함.
    구해진 값을 이전 max와 비교, 교체

     */
    static long arrayManipulation2(int n, int[][] queries) {

        int operationCount = queries.length;
        int endIdx = queries[0][1]; //첫번째 end인덱스
        long addValue = 0;
        long currentValue = 0;
        int isPlus = 0;
        long maxValue = 0;
        for(int i = 0; i < operationCount; i++) {

            //겹치는지 검증
            isPlus = endIdx - queries[i][1]; //이전 두번째 인덱스 - 현재 첫인덱스
            addValue = queries[i][2]; //현재 더해질 값

            //겹치면 더함
            if(isPlus >= 0) {
                currentValue += addValue;
            } else {
                //안겹치면 피가수와 현재값을 비교 더 큰값을 찾는다
                if(addValue > currentValue) {
                    currentValue = addValue;
                }
            }

            //max비교, 교체
            if(maxValue < currentValue) {
                maxValue = currentValue;
            }

            endIdx = queries[i][1];
        }

        return maxValue;
    }

    // 가장 많이 겹치는 idx를 찾는다.
    // 그 idx의 해당 row 피가수들을 더한다.
    // 더한 값과 피가수들을 비교 가장 큰 값을 리턴
    static long arrayManipulation3(int n, int[][] queries) {

        int operationCount = queries.length;
        long maxValue = 0;
        long curValue = 0;
        Map<Integer, Long> idxCounterMap = new HashMap<>();
        for(int i = 0; i < operationCount; i++) {

            for(int j = queries[i][0] - 1; j < queries[i][1]; j++) {
                curValue = queries[i][2];
                if(idxCounterMap.containsKey(j)) {
                    curValue = idxCounterMap.get(j) + curValue;
                    idxCounterMap.put(j, curValue);
                } else {
                    idxCounterMap.put(j, curValue);
                }
                if(curValue > maxValue) {
                    maxValue = curValue;
                }
            }

        }
        return maxValue;
    }

    // difference array 사용
    // 첫번째 input(idx)에 피가수 더함, 두번째 input(idx) + 1위치에 피가수를 뺌
    // 전체 operations(rows) 종료 후 구해진 배열의 인덱스 순대로 돌면서 현재값과 최대값 비교해서 maxValue 구한다.
    // (현재값 : 이전 maxValue + 현재 인덱스의 값, 최대값 : maxValue)

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        scanner.close();
    }
}
