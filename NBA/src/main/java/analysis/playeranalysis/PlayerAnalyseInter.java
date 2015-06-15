package analysis.playeranalysis;

public interface PlayerAnalyseInter {
	
	/*******************单个球员分析 ******************************/
	/*
	 *球员单指标排名分析
	 *field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getSortInfo(String field, String playerName);
	
	
	/*
	 * 球员多指标 雷达图
	 */
	public void showRedar(String playerName);
	
	
	/*
	 *球员单指标区间估计 
	 *field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getIntervalInfo(String field, String playerName);
	
	
	/*
	 *球员单指标 均值 演变分析
	 *field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getAvgEvolveInfo(String field, String playerName);
	
	
	/*
	 *球员单指标 方差 演变分析
	 *field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getVarEvolveInfo(String field, String playerName);
	
	
	/******************球员比较***********************************/
	/*
	 * 球员单指标 对比分析
	 * field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getPlayersInfo(String field, String palyerANmae,String playerBName);
	
	
	/*
	 * 球员单指标 均值 对比分析
	 * field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getPlayersAvgEvolveInfo(String field, String palyerANmae,String playerBName);
	
	
	/*
	 * 球员单指标 方差 对比分析
	 * field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getPlayersVarEvolveInfo(String field, String palyerANmae,String playerBName);
	
	
	/*
	 * 展示雷达图
	 * 显示各项指标对比
	 */
	public void showRedar(String playerAName,String playerBName);
	
}
