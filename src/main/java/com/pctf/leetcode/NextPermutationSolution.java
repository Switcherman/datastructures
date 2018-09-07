package com.pctf.leetcode;

public class NextPermutationSolution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 查询数组的反转位置
        int index = getRotatedIndex(nums);
        int start, end;
        if (target > nums[0]) {
            start = 0;
            end = index - 1 > 0 ? index - 1 : nums.length - 1;
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
