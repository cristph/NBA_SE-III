package data.gamedata;

import java.util.HashSet;

public class FileFilter {

	HashSet<String> matchSet=null;
	HashSet<String> bDateSet=null;
	
	public FileFilter()
	{
		matchSet=new HashSet<String>();
		matchSet.add("EST-WST");
		matchSet.add("SHQ-CHK");
		matchSet.add("HIL-WEB");
		matchSet.add("WLD-USA");
		matchSet.add("WST-EST");
	}
	
	public boolean isGoodFile(String fileName)
	{
		try
		{
        String names[]=fileName.split("_");
        String matchPair=names[2];
        String dates[]=names[1].split("-");
        int date=Integer.parseInt(dates[0]+dates[1]);
        
        boolean unNormal=matchSet.contains(matchPair);
        boolean illegal=((date>=700)&&(date<=1025));
        return !((unNormal)||(illegal));
		}
        catch(Exception e)
		{
        	
        }
		return false;
	}
}
