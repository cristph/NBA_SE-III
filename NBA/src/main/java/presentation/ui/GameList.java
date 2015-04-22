package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import po.TeamPO;
import businesslogicservice.teamblservice.TeamBLService;
import vo.DateGameVO;

public class GameList extends JPanel{
	JScrollPane scroll;
	JPanel panel;
	TeamBLService ts;
	public GameList(TeamBLService ts){
		super();
		this.ts = ts;
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setLayout(new BorderLayout());
		this.add(scroll,BorderLayout.CENTER);
	}

	public GameList(ArrayList<DateGameVO> date,TeamBLService ts) {
		this.ts = ts;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for(int i=0;i<date.size();i++){
			DateGameVO temp = date.get(i);
			panel.add(CreatePanel(temp));
		}
		scroll =new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setLayout(new BorderLayout());
		this.add(scroll,BorderLayout.CENTER);
		revalidate();
		this.repaint();
	}

	private JPanel CreatePanel(DateGameVO temp) {
		// 根据temp得到信息
		final DateGameVO temp1 = temp;
		String team1 = temp.getTeam1();
		String team2 = temp.getTeam2();
		TeamPO t1 = ts.getTeamInfo(team1);
		TeamPO t2 = ts.getTeamInfo(team2);
		Image im1 = t1.getTeamPic();
		im1 = im1.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon action1 = new ImageIcon(im1);
		JLabel omg1 = new JLabel(action1);
		Image im2 = t2.getTeamPic();
		im2 = im2.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon action2 = new ImageIcon(im2);
		JLabel omg2 = new JLabel(action2);
		JPanel showP = new JPanel();
		JLabel label = new JLabel(temp.getScore1()+":"+temp.getScore2());
		Font font = new Font("TimesRoman",Font.BOLD,25);
		label.setFont(font);
		JButton button = new JButton("详细信息");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String a = temp1.getTeam1()+"-"+temp1.getTeam2();
				String b = temp1.getDate();
				String c = temp1.getScore1()+":"+temp1.getScore2();
				new GameDFrame(a,b,c,ts);
				
			}
			
		});
		showP.add(omg1);
		showP.add(label);
		showP.add(omg2);
		showP.add(button);
		return showP;
	}

	public void update(ArrayList<DateGameVO> game) {
		//更新下拉菜单
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for(int i=0;i<game.size();i++){
			DateGameVO temp = game.get(i);
			panel.add(CreatePanel(temp));
		}
		scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setLayout(new BorderLayout());
		this.add(scroll,BorderLayout.CENTER);
		revalidate();
		this.repaint();
		System.out.print("today update"+game.size());
	}
	

}
