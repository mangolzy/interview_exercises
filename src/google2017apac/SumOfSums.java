package google2017apac;

import java.util.Arrays;

public class SumOfSums {
	public int subArraySum(int[] a, int start, int end){
		int res = 0;
		int[] accumulateArray = a;
		for(int i = 1; i < a.length; i++){
			accumulateArray[i] += a[i-1];
		}
		res = accumulateArray[end] - accumulateArray[start];
		
		return res;
	}
	
	public int sumOfSums(int[] a, int start, int end){
		int res = 0;
		int l = a.length;
		int[] subArraySum = new int[l * (l+1)/2];
		int k = 0;
		for(int i = 0; i < a.length; i++){
			for(int j = i; j < a.length; j ++, k++){
				if( k < l * (l+1)/2)
					subArraySum[k] = subArraySum(a,i,j);
			}
		}
		Arrays.sort(subArraySum);
		res = subArraySum(subArraySum, start, end);
		return res;
	}
	
	public static void main(String[] args){
		SumOfSums sofs = new SumOfSums();
		int[] test = {5, 4, 3, 2, 1};
		System.out.println(sofs.sumOfSums(test, 3, 8));
	}
}
