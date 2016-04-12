package microsoft;


import java.util.Scanner;

public class IslandTravel {
	

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int n = in.nextInt();
        	int[][] islands = new int[n][2];
        	for(int i = 0; i < n; i ++)
        	{
        		islands[i][0] = in.nextInt();
        		islands[i][1] = in.nextInt();
        	}
        	int[][] graph = new int[n][n];
        	int x = 0;
        	int y = 0;
        	
        	//weighted adjacent matrix 
        	for(int i = 0; i < n; i ++){
        		for(int j = 0; j <= i; j ++){
        			if(i == j)
        				graph[i][j] = 0;
        			else
        			{
        				x = Math.abs(islands[i][0] - islands[j][0]);
        				y = Math.abs(islands[i][1] - islands[j][1]);
        				graph[i][j] = Math.min(x, y);
        			}
        		}	
        	}
        	
        	/* Dijstra */
        	// construct a bfs tree
        	int mincost = Integer.MAX_VALUE;
        	
        	int l = 0;
        	// we record the distance between start and each point in the graph 
        	// and we make a visited array
        	int[] dis = new int[n];
        	int[] visited = new int[n];
        	for(int i = 0; i < n; i ++)
        		dis[i] = graph[i][0];
        	
        	//initiation:
        	visited[0] = 1;
        	for(int j = 1; j < n; j++){   // define how many points are in the path to the destination
        								  
        								  // find the nearest neighbor
        		for(int k = 0; k < n; k++){
        			if(visited[k] != 1){
        				if(dis[k] < mincost){
        					mincost = dis[k];
        					l = k;
        					if(l == n)
        					{
        						System.out.println(mincost);
        						return;
        					}
        				}
        			}
        		}
        		visited[l] = 1;
        		
        		for(int m = 0; m < n; m++){
        			// cost by passing l + l->m < direct to m
        			if(mincost+graph[m][l] < dis[m] && visited[m] != 1)
        				dis[m] = mincost + graph[m][l];
        		}
        		
        	}
        	System.out.println(dis[n-1]);
        	
        }
        in.close();	
        
        
    }
}
