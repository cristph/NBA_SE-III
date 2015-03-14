/*
 * version 0.1 2015-3-11
 */
package po;

import java.awt.Image;
import java.util.ArrayList;

public class TeamPO {
	
	String teamName; //球队全名
	String shortName; //缩写
	
	String location; //所在地
	String compArea; //赛区
	String zone; //分区
	String home; //主场
	String birthday; //建立时间
	
	ArrayList<String> playerList;//所属球员列表
	Image teamPic; //球队标志
	
	ArrayList<TeamGamePO> gameDataList;
}
