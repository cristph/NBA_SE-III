package analysis.playeranalysis;

import data.gamedata.Selector;

public interface PlayerAnalyseInter {
	
	/*******************单个球员分析 ******************************/
	/*
	 *球员单指标排名分析
	 *sel为所选赛季 
	 *field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 *sampleNum样本容量
	 *kscredit ks检验置信度
	 */
	public String getSortInfo(Selector sel,String field, String playerName);
	
	
	/*
	 * 球员多指标 雷达图
	 */
	public void showRedar(Selector sel,String playerName);
	
	
	/*
	 *球员单指标区间估计 
	 *escredit 区间估计置信度
	 *field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getIntervalInfo(Selector sel,String field, String playerName, double escredit);
	
	
	/*
	 *球员单指标 均值 演变分析
	 *kscredit ks检验置信度
	 *zcredit 均值检验置信度
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
	public String getPlayersInfo(Selector sel,String field, String palyerANmae, String playerBName);
	
	
	/*
	 * 球员单指标 均值 对比分析
	 * field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getPlayersAvgEvolveInfo(Selector sel,String field, String palyerANmae,String playerBName);
	
	
	/*
	 * 球员单指标 方差 对比分析
	 * field 为指标，可能的值为{"得分","篮板","助攻","抢断","盖帽"}
	 */
	public String getPlayersVarEvolveInfo(Selector sel,String field, String palyerANmae,String playerBName);
	
	
	/*
	 * 展示雷达图
	 * 显示各项指标对比
	 */
	public void showRedar(Selector sel,String playerAName,String playerBName);
	
}
