//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly left rotated at an 
//unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k],
// nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// 
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 28944 👎 1750


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[l]){
                // m is in left section (left section is sorted)
                if (target >= nums[l] && target < nums[m]){
                    // t in left sorted section
                    r = m - 1;
                }else{
                    // t in right unsorted section
                    l = m + 1;
                }
            }else{
                // m is in right section (right section is sorted)
                if (target > nums[m] && target <= nums[r]){
                    // t in the right sorted section
                    l = m + 1;
                }else{
                    // t in the left unsorted section
                    r = m - 1;
                }

            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
