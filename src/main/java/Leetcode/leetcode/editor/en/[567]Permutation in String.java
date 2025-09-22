//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Sliding Window 👍 12583 👎 503


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        // Handle edge case
        if (s1.length() > s2.length()){
            return false;
        }
        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char curChar = s1.charAt(i);
            s1Count.put(curChar, s1Count.getOrDefault(curChar, 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s1Count.equals(s2Count)){
            return true;
        }

        // Iterate s2
        int left = 0;
        for(int j = s1.length(); j < s2.length(); j++){
            char curChar = s2.charAt(j);
            s2Count.put(curChar, s2Count.getOrDefault(curChar, 0) + 1);

            char leftChar = s2.charAt(left);
            s2Count.put(leftChar, s2Count.get(leftChar) - 1);
            if (s2Count.get(leftChar) == 0){
                s2Count.remove(leftChar);
            }
            left++;

            if (s2Count.equals(s1Count)){
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
