//给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。 
//
// 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。 
//
// 如果无法得到答案，请返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：digits = [8,1,9]
//输出："981"
// 
//
// 示例 2： 
//
// 输入：digits = [8,6,7,1,0]
//输出："8760"
// 
//
// 示例 3： 
//
// 输入：digits = [1]
//输出：""
// 
//
// 示例 4： 
//
// 输入：digits = [0,0,0,0,0,0]
//输出："0"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 10^4 
// 0 <= digits[i] <= 9 
// 返回的结果不应包含不必要的前导零。 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 64 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

class LargestMultipleOfThree {
  public static void main(String[] args) {
    Solution solution = new LargestMultipleOfThree().new Solution();
    System.out.println(solution.largestMultipleOfThree(new int[]{8, 1, 9}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String largestMultipleOfThree(int[] digits) {
      Arrays.sort(digits);
      int minMod1[] = new int[]{0, 0};
      int minMod2[] = new int[]{0, 0};
      int sum = 0;
      for (int i : digits) {
        sum += i;
        if (i % 3 == 0) {

        } else if (i % 3 == 1 && minMod1[1] == 0) {
          setMod(i, minMod1);
        } else if (i % 3 == 2 && minMod2[1] == 0) {
          setMod(i, minMod2);
        }
      }

      StringBuilder sb = new StringBuilder();
      switch (sum % 3) {
        case 0:
          for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
          }
          break;
        case 1:
          if (minMod1[0] != 0) {
            remove1(digits, minMod1[0], sb);
          } else if (minMod2[1] != 0) {
            remove2(digits, minMod2, sb);
          } else {
            return "";
          }
          break;
        case 2:
          if (minMod2[0] != 0) {
            remove1(digits, minMod2[0], sb);
          } else if (minMod1[1] != 0) {
            remove2(digits, minMod1, sb);
          } else {
            return "";
          }
          break;
      }
      if(sb.indexOf("0")==0){
        return "0";
      }
      return sb.toString();
    }

    private void setMod(int digit, int[] mod) {
      if (mod[0] == 0) {
        mod[0] = digit;
      } else {
        mod[1] = digit;
      }
    }

    private void remove1(int[] digits, int needRemove, StringBuilder stringBuilder) {
      for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] == needRemove) {
          needRemove = -1;
        } else {
          stringBuilder.append(digits[i]);
        }
      }
    }

    private void remove2(int[] digits, int[] needRemove, StringBuilder stringBuilder) {
      for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] == needRemove[1]) {
          needRemove[1] = -1;
        } else if (digits[i] == needRemove[0]) {
          needRemove[0] = -1;
        } else {
          stringBuilder.append(digits[i]);
        }
      }
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}