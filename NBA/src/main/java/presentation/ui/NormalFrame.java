/**
 * @author xinlin
 * 查询窗口
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import businesslogic.playerbl.PlayerBLController;
import businesslogic.teambl.TeamController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;
import presentation.control.ControlService;
import presentation.control.PlayerOrderControl;
import presentation.control.PlayerTopControl;
import presentation.control.TeamControl;


class NormalFrame extends JFrame{
	
	public NormalFrame(){
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		// 初始化查看界面
		this.setTitle("NBA数据库");
		int height = 640;
		int width = 768;
		System.out.println(height+" "+width);
		this.setBounds((DataInAll.screenSize.width-width)/2
				, (DataInAll.screenSize.height-height)/2, width, height);
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panel.setBorder(BorderFactory.createTitledBorder(border, 
				"    ", TitledBorder.LEFT,TitledBorder.TOP));
		JLabel title = new JLabel("NBA数据库");
		Font font = new Font("TimesRoman",Font.ITALIC,40);
		title.setFont(font);
		panel.add(title);
		this.add(panel,BorderLayout.NORTH);
		
		
		
		//状态栏
		final JLabel stateBar = new JLabel("", SwingConstants.RIGHT);
		stateBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		//用定时任务来显示当前时间
		new java.util.Timer().scheduleAtFixedRate(
				new TimerTask(){
					DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
					public void run() {
						stateBar.setText("当前时间：" + df.format(new Date()) + "  ");
					}
				}, 0, 1000);
		this.add(stateBar, BorderLayout.SOUTH); //把状态栏添加到窗体的南边
	}
}