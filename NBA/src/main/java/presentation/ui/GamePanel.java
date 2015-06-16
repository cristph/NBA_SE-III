package presentation.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vo.DateGameVO;
import businesslogicservice.teamblservice.TeamBLService;

public class GamePanel extends JPanel{
	TeamBLService ts;
	JComboBox box1 ;
	JComboBox box2 ;
	JComboBox box3 ;
	GameList list;
	public GamePanel(TeamBLService ts){
		this.ts = ts;
		init();
	}
	private void init() {
		//初始化
		this.setLayout(new BorderLayout());
		JPanel time = new JPanel();
		JLabel label1 = new JLabel("比赛时间:");
		JLabel year = new JLabel("年");
		JLabel month = new JLabel("月");
		JLabel day = new JLabel("日");
		String[] str1 = {"2012","2013","2014","2015"};
		String[] str2 = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		String[] str3 = {"01","02","03","04","05","06","07","08","09","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"
				,"28","29","30","31"};
		box1 = new JComboBox(str1);
		box2 = new JComboBox(str2);
		box3 = new JComboBox(str3);
		JButton sure = new JButton("确定");
		sure.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				update();
				
			}
			
		});
		time.add(label1);
		time.add(box1);
		time.add(year);
		time.add(box2);
		time.add(month);
		time.add(box3);
		time.add(day);
		time.add(sure);
		this.add(time,BorderLayout.NORTH);
		//显示界面
		list = new GameList(ts);
		this.add(list,BorderLayout.CENTER);
		
		
	}
	
	protected void update() {
		//选择新的日期的比赛
		String date = (String)box1.getSelectedItem()+"-"+(String)box2.getSelectedItem()+"-"+(String)box3.getSelectedItem();
		ArrayList<DateGameVO> game = ts.getGamebyDate(date);
		this.remove(list);
		list = new GameList(game,ts);
		this.add(list,BorderLayout.CENTER);
		revalidate();
		this.repaint();
		
	}

	class IntField extends JTextField {

		public IntField(){
			this.addKeyListener(new intListener());
		}
		
		public IntField(String str){
			this.setText(str);
			this.addKeyListener(new intListener());
		}
		
		class intListener extends KeyAdapter{
			public void keyTyped(KeyEvent e){
				int keyChar=e.getKeyChar();
				if(!((keyChar>=KeyEvent.VK_0)&&(keyChar<=KeyEvent.VK_9)))
					e.consume();
			}
			
		}
	}
	

}
