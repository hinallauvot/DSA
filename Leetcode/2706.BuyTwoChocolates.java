class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int price : prices) {
            if(min1 > price) {
                min2 = min1;
                min1 = price;
            } else if(min2 > price) {
                min2 = price;
            }
        }
        if(min1 + min2 > money) return money;
        return money - (min1 + min2);
    }
}