package data.common;

import java.io.File;
import java.util.ArrayList;



public class MatchFileList {

	
	static MyHashSet<File> fileSet=new MyHashSet<File>();
	
	public Signal hasThese(File[] f){
		
		MyHashSet<File> newSet=new MyHashSet<File>(f);
		boolean noChange=fileSet.equals(newSet);
		
		String op=null;
		ArrayList<File> sList=null;
		
		
		if(noChange==false)
		{
			
			MyHashSet<File> tmpSet=new MyHashSet<File>(newSet);
			boolean add=fileSet.smallerThan(newSet);
			if(add){
				op="ADD";
				newSet.removeAll(fileSet);
				sList=new ArrayList<File>(newSet);
				fileSet=new MyHashSet<File>(tmpSet);
			}
			else{
				op="DEL";
				sList=new ArrayList<File>();
			}
		}
		else
		{
			 op="NO";
			 sList=new ArrayList<File>();
			 
        }
		
		Signal result=new Signal();
		
		result.setChange(!noChange);
		result.setOpration(op);
		result.setNewFile(sList);
		
		return result;
	}
	
   }

