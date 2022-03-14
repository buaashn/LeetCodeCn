//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1697 👎 0


package leetcode.editor.cn;

import java.util.Stack;

class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() < 2) {
                return 0;
            }
            int maxLength = 0, tempMaxLength = 0;
            Stack<Character> leftStack = new Stack<>();
            boolean isPoping = false;
            for (Character character : s.toCharArray()) {
                if (character == '(') {
                    if (isPoping) {
                        leftStack.clear();
                    } else {
                        leftStack.push(character);
                    }
                } else {
                    if (!leftStack.empty()) {
                        tempMaxLength += 2;
                        leftStack.pop();
                        isPoping = true;
                    } else {
                        maxLength = Math.max(maxLength, tempMaxLength);
                        tempMaxLength = 0;
                        isPoping = false;
                    }
                }
            }
            return Math.max(maxLength, tempMaxLength);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}