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
    System.out.println(solution.canPartitionKSubsets(new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269}, 5));
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
        for (int i = nums.length - 1; i > -1; i--) {
          if (isUsed[i]) {
            break;
          }

          tempSum = nums[i];
          isUsed[i] = true;

          for (int j = i - 1; j > -1; j--) {
            if (!isUsed[j] && tempSum + nums[j] <= target) {
              isUsed[j] = true;
              tempSum += nums[j];
              if (tempSum == target) {
                break;
              }
            }
          }

          if (tempSum != target) {
            return false;
          }

        }
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}