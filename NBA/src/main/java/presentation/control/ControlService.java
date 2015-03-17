package presentation.control;

import java.awt.Image;

import javax.swing.ComboBoxModel;

public interface ControlService {

	String findTeam(int line, int row);

	Image getTeamPic(String name);

	void findTeam(String name);

	String[] getOrder();

	String[] getString();

}
