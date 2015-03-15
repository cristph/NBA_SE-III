package presentation.control;

import java.awt.Image;

public interface ControlService {

	String findTeam(int line, int row);

	Image getTeamPic(String name);

	void findTeam(String name);

}
