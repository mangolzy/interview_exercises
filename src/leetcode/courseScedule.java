package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class courseScedule {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        // we suppose to begin with the independent node... if it didn't exist.. no possible result, right?
        int[] dep = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            order[i] = i;
        if(prerequisites == null || prerequisites.length == 0)
            return order;
            
        // we construct the graph as usual;
        Map<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < prerequisites.length; i++){
            if(!graph.containsKey(prerequisites[i][1])){
                ArrayList<Integer> adj = new ArrayList<Integer>();
                adj.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1],adj);
            }
            else{
                ArrayList<Integer> new_adj = graph.get(prerequisites[i][1]);
                new_adj.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1],new_adj);
            }
            dep[prerequisites[i][0]] = 1;
        }
        // check if it's a circle
        int count = 0;
        int start = 0;
        for(; start < numCourses; start++){
            if(dep[start] == 1)
                count++;
            else
                break;
        }
        if(count == numCourses);
            //return ;
            
        // we find the path begin with start... but it forms some dependance, maybe not all courses are covered, so normally we need a visited array...?
        int[] visited = new int[numCourses];
        visited[start] = 1;
        
        Stack<Integer> stack = new Stack();
        stack.push(start);
        order[0] = start;
        //while(visited[])
        while(!stack.isEmpty()){
            if(graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()){
                
            }
        }
        // philosophy
        String s = "asfbsf";
        String a = s.substring(3);
       // List<String> str = new LinkedList<String>();
        
        return order;
        
            
    }
}
