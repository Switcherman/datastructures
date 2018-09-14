package com.pctf.leetcode;

/**
 * 80
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesSolution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int location = 1;
        for (int index = 1; index < nums.length - 1; index++) {
            if (nums[index] == nums[index - 1 ] && nums[index] == nums[index + 1]) {
                continue;
            } else {
                nums[location++] = nums[index];
            }
        }
        // 判断最后一个
        nums[location++] = nums[nums.length - 1];
        return location;
    }
}
