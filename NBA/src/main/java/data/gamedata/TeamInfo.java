package data.gamedata;

public class TeamInfo {

	    public TeamInfo(int allPlayerTime, int teamRebNum, int oppTeamRebNum,
				int teamAttRebNum, int oppTeamAttRebNum, int teamDefRebNum,
				int oppTeamDefRebNum, int teamHitNum, int oppAttNum, int oppTwoNum,
				 int teamThrowNum, int teamFreeNum, int teamErrorNum) {
			this.allPlayerTime = allPlayerTime;
			this.teamRebNum = teamRebNum;
			this.oppTeamRebNum = oppTeamRebNum;
			this.teamAttRebNum = teamAttRebNum;
			this.oppTeamAttRebNum = oppTeamAttRebNum;
			this.teamDefRebNum = teamDefRebNum;
			this.oppTeamDefRebNum = oppTeamDefRebNum;
			this.teamHitNum = teamHitNum;
			this.oppAttNum = oppAttNum;
			this.oppTwoNum = oppTwoNum;
			
			this.teamThrowNum = teamThrowNum;
			this.teamFreeNum = teamFreeNum;
			this.teamErrorNum = teamErrorNum;
		}
		
		private int allPlayerTime; //球队所有队员上场时间（单位：秒）
		private int teamRebNum; //球队总篮板数
		private int oppTeamRebNum; //对手总篮板数
		private int teamAttRebNum; //球队总进攻篮板数
		private int oppTeamAttRebNum; //对手总进攻篮板数
		private int teamDefRebNum; //球队总防守篮板数
		private int oppTeamDefRebNum; //对手总防守篮板数
		private int teamHitNum; //球队总进球数
		private int oppAttNum; //对手进攻次数
		private int oppTwoNum; //对手两分球出手次数
	    
		private int teamThrowNum; //球队所有球员总出手次数
		private int teamFreeNum; //球队所有球员罚球次数
		private int teamErrorNum; //球队所有球员失误次数
	    
		public int getAllPlayerTime() {
			return allPlayerTime;
		}
		public int getTeamRebNum() {
			return teamRebNum;
		}
		public int getOppTeamRebNum() {
			return oppTeamRebNum;
		}
		public int getTeamAttRebNum() {
			return teamAttRebNum;
		}
		public int getOppTeamAttRebNum() {
			return oppTeamAttRebNum;
		}
		public int getTeamDefRebNum() {
			return teamDefRebNum;
		}
		public int getOppTeamDefRebNum() {
			return oppTeamDefRebNum;
		}
		public int getTeamHitNum() {
			return teamHitNum;
		}
		public int getOppAttNum() {
			return oppAttNum;
		}
		public int getOppTwoNum() {
			return oppTwoNum;
		}
		
		public int getTeamThrowNum() {
			return teamThrowNum;
		}
		public int getTeamFreeNum() {
			return teamFreeNum;
		}
		public int getTeamErrorNum() {
			return teamErrorNum;
		}
		
}
