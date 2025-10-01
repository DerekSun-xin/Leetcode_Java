//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 22675 👎 1058


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>(); 
        int openRemain = n, closeRemain = n;
        backtrack(ret,"", openRemain, closeRemain);
        return ret;
    }
    
    public void backtrack(List<String> ret, String curStr, int openRemain, int closeRemain){
        if (openRemain == 0 && closeRemain == 0){
            ret.add(curStr);
            return;
        }
        // Add ( or )
        if (openRemain > 0){
            backtrack(ret, curStr + "(", openRemain - 1, closeRemain);
        }
        if (closeRemain > 0 && closeRemain > openRemain){
            backtrack(ret, curStr + ")", openRemain, closeRemain - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
