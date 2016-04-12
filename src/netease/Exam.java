package netease;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Exam {
	
	// sort an array of 2-element tuple according to its 1st element
	public static void sortTuple(int[][] x){
		int n = x.length;
		//int max = 0;
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

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
            int r = in.nextInt();
       		int avg = in.nextInt();
            //Map<String,Integer> course = new HashMap<String,Integer>();
       		int[][] courses = new int[n][2];
        	for(int i = 0; i < n; i++)
        	{
        		courses[i][1] = in.nextInt();  // mark
        		courses[i][0] = in.nextInt();  // avg_time
        	}
        	sortTuple(courses);
        	int target = n * avg;
        	int current = 0;
        	int need = 0;
        	for(int j = 0; j < n; j++)
        	{
        		//System.out.println(courses[j][0]);
        		current += courses[j][1];
        	}
        	int k = 0;
        	while(current < target && k < n)
        	{
        		
        		int point = target - current;
        		int get = Math.min(point, r-courses[k][1]);
        		need += get * courses[k][0];
        		
        		current += get;
        		k++;
        		
        	}
        	System.out.println(need);
            	
        	
        }
        in.close();
    }
}
