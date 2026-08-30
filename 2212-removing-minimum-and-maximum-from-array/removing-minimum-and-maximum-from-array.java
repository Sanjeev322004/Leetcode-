class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int min = 0;
        int max = 0;
        for(int i=0; i<n;i++){
            if(nums[i]<nums[min]) min=i;
            if(nums[i]>nums[max]) max=i;
        }
        int low=Math.min(min,max);
        int high=Math.max(min,max);
        int s=high+1;
        int s1=n-low;
        int s2=(low+1)+(n-high);

        return  Math.min(s,Math.min(s1,s2));
    }
}