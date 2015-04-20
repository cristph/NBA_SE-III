package presentation.ui;
/**
 * @author xinlin
 * 根据名称显示球员的Frame
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import test.data.PlayerNormalInfo;
import vo.PlayerVO;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class PlayerFrame extends NormalFrame{
	String name;
	PlayerBLService ps;
	TeamBLService ts;
	public PlayerFrame(String name2, PlayerBLService ps, TeamBLService ts) {
		this.name = name;
		this.ts = ts;
		this.ps = ps;
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		PlayerVO pvo = ps.getPlayerInfo(name);
		//基本信息
		Image test = pvo.getPic();
		test = test.getScaledInstance(140,120,test.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(test);
		Image temp = pvo.getAction();
		temp = temp.getScaledInstance(320,480,temp.SCALE_DEFAULT);
		ImageIcon action = new ImageIcon(temp);
		JLabel img = new JLabel(icon);
		JLabel omg = new JLabel(action);
		JLabel info = new JLabel("基本信息");
		Font font =new  Font("TimesRoman",Font.BOLD,35);
		info.setFont(font);
		JLabel name = new JLabel("姓名");
		JLabel num = new JLabel("号码");
		JLabel pos = new JLabel("位置");
		JLabel hei = new JLabel("身高");
		JLabel wei = new JLabel("体重");
		JLabel bir = new JLabel("生日");
		JLabel age = new JLabel("年龄");
		JLabel exp = new JLabel("球龄");
		JLabel sch = new JLabel("学校");
		JLabel team = new JLabel("队伍");
		JLabel namer = new JLabel(pvo.getName());
		JLabel numr = new JLabel(pvo.getNumber());
		JLabel posr = new JLabel(pvo.getPosition());
		JLabel heir = new JLabel(pvo.getHeight());
		JLabel weir = new JLabel(pvo.getWeight());
		JLabel birr = new JLabel(pvo.getBirth());
		JLabel ager = new JLabel(pvo.getAge());
		JLabel expr = new JLabel(pvo.getExp());
		JLabel schr = new JLabel(pvo.getSchool());
		JLabel teamr = new JLabel(pvo.getTeam());
		JButton enter = new JButton("球队信息");
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//进入球队界面
				new TeamFrame(teamr.getText(),ps,ts);
				
			}
			
		});
		
		
		JPanel label = new JPanel();
		GroupLayout layout = new GroupLayout(label);
		label.setLayout(layout);
		//水平连续组
		GroupLayout.SequentialGroup hGroup = 
				layout.createSequentialGroup();
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(info).addComponent(img));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(name).addComponent(namer).addComponent(team).addComponent(teamr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(pos).addComponent(posr).addComponent(num).addComponent(numr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(hei).addComponent(heir).addComponent(wei).addComponent(weir));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(age).addComponent(ager).addComponent(bir).addComponent(birr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(sch).addComponent(schr).addComponent(exp).addComponent(expr));
		hGroup.addGap(20);
		//垂直组
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(info).addComponent(name).addComponent(pos).addComponent(hei).addComponent(age).addComponent(sch));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(namer).addComponent(posr).addComponent(heir)
				.addComponent(ager)
				.addComponent(schr));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(team).addComponent(num).addComponent(wei)
				.addComponent(bir)
				.addComponent(exp));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(img)
				.addComponent(teamr).addComponent(numr).addComponent(weir)
				.addComponent(birr)
				.addComponent(expr));
		
		
		layout.setHorizontalGroup(vGroup);
		layout.setVerticalGroup(hGroup);
		
		
		//比赛信息
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("球员风采", omg);
		tabbedPane.addTab("球员基本信息",label);
		tabbedPane.addTab("球员数据",list);
		this.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setTabComponentAt(0, new JLabel("球员基本信息"));
		
      
		
		
		
		
	}

}
