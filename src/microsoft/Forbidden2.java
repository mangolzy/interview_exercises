package microsoft;


import java.util.Scanner;
import java.util.HashMap;

public class Forbidden2 {

	
	public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
        	//String[] firstLine=input.nextLine().split(" ");
        	//int n=Integer.parseInt(firstLine[0]);
        	//int m=Integer.parseInt(firstLine[1]);
        	int n = input.nextInt();
        	int m = input.nextInt();
        	long[] ips = new long[m];
        	HashMap<Long, Integer>[] rules=(new HashMap[33]);
        	for(int i=1;i<=n;i++){
        		String permission =input.next();
        		String rule = input.next();
        		String ip;
        		int mask;
        		if(rule.split("/").length==2){
        			  ip=rule.split("/")[0];
        			  mask=Integer.parseInt(rule.split("/")[1]);
        		}
        		else{
        			ip=rule;
        			mask=32;  
        		}
        		long ipLong=ip2long(ip);
        		
        		ipLong>>=(32-mask);
                if(rules[mask]==null){
                	rules[mask]=new HashMap<Long,Integer>();
                }
                
                int value=(permission.charAt(0)=='a')? i:-i;
               
                rules[mask].put(ipLong,value);
                
        	}
        	for(int j = 0; j < m; j++){
        		String re = input.next();
        		ips[j] = ip2long(re);
        	}
        	for(int i=0;i<m;i++){
        		long ipLong=ips[i];
        		int nRules=n+1;
        		for(int j=0;j<=32;j++){
        			long ipTrans=ipLong>>(32-j);
        			if(rules[j]==null||!rules[j].containsKey(ipTrans))
        				continue;
        			else{
        		        int nth=rules[j].get(ipTrans);
        		        if(Math.abs(nth)<Math.abs(nRules)){
        		        	nRules=nth;
        		        	//System.out.println("value" + nRules);
                            
                        }// find the first rule that it matches... value contains the information of nth rule and allow or deny

        			}
        			//System.out.println("ipTrans="+ipTrans);
        		}
        		if(nRules>0)
        		{
        			System.out.println("YES");
        		}
        		else
        		{
        			System.out.println("NO");
        		}
        		
        	}
        } 
        input.close();
    }
	
	public static long ip2long(String ip){
		String[] ips=ip.split("\\.");
		long ipL=0;
		ipL=(Long.parseLong(ips[0])<<24)+(Long.parseLong(ips[1])<<16)
				+(Long.parseLong(ips[2])<<8)+(Long.parseLong(ips[3]));
		return ipL;
	}
	/*
	public static void main(String[] args){
		
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
        	String[] firstLine=input.nextLine().split(" ");
        	int n=Integer.parseInt(firstLine[0]);
        	int m=Integer.parseInt(firstLine[1]);
        	long[] ips = new long[m];
        	HashMap<Long, Integer>[] rules=(new HashMap[33]);
        	for(int i=0;i<n;i++){
        		String[] rule=input.nextLine().split(" ");
        		String permission=rule[0];
        		String ip;
        		int mask;
        		if(rule[1].split("\\/").length==2){
        			  ip=rule[1].split("\\/")[0];
        			  mask=Integer.parseInt(rule[1].split("\\/")[1]);
        		}
        		else{
        			ip=rule[1];
        			mask=32;  
        		}
        		long ipLong=ip2long(ip);
        		
        		ipLong>>=(32-mask);
                if(rules[mask]==null){
                	rules[mask]=new HashMap<Long,Integer>();
                }
                
                int value=permission.charAt(0)=='a'? i+1:(-(i+1));
                rules[mask].put(ipLong,value);
                
        	}
        	String rets = "";
        	for(int j = 0; j < m; j++){
        		String re = input.next();
        		ips[j] = ip2long(re);
        	}
        	for(int i=0;i<m;i++){
        		long ipLong=ips[i];
        		//long ipLong=ip2long(ip);
        		int nRules=n+1;
        		for(int j=0;j<33;j++){
        			long ipTrans=ipLong>>(32-j);
        			if(rules[j]==null||!rules[j].containsKey(ipTrans))
        				continue;
        			else{
        		        int nth=rules[j].get(ipTrans);
        		        if(Math.abs(nth)<Math.abs(nRules)){
        		        	nRules=nth;
                        }

        			}
        			//System.out.println("ipTrans="+ipTrans);
        		}
        		if(nRules==n+1)
        		{
        			rets="YES";
        		}
        		else if(nRules>0)
        		{
        			rets="YES";
        		}
        		else
        		{
        			rets="NO";
        		}
        		System.out.println(rets);
        	}
        } 
    }
	
	public static long ip2long(String ip){
		String[] ips=ip.split("\\.");
		long ipL=0;
		ipL=(Long.parseLong(ips[0])<<24)+(Long.parseLong(ips[1])<<16)
				+(Long.parseLong(ips[2])<<8)+(Long.parseLong(ips[3]));
		return ipL;
	}
	*/
}
