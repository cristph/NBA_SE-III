package data.teamdata;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.common.Filter;
import po.TeamGamePO;
import po.TeamPO;

public class TeamDataReader implements TeamDataReadService {

	public ArrayList<TeamPO> getTeamPo() {
		// TODO Auto-generated method stub
		String txtPath="data/teams/teams.txt";
		String imgPath="data/teams";
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
				  System.out.println(row);
				  String info[]=line.split("│");
				  TeamPO temp=new TeamPO();
				  temp.setTeamName(info[0]);
				  temp.setShortName(info[1]);
				  temp.setLocation(info[2]);
				  temp.setCompArea(info[3]);
				  temp.setZone(info[4]);
				  temp.setHome(info[5]);
				  temp.setBirthday(info[6]);
				  Image teamImg=Toolkit.getDefaultToolkit().createImage(imgPath+"/"+info[1]
						  +".svg");
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

	public ArrayList<TeamGamePO> getTeamGamePo() {
		// TODO Auto-generated method stub
		return null;
	}

}
