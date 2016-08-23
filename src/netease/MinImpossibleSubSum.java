package netease;

import java.util.Arrays;
import java.util.Scanner;

public class MinImpossibleSubSum {
	
	/////// 利用连续性，若累加和和下一个相差大于1，则累加和＋1这个数无法得到。
	///// 首先如果数字里没有1， 那么1肯定是最少不能获得的数
	///// 其次如果数组长度为1， 则比它大1的数字是最小的无法求和得到的数
	///// 当数组里含有1的时候， 容易理解，如果某数字比累加和大超过1，那么至少 累加和＋1 那个数字无法获得
	///// 因为，累加和是把当前数字前面的都已经加起来了的，这个时候如果它跟当前数字相差相等，那没事
	///// 如果当前数字比它大1，还可以认为是连续的
	///// 只要当前数字比它大2以上，后边的数字不需要考虑，我们都知道比它大1的数字无法获得....
	
	
	//    若当前值比和小呢？比如一个4， 一个6 如何保证5是可以获得的？因为我们直到已经保证1～4可获得，那估计是减掉1～4的都可能？
	//    而当前值不可能比累加和小那么多，多于自己吧..如何保证...
	
	public static int check(int[] nums, int n){
		if(nums[0] > 1)
			return 1;
		else if(n == 1)
			return nums[0] + 1;
		else{
			int sum = nums[0];
			for(int i = 1; i < nums.length; i++){
				System.out.println(nums[i]);
				if(nums[i] - sum > 1)
					break;
				else 
					sum += nums[i];
			}
			return sum+1;
		}
	}
	// 0-1背包问题，求出当前数字使用与否的区别: 复杂度 N * n...?
	public static int dp(int[] nums, int n){
		int round = 1;
		while(true){
			int sum = 0;
			for(int i = n-1; i >= 0 && sum != round; i--){
				if(sum+nums[i] <= round)  // 如果容量为round能装就继续装，否则跳过，找更小的，直到遍历一遍以后
					sum += nums[i];
			}
			if(round == sum) {
				//刚好装满
				round ++;
				continue;
			}
			else
				return round;
				
		}
	}
	
	public static void main(String[] args){
		
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = in.nextInt();
		}
		Arrays.sort(nums);    // ascending
		System.out.println(dp(nums, n));
	}

}
