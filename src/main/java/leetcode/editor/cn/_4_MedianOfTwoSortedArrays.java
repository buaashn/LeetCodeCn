//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5143 👎 0

package leetcode.editor.cn;

/*
 * 题目标题：寻找两个正序数组的中位数
 */
public class _4_MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    Solution solution = new _4_MedianOfTwoSortedArrays().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length == 0 && nums2.length == 0) {
        return 0.0d;
      }
      if (nums1.length < nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
      }

      int m = nums1.length;
      int n = nums2.length;
      // 左边可以多一个
      int left = (m - n + 1) / 2;
      int right = (m + n + 1) / 2;

      int cut1 = (right + left) / 2;
      int cut2 = (m + n + 1) / 2 - cut1;
      long left1, left2, right1, right2;
      while (true) {
        left1 = cut1 < 1 ? Long.MIN_VALUE : nums1[cut1 - 1];
        left2 = cut2 < 1 ? Long.MIN_VALUE : nums2[cut2 - 1];
        right1 = cut1 >= m ? Long.MAX_VALUE : nums1[cut1];
        right2 = cut2 >= n ? Long.MAX_VALUE : nums2[cut2];
        if (left1 > right2) {
          right = cut1;
          cut1 = (right + left) / 2;
          cut2 = (m + n + 1) / 2 - cut1;
        } else if (right1 < left2) {
          left = left == cut1 ? left + 1 : cut1;
          cut1 = (right + left) / 2;
          cut2 = (m + n + 1) / 2 - cut1;
        } else {
          return (m + n) % 2 == 0
              ? (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2
              : Math.max(left1, left2);
        }
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}