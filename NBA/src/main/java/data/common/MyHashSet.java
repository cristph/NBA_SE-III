package data.common;

import java.util.HashSet;

public class MyHashSet<T> extends HashSet<T>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyHashSet(){}
	public MyHashSet(T[] t){
		for(int i=0;i<t.length;i++)
		{
			this.add(t[i]);
		}
	}
	public MyHashSet(HashSet<T> h){
		super(h);
	}
	public boolean smallerThan(HashSet<T> t){
		boolean smaller=!(this.retainAll(t));
		return smaller;
	}
  
}
