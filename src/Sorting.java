
public class Sorting {

	
	public void quickSort(int[] nums){
		
	}
	public void partition(int[] nums, int m, int n){
		int i = m; 
		int j = n + 1;
		int pivot = nums[i];
		
		while(true){
			while(nums[++i] < pivot) ;
			while(nums[--j] > pivot) ;
			if(i >= j)
				break;
			
			swap(nums, i, j);
		}
		swap(nums, m, j);
		
	}
	public void swap(int[] nums, int m,int n){
		int temp = nums[n];
		nums[n] = nums[m];
		nums[m] = temp;
	}
}
