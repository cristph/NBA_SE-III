/**
 * @author xinlin
 * 查询窗口
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	
	/*
	 * new added lines
	 */
	private ImageIcon background;
	private JPanel imgPanel;
	public static String season ="14-15"; 
	
	public NormalFrame(){
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		// 初始化查看界面
		this.setTitle("NBA数据库");
		int height = 640;
		int width = 780;
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
		JPanel lay = new JPanel();
		lay.setBounds(0, 600, 768, 40);
		final JLabel stateBar = new JLabel("", SwingConstants.RIGHT);
		JButton button = new JButton("切换赛季");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// 切换赛季
				SFrame frame = new SFrame();
			}
			
		});
		stateBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		//用定时任务来显示当前时间
		new java.util.Timer().scheduleAtFixedRate(
				new TimerTask(){
					public void run() {
						stateBar.setText("当前赛季：" +NormalFrame.season );
						
					}
				}, 0, 1000);
		lay.add(button);
		lay.add(new JLabel("        "));
		lay.add(new JLabel("        "));
		lay.add(new JLabel("        "));
		lay.add(stateBar);
		this.add(lay, BorderLayout.SOUTH); //把状态栏添加到窗体的南边
	}
	
	public static void main(String[] args){
		NormalFrame a =new NormalFrame();
	}
}