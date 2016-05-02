package microsoft;

import java.util.Scanner;

public class kmp_ {
	

		public void cal_next(int[] next,String p_string)
		{
			// next : = 0 -> = length()
		    for(int i = 1; i < p_string.length();i ++){
		        int q = i;
		        while(q > 0){
		           q = next[q];
		           if(p_string.charAt(i)==p_string.charAt(q)){
		               next[i+1]=q+1;
		               break;
		           }
		        }
		    }
		}
		//p_string 模式串
		//m_string 目标串
		// q pointer to pattern
		// p pointer to target
		public int cal_num(int p,int q,int times,String p_string,String m_string,int[] next){
		    while(q < p_string.length() && p < m_string.length()){
		        if(q == -1 || p_string.charAt(q)==m_string.charAt(p)){
		            p++;
		            q++;
		        }else{
		            q=next[q];
		        }
		    }
		    if(q >= p_string.length()){
		        times++;
		        if(p < m_string.length()){
		            p = p - p_string.length() + 1;
		            q = 0;
		            times=cal_num(p,q,times,p_string,m_string,next);
		        }

		    }
		    return times;
		}

		public static void main(String[] args){
		    Scanner scan=new Scanner(System.in);
		    int num=scan.nextInt();
		    kmp_ main=new kmp_();
		    for(int i=0;i<num;i++){
		        String p_string=scan.next();
		        String m_string=scan.next();
		        int next[]=new int[p_string.length()+1];
		        next[0]=-1;
		        main.cal_next(next,p_string);
		        for(int j = 0; j < p_string.length()+1; j++)
		        	System.out.print(next[j]+" ");
		        int p_num=main.cal_num(0,0,0,p_string,m_string,next);
		        System.out.println(p_num);
		    }
		    scan.close();
		}
}



