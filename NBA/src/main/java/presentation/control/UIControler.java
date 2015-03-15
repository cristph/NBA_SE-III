package presentation.control;

import java.awt.Image;
import java.util.HashMap;

import businesslogic.teambl.TeamController;
import businesslogicservice.teamblservice.TeamBLService;

public class UIControler implements ControlService{

	TeamBLService ts = new TeamController();
	public String findTeam(int line, int row) {
		// 得到球队的名称在显示层
		String[][] list = {{"CHI","BKN","ATL","DEN","GSW","DAL"}
		,{"CLE","BOS","CHA","MIN","LAC","HOU"}
		,{"DET","NYK","MIA","OKC","LAL","MEM"}
		,{"IND","PHI","ORL","POR","PHX","NOP"}
		,{"MIL","TOR","WAS","UTA","SAC","SAS"}};
		return list[row-1][line-1];
	}

	public Image getTeamPic(String name) {
		// 得到图片在显示层
		HashMap<String,Image> hash = ts.getAllTeam();
		
		return hash.get(name);
	}

	public void findTeam(String name) {
		//跳转到球队的信息的界面
		
	}

}
