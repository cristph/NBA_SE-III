package presentation.ui;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
public class IntField extends JTextField {

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
