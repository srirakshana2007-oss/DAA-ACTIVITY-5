//https://leetcode.com/problems/combination-sum/submissions/2168507261/

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, int target, int start,
                   List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target)
                continue;

            current.add(nums[i]);
            backtrack(nums, target - nums[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
