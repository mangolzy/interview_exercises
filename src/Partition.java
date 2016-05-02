import java.util.Random;


public class Partition {
	/*
	private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        int temp = 0;
        while (true) { 

            // find item on lo to swap
            while (a[++i]< v)
                if (i == hi) break;

            // find item on hi to swap
            while (v < a[--j])
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) 
            	break;

            temp = a[i];
			a[i] = a[j];
			a[j] = temp;
        }

        // put partitioning item v at a[j]
        a[lo] = a[j];
        a[j] = v;
        for(int k = 0; k < a.length; k++)
			System.out.print(a[k]+" ");
		System.out.println();
		
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
	
	*/
	/*
	public int partition(int[] nums, int start, int end){
		
		int pivot = nums[start];
		int i = start;
		int j = end+1;
		int temp = 0;

		while(true){
			while(++i < end && nums[i] < pivot)
			while(--j > start && nums[j] > pivot)
			if(j <= i)
				break;
			
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			
			
			
		}
		
		nums[start] = nums[j];
		nums[j] = pivot;
		for(int k = 0; k < nums.length; k++)
			System.out.print(nums[k]+" ");
		System.out.println();
		return j;
		
	}*/
	
	public int partition(int[] nums, int start, int end){
		//Random rand = new Random();
		//int r = rand.nextInt(end);
		int pivot = nums[end];
		int i = start-1;
		int j = end;
		int temp = 0;
	
		while(i < j){
			while(++i < end && nums[i] < pivot) ;
			/*while(nums[++i] < pivot)
				if(i == end)
					break;
			*/
			while(--j > start && nums[j] > pivot) ;
			/*
			while(nums[--j] > pivot)
				if(j == start)
					break;
			*/
			if(j > i)
			{
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
			
			
		}
		
		nums[end] = nums[i];
		nums[i] = pivot;
		for(int k = 0; k < nums.length; k++)
			System.out.print(nums[k]+" ");
		System.out.println();
		return i;
		
	}
	
	 public int findKthLargest(int[] nums, int k) {
	        int low = 0;
	        int high = nums.length - 1;
	        int cur = partition(nums, low, high);
	        int index = nums.length - k;
	        while(cur != index){
	            if(cur > index){
	                high = cur - 1;
	                cur = partition(nums, low, high);
	            }
	            else{
	                low = cur + 1;
	                cur = partition(nums, low, high);
	            }
	                
	        }
	        return nums[index];
	    }
	public static void main(String[] args){
		Partition p = new Partition();
		//int[] nums = {3,2,3,1,2,4,5,5,6};
		int[] nums = {3,3,2,4,5,3,6,5,7};
		//int[] nums = {3,3,3,3,3,3,3,3,3};
		//int[] nums = {2,4,2,5,1};
		//int x = p.partition(nums, 0, nums.length-1);
		int x = p.findKthLargest(nums, 2);
		System.out.println(x);
	}
}
