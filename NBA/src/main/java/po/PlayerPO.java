/*
 * version 0.1 2015-3-11
 */
package po;

import java.awt.Image;


public class PlayerPO {
	

	String name; 
	int number; //球衣号码
	String position; //位置
	double height;
	double weight;
	String birth; //生日(月日，年)
	int age;
	int exp; //球龄
	String school; //毕业院校
	
	String team;//所属球队名称
	
	Image actionImage; //全身照
	Image portaitImage; //球员头像
	
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public String getPosition() {
		return position;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getBirth() {
		return birth;
	}
	public int getAge() {
		return age;
	}
	public int getExp() {
		return exp;
	}
	public String getSchool() {
		return school;
	}
	public String getTeam() {
		return team;
	}
	public Image getActionImage() {
		return actionImage;
	}
	public Image getPortaitImage() {
		return portaitImage;
	}
}
