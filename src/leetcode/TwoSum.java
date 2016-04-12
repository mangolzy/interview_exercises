package leetcode;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        int i=0;
        int j=0;
        re[0] = 0;
        re[1] = 0;
        for(i = 0; i < nums.length; i++)
        {
            
            for(j = i + 1; j < nums.length; j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    re[0] = i + 1;
                    re[1] = j + 1;
                    break;
                }
                else
                    continue;
            }
            if(j == nums.length)
                continue;
        }
       
        return re;
    }
}
