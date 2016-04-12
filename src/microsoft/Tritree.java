package microsoft;

import java.util.Scanner;



public class Tritree {
	int SIZE = 26;
	TrieNode root;
	class TrieNode {
	    int count;
	    char val;
	    int isEnd;
	    TrieNode[] son;
        TrieNode() { 
        	
        	count = 1;
        	son = new TrieNode[SIZE];
        	isEnd = 0;
        	
        }
        TrieNode(char x) { 
        	val = x;
        	count = 1;
        	son = new TrieNode[SIZE];
        	isEnd = 0;
        	
        }
    }
	Tritree(){
		root = new TrieNode();
	}
	public void insert(String s){
		if(s == null||s.length() == 0)
			return;
		else{
			TrieNode node = root;
			char[] chars = s.toCharArray();
			for(int i = 0; i < s.length(); i++){
				int nth = chars[i] - 'a';
				if(node.son[nth] == null){
					node.son[nth] = new TrieNode(chars[i]);
				}else{
					node.son[nth].count ++;
				}
				node = node.son[nth];
			}
			node.isEnd = 1;
		}
	}
	public int count(String q){
		if(q == null || q.length() == 0)
			return -1;
		else{
			TrieNode node = root;
			char[] chars = q.toCharArray();
			int i = 0;
			for(;i<q.length();i++){
				int nth = chars[i] - 'a';
				if(node.son[nth] != null){
					node = node.son[nth];
				}
				else{
					break;
				}
			}
			if(i == q.length())
				return node.count;
			else
				return 0;
		}
	}
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			Tritree t = new Tritree();
			for(int i = 0; i < n; i ++){
				String s = in.next();
				t.insert(s);
			}
			
			int m = in.nextInt();
			for(int j = 0; j < m; j ++){
				String q = in.next();
				int c = t.count(q);
				System.out.println(c);
			}
		}
		in.close();
	}
	
	
}
