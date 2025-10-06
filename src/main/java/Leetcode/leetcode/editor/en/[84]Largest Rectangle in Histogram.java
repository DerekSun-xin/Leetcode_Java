//Given an array of integers heights representing the histogram's bar height 
//where the width of each bar is 1, return the area of the largest rectangle in the 
//histogram. 
//
// 
// Example 1: 
// 
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
// 
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics Array Stack Monotonic Stack 👍 18834 👎 363


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>(); // Maintain a dq of non-decreasing order
        dq.push(0);
        int maxArea = heights[0];
        for(int i = 1; i <= heights.length; i++){
            int curHeight;
            // Add a prolonged height 0 at the end to make sure the stack will be processed empty no element is left
            if (i == heights.length){
                curHeight = 0;
            }else{
                curHeight  = heights[i];
            }

            if (curHeight >= heights[dq.peek()]){
                dq.push(i);
            }else{
                while(!dq.isEmpty() && curHeight < heights[dq.peek()]) {
                    // Find the boundary for the top element of dq
                    int width;
                    Integer barIdx = dq.pop();
                    if (!dq.isEmpty()){
                        width = i - dq.peek() - 1;
                    }else{
                        width = i;
                    }
                    if (heights[barIdx] * width > maxArea) {
                        maxArea = heights[barIdx] * width;
                    }
                }
                dq.push(i);
            }
        }

        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
