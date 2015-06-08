/*
 * version 0.1 2015-3-11
 */
package po;

import java.awt.Image;

public class PlayerPO {
	
	String name; 
	String number; //球衣号码
	String position; //位置
	String height;
	String weight;
	String birth; //生日(月日，年)
	String age;
	String exp; //球龄
	String school; //毕业院校
	
	Image actionImage; //全身照
	Image portaitImage; //球员头像
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public void setActionImage(Image actionImage) {
		this.actionImage = actionImage;
	}
	public void setPortaitImage(Image portaitImage) {
		this.portaitImage = portaitImage;
	}
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public String getPosition() {
		return position;
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

	public Image getActionImage() {
		return actionImage;
	}
	public Image getPortaitImage() {
		return portaitImage;
	}
}
