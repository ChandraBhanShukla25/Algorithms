package com.array.important;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStocks bestTimeToBuyAndSellStocks = new BestTimeToBuyAndSellStocks();
        int maxProfit = bestTimeToBuyAndSellStocks.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {

        int buy = prices[0];
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){
            maxProfit= Integer.max(prices[i]-buy, maxProfit);
            buy = Integer.min(buy, prices[i]);
        }
        return maxProfit;
    }
}
