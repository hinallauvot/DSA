/*  Intuition
* To find the good pairs, we need to have two pairs in array which are equal. So count the number of duplicates in an array.
* Eg: Input: nums = [1,2,3,1,1,3]
* map = [{1, 3}, {2, 1}, {3, 2}] //map that stores the count
* For each element, we can make pair with all the duplicates coming forward.
* In this case, we have 3 occurances of 1. Therefore for first 1, we will have 2 good pair, and for second 1, we will have 1 good pair.
* By this we can see one pattern
* no of good pair for a num => sum of count-1 natural numbers => count*(count-1)/2
* Approach
* Initialize a HashMap to store num and respective count
* Traverse and array and store count for each num
* Traverse values for each num and find good pairs for each num
* good pair for each num = count * (count-1)/2
* Complexity
* Time complexity:
* O(n)
* Space complexity:
* O(n)
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int val : map.values())
            res += (val*(val-1))/2;
        return res;
    }
}