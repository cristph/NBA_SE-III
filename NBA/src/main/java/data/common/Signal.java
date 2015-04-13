package data.common;

import java.io.File;
import java.util.ArrayList;

public class Signal {

	private	String operation=null;
	private ArrayList<File> newFile=null;
	private boolean hasChange=false; 
	
	
	
	
	public ArrayList<File> getNewFile() {
		return newFile;
	}

	public void setNewFile(ArrayList<File> newFile) {
		if(newFile!=null)
		this.newFile = newFile;
	}

	public String getOpration() {
		return operation;
	}

	public void setOpration(String operation) {
		if(operation!=null)
		this.operation = operation;
	}
	
	public void setChange(boolean isChange){
		this.hasChange=isChange;
	}
	
	public boolean getChange(){
		return hasChange;
	}
}
