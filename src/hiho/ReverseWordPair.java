package hiho;

import java.util.HashSet;
import java.util.Scanner;



class Tritree {
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
	public int contains(String s){
		TrieNode node = root;
		char[] each = s.toCharArray();
    	int k = 0;
    	for(k = each.length - 1; k >= 0; k--){
			int nth = each[k] - 'a';
			if(node.son[nth] != null){
				node = node.son[nth];
			}
			else{
				break;
			}
		}
    	if(k < 0)
    		return 1;
    	else 
    		return 0;
	}
}
public class ReverseWordPair {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        
        int N = 0;
        int count = 0;
        N = in.nextInt();
        
        HashSet<String> set = new HashSet<String>();
        while(N-- > 0){
        	String s = in.next();
        	if(set.contains(s))
        		count ++;
        	else
        	  set.add(new StringBuilder(s).reverse().toString());
        }
        System.out.println(count);
        /*
        // 1. construct a tritree and then reverse check
        // 2. use the redix sort ?
        Tritree tri = new Tritree();
        int count = 0;
        String[] dict = null;
        while (in.hasNext()){
            
            N = in.nextInt();
           
            dict = new String[N];
            for(int i = 0; i < N; i++){
            	dict[i] = in.next();
            	tri.insert(dict[i]);
            }
           
            for(int j = 0; j < N; j++){
            	
            	count += tri.contains(dict[j]);
            }
            System.out.println(count/2);
            
        }
        in.close();
       */
	}
}
