package presentation.ui;
/**
 * @author xinlin
 * 根据名称显示球员的Frame
 */

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
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
		this.setLayout(null);
		
		JPanel all = new JPanel();
		all.setBounds(0, 0, width, height/3);
		PlayerBLService ps = new PlayerBLController();
		PlayerVO pvo = ps.getPlayerTotalInfo("Aaron Gray");
		ImageIcon icon = new ImageIcon(pvo.getPic());
		ImageIcon action = new ImageIcon(pvo.getAction());
		
		String [][] data = new String[2][9];
		data[0][0] = "姓名";
		data[0][1] = "号码";
		data[0][2] = "位置";
		data[0][3] = "身高";
		data[0][4] = "体重";
		data[0][5] = "生日";
		data[0][6] = "年龄";
		data[0][7] = "球龄";
		data[0][8] = "学校";
		data[1][0] = pvo.getName();
		data[1][1] = pvo.getNumber();
		data[1][2] = pvo.getPosition();
		data[1][3] = pvo.getHeight();
		data[1][4] = pvo.getWeight();
		data[1][5] = pvo.getBirth();
		data[1][6] = pvo.getAge();
		data[1][7] = pvo.getExp();
		data[1][8] = pvo.getSchool();
		JList li = new JList(data);
		all.add(li);
		
		// 加入表格信息
		
		
		this.add(all);
		
		
		
		
	}
	
	

}
