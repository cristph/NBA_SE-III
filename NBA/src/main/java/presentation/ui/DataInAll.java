package presentation.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
 * @author xinlin
 * ui层的基本数据
 *
 */

public class DataInAll {
	public static Dimension screenSize;
	/*
	 * 初始化屏幕大小
	 */
	static{
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}

}
