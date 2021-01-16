//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
class SellStock {
    public int maxProfit(int[] prices) {
        int currentMinValue = prices[0];
        int currentMaxGain = 0;
        for(int i = 1; i < prices.length; i++) {
            int tempGain = prices[i] - currentMinValue;
            if (tempGain > currentMaxGain) {
                currentMaxGain = tempGain;
            }
            if (prices[i] < currentMinValue) {
                currentMinValue = prices[i];
            }
        }
        return currentMaxGain;
    }
}
