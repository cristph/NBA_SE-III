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
	String number; //球衣编号
    String Position;//位置
    String height;
    String weight;
    String birth;
    String age;
    String exp;
    String school;
    Image pic;
    Image action;//动作图片
    PlayerInfoVO  all;
    PlayerInfoVO avg;//平均的
    
	public PlayerVO(String name, String team, String number, String position,
			String height, String weight, String birth, String age, String exp,
			String school, Image pic, Image action, PlayerInfoVO all,
			PlayerInfoVO avg) {
		super();
		this.name = name;
		this.team = team;
		this.number = number;
		Position = position;
		this.height = height;
		this.weight = weight;
		this.birth = birth;
		this.age = age;
		this.exp = exp;
		this.school = school;
		this.pic = pic;
		this.action = action;
		this.all = all;
		this.avg = avg;
	}
	
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
	public String getWeight() {
		return weight;
	}
	public String getBirth() {
		return birth;
	}
	public String getAge() {
		return age;
	}
	public String getExp() {
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
	public String getNumber() {
		return number;
	}
}
