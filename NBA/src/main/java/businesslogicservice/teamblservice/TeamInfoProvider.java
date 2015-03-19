package businesslogicservice.teamblservice;

import businesslogic.teambl.TeamInfo;

public interface TeamInfoProvider {
	
	/*
	 * 该接口用于获取某球队、某日期的比赛信息
	 * 供playerbl包内调用
	 * String team参赛主体队伍名
	 * String date指日期，格式形如1999-01-01
	 */
	public TeamInfo getTeamInfo(String team, String date);
	
	/*
	 *该接口用于获取球队所属分区
	 *供playerbl包内调用
	 *返回值格式形如：“W-Atlantic”
	 */
	public String getArea(String teamName);
	
}
