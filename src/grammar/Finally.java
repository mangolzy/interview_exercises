package grammar;

public class Finally {
	 static int i = 0;
	 public static void main(String[] args) {
	 try{
	       //i = 100 / 0;
	    	   System.out.print(i); // 023
	  }catch(Exception e){
	       System.out.print(1);
	       //e.printStackTrace();   // with or without 123
	       throw new RuntimeException();  // only 12
	  }finally{
	       System.out.print(2);
	  }
	      System.out.print(3);
	 }
	 
}
