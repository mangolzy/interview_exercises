
public class RadixSort {
	// array to be sort nums
	// the length of th longest number in the array, we need to treat them in d pass
	
	public static void rsort(int[] nums, int d){
		
		int k = 0; // index for restoring the array every pass
		int n = 1; // act as the divider to get the lsd of each number, augment by * 10 each pass
		int m = 0; // current nb of pass
		int[][] temp = new int[10][nums.length]; // 10 buckets of length = nums.length
		int[] counts = new int[10]; // counting the nbs in each bucket, helpful when we get them out to restore the array
		
		while(m < d){
			// allocate to different buckets
			for(int i = 0; i < nums.length; i ++){
				int lsd = ( nums[i] / n ) % 10;
				temp[lsd][counts[lsd]] = nums[i];
				counts[lsd] ++;
			}
			
			// reconstruct the array from the buckets
			for(int j = 0; j < counts.length; j++){
				for(int l = 0; l < counts[j]; l++){
					nums[k] = temp[j][l];
					k++;
				}
				counts[j] = 0;
			}
			m ++;
			n *= 10;
			k = 0;
		}
	}
	
	
	
	
	
	public static void main(String[] args){
		int[] t = {123,1421,2323,123124,1232,456,546,786,8686};
		rsort(t,6);
		for(int i = 0; i < t.length; i++){
			System.out.println(t[i]);
		}
	}
}
