package presentation.ui;
/**
 * @author xinlin
 * 根据名称显示球员的Frame
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import vo.PlayerVO;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;

public class PlayerFrame extends JFrame{
	String name;
	
	public PlayerFrame(String name){
		this.name = name;
		init();
		this.setVisible(true);
		this.setResizable(false);
		
	}

	private void init() {
		//初始化
		this.setTitle("球员页面");
		int height = 640;
		int width = 768;
		System.out.println(height+" "+width);
		this.setBounds((DataInAll.screenSize.width-width)/2
				, (DataInAll.screenSize.height-height)/2, width, height);
		this.setLayout(new BorderLayout());
		
		JPanel all = new JPanel();
		all.setLayout(new BorderLayout());
		PlayerBLService ps = new PlayerBLController();
		PlayerVO pvo = ps.getPlayerTotalInfo(name);
		Image test = pvo.getPic();
		test = test.getScaledInstance(140,120,Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(test);
		Image temp = pvo.getAction();
		temp = temp.getScaledInstance(320,480,Image.SCALE_DEFAULT);
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
		JPanel label  = new JPanel();
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

		//垂直连续组
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
		all.add(omg,BorderLayout.WEST);
		all.add(label,BorderLayout.CENTER);
		
		// 加入表格信息
		ShowPanel spane = new ShowPanel(pvo);
		spane.setPreferredSize(new Dimension(width, height/5));
		this.add(all,BorderLayout.CENTER);
		this.add(spane,BorderLayout.SOUTH);	
		
		
		
		
		
	}
	
	public static void main(String[] args){
		PlayerFrame frame = new PlayerFrame("Aaron Gray");
	}

}
