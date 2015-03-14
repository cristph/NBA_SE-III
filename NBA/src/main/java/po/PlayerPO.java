/*
 * version 0.1 2015-3-11
 */
package po;

import java.awt.Image;
import java.util.ArrayList;

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
	
	ArrayList<PlayerGamePO> gameDataList;//球员赛季每一场比赛的数据
	
	
}
