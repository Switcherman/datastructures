package com.pctf.leetcode;

public class NextPermutationSolution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(i, j, nums);
        }
        resverse(i + 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void resverse(int i, int[] nums) {
        int j = nums.length - 1;
        while(i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

}
