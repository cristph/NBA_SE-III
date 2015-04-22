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
	JComboBox box ;
	IntField mou;
	IntField da;
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
		String[] str1 = {"2012","2013"};
		box = new JComboBox(str1);
		mou = new IntField();
		da = new IntField();
		JButton sure = new JButton("确定");
		sure.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				update();
				
			}
			
		});
		time.add(label1);
		time.add(box);
		time.add(year);
		time.add(mou);
		time.add(month);
		time.add(da);
		time.add(day);
		time.add(sure);
		this.add(time,BorderLayout.NORTH);
		//显示界面
		list = new GameList();
		this.add(list,BorderLayout.CENTER);
		
		
	}
	
	protected void update() {
		//选择新的日期的比赛
		String date = (String)box.getSelectedItem()+"-"+mou.getText()+"-"+da.getText();
		ArrayList<DateGameVO> game = ts.getGamebyDate(date);
		list.update(game);
		
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
