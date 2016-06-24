package leetcode;

public class SumRange_DP {

    private int len;
    private int[][] rec;
    public SumRange_DP(int[] nums) {
        this.len = nums.length;
        rec = new int[len][len];
        for(int i = 0; i < len; i ++){
           rec[i][i] = nums[i];
        }
        //for(int i = 1; i < len; i ++){
          //  rec[i][i-1] = rec[i-1][i-1] + rec[i][i];
        // }
        for(int i = 1; i < len; i ++){
            for(int j = i - 1; j >= 0; j --){
                rec[i][j] = rec[j][j] + rec[i][j+1];
            }
        }
        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j++){
                System.out.print(rec[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int sumRange(int i, int j) {
        int[][] temp = rec;
        return temp[j][i];
        
    }
    
    public static void main(String[] args){
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	SumRange_DP sr = new SumRange_DP(nums);
    	System.out.println(sr.sumRange(0, 2));
    	System.out.println(sr.sumRange(2, 5));
    	System.out.println(sr.sumRange(0, 5));
    }
}