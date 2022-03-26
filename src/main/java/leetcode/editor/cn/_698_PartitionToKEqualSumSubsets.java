/**
 * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 * <p>
 * Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 517 👎 0
 */
package leetcode.editor.cn;

import java.util.Arrays;

/*
 * 题目标题：划分为k个相等的子集
 */
public class _698_PartitionToKEqualSumSubsets {
  public static void main(String[] args) {
    Solution solution = new _698_PartitionToKEqualSumSubsets().new Solution();
    System.out.println(solution.canPartitionKSubsets(new int[]{4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9}, 5));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      // 排序
      Arrays.sort(nums);
      // 先求和
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      if (sum % k != 0 || nums[nums.length - 1] > sum / k) {
        return false;
      }
      final int target = sum / k;
      boolean[] isUsed = new boolean[nums.length];
      return canMatchTarget(nums, isUsed, target, 0, nums.length - 1, k);
    }

    private boolean canMatchTarget(int[] nums, boolean[] isUsed, final int target, int sumTemp, int startIndex, int k) {
      for (; startIndex >= 0; startIndex--) {
        if (!isUsed[startIndex]
            && target >= sumTemp + nums[startIndex]) {
          // 没有使用并且可以放入桶里，先放进去
          sumTemp += nums[startIndex];
          isUsed[startIndex] = true;
          if (target == sumTemp) {
            // 放完刚好满了，找下一个桶,剩下最后一个桶时，一定能刚好装满
            return k < 3 || canMatchTarget(nums, isUsed, target, 0, nums.length - 1, k - 1);
          }
          // 当前桶还没装满，继续装，如果找不到合适的，就需要回溯
          if (!canMatchTarget(nums, isUsed, target, sumTemp, startIndex - 1, k)) {
            sumTemp -= nums[startIndex];
            isUsed[startIndex] = false;
          } else {
            return true;
          }
        }
      }
      // 都找完了还不能匹配到合适的，就说明装不下
      return false;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}