package tencent;

import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
    	//int key = 0;
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i++){
            if(!count.containsKey(gifts[i]))
                count.put(gifts[i],1);
            else{
                int x = count.get(gifts[i]);
                count.put(gifts[i],x+1);
            }    
        }
        for(int key : count.keySet()){
            if(count.get(key) > n/2)
            	return key;
        }
        return 0;
    }
}