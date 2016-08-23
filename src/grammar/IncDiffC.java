package grammar;

public class IncDiffC {

    public static void main(String[] args) { 
        IncDiffC inc = new IncDiffC(); 
        int i = 0; 
        inc.fermin(i); 
        i= i ++;   // java is zero, but c is 1....amazing
        System.out.println(i);
     
     } 
     void fermin(int i){ 
        i++; 
     } 
 }
