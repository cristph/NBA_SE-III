package presentation.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import presentation.control.HotPlayerControl;
import presentation.control.HotTeamControl;
import presentation.control.KingControl;
import presentation.control.PcsPlayerControl;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class HotPanel extends JPanel{

	PlayerBLService ps;
	TeamBLService ts;
	public HotPanel(PlayerBLService ps, TeamBLService ts) {
		this.ps = ps;
		this.ts = ts;
		init();
	}
	private void init() {
		//初始化热点panel
		this.setLayout(new BorderLayout());
		HotTeamControl htc = new HotTeamControl(ps,ts);
		HotPlayerControl hpc = new HotPlayerControl(ps,ts);
		PcsPlayerControl ppc = new PcsPlayerControl(ps,ts);
		KingControl kc = new KingControl(ps,ts);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("热点球员",new PicPanel(hpc));
		tabbedPane.addTab("热点球队", new PicPanel(htc));
		tabbedPane.addTab("进步最快球员", new PicPanel(ppc));
		tabbedPane.addTab("球员王", new PicPanel(kc));
		this.add(tabbedPane);
		
	}

}
