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
class Solution42 {
    public int trap(int[] height) {
        // Method 2: Two pointers
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int left = 1;
        int right = height.length - 2;
        int sum = 0;

        while(left <= right){
            // if leftMax <= rightMax
            if (leftMax <= rightMax){
                int waterHold = leftMax - height[left];
                if (waterHold > 0){
                    sum+=waterHold;
                }
                if (height[left] > leftMax){
                    leftMax = height[left];
                }
                left++;
            }else{
                int waterHold = rightMax - height[right];
                if (waterHold > 0){
                    sum += waterHold;
                }
                if (height[right] > rightMax){
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }
    
}
//leetcode submit region end(Prohibit modification and deletion)
