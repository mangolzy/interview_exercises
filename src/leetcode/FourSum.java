package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TwoInt{
	int a=0;
	int b=0;
	TwoInt(int x, int y){
		a = x;
		b = y;
	}
	boolean equals(TwoInt q){
		if((q.a == this.a && q.b == this.b) || (q.b == this.a && q.a == this.b))
			return true;
		else return false;
	}
}
class FourInt{
	int a=0;
	int b=0;
	int c=0;
	int d=0;
	
	FourInt(int x, int y, int z, int p){
		a = x;
		b = y;
		c = z;
		d = p;
	}
	boolean equals(FourInt q){
		
		if((q.a == this.a && q.b == this.b && q.c == this.c && q.d == this.d)
				|| (q.a == this.a && q.b == this.b && q.d == this.c && q.c == this.d)
				|| (q.a == this.a && q.b == this.b && q.c == this.c && q.d == this.d)
				)
			return true;
		else return false;
	}
}


public class FourSum {


/*
O(N^3LogN)的算法：
三重for循环穷举a,b,c的值，剩下d = sum-a-b-c,使用二分查找(数组事先排好序)来确定d是否存在。

O(N^2LogN)的算法：
预先枚举c,d得到c+d的n^2个数字并排好序。
双重for循环穷举a,b的值，再使用二分查找确定c+d是否存在。
c+d的值得出来后同样枚举得出c,d的值。（或者在第一步就浪费一些空间将c+d对应的c,d存好，此时直接取出即可。)

排序及循环二分查找都为O(n^2logn)时间，总的O(n^2logn)时间。
*/
	
	
    public static List<TwoInt> twoSum(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        List<TwoInt> res = new LinkedList<TwoInt>();
        Arrays.sort(nums);
        while(low < high)
        {
            if(nums[low] + nums[high] == target)
            {
                res.add(new TwoInt(nums[low],nums[high]));
                low ++;
            }
            else if(low < high && nums[low] + nums[high] < target)
                low ++;
            else if(low < high && nums[low] + nums[high] > target)
                high --;
        }
        return res;
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // we got a hashtable of all the possible values of pair adding of the original array element 
        // key:  sum2 , possible pair value list (nums[i], nums[j])   ->  n2
        // use TwoSum algo to solve the problem on the hashtable: input -> keyset, output which two ..
        
       List<List<Integer>> myList = new LinkedList<List<Integer>>();
       Map<Integer,List<TwoInt>> pair = new TreeMap<Integer,List<TwoInt>>();
       // List<Integer> sumList = new LinkedList<Integer>();
        for(int i = 0; i < nums.length - 1; i ++)
        {
            for(int j = i + 1; j < nums.length; j ++)
            {
                int key = nums[i] + nums[j];
                
                if(pair.containsKey(key))
                {
                    List<TwoInt> elem = pair.get(key);
                    TwoInt ti = new TwoInt(nums[i],nums[j]);
                    if(!elem.contains(ti))
                    {
                    	elem.add(ti);
                    	pair.put(key,elem);
                    }
                }
                else
                {
                    List<TwoInt> elem = new LinkedList<TwoInt>();
                    elem.add(new TwoInt(nums[i],nums[j]));
                    pair.put(key,elem);
                }
                
          
            }
        }
     
        //Arrays.sort(nums);
        //for(int k = 0; k < sum.length; k ++)
        List<TwoInt> half = new LinkedList<TwoInt>();
        
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        for(int k : pair.keySet())
        {
            
           
            for(TwoInt ah : pair.get(k))
            {
            	int i = 0;
            	int temp = 0;
                while(i++ < nums.length-1)
                {	
                	if(nums[i] == ah.a)
                	{
                		temp = nums[nums.length-1];
                		nums[nums.length-1] = nums[i];
                		nums[i] = temp;
                		break;
                	}
                }
                i = 0;
                while(i++ < nums.length-2)
                {	
                	if(nums[i] == ah.b)
                	{
                		temp = nums[nums.length-2];
                		nums[nums.length-2] = nums[i];
                		nums[i] = temp;
                		break;
                	}
                }
                int[] newnums = new int[nums.length - 2];
               
                System.arraycopy(nums, 0, newnums, 0, nums.length - 2);
                half = twoSum(newnums,target-k);
                		
                for(TwoInt ha : half){
                	LinkedList<Integer> solution = new LinkedList<Integer>();
                	solution.add(ha.a);
                	solution.add(ha.b);
                    solution.add(ah.a);
                    solution.add(ah.b);
                    Collections.sort(solution);
                    if(!res.contains(solution))
                        res.add(solution);
                }
                	
            }
           
        }
        for(List<Integer> l : res)
        	myList.add(l);
        return myList;
        
        
    }
    public static void main(String[] args){
    	List<List<Integer>> t = new LinkedList<List<Integer>>();
    	int[] a = {1, 0, -1, 0, -2, 2};
    	t = fourSum(a, 0);
    	for(List<Integer> x : t){
    		for(int b : x)
    			System.out.print(b+" ");
    		System.out.println();
    	}
    	
    }
}


/*
public List<List<Integer>> fourSum(int[] nums, int target) {
// we got a hashtable of all the possible values of pair adding of the original array element 
// key:  sum2 , possible pair value list (nums[i], nums[j])   ->  n2
// use TwoSum algo to solve the problem on the hashtable: input -> keyset, output which two ..

List<List<Integer>> myList = new LinkedList<List<Integer>>();
Map<Integer,List<List<Integer>>> pair = new TreeMap<Integer,List<List<Integer>>>();
// List<Integer> sumList = new LinkedList<Integer>();
for(int i = 0; i < nums.length - 1; i ++)
{
    for(int j = i + 1; j < nums.length; j ++)
    {
        int key = nums[i] + nums[j];
        
        if(pair.containsKey(key))
        {
            List<List<Integer>> elem = pair.get(key);
            elem.add(Arrays.asList(nums[i],nums[j]));
            pair.put(key,elem);
        }
        else
        {
            List<List<Integer>> elem = new LinkedList<List<Integer>>();
            elem.add(Arrays.asList(nums[i],nums[j]));
            pair.put(key,elem);
        }
        
        
    }
}

//Arrays.sort(nums);
//for(int k = 0; k < sum.length; k ++)
List<List<Integer>> half = new LinkedList<List<Integer>>();
List<List<Integer>> another_half = new LinkedList<List<Integer>>();
Set<List<Integer>> res = new HashSet<List<Integer>>();
for(int k : pair.keySet())
{
    
  
    half = twoSum(nums,k);
    
    int[] rest = new int[nums.length - 2];
    for(LinkedList<Integer> ah : k.values())
    {
        LinkedList<Integer> solution = new LinkedList<Integer>();
        solution.addAll(half);
        solution.addAll(ah);
        if(!res.contains(solution))
            res.add(solution);
    }
   // int count = 0;
    //int first = 0;
    //int second = 0;
    
    for(List<Integer> l : half)
    {
       
        LinkedList<Integer> numsList = new LinkedList<Integer>();
        for(int j = 0; j < nums.length; j ++)
            numsList.add(nums[j]);
       
        numsList.remove(l.get(0));
        numsList.remove(l.get(1));
        
       // int[] newnums = new int[nums.length - 2];
        for(int m = 0; m < numsList.size(); m++)
            rest[m] = numsList.get(m);
        //System.arraycopy(newnums, 0, rest, 0, nums.length - 2);
        
        another_half = twoSum(rest,target - k);
        
        for(List<Integer> bbb : another_half)
        {
           
            Integer[] ab = {l.get(0),l.get(1),bbb.get(0),bbb.get(1)};
            Arrays.sort(ab);
            if(myList.contains(Arrays.asList(ab)))
                ;
            else
                myList.add(Arrays.asList(ab));
        }

    }
}

return myList;


}
*/