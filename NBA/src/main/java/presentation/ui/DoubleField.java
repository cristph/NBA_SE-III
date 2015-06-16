package presentation.ui;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class DoubleField extends JTextField{
	
	public DoubleField(){
		this.addKeyListener(new doubleListener());
	}
	
	public DoubleField(String str){
		this.setText(str);
		this.addKeyListener(new doubleListener());
	}
	
	boolean checkDot(){
		boolean result=false;
		String text=this.getText();
	
	    int dotLoc=text.indexOf('.');
		if(dotLoc!=-1)
			result=true;
		return result;
	}
	
    class doubleListener extends KeyAdapter{
    	
    	
    	
       public void keyTyped(KeyEvent e){
    	  boolean dot=checkDot();
    	
    	  int temp=e.getKeyChar();
    	  boolean b1=temp>=KeyEvent.VK_0;
    	  boolean b2=temp<=KeyEvent.VK_9;
    	  boolean b3=temp=='.';
    	  boolean b=(b1&&b2)||b3;
    	   if((!b)||(b3&&dot))
    	   e.consume();
    	
    		   
        }
    }
}

