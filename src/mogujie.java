import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class mogujie {
	 public static boolean stable(int [] a){
		 boolean res = false;
		 int len = a.length;
		 if(len < 1)
			 return false;
		 if(len == 1 || (len == 2&& a[0] == a[1]))
			 return true;
		 else{
			 int max = a[0];
			 for(int i = 0; i < len; i++)
				 if(a[i] > max)
					 max = a[i];
			 int count = 0;
			 for(int i = 0; i < len; i++)
				 if(a[i] == max)
					 count++;
			 if(count > len/2.0)
				 return true;
			 else
				 return false;
				 
		 }
			 
		 
	 }
	 // sort by the selected elem : first length, second cost
	 public static void sortTuple(int[][] x,int th){
			int n = x.length;
			if(th == 0)
			{
				for(int i = n - 1; i > 0; i--)
				{
					int tp1=0;
					int tp2=0;
					for(int j = 0; j < i;j++)
					{
						if(x[j+1][0] < x[j][0])
						{
							tp1 = x[j+1][0];
							tp2 = x[j+1][1];
							x[j+1][0] = x[j][0];
							x[j+1][1] = x[j][1];
							x[j][0] = tp1;
							x[j][1] = tp2;
						}
					}
				}
			}
			else if(th == 1){
				for(int i = n - 1; i > 0; i--)
				{
					int tp1=0;
					int tp2=0;
					for(int j = 0; j < i;j++)
					{
						if(x[j+1][1] < x[j][1])
						{
							tp1 = x[j+1][0];
							tp2 = x[j+1][1];
							x[j+1][0] = x[j][0];
							x[j+1][1] = x[j][1];
							x[j][0] = tp1;
							x[j][1] = tp2;
						}
					}
				}
			}
		}
	 public static int calculate(int[][] legs, List<Integer> l){
		 int res = 0;
		 for(int i = 0, j = 0; i < l.size(); i ++){
			 if(legs[j][0] == l.get(i))
			 {
				 res += legs[j][1];
				 j++;
			 }
			 else
				 j++;
			 
		 }
		 return res;
	 }
	 public static int[] minus(int[] origin, List<Integer> l){
		 if(l.size() == 0)
			 return origin;
		 else{
		 int len = origin.length - l.size();
		 int[] n = new int[len];
		 int i = 0,j = 0, k = 0;
		 for(; j < l.size() && k < len;i++)
		 {
			 if( origin[i] != l.get(j))
			 {
				 n[k] = origin[i];
				 k++;
				 
			 }
			 else{
				 j++;
			 }
			 
		 }
		 for(;k<len; k++)
			 n[k] = origin[i+k];
		 return n;
		 }
			 
	 }
	 public static void main(String[] args) {
	     
		 Scanner in = new Scanner(System.in);
	        while(in.hasNext()){
	        	int n = in.nextInt();
	        
	       		int[][] legs = new int[n][2];
	       		int[] legSet = new int[n];
	       		List<Integer> myleg = new ArrayList<Integer>();
	       		
	        	for(int i = 0; i < n; i++)
	        	{
	        		legs[i][0] = in.nextInt(); //leglength

	        		legs[i][1] = in.nextInt();  // cost
	        	}
	        	
	        	sortTuple(legs,1);
	        	for(int ix = 0; ix < n; ix++)
	        		legSet[ix] = legs[ix][0];
	        	int cost = 0;
	        	//for(int l = 0; l < n - 1; l ++)  // how many legs we remove
	        	//{
	        		int k = 0;
	        		List<Integer> temp = new ArrayList<Integer>();
	        		List<List<Integer>> all_possible_rm = new ArrayList<List<Integer>>();
	        		all_possible_rm.add(temp);
	        		
	        		for(int skip = k; skip <= n - 1; skip ++)  // how many legs we can select to remove
					{
	        			List<Integer> tmp = new ArrayList<Integer>();
	        			tmp.add(legs[skip][0]);
	        			all_possible_rm.add(tmp);
        			}
	        		
	        		while(k < n)   //remove from which leg
	        		{
	        			temp = all_possible_rm.remove(0);
	        			int[] test = minus(legSet, temp);
	        			
	        			if(stable(test) ==  true)
        				{
	        				cost = calculate(legs,temp);
	        				System.out.println(cost);
	        				for(int i : test)
	        					System.out.print(i +" ");
	        				return;
	        			}
	        			else
	        			{
	        				//int size = all_possible_rm.size();
	        				int j = 0;
	        				while(j < n)
	        				{
	        					temp = all_possible_rm.remove(0);
	        					for(int skip = k; skip <= n - 1; skip ++)  // how many legs we can select to remove
	        					{
	        						List<Integer> tmp = new ArrayList<Integer>();
	        	        			//tmp = temp.add(legs[skip][0]);
	        	        			//all_possible_rm.add(tmp);
			        			}
	        					
	        					j++;
	        				}
		        			
	        				
	        				cost = 0;
	        			}
	        		
	        		}
	        		
	        }
	        //}
	     in.close();
	     
		 
	     Queue<Integer> q = new LinkedList<Integer>();
	     Stack<Integer> s = new Stack<Integer>();
	     String a = "cad";
	     a.toCharArray();
	 }
}
