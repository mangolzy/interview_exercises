import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Sorting {

	private static int cutoff = 3;
	
	public void quickSort(int[] nums){
		
		partition(nums, 0, nums.length-1);
		
	}
	public void partition(int[] nums, int m, int n){
		int i = 0; 
		int j = 0;
		int pivot;
		
		if(m+cutoff <= n){
			pivot = Median3(nums, m, n);
			i = m;
			//j = n-1;          //   reserve the position n for what??  
			j = n;
			while(true){
				while(nums[++i] < pivot) ;
				while(nums[--j] > pivot) ;
				if(i < j)
					swap(nums, i, j);
				else
					break;
			}
			swap(nums, i, n-1);  // and why switch with n-1 but not pivot ??
			partition(nums, m, i-1);
			partition(nums, i+1, n);
		}
		else
			insertionSort(nums, m, n+1);
		
		
		
	}
	public void swap(int[] nums, int m,int n){
		int temp = nums[n];
		nums[n] = nums[m];
		nums[m] = temp;
	}
	
	public int Median3(int[] a, int m, int n){
		int center = m + (n-m)/2 ;
		int left = m;
		int right = n;
		int temp;
		//int res; 
		//int min = (left<mid?left:mid)<right?(left<mid?left:mid):right;
		//int max = Math.max(left, mid)>right?Math.max(left, mid):right;
		//res = mid+left+right - min - max;
		if (a[center] < a[left]) {  
            temp = a[center];  
            a[center] = a[left];  
            a[left] = temp;  
        }  
        if (a[right] < a[left]) {  
            temp = a[right];  
            a[right] = a[left];  
            a[left] = temp;  
        }  
        if (a[right] < a[center]) {  
            temp = a[center];  
            a[center] = a[right];  
            a[right] = temp;  
        }  
          
        //place pivot at position right - 1 or left + 1，這樣left和right就不用移動  
        temp = a[center];  
        a[center] = a[right - 1];  
        a[right - 1] = temp;  
		return a[right-1];
	}
	
	public void insertionSort(int[] nums, int m, int n){
		// check each nums[i], and the elements before it, find the suitable place to insert
		if(m < n){
		for(int i = m; i < n; i++){
			int temp = nums[i];
			int j = i - 1;
			while(j >= 0 && nums[j] > temp){  // means the left part are ordered!! 
											 // if the neighbour < temp... no need to move anything
				// move to the right
				nums[j+1]= nums[j];
				j--;
			}
			if(j != i-1){
				nums[j+1] = temp;
			}
		}
		}
	}
	
	public void bubbleSort(int[] nums){
		//  from the rightmost place, find the one that should be place there by bubbling
		for(int i = nums.length-1; i >= 0; i--){
			for(int j = 0; j < i; j ++){
				if(nums[j] > nums[j+1])
					swap(nums, j, j+1);
			}
			
		}
		
	}
	
	public void selectionSort(int[] nums){
		// the place used from left to right
		// each time find the min from i to len-1
		
		for(int i = 0; i < nums.length; i++){
			int min = nums[i];
			int index = i;
			for(int j = i+1; j < nums.length; j++){
				if(nums[j] < min){
					min = nums[j];
					index = j;
				}
			}
			swap(nums, i, index);
		}
	}
	
	public void mergeSort(int[] nums, int m, int n){
		if(m < n){
			int mid = m + (n-m)/2;
			mergeSort(nums, m, mid);
			mergeSort(nums, mid+1, n);
			doMerge(nums,m,(m+n)/2,n);
		}
	}
	
	public void doMerge(int[] nums, int low, int mid, int high){
		// its con: have to use a large extra space
		int[] temp = new int[nums.length];
		
		for(int i = low; i <= high; i++)
			temp[i] = nums[i];
		int i = low;
		int j = mid + 1;
		int k = low;
		
		while(i <= mid && j <= high){
			if(temp[i] < temp[j]){
				nums[k] = temp[i];
				i++;
				k++;
			}
			else{
				nums[k] = temp[j];
				j++;
				k++;
			}
				
		}
		
		while(i <= mid){
			nums[k++] = temp[i++];
		}
		
		while(j <= high){
			nums[k++] = temp[j++];
		}
		
	}
	// min heap
	public void heapSort(int[] nums){
		int len = nums.length;
		buildHeap(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		for(int i = len-1; i >= 0; i--)
			delete(nums, i);
	}
	
	// so the smaller go up
	public void bubbleUp(int[] nums, int x){
		int i = 0;
		for(i = nums.length-1; nums[i/2] > x; i/=2)
			nums[i] = nums[i/2];
		nums[i] = x;  // the highest x can get
		
	}
	
	//  delete(swap) and then build the 0 to i-1, length of i
	public void delete(int[] nums, int i){
		int temp = nums[i];
		nums[i] = nums[0];
		nums[0] = temp;
		
		buildHeap(nums,0, i);
	}
	//  this one build heap to make each tree, with root of non-leaf legal(from small to big) 
	public void buildHeap(int[] nums){
		int n = nums.length;
		for(int i = n/2-1; i >= 0; i--)
			buildHeap(nums, i, n);
	}
	//  build heap of a tree, root is i, length is n
	//  from top to down 
	
	
	public void buildHeap(int[] nums, int i, int n){
		
		int f = i;
		int c = f*2+1;
		int temp ;
		while(c < n){
			temp = nums[f];
			
			if(c + 1 < n && nums[c+1] > nums[c])
				c++;
			if(nums[c] < nums[f])   // cut-off
				break;
			
			nums[f] = nums[c];
			nums[c] = temp;
			f = c;
			c = f*2+1;
		}
			
	}
	public int JumpFloorII(int target) {
        int[] jump = new int[target+1];
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        
        jump[0] = 1;
        jump[1] = 1;
        jump[2] = 2;
        
        for(int i = 3; i < target+1; i++){
            for(int j = 0; j < i; j++){
                jump[i] = jump[i] + jump[j];
                System.out.print(jump[i]+" ");
            }
            System.out.println(jump[i]);
        }
        return jump[target];
    }
	public static void main(String[] args){
		Sorting mysort = new Sorting();
		int[] nums = {32,61,11,54,62,86,134,0,-1,14,59};
		mysort.quickSort(nums);
		//mysort.bubbleSort(nums);
		//mysort.selectionSort(nums);
		//mysort.insertionSort(nums, 0, 6);
		//mysort.mergeSort(nums, 0, 6);
		//mysort.heapSort(nums);
		Set<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		//System.out.println(mysort.JumpFloorII(4));
	}
}
