package indeed;

import java.util.Scanner;

public class UpdateShortestPath {
/*
	public static int shortestPath(int[][] graph, int s, int d){
		
    	
	}
	*/
	int[][] graph;
	public static void updateGraph(int[][] graph,int s, int d ){
int mincost = Integer.MAX_VALUE;
    	
		int n = graph.length;
    	int l = 0;
    	// we record the distance between start and each point in the graph 
    	// and we make a visited array
    	int[] dis = new int[n];
    	int[] visited = new int[n];
    	for(int i = 0; i < n; i ++)
    		dis[i] = graph[s][i];
    	
    	//initiation:
    	visited[s] = 1;
    	int flag = 0;
    	for(int j = 1; j < n; j++){   // define how many points are in the path to the destination
    								  
    								  // find the nearest neighbor
    		for(int k = 0; k < n; k++){
    			if(visited[k] != 1){
    				if(dis[k] < mincost){
    					mincost = dis[k];
    					l = k;
    					if(l == d)
    					{
    						flag = 1;
    						break;
    						//return  mincost;
    					}
    				}
    			}
    			if(flag == 1)
    				break;
    		}
    		visited[l] = 1;
    		
    		for(int m = 0; m < n; m++){
    			// cost by passing l + l->m < direct to m
    			if(mincost+graph[m][l] < dis[m] && visited[m] != 1)
    				dis[m] = mincost + graph[m][l];
    		}
    		
    	}
    	graph[s][d] = dis[d];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		UpdateShortestPath main = new UpdateShortestPath();
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			main.graph = new int[m][m];
			int x = 1;
			int i, j;
			for(i = 0; i < m-1; i ++){
				x = 1;
				for(j = i+1; j < m; j++)
				{
					main.graph[i][j] = x;
					x++;
				}
			}
				
			for(int k = 0; k < n; k ++){
				int s = in.nextInt();
				int d = in.nextInt();
				int dis = main.graph[s-1][d-1];//shortestPath(graph, s, p);
				if(dis == 0){
					System.out.println(-1);
					main.graph[s-1][d-1] = 1;
					updateGraph(main.graph, s-1, d-1);
				}
				else
					System.out.println(dis);
				
			}
		}

	}

}
