import java.io.IOException;
import java.util.*;

public class SockMerchant {

    // 요소를 뽑아 맵에 input, key가 없으면 요소를 key로 넣고, value = 1
    // key가 있으면 value++

    // iterator로 value를 돌린다.

    // iter로 value / 2의 값을 모두 합

    //합 한 값을 리턴

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        if(n < 2) return 0;

        Map<Integer, Integer> socksMap = new HashMap<>(n);
        int currentValue = 0;
        int returnValue = 0;

        for(int i = 0; i < n; i++) {
            if(socksMap.containsKey(ar[i])) {
                currentValue = socksMap.get(ar[i]) + 1;
                socksMap.put(ar[i], currentValue);
            } else {
                socksMap.put(ar[i], 1);
            }
        }

        Collection<Integer> values = socksMap.values();
        for(Integer value : values) {
            returnValue += value / 2;
        }
        return returnValue;
    }

    static int sockMerchantWithSet(int n, int[] ar) {
        if(n < 2) return 0;

        Set<Integer> socksSet = new HashSet<>(n);
        int pairCount = 0;
        for(int i = 0; i < n; i++) {
            if(socksSet.contains(ar[i])) {
                pairCount++;
                socksSet.remove(ar[i]);
            } else {
                socksSet.add(ar[i]);
            }
        }

        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);

        scanner.close();
    }
}