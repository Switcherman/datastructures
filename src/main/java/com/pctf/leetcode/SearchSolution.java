package com.pctf.leetcode;

/**
 *
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 示例 2:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: -1
 */
public class SearchSolution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 查询数组的反转位置
        int index = getRotatedIndex(nums);
        int start, end;
        if (target > nums[0]) {
            start = 0;
            end = index - 1;
        } else if (target < nums[0]) {
            start = index;
            end = nums.length - 1;
        } else {
            return 0;
        }
        return binarySearch(start, end, nums, target);
    }

    private int binarySearch(int start, int end, int[] nums, int target) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private int getRotatedIndex(int[] nums) {
        int i = 0;
        while (nums[i] > nums[nums.length - 1]) {
            i++;
        }
        return i;
    }

}
