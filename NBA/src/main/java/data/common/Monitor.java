package data.common;

import java.io.File;
import java.util.ArrayList;

import data.playerdata.PlayerGameDataReader;
import data.teamdata.TeamGameDataReader;

public class Monitor implements Runnable {

	public static int obNum=0;
	public Monitor(){
		obNum++;
	}
	public void run() {
		// TODO Auto-generated method stub
	  
	  
		
      MatchFileList mfl=new MatchFileList();
      String path="data/matches/";
      File dataFile=new File(path);
     
      while(true)
      {
    	 // System.out.println("Monitor线程正在运行");	
    	  try 
    	  {
			Thread.sleep(2000);
		  } 
    	  catch (InterruptedException e) 
    	  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
    	  
    	  File[] f=dataFile.listFiles();
    	  Signal sig=mfl.hasThese(f);
    	
    	  boolean change=sig.getChange();
    	  if(!change)
    		  continue;
    	  else{
    		  String op=sig.getOpration();
    		   
    		  if(op.equals("ADD"))
    		  {
    			  ArrayList<File> listF=sig.getNewFile();
    			  for(int i=0;i<listF.size();i++)
    			  {
    				  File temp=listF.get(i);
    				  TeamGameDataReader tgds=new TeamGameDataReader();
    				  PlayerGameDataReader pgds=new PlayerGameDataReader();
    				  pgds.processFile(temp);
    				  tgds.processFile(temp);
    				  
    			  }
    		  }
    		  else if(op.equals("DEL"))
    		  {
    			  TeamGameDataReader tgds=new TeamGameDataReader();
    			  PlayerGameDataReader pgds=new PlayerGameDataReader();
    			  tgds.loadTeamData();
    			  pgds.loadPlayerData();
    		  }
    	  }
    	 
    	  
        }
	}

}
