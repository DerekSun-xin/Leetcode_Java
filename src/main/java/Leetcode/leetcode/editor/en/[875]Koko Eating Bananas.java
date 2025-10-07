//Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has 
//piles[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
//chooses some pile of bananas and eats k bananas from that pile. If the pile has less 
//than k bananas, she eats all of them instead and will not eat any more bananas 
//during this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas 
//before the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h 
//hours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 12855 👎 853


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // left is 1, right is the max pile of piles
        int left = 1, right = 0;
        int k = Integer.MAX_VALUE;
        for(int pile: piles){
            if (pile > right){
                right = pile;
            }
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            long timeFinish = calculateTime(mid, piles);
            if (timeFinish <= h){
                if (mid < k){
                    k = mid;
                }
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return k;
    }

    // Calculate the hours Koko take to finish the piles of bananas
    // O(n)
    private long calculateTime(int k, int[] piles){
        long total = 0;
        for(int pile: piles){
            total += (long) Math.ceil((double) pile / k);
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
