/**
 * @author xinlin
 * 查询窗口
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import businesslogic.playerbl.PlayerBLController;
import businesslogic.teambl.TeamController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;
import presentation.control.PlayerOrderControl;
import presentation.control.PlayerTopControl;
import presentation.control.TeamControl;


class NbaFrame extends NormalFrame{
	static PlayerBLService ps = new PlayerBLController();
	static TeamBLService ts = new TeamController("2014-2015");
	public NbaFrame(){
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		// 初始化查看界面
		
		
		//声明一个controler作为控制
		TeamControl cs = new TeamControl(ps,ts);
		PlayerOrderControl os = new PlayerOrderControl(ps,ts);
		PlayerTopControl pts = new PlayerTopControl(ps,ts);
		//选项卡的界面
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("热点",new HotPanel(ps,ts));
		tabbedPane.addTab("球队查看", new TeamAllPanel(cs));
		tabbedPane.addTab("球队排序", new OrderPanel(cs));
		tabbedPane.addTab("球员查看", new OrderPanel(os));
		tabbedPane.addTab("前五十球员", new OrderPanel(pts));
		tabbedPane.addTab("比赛查看", new GamePanel(ts));
		tabbedPane.setTabComponentAt(0, new JLabel("热点"));
		this.add(tabbedPane, BorderLayout.CENTER);
		this.addWindowListener(new WindowAdapter(){

			

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}

			
			
		});
		
	}
	
	
	public static void main(String[] args){
		NbaFrame f= new NbaFrame();
	}
}

