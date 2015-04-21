package presentation.ui;

import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamFrame extends NormalFrame{
	String name;
	PlayerBLService ps;
	TeamBLService ts;
	public TeamFrame(String name2, PlayerBLService ps, TeamBLService ts) {
		this.name = name;
		this.ts = ts;
		this.ps = ps;
		init();
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void init(){
		
	}

}

