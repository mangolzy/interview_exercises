package netease;

import java.util.HashSet;
import java.util.Scanner;

public class xiaozhao1 {
	
	
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashSet<String> myset = new HashSet<String>();
        int limit = 2500;
        int  i = 0;
        while(in.hasNextLine()){
        	
        	String s = in.nextLine();
        	if(s.isEmpty() || s.equals("") || s.equals("\n"))
        		break;
        	String[] each = s.split(" ");
        	/*
        	if(s.isEmpty())
        		break;
        	else
        		i++;
        		*/
        	for(int j = 0; j < each.length; j ++)
        		if(!myset.contains(each[j]))
        			myset.add(each[j]);
   }
        System.out.println(myset.size());
        in.close();
    }
}
