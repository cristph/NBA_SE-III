package presentation.control;

import java.awt.Image;

public interface TeamControlService {
	public String findTeam(int line); 
		// 得到球队的名称在显示层


	public Image getTeamPic(String name);
		// 得到图片在显示层
		

	public void findAim(String name) ;
		//跳转到球队的信息的界面
		
	

}
