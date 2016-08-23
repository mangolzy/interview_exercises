package grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Hashmap_table {
	
	
	/*  hashmap
	 *  static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	 */
	
	/*
	 *  hash table
	 *  
	 *  Neither the key nor the value can be <code>null</code>. <p>
     * 
     *  return previous or null same as hash map
	 *   public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, index);
        return null;
    }
	 */

	public static void main(String[] args){
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(10));
		students.add(new Student(18));
		students.add(new Student(15));
		
		Collections.sort(students);  // Descending
		
		System.out.print(students.get(0).age);
		
		
		/*
		Map<String, Integer> mymap = new HashMap<>();
		Map<String, Integer> mytable = new Hashtable<>();
		try{
			mymap.put(null, null);  //实际上不存入.....
			mymap.put(null, 3);
			mymap.put("10", 10);
			mymap.put("2",1);   // map 按key 升序打印
			
			
			//mytable.put(null, null);  // table 不允许 null 做键值
			//mytable.put(null, 1);
			mytable.put("10", 7);
			mytable.put("2",10);
			mytable.put("5", 5);
			mytable.put("6",8);  // table 按插入顺序打印？
			
			for(Entry e: mymap.entrySet()){
				System.out.println(e.getKey() + " "+e.getValue());
			}
			
            System.out.println();
			for(Entry e: mytable.entrySet()){
				System.out.println(e.getKey() + " "+e.getValue());
			}
			
			System.out.println(mytable.containsKey("a"));  // 有contains 更昂贵但相当于containsValue 
			System.out.println(mymap.containsKey("1"));  //无contains方法的 set 有
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
	}
}

class Student implements Comparable<Student>{
	Integer age;
	
	public Student(Integer age){
		this.age = age;
	}
	public int compareTo(Student s){
		return s.age.compareTo(this.age);
	}
}
