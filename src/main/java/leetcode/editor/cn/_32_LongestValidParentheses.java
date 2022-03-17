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
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1700 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/*
 * 题目标题：最长有效括号
 */
public class _32_LongestValidParentheses {
  public static void main(String[] args) {
    Solution solution = new _32_LongestValidParentheses().new Solution();
    System.out.println(solution.longestValidParentheses("()(()"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestValidParentheses(String s) {
      if (s.length() < 2) {
        return 0;
      }
//      int maxLength = 0, tempMaxLength = 0;
//      Stack<Character> leftStack = new Stack<>();
//      boolean isPoping = false;
//      for (Character character : s.toCharArray()) {
//        if (character == '(') {
//          leftStack.push(character);
//        } else {
//          if (!leftStack.empty()) {
//            leftStack.pop();
//            tempMaxLength += 2;
//          } else {
//            maxLength = Math.max(maxLength, tempMaxLength);
//            tempMaxLength = 0;
//          }
//        }
//      }

//      return Math.max(maxLength, tempMaxLength);

      int n=s.length();
      int left=0;
      int right=0;
      int res=0;
      for(int i=0;i<n;i++){
        if(s.charAt(i)=='(')left++;
        else right++;
        if(left==right)res=Math.max(res,2*right);
        else if(left<right)left=right=0;
      }
      left=right=0;
      for(int i=n-1;i>=0;i--){
        if(s.charAt(i)=='(')left++;
        else right++;
        if(left==right)res=Math.max(res,2*left);
        else if(right<left)left=right=0;
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}