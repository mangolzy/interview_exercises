package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
	        TreeNode(int x) { val = x; }
	}
	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        levelHelper(res,root,0);
	        return res;
	        
	    }
	    public void levelHelper(List<List<Integer>> cur, TreeNode t, int height){
	        if(t == null)
	            return;
	        if(height >= cur.size())
	        {
	            cur.add(new ArrayList<Integer>());
	        }
	        else
	        {
	            cur.get(height).add(t.val);
	            levelHelper(cur,t.left,height+1);
	            levelHelper(cur,t.right,height+1);
	        }
	    }
	}
	public static void main(String[] args){
		for(int x = 3,y = 0;x > y; x--, y++)
			System.out.println(x+" "+y+" ");
	}
}
