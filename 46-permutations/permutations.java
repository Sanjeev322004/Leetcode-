class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int num : nums) {
            if (currentPath.contains(num)) {
                continue;
            }
            currentPath.add(num);
            backtrack(result, currentPath, nums);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}