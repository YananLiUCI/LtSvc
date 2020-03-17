package App;

public class buySellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int n = prices.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int localMin = prices[0];
        int globalMax = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            globalMax = Math.max(globalMax, Math.max(0, prices[i] - localMin));
            localMin = Math.min(localMin, prices[i]);
            left[i] = globalMax;
        }

        int localMax = prices[n - 1];
        globalMax = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            globalMax = Math.max(globalMax, Math.max(0, localMax - prices[i]));
            localMax = Math.max(localMax, prices[i]);
            right[i] = globalMax;
        }

        int rst = 0;

        for(int i = 0; i < n - 1; i++){
            rst = Math.max(rst, left[i] + right[i + 1]);
        }
        // might be completely on left side;
        rst = Math.max(rst, left[n - 1]);

        return rst;
    }

}
