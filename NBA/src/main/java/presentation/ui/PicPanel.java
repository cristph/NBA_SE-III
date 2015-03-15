package presentation.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PicPanel extends JPanel{
	Image icon;
	public PicPanel(Image a){
		super();
		icon = a ;
		
	}
	 public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(icon, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	 

}
