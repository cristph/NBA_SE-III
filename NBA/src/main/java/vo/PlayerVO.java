package vo;

import java.awt.Image;

/**
 * 
 * @author xinlin
 *返回球员的所有信息
 */

public class PlayerVO {
	String name;
	String team;
    String Position;//位置
    String height;
    double weight;
    String birth;
    int age;
    int exp;
    String school;
    Image pic;
    Image action;//动作图片
    PlayerInfoVO  all;
    PlayerInfoVO avg;//平均的
	public String getName() {
		return name;
	}
	public String getTeam() {
		return team;
	}
	public String getPosition() {
		return Position;
	}
	public String getHeight() {
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
	public Image getPic() {
		return pic;
	}
	public Image getAction() {
		return action;
	}
	public PlayerInfoVO getAll() {
		return all;
	}
	public PlayerInfoVO getAvg() {
		return avg;
	}
	
	

}
