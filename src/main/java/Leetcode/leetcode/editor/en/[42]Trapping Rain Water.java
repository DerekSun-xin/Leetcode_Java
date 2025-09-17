//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 35000 👎 638


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // Method 1: Dynamic Programming
        int n = height.length;

        // 1. Create int[] maxLeft O(n)
        int[] maxLeft = new int[n];
        int leftMaxHeight = height[0];

        for(int i = 1; i < n; i++){
            maxLeft[i] = leftMaxHeight;
            if (height[i] > leftMaxHeight){
                leftMaxHeight = height[i];
            }
        }

        // 2. Create int[] maxRight O(n)
        int[] maxRight = new int[n];
        int rightMaxHeight = height[n-1];
        for (int j = n-2; j >= 0; j--){
            maxRight[j] = rightMaxHeight;
            if (height[j] > rightMaxHeight){
                rightMaxHeight = height[j];
            }
        }

        // 3. Create a dp to store the water hold at each position i  O(n)
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            int waterHold = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (waterHold > 0){
                dp[i] = waterHold;
                sum += dp[i];
            }
        }

        return sum;
    }

//    public static void main (String[] args){
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        Solution sol = new Solution();
//        System.out.println(sol.trap(height));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
