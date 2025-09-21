//Given a string s, find the length of the longest substring without duplicate 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 43143 👎 2110


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int maxLength = 0, subStringLength = 0, left = 0;
        Set<Character> seen = new HashSet<>();
        // Iterate the string using right pointer
        for(int j = 0; j < s.length(); j++){
            char curChar = s.charAt(j);
            // If not seen before
            if (!seen.contains(curChar)){
                seen.add(curChar);
                subStringLength++;
                maxLength = Math.max(maxLength, j - left + 1);
            }
            // If seen before
            else{
                while(seen.contains(curChar)){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.add(curChar);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)