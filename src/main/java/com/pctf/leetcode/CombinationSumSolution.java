package com.pctf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSumSolution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        backTract(result, temp, target, candidates, 0);
        return result;
    }

    private void backTract(List<List<Integer>> result, List<Integer> temp, int remains, int[] candidates, int index ) {
        if (remains < 0) {
            return;
        } else if (remains == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backTract(result, temp, remains - candidates[i], candidates, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
