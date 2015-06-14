package analysis.playeranalysis;

import java.util.ArrayList;

public interface PlayerAnalyseInter {
	
	//单个球员分析
	public PlayerSelfInfo getPlayerSelfInfo(String playerName);
	
	//球员比较
	public PlayerCompareInfo getPlayerCompareInfo(String playerAName, String playerBName);
	
	//返回该位置所有球员名
	public ArrayList<String> getPlayers(String position);
}
