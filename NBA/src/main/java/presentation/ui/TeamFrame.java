package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.PlayerVO;
import vo.TeamVO;
import businesslogic.playerbl.PlayerBLController;
import businesslogic.teambl.TeamController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamFrame extends JFrame{
	String name;

	public TeamFrame(String text, PlayerBLService ps, TeamBLService ts) {
		this.name = name;
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		//初始化
		this.setTitle("球队页面");
		int height = 640;
		int width = 768;
		System.out.println(height+" "+width);
		this.setBounds((DataInAll.screenSize.width-width)/2
				, (DataInAll.screenSize.height-height)/2, width, height);
		this.setLayout(new BorderLayout());
		
		JPanel all = new JPanel();
		all.setLayout(new BorderLayout());
		TeamBLService ps = new TeamController();
		TeamVO tvo = ps.getTeamInfo(name);
		Image temp = tvo.getTeamPic();
		temp = temp.getScaledInstance(240, 240, temp.SCALE_DEFAULT);
		ImageIcon action = new ImageIcon(temp);
		JLabel omg = new JLabel(action);
		JLabel name = new JLabel("队名");
		JLabel shortName = new JLabel("简称");
		JLabel pos = new JLabel("位置");
		JLabel zone = new JLabel("分区");
		JLabel loc = new JLabel("赛区");
		JLabel main = new JLabel("主场");
		JLabel bir = new JLabel("建队时间");
		JLabel namer = new JLabel(tvo.getTeamName());
		JLabel shortNamer = new JLabel(tvo.getShortName());
		JLabel posr = new JLabel(tvo.getLocation());
		JLabel zoner = new JLabel(tvo.getZone());
		JLabel locr = new JLabel(tvo.getLocation());
		JLabel mainr = new JLabel(tvo.getHome());
		JLabel birr = new JLabel(tvo.getBirthday());
		JPanel label  = new JPanel();
		GroupLayout layout = new GroupLayout(label);
		label.setLayout(layout);
		//水平连续组
		GroupLayout.SequentialGroup hGroup = 
				layout.createSequentialGroup();
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup());
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(name).addComponent(namer).addComponent(shortName).addComponent(shortNamer));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(pos).addComponent(posr).addComponent(main).addComponent(mainr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(zone).addComponent(zoner).addComponent(loc).addComponent(locr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(bir).addComponent(birr));
		hGroup.addGap(20);
		//垂直连续组
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(name).addComponent(pos).addComponent(zone).addComponent(bir));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(namer).addComponent(posr).addComponent(zoner)
				.addComponent(birr));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(shortName).addComponent(main).addComponent(loc)
				);
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(shortNamer).addComponent(mainr).addComponent(locr)
				);
		vGroup.addGap(20);
		
		
		layout.setHorizontalGroup(vGroup);
		layout.setVerticalGroup(hGroup);
		all.add(omg,BorderLayout.WEST);
		all.add(label,BorderLayout.CENTER);
		
		
		// 加入表格信息
		ShowPanel spane = new ShowPanel(tvo,1);
		spane.setPreferredSize(new Dimension(width, height/5));
		this.add(all,BorderLayout.CENTER);
		this.add(spane,BorderLayout.SOUTH);	
		JLabel block = new JLabel("基本信息");
		Font font =new  Font("TimesRoman",Font.BOLD,30);
		block.setFont(font);
		this.add(block,BorderLayout.NORTH);
		
		
		
		
		
	}
	public static void main(String[] args){
		TeamFrame frame = new TeamFrame("HOU");
	}

}

