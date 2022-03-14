//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1528 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{1,2,3,4},2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
        public int findKthLargest(int[] nums, int k) {
            int length = nums.length;
            if (length < k) {
                return -1;
            }
            PriorityQueue<Integer> numsQueue = new PriorityQueue(k + 1);
            for (int num : nums) {
                numsQueue.offer(num);
                if (numsQueue.size() > k) {
                    numsQueue.poll();
                }
            }
            return numsQueue.poll();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}