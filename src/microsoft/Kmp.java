package microsoft;

import java.util.ArrayList;
import java.util.Scanner;

public class Kmp {
	public static int[][] dfa_construct(char[] pat){
        int len = pat.length;
        int alphabet = 26;
        int[][] res = new int[alphabet][len];
    
        int X = 0;
        res[pat[0]-'A'][0] = 1;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < alphabet; j++)
                res[j][i] = res[j][X];
            res[pat[i]-'A'][i] = i+1;
            X = res[pat[i]-'A'][X];
        }
        return res;
        
    }
    public static int kmp(char[] ori, char[] pat){
        
        int l = ori.length;
        int m = pat.length;
        int i, j;
        int[][] dfa = dfa_construct(pat);
        int count = 0;
        for(i = 0, j = 0; i < l && j < m; i++){
            j = dfa[ori[i]-'A'][j];
            if(j == m){
                count ++;
                j = 0;
                if(ori[i] == pat[j])
                	i--;
            }
        }
        return count;
            
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        while(in.hasNext()){
            int ncase = in.nextInt();
            for(int i = 0; i < ncase; i ++){
                String pat = in.next();
                String ori = in.next();
                input.add(pat);
                input.add(ori);
 
            }
            for(int i = 0; i < ncase * 2; i += 2){
                String pat = input.get(i);
                String ori = input.get(i+1);
                char[] p = pat.toCharArray();
                char[] o = ori.toCharArray();
                
                System.out.println(kmp(o,p));
 
            }
            
        }
    }
}
