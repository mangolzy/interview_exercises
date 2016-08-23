package netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import netease.Xiaoyi2.Step;

public class Chongkao3 {
	public static void main(String[] args){
        
        
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext()){
        	int n = in.nextInt();
        	int[] nums = new int[n];
        	//int count  = 0;
        	for(int i = 0; i < n; i++){
        		nums[i] = in.nextInt();
        	}
        	int[] max = new int[100000+1];
        	Arrays.sort(nums);
        	//for(int j = 1; j < max.length; j++){
        	if(nums[0] > 1)
        		System.out.println(1);
        		
        	
        	//}
        	ArrayList<ArrayList<Integer>> res = subsetSum(nums);
        	Queue<Integer> temp = new LinkedList<Integer>();
        	for(int i = 0; i < nums.length; i++)
        		temp.add(nums[i]);
        	//  1 1 2 7 
        	//  127 127 117 112
        	while(!temp.isEmpty()){
        		//sum 
        	}
        	int current = 1;
        	for(List<Integer> l: res){
        		int sum = 0;
        		for(int x: l)
        			sum += x;
        		if(sum != current)
        			System.out.println(current);
        		current ++;
        	}
        	
        }
	}
	
	
	
	public static ArrayList<ArrayList<Integer>> subsetSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num,int x, ArrayList<ArrayList<Integer>> returnList) {
		
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			while(i > 0 && num[i-1] == num[i])
				i++;
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}
	 
		return returnList;
	}
}
