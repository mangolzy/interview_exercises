package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {

	
	/**
	 * Definition for singly-linked list.
	 * */
	/*
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	  private int start = 0;
	    private int end = 0;
	    private int max = 0;
	    public String longestPalindrome(String s) {
	        int len = s.length();
	        if(len == 0 || len == 1)
	            return s;
	        else
	        {
	            for(int i = 0; i < s.length(); i++)
	            {
	                constructPalindrome(s,i,i);
	                constructPalindrome(s,i,i+1);
	            }
	            return s.substring(start, end);//(start,end);
	            
	        }
	    }
	    public void constructPalindrome(String s, int m, int n){
	        while(m>0&&n<s.length()&&(s.charAt(m) == s.charAt(n)))
	        {
	            m--;
	            n++;
	        }
	        if(max < n - m - 1)
	        {
	            max = n - m - 1;
	            start = m + 1;
	            end = n - 1;
	        }
	    }
	
	    */
	    /*	    
	    public int lengthOfLongestSubstring(String s) {
	        int i;
	        String sub = "";
	        String res = "";
	        int longest = 0;
	        if(!s.isEmpty())
	        	longest = 1;
	        HashMap<String,Integer> hm = new HashMap<String,Integer>();
	        for(i = 0; i < s.length(); i++)
	        {
	             String key = s.charAt(i)+"";
	            //char next = s[i+1];
	            
	            if(hm.containsKey(key))
	            {
	                if(hm.size() > longest)
	                {
	                    longest = hm.size();
	                    res = sub;
	                }
	                hm.clear();
	            }
	            else 
	            {
	                hm.put(key,1);
	                sub += s.charAt(i);
	            }
	            
	        }
	        return longest;
	    }
	    
	    public int myAtoi(String str) {
	        int res = 0;
	        char c;
	        //str = str.trim();
	        String[] s = str.replaceAll("[\s+]", " ");
	        str = str.split(" ")[0];
	        if(str.isEmpty())
	            return res;
	        else
	            for(int i = 0; i < str.length(); i++)
	            {
	            	c = str.charAt(i);
	                switch(c)
	                {
	                    case '0': res += res * 10 + 0;break;
	                    case '1': res += res * 10 + 1;break;
	                    case '2': res += res * 10 + 2;break;
	                    case '3': res += res * 10 + 3;break;
	                    case '4': res += res * 10 + 4;break;
	                    case '5': res += res * 10 + 5;break;
	                    case '6': res += res * 10 + 6;break;
	                    case '7': res += res * 10 + 7;break;
	                    case '8': res += res * 10 + 8;break;
	                    case '9': res += res * 10 + 9;break;
	                    default: res = 0;break;
	                }
	            }
	            if(res > Integer.MAX_VALUE)
	                res = 2147483647;
	            else if(res < Integer.MIN_VALUE)
	                res = -2147483648;
	        return res;
	    }
	    
	    public void moveZeroes(int[] nums) {
	        int i;
	        for(i = 0; i < nums.length; i++)
	        {
	            if(nums[i] == 0)
	            {
	               nums[i] = nums[i+1];
	               nums[i+1] = 0;
	               continue;
	            }
	        }
	    }
	  
	 public static int lengthOfLongestSubstring(String s) {
	  
		 if(s.isEmpty())
		       return 0;
		  if(s.length() == 1)
		       return 1;
		       
		      else{
			      char current; 
			      int max = 0;
			      int dup = 0;
			      int bestStart = 0;
			      for(int i = 0; i < s.length(); i++)
		          {

		               current = s.charAt(i);
		               for(dup = bestStart; dup < i; dup++)
		               {
		            	   if(current == s.charAt(dup))
		            	   {    	   
			                   break;
			               }
		               }
		              
		               if(dup < i)
		               {   
		            	
		            	   bestStart = dup + 1;
		            	  
		               }
		              
		               if(max < i - bestStart + 1)
	                   {
	                             max = i - bestStart + 1;    
	                   }
		               
		               
		          } 
		          return max;
		      }
	 }
	public static int myAtoi(String str) {
        long res = 0;
        char c;
        int i;
        int flag = 0;
        int count = 0;
        int flag2 = 0;
        int sign = 1;
        //str = str.trim();
        //String[] s = str.replace("\s"," ");
        //str = s.split(" ")[0];
        if(str.isEmpty())
            return (int) (res);
        else
        {
            str = str.split(" ")[0];
            str = str.trim();
            c = str.charAt(0);
            if(c == '+')
                sign = 1;
            else if(c == '-')
                sign = -1;
            else if(c >= '0' && c <= '9')
                res = c - '0';
            else
                return 0;
            for(i = 1; i < str.length(); i++)
	        {
	            c = str.charAt(i);
	            if((c < '0' || c > '9'))
	            {
	            	 res = res * sign;
	                 if(res > 	Integer.MAX_VALUE)
	                     res = 2147483647;
	                 else if(res < Integer.MIN_VALUE)
	                     res = -2147483648;
	                 return (int) (res);
	            }
	            else
	            {
	            	res = res * 10 + c - '0';
	            	System.out.println(i+":"+res);
	            }
            }
            res = res * sign;
            if(res > Integer.MAX_VALUE)
                res = 2147483647;
            else if(res < Integer.MIN_VALUE)
                res = -2147483648;
            return (int) (res);
            
        }
	}*/ 
	/*
	 public static int[] sort(int[] nums)
     {
         for(int i = nums.length - 1; i >= 0; i --)
         {
             //int max = nums[i];
             int k = 0;
             for(int j = 0; j < i; j ++)
             {
                 if(nums[j] >= nums[i])
                 {
                	 // = nums[j];
                     k = nums[i];
                     nums[i] = nums[j];
                     nums[j] = k;
                     
                 }
             }
         }
         return nums;
     }
	public List<List<Integer>> threeSum(int[] nums) {
       
        if(nums.length < 3)
            return null;
        
        int[] sorted = sort(nums);
        //List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < sorted.length; i ++)
        {
            for(int j = i; j < sorted.length; j ++)
            {
                for(int k = j; k < sorted.length; k ++)
                    if((sorted[i] + sorted[j] + sorted[k]) == 0)
                    {
                    	List<Integer> temp = new ArrayList<Integer>();
                    	temp.add(sorted[i]);
                    	temp.add(sorted[j]);
                    	temp.add(sorted[k]);
                    	if(!res.contains(temp))
                    		res.add(temp);
                    }
            }
        }
        return res;
        
    }
    
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minErr = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            else
            {
                target = target - nums[i];
                int low = i;
                int high = nums.length - 1;
                
                
                while(low < high)
                {
                    if(Math.abs(nums[low] + nums[high] - target) < minErr)
                    {
                        minErr = Math.abs(nums[low] + nums[high] - target);
                        res = nums[i] + nums[low] + nums[high];
                        while(low < high && nums[low] == nums[low+1])
                            low++;
                        while(low < high && nums[high] == nums[high-1])
                            high--;
                        low++;
                        high--;
                    }
                    if(nums[low] + nums[high] < target)
                    {
                       // while(low < high && nums[low] == nums[low+1])
                         //   low++;
                        low ++;
                    }
                        
                    else if(nums[low] + nums[high] > target)
                    {
                       // while(low < high && nums[high] == nums[high-1])
                         //   high--;
                        high --;
                    }
                    else
                       return nums[i] + nums[low] + nums[high];
                }
            }
        }
        return res;
    }
    
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minErr = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            else
            {
                int tar = target - nums[i];
                int low = i+1;
                int high = nums.length - 1;
                while(low < high)
                {
                  
                    if(nums[low] + nums[high] > tar)  //  sum > target
                    {
                         if((nums[low] + nums[high] + nums[i] - target) < minErr)
                         {
                                minErr = nums[i] + nums[low] + nums[high] - target;
                                res = nums[i] + nums[low] + nums[high];          
                         }
                         while(low < high && nums[high] == nums[high-1])
                             high--;
                         high--;
                    }
                        
                    else if(nums[low] + nums[high] < tar)  // sum < target
                    {
                         if(tar - (nums[low] + nums[high]) < minErr)
                         {
                            minErr = tar - (nums[low] + nums[high]) ;
                            res = nums[i] + nums[low] + nums[high];
                         }
                         while(low < high && nums[low] == nums[low+1])
                             low++;
                         low++;
                    }
                    else
                       return nums[i] + nums[low] + nums[high];
                }
            }
        }
        return res;
    }
    */
	public static List<List<Integer>> twoSum(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        while(low < high)
        {
            if(nums[low] + nums[high] == target)
            {
                res.add(Arrays.asList(nums[low],nums[high]));
                low ++;
            }
            else if(low < high && nums[low] + nums[high] < target)
                low ++;
            else if(low < high && nums[low] + nums[high] > target)
                high --;
        }
        return res;
    }
	/*
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // we got a hashtable of all the possible values of pair adding of the original array element 
        // key:  sum2 , possible pair value list (nums[i], nums[j])   ->  n2
        // use TwoSum algo to solve the problem on the hashtable: input -> keyset, output which two ..
        
        List<List<Integer>> myList = new LinkedList<List<Integer>>();
        HashMap<Integer,List<List<Integer>>> pair = new HashMap<Integer,List<List<Integer>>>();
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
        int size = pair.size();
        int[] sum = new int[size];
        int i = 0;
        for(int key : pair.keySet())
        {    
            sum[i] = key;
            i++;
        }
        System.out.println("before");
        List<List<Integer>> possible = twoSum(sum,target);
        System.out.println("find possible");
        for(List<Integer> l : possible)
        {
            int a = l.get(0);
            int b = l.get(1);
            List<List<Integer>> aa = pair.get(a);
            List<List<Integer>> bb = pair.get(b);
            for(List<Integer> aaa : aa)
            {
            	
                for(List<Integer> bbb : bb)
                {
                	//myList.add(aaa.addAll(bbb));
                    Integer[] ab = {aaa.get(0),aaa.get(1),bbb.get(0),bbb.get(1)};
                    Arrays.sort(ab);
                    if(myList.contains(Arrays.asList(ab)))
                    	;
                    else
                    	myList.add(Arrays.asList(ab));
                }
            }
        }
        
        
        

    }
    */
	/*
    List<List<Integer>> half = twoSum(nums,sum[i]);
    List<Integer> listNums = Arrays.asList(sum);
    listNums.remove(half);
    //int[] rest = listNums.toArray();
    LinkedList<Integer> numsList = new LinkedList<Integer>();
    int[] rest = numsList.get(index);
    int[] newnums = new int[];
    rest = nums[0:nums.length-2];
    numsList.add
    return myList;
   
    Stack<char[]> test = new Stack<char[]>();
    Stack<Character> saving = new Stack<Character>();
    Math.f
    */
	 /*
    System.out.println(n);
    
    if(n == 0)
        return 0;
    if(n % 2 == 0)
        count = 0;
    else 
        count = 1;
  
    return count + hammingWeight(n/2);
    */
	/*
    // public static void googleIO()
     
	 public static int hammingWeight(int n) {
	        int count = 0;
	        //n = n&0x0FFFFFFFF;
	       
	        while(n!=0)
	        {
	        	count = count + (n & 1);
	        	n >>>= 1;
	        }
	        return count;
	       // Stack<Integer> x = new Stack<Integer>();
	        
	        
	    }
	 */
	/*
	 public static List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> res = new ArrayList<Integer>();
	        if(matrix.length == 0)
	            return res;
	        else{
	            int row = matrix.length;
	            int col = matrix[0].length;
	            int i,j;
	            System.out.println(row + " " + col);
	           // if(col == row){
	                
	            
	            for(i = 0; i < row/2; i ++)
	            {
	                // from left to right, modify j 
	                for(j = i; j < col - i; j ++)
	                    res.add(matrix[i][j]);
	                
	                // from top to down, modify i by j 
	                for(j = i+1; j < row - 1 - i; j ++)
	                    res.add(matrix[j][row - 1 - i]);
	                
	                // from right to left, modify j by --
	                for(j = col - 1 - i; j > i; j --)
	                    res.add(matrix[col - 1 - i][j]);
	            
	                // from down to top, modify i by j --
	                for(j = row - 1 - i; j > i; j --)
	                    res.add(matrix[j][i]);
	            }
	            //the last element
	            if(row%2 == 1)
	                res.add(matrix[row/2][row/2]);
	            }
	            return res;
	          //}
	        
	 }
	 */
	public static int maxProfit(int[] prices) {
        int maxPro = 0;
        int sum = 0;
        int min = prices[0];
        int max = prices[0];
        
        for(int i = 1; i < prices.length; i ++)
        {
        	if(prices[i] < max)
            {
                min = prices[i];
                System.out.println(min);
                //maxPro = Math.max(maxPro, max - min);
            	sum += maxPro;
            	max = 0;
                min = prices[i];
            }
            if(prices[i] > min) 
            {
            	maxPro = Math.max(maxPro, prices[i] - min);
                max = prices[i];
                System.out.println("max" + " " + max + "min" + " " + min);
            }
            
        }
        return sum;
    }
	public static List<String> letters(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() <= 0) {
            return res;
        }
        res.add("");
        String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz" };
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String chars = map[c - '0'];
            int size = res.size();
            int k = 0;
            while (k < size) {
                String tmp = res.remove(0);//remove the first ele
                for (int j = 0; j < chars.length(); j++) {
                    res.add(tmp + chars.charAt(j));
                }
                k++;
            }

        }
        return res;
    }
 public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if(digits.length()==0)
            return res;
        else
        {
            String[] dict = {
	        			" ",
	        			" ",
	        			"abc",
	        			"def",
	        			"ghi",
	        			"jkl",
	        			"mno",
	        			"pqrs",
	        			"tuv",
	        			"wxyz"
	        	};
	        int[] aval = {0,0,3,3,3,3,3,4,3,4};
	        int[] number = new int[digits.length()];  // the nth input is which number
	        int[] answer = new int[digits.length()];  // the nth number we choose which char
	        
	        for(int i = 0; i < digits.length(); i++)
	        {
	        	number[i] = Integer.parseInt(digits.substring(i,i+1));
	        
	        	//System.out.print(number[i]+" "+answer[i] +" ");
	        }
	        while(true){
	        	String temp = "";
		        for(int i = 0; i < digits.length(); i ++){
		            //System.out.println(dict[number[i]]);
		            temp += dict[number[i]].charAt(answer[i]);
		            	
		        }
		                
		        res.add(temp.replace(" ", ""));
	            int k = digits.length() - 1;
	            while(k >= 0)
	            {
	                if(answer[k] < aval[number[k]] - 1)
	                {
	                    answer[k]++;
	                    break;
	                }
	                else
	                {
	                    answer[k] = 0;
	                    k--;
	                }
	            }
	           
	            if(k < 0)
	                break;
	        }
	        return res;
	        
	            
	        
	        
        }
    }
	 public static void main(String[] args){
			
		 int[] test = {3,1,2,3,4,2,4};
		 
		 System.out.println(maxProfit(test));
		 
		 
		 //int[][] a = {{ 1, 2, 3 , 4, 5, 6 },{ 7, 8, 9 , 10 ,11, 12 }};//{1, 0, -1, 0, -2, 2}; //{-1, 1 ,2, -4};
		//int[][] x = {{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
		//List<Integer> b = spiralOrder(a);
		//for(Integer i : b)
			//System.out.println(i);
		 //int[] b = so	rt(a);
		 //for(int i = 0; i < b.length; i++)
			 //System.out.println(fourSum(a,0));
		 
		// File f = new File("./A-small-pratice.in");
		// BufferedReader in = new BufferedReader(new FileReader(filePath));
		 
		 
	}
}
