package leetcode309;

public class Solution {
    public int maxProfit(int[] prices) {
        int last_sell = 0, last_buy = Integer.MIN_VALUE, last_cooldown = 0, sell = 0, buy = 0, cooldown = 0;
        for(int price:prices) {
            buy = Math.max(last_buy, last_cooldown - price);
            sell = Math.max(last_sell, last_buy + price);
            cooldown = Math.max(last_cooldown, last_sell);
            last_buy = buy;
            last_sell = sell;
            last_cooldown = cooldown;
        }
        return sell;
    }
}
