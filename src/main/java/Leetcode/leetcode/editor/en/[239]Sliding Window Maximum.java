//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 19713 👎 782


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == k){
            int[] res = new int[1];
            int maxVal = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++){
                if (nums[i] > maxVal){
                    maxVal = nums[i];
                }
            }
            res[0] = maxVal;
            return res;
        }

        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for(int i = 0; i < nums.length; i++){
            // Before adding a new element, check the index at the front of deque.
            // If it is outside the current window's bound (ie. index <= i - k, remove it.
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.removeFirst();
            }
            // Now look at the new element nums[i].
            // While deque is not empty and nums[i] > element at the back of deque,
            // 1. Pop from back and remove all elements smaller than nums[i] because they can no longer be the maximum.
            // 2. Add nums[i] to the back of deque.
            // 3. if i has reached the end of the first full window (ie. i >= k-1),
            // the maximum value for this window is the element at the front of deque.
            // Add this value to result list.
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k-1){
                res.add(nums[dq.peekFirst()]);
            }
        }
        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
