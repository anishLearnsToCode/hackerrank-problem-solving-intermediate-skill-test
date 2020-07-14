import java.util.ArrayList;
import java.util.List;

public class GCDSubSequence {
    static List<Integer> findMaxGCD(List<Integer> numbers, int k) {
        Object[] original = numbers.toArray();
        numbers.sort(Integer::compareTo);
        int high = numbers.get(numbers.size() - 1);
        int[] divisors = getDivisors(numbers, high + 1);
        int maxGcd = hetMaxGcd(divisors, high, k);
        return numbersDivisibleBy(original, maxGcd);
    }

    private static int hetMaxGcd(int[] divisors, int high, int k) {
        int maxGcd = 0;
        for (maxGcd = high; maxGcd >= 1; maxGcd--) {
            if (divisors[maxGcd] >= k) {
                break;
            }
        }
        return maxGcd;
    }

    private static int[] getDivisors(List<Integer> numbers, int length) {
        int[] divisors = new int[length];
        for (Integer integer : numbers) {
            for (int j = 1; j * j <= integer; j++) {
                if (integer % j == 0) {
                    divisors[j]++;
                    if (j != integer / j) {
                        divisors[integer / j]++;
                    }
                }
            }
        }
        return divisors;
    }

    private static List<Integer> numbersDivisibleBy(Object[] numbers, int gcd) {
        List<Integer> result = new ArrayList<>();
        for (Object number : numbers) {
            if ((int) number % gcd == 0) {
                result.add((int) number);
            }
        }
        return result;
    }

    public static List<Integer> findSubsequence(List<Integer> numbers, int k) {
        return findMaxGCD(numbers, k);
    }

    static public void main (String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(4);
        arr.add(15);
        arr.add(20);
        arr.add(1);
        int k = 3;
        System.out.println(findSubsequence(arr, k));
    }
}
