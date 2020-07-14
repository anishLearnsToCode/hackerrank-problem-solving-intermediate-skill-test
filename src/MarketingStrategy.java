public class MarketingStrategy {
    public static int minimumSwaps(String status) {
        return Math.min(
                minSwapsStartingWithS(status),
                minSwapsStartingWithR(status)
        );
    }

    private static int minSwapsStartingWithS(String status) {
        return swaps(status, 0, 'S') + swaps(status, 1, 'R');
    }

    private static int minSwapsStartingWithR(String status) {
        return swaps(status, 1, 'S') + swaps(status, 0, 'R');
    }

    private static int swaps(String string, int start, char character) {
        int swaps = 0;
        for (int index = start ; index < string.length() ; index += 2) {
            if (string.charAt(index) != character) {
                swaps++;
            }
        }
        return swaps;
    }
}
