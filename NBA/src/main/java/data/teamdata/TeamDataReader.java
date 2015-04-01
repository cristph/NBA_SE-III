package data.teamdata;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import data.common.Filter;
import data.common.Transverter;
import po.TeamPO;

public class TeamDataReader implements TeamDataReadService {


    public ArrayList<TeamPO> getTeamPo() {

		// TODO Auto-generated method stub
		String txtPath="data/teams/teams.txt";
		String imgPath="data/teamPng";
		ArrayList<TeamPO> result=new ArrayList<TeamPO>();
		
		File file=new File(txtPath);
		
		try 
		{
			Filter filter=new Filter();
			FileReader 	inOne = new FileReader(file);
			BufferedReader inTwo=new BufferedReader(inOne);
			String line=inTwo.readLine();
			int row=1;
			while((line=inTwo.readLine())!=null)
			{
				if(row<=30)
				{
				  line=filter.filtTeam(line);
				
				  String info[]=line.split("│");
				  TeamPO temp=new TeamPO();
				  temp.setTeamName(info[0]);
				  temp.setShortName(info[1]);
				  temp.setLocation(info[2]);
				  temp.setCompArea(info[3]);
				  temp.setZone(info[4]);
				  temp.setHome(info[5]);
				  temp.setBirthday(info[6]);
				  Image teamImg=Toolkit.getDefaultToolkit().getImage(imgPath+"/"+info[1]
						  +".png");
				  temp.setTeamPic(teamImg);
				  result.add(temp);
				  }
				row++;
			}
			inTwo.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}

	public HashMap<String, Image> getTeamImage() {
		String imgPath="data/teamPng";
		File file=new File(imgPath);
		File array[]=file.listFiles();
		
		System.out.println("teamPng.length"+array.length);
		if(array.length==0){
		convertSvg();
		}
		
		HashMap<String,Image> imgMap=new HashMap<String,Image>();
		array=file.listFiles();
		
		for(int i=0;i<array.length;i++)
		{
			String fileName=array[i].getName();
			boolean isPng=fileName.substring((fileName.indexOf('.')+1)).equals("png");
			String teamName=fileName.substring(0, fileName.indexOf('.'));
			if(isPng)
			{   
				Image img=Toolkit.getDefaultToolkit().getImage(imgPath+"/"+fileName);
				imgMap.put(teamName, img);
			}
		}
		
		return imgMap;
	}

	private void convertSvg(){
		Transverter ts=new Transverter();
		
		String sourceImg="data/teams";
		String targetPath="data/teamPng";
		
		File sourceRoot=new File(sourceImg);
		File array[]=sourceRoot.listFiles();
		for(int i=0;i<array.length;i++)
		{
			String fileName=array[i].getName();
			String backName=fileName.substring(fileName.indexOf('.')+1);
			String preName=fileName.substring(0,fileName.indexOf('.'));
			if(backName.equals("svg"))
			{
				String pngPath=targetPath+"/"+preName+".png";
				ts.convertToPngByFIle(sourceImg+"/"+fileName,pngPath );
			}
		}
	}
	
	public static void main(String[] args){
		TeamDataReader tdr=new TeamDataReader();
		HashMap<String,Image> map=tdr.getTeamImage();
		
	}
	
	
	
}
