package Leetcode.leetcode.editor.en;//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 33976 👎 3171


import com.alibaba.fastjson.JSON;

import java.util.*;

import static java.util.Arrays.sort;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret;
        Set<List<Integer>> set = new HashSet<>();

        // Sort nums O(nlogn)
        Arrays.sort(nums);

        // For loop O(n^2)
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length - 1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > 0){
                    end--;
                }else if (sum < 0){
                    start++;
                }else{
                    set.add(new ArrayList<>(List.of(nums[i], nums[start], nums[end])));
                    start++;
                    end--;
                }
            }
        }
//        System.out.println(set);
        ret = new ArrayList<>(set);
        return ret;
    }

//    public static void main(String[] args){
//        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
//        List<List<Integer>> ret = threeSum(nums);
//        System.out.println(JSON.toJSONString(ret));
//        if (ret.equals("[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]")){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
//
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
