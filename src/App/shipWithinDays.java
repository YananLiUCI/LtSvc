package App;

public class shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        // use binary search to find the optimal weight
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
        }
        int low = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean can = canShip(weights, D, mid);
            if (can) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // check whether can ship under the given D and capacity
    private boolean canShip(int[] weights, int D, int capacity) {
        int day = 1, w = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity || day > D) return false;
            if (w + weights[i] > capacity) {
                w = weights[i];
                day++;
            } else {
                w += weights[i];
            }
        }
        return day <= D;
    }
}
