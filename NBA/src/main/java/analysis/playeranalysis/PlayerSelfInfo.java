package analysis.playeranalysis;

public class PlayerSelfInfo {
	
	String playerName;
	String position;
	
	String leiDaPath;  //各项指标的雷达图
	
	//得分
	String score_normal_linePicPath;		//球员过往比较 的 柱状折线正态图
	String score_normalPicPath;  //球员过往比较 的 正态图
	
	String score_ks;     //KS检验 文字说明
	String score_IE;		//球员各项指标 的 区间估计 的 文字说明
	String score_IE_sign;		//球员过往比较 的 各项指标 的文字说明
	String score_VAR_sign;	//球员过往比较 的 各项指标 的  稳定性 的 文字说明
	
	
	//篮板
	String reb_normal_linePicPath;		//球员过往比较 的 柱状折线正态图
	String reb_normalPicPath;  //球员过往比较 的 正态图
	
	String reb_ks;     //KS检验 文字说明
	String reb_IE;		//球员各项指标 的 区间估计 的 文字说明
	String reb_IE_sign;		//球员过往比较 的 各项指标 的文字说明
	String reb_VAR_sign;	//球员过往比较 的 各项指标 的  稳定性 的 文字说明
	
	
	//助攻
	String ass_normal_linePicPath;		//球员过往比较 的 柱状折线正态图
	String ass_normalPicPath;  //球员过往比较 的 正态图
	
	String ass_ks;     //KS检验 文字说明
	String ass_IE;		//球员各项指标 的 区间估计 的 文字说明
	String ass_IE_sign;		//球员过往比较 的 各项指标 的文字说明
	String ass_VAR_sign;	//球员过往比较 的 各项指标 的  稳定性 的 文字说明
	
	
	//抢断
	String ste_normal_linePicPath;		//球员过往比较 的 柱状折线正态图
	String ste_normalPicPath;  //球员过往比较 的 正态图
	
	String ste_ks;     //KS检验 文字说明
	String ste_IE;		//球员各项指标 的 区间估计 的 文字说明
	String ste_IE_sign;		//球员过往比较 的 各项指标 的文字说明
	String ste_VAR_sign;	//球员过往比较 的 各项指标 的  稳定性 的 文字说明
	
	//盖帽
	String blo_normal_linePicPath;		//球员过往比较 的 柱状折线正态图
	String blo_normalPicPath;  //球员过往比较 的 正态图
	
	String blo_ks;     //KS检验 文字说明
	String blo_IE;		//球员各项指标 的 区间估计 的 文字说明
	String blo_IE_sign;		//球员过往比较 的 各项指标 的文字说明
	String blo_VAR_sign;	//球员过往比较 的 各项指标 的  稳定性 的 文字说明
	
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setLeiDaPath(String leiDaPath) {
		this.leiDaPath = leiDaPath;
	}
	public void setScore_normal_linePicPath(String score_normal_linePicPath) {
		this.score_normal_linePicPath = score_normal_linePicPath;
	}
	public void setScore_normalPicPath(String score_normalPicPath) {
		this.score_normalPicPath = score_normalPicPath;
	}
	public void setScore_ks(String score_ks) {
		this.score_ks = score_ks;
	}
	public void setScore_IE(String score_IE) {
		this.score_IE = score_IE;
	}
	public void setScore_IE_sign(String score_IE_sign) {
		this.score_IE_sign = score_IE_sign;
	}
	public void setScore_VAR_sign(String score_VAR_sign) {
		this.score_VAR_sign = score_VAR_sign;
	}
	public void setReb_normal_linePicPath(String reb_normal_linePicPath) {
		this.reb_normal_linePicPath = reb_normal_linePicPath;
	}
	public void setReb_normalPicPath(String reb_normalPicPath) {
		this.reb_normalPicPath = reb_normalPicPath;
	}
	public void setReb_ks(String reb_ks) {
		this.reb_ks = reb_ks;
	}
	public void setReb_IE(String reb_IE) {
		this.reb_IE = reb_IE;
	}
	public void setReb_IE_sign(String reb_IE_sign) {
		this.reb_IE_sign = reb_IE_sign;
	}
	public void setReb_VAR_sign(String reb_VAR_sign) {
		this.reb_VAR_sign = reb_VAR_sign;
	}
	public void setAss_normal_linePicPath(String ass_normal_linePicPath) {
		this.ass_normal_linePicPath = ass_normal_linePicPath;
	}
	public void setAss_normalPicPath(String ass_normalPicPath) {
		this.ass_normalPicPath = ass_normalPicPath;
	}
	public void setAss_ks(String ass_ks) {
		this.ass_ks = ass_ks;
	}
	public void setAss_IE(String ass_IE) {
		this.ass_IE = ass_IE;
	}
	public void setAss_IE_sign(String ass_IE_sign) {
		this.ass_IE_sign = ass_IE_sign;
	}
	public void setAss_VAR_sign(String ass_VAR_sign) {
		this.ass_VAR_sign = ass_VAR_sign;
	}
	public void setSte_normal_linePicPath(String ste_normal_linePicPath) {
		this.ste_normal_linePicPath = ste_normal_linePicPath;
	}
	public void setSte_normalPicPath(String ste_normalPicPath) {
		this.ste_normalPicPath = ste_normalPicPath;
	}
	public void setSte_ks(String ste_ks) {
		this.ste_ks = ste_ks;
	}
	public void setSte_IE(String ste_IE) {
		this.ste_IE = ste_IE;
	}
	public void setSte_IE_sign(String ste_IE_sign) {
		this.ste_IE_sign = ste_IE_sign;
	}
	public void setSte_VAR_sign(String ste_VAR_sign) {
		this.ste_VAR_sign = ste_VAR_sign;
	}
	public void setBlo_normal_linePicPath(String blo_normal_linePicPath) {
		this.blo_normal_linePicPath = blo_normal_linePicPath;
	}
	public void setBlo_normalPicPath(String blo_normalPicPath) {
		this.blo_normalPicPath = blo_normalPicPath;
	}
	public void setBlo_ks(String blo_ks) {
		this.blo_ks = blo_ks;
	}
	public void setBlo_IE(String blo_IE) {
		this.blo_IE = blo_IE;
	}
	public void setBlo_IE_sign(String blo_IE_sign) {
		this.blo_IE_sign = blo_IE_sign;
	}
	public void setBlo_VAR_sign(String blo_VAR_sign) {
		this.blo_VAR_sign = blo_VAR_sign;
	}
	
}
