package google2017apac;


import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
public class Xiaoyi {





    public static void main(String [] args) throws IOException{
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/A-small.in"))));
        System.setOut(new PrintStream(new FileOutputStream("/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/A-small.txt")));

        HashSet<Character> set = new HashSet<>();

        TreeSet<String> treeSet = new TreeSet<>();

        while (in.hasNext()){
            int caseNum = in.nextInt();
            for (int i = 1; i <= caseNum; ++ i){
                int sizeOfPeople = in.nextInt();
                Person maxP = null;
                for (int j = 0; j < sizeOfPeople; ++ j){
                    String name = in.nextLine();
                    if(name == null || name.equals("")) name = in.nextLine();
                    for (int k = 0; k < name.length(); ++ k){
                        char c = name.charAt(k);
                        if(c != ' ') set.add(c);
                    }
                    int anums = set.size();
                    set.clear();
                    if(maxP == null){
                        maxP = new Person(name, anums);
                    }else {
                        if(maxP.anums < anums){
                            maxP.anums = anums;
                            maxP.name = name;
                        }else if(maxP.anums == anums) {
                            treeSet.add(maxP.name);
                            treeSet.add(name);
                            maxP.name = treeSet.first();
                            treeSet.clear();
                        }
                    }
                }
                System.out.println("Case #" + i +  ": " + maxP.name);
            }
        }

    }





    static class Person{
        public String name;
        public int anums;

        public Person(String name, int anums){
            this.name = name;
            this.anums = anums;
        }
    }
}