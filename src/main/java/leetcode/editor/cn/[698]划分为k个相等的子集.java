//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 
// 👍 516 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

class PartitionToKEqualSumSubsets {
  public static void main(String[] args) {
    Solution solution = new PartitionToKEqualSumSubsets().new Solution();
    System.out.println(solution.canPartitionKSubsets(new int[]{4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9}, 5));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      // 先求和
      int maxNum = nums[0], sum = 0;
      for (int num : nums) {
        sum += num;
        if (num > maxNum) {
          maxNum = num;
        }
      }
      if (sum % k != 0 || maxNum > sum / k) {
        return false;
      }
      int target = sum / k;
      int tempSum;
      // 排序
      Arrays.sort(nums);
      boolean[] isUsed = new boolean[nums.length];
      for (k--; k > 0; k--) {
        if (!canMatchTarget(nums, isUsed, target, nums.length - 1)) {
          return false;
        }
      }
      return true;
    }

    private boolean canMatchTarget(int[] nums, boolean[] isUsed, int target, int startIndex) {
      // 匹配越界了
      if (startIndex < 0) {
        return false;
      }
      for (; startIndex >= 0; startIndex--) {
        if (!isUsed[startIndex]
            && target >= nums[startIndex]) {
          target -= nums[startIndex];
          isUsed[startIndex] = true;
          if (target == 0) {
            return true;
          }
          if (!canMatchTarget(nums, isUsed, target, startIndex - 1)) {
            target += nums[startIndex];
            isUsed[startIndex] = false;
          } else {
            return true;
          }
        }
      }
      return target == 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}