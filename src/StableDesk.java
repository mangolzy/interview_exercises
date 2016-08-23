import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StableDesk {
	static // input length-cost pair
	
	boolean flag = false;
	// sort by length
	public void sortByLen(int[][] legs){
		int n = legs.length;
		for(int i = n - 1; i > 0; i--)
		{
			int tp1=0;
			int tp2=0;
			for(int j = 0; j < i;j++)
			{
				if(legs[j+1][0] > legs[j][0])
				{
					tp1 = legs[j+1][0];
					tp2 = legs[j+1][1];
					legs[j+1][0] = legs[j][0];
					legs[j+1][1] = legs[j][1];
					legs[j][0] = tp1;
					legs[j][1] = tp2;
				}
			}
		}
	}
	// sort by cost
	public void sortByCost(int[][] legs, int n){
		//int n = legs.length;
		for(int i = n - 1; i >= 0; i--)
		{
			int tp1=0;
			int tp2=0;
			for(int j = 0; j < i;j++)
			{
				if(legs[j+1][1] < legs[j][1])
				{
					tp1 = legs[j+1][0];
					tp2 = legs[j+1][1];
					legs[j+1][0] = legs[j][0];
					legs[j+1][1] = legs[j][1];
					legs[j][0] = tp1;
					legs[j][1] = tp2;
				}
			}
		}
	}
	// calculate cost if we remove all the longest legs
	public int removeCost(int[][] legs){
		//sortByLen(legs);
		int longest = legs[0][0];
		int rmcost = 0;
		for(int i = 0; i < legs.length; i++){
			if(legs[i][0] == longest)
				rmcost += legs[i][1];
		}
		
		return rmcost;
	}
	
	// calculate cost if we maintain the longest legs but make the more than half
	// so we have to remove n - m + 1 legs; with least cost
	
	public int maintainCost(int[][] legs, int needToBeRm){
		int cost = 0;
		//sortByCost(legs);
		for(int i = 0; i < needToBeRm; i++)
			cost += legs[i][1];
		return cost;
	}
	
	// check
	public boolean check(int[] lens){
		int len = lens.length;
		if(len < 1)
			return false;
		if(len == 1 || (len == 2 && lens[0] == lens[1]))
			return true;
		else{
			 int max = lens[0];
			 for(int i = 0; i < len; i++)
				 if(lens[i] > max)
					 max = lens[i];
			 int count = 0;
			 for(int i = 0; i < len; i++)
				 if(lens[i] == max)
					 count++;
			 if(count > len/2.0)
				 return true;
			 else
				 return false;
				 
		 }
	}
	
	
	public static void main(String[] args){
			
			Scanner in = new Scanner(System.in);
			StableDesk sd = new StableDesk();
	        while(in.hasNext()){
	        	int n = in.nextInt();
	        
	       		int[][] legs = new int[n][2];
	       		int[] lens = new int[n];
	       		int[][] rest = legs;
	       		//List<Integer> myleg = new ArrayList<Integer>();
	       		
	        	for(int i = 0; i < n; i++)
	        	{
	        		legs[i][0] = in.nextInt(); //leglength
	        		lens[i] = legs[i][0];
	        		legs[i][1] = in.nextInt();  // cost
	        	}
	        	int minCost = Integer.MAX_VALUE;
	        	int rmcost = 0;
	        	int mtcost = 0;
	        	int tmp;
	        	sd.sortByLen(legs);
	        	int acc = 0;
	        	int len = n;
	        	while(true){
	        		int m = 0;
	        		int longest = rest[0][0];
	        		for(int i = 0; i < n; i++)
	        			if(rest[i][0] == longest)
	        				m++;
	        			else
	        				break;
	        		if(m * 2 > n){
	 	        		minCost = rmcost < minCost?rmcost:minCost;
	 	        		break;
	 	        	}else{
	 	        		tmp = rmcost;
	 	        		rmcost = sd.removeCost(legs);
	 	        		acc += m;
	 	        		System.arraycopy(legs, acc, rest, 0,len-acc);  // will raise bug.. because we don't do the removement clearly ... 
	 	        													   // maybe we can change the sort range to ignore the elements left behind??
	 	        		sd.sortByCost(rest,len-acc);
	 	        		mtcost =sd.maintainCost(rest, n-2*m+1);
	 	        		n -= m;
	 	        		rmcost += tmp;
	 	        		mtcost += tmp;
	 	        		if(mtcost < minCost)
	 	        			minCost = mtcost;
	 	        		
	 	        	}	
	 	        		
	 	        }
	        	System.out.println(minCost);
	        }
	        
	       
	}
}
