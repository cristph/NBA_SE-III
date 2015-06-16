/**
 * @author xinlin
 * 切换赛季的界面
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import util.Selector;

public class SFrame extends JFrame{

	public SFrame(){
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		// 初始化
		this.setTitle("NBA数据库");
		int height = 200;
		int width = 150;
		this.setBounds((DataInAll.screenSize.width-width)/2
				, (DataInAll.screenSize.height-height)/2, width, height);
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panel.setBorder(BorderFactory.createTitledBorder(border, 
				"    ", TitledBorder.LEFT,TitledBorder.TOP));
		JLabel title = new JLabel("切换赛季");
		Font font = new Font("TimesRoman",Font.ITALIC,20);
		title.setFont(font);
		panel.add(title);
		this.add(panel,BorderLayout.NORTH);
		//中间为选择界面
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		JButton a = new JButton("    14-15    ");
		JButton b = new JButton("    13-14    ");
		JButton c = new JButton("    12-13    ");
		a.addActionListener(new Switch(a.getText()));
		b.addActionListener(new Switch(b.getText()));
		c.addActionListener(new Switch(c.getText()));
		panel1.add(a);
		panel1.add(b);
		panel1.add(c);
		
		this.add(panel1,BorderLayout.CENTER);
	}
	
	public static void main(String[] args){
		new SFrame();
	}
	
	class Switch implements ActionListener{
		String name;
		public Switch(String a){
			name = a;
			System.out.print(name);
		}

		public void actionPerformed(ActionEvent e) {
			String m[] = name.split("-");
			String s = "20"+m[0]+"-"+"20"+m[1];
			Selector sel = new Selector();
			sel.setKind("A");
			sel.setSeason(s);
			NbaFrame.ps.changeMatchSet(sel);
			NbaFrame.ts.setSeason(s);
			NormalFrame.season = name;
		}
		
	}
}
