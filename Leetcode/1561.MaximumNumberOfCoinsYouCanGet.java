class Solution {
    public int maxCoins(int[] piles) {
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(piles);
        int sum = 0;
        for(Integer pile : piles)
            deque.addLast(pile);
        for(int i = 0; i < piles.length; i+=3) {
            deque.pollLast();
            sum+=deque.pollLast();
            deque.pollFirst();
        }
        return sum;
    }
}