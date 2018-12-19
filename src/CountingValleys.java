import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // 0으로 시작, u인 경우 +1, d인 경우 -1

    // 이전 단계가  u인 경우만, 현재 level 이 0이면 계곡을 지나옴

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        int currentLevel = 0;
        char currentChar = ' ';
        for(int i = 0; i <  s.length(); i++) {
            currentChar = s.charAt(i);
            if(currentChar == 'U') {
                currentLevel++;
                if(currentLevel == 0) {
                    valleyCount++;
                }
            } else {
                currentLevel--;
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();
    }
}
