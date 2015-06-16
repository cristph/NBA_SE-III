package analysis.teamanalysis;

import java.awt.Image;
import java.util.HashMap;

import value.Value.Std;

public interface TeamAnaInterface {
	public String teamCompare(String team1,String team2,Std st);
	public String oneTeamAna(String team,Std st);
	public String linregress(Std st);
	public HashMap<String,Image> getAllTeam();
	public void setSeason(String season);
}
