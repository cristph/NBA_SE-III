package value;

public class Value {
	
	public enum Position{
		F,G,C,All
	}
	
	public enum League{
		West,East,All,Southeast,Atlantic,Central,Northwest,Pacific,Southwest
	}
	
	/*
	 * @param asc:升序 
	 * @param dsec:降序
	 */
	public enum Order{
		asc,dsec
	}
	
	/*
	 * @score 得分
	 * @rebound 篮板
	 * @assist 助攻
	 */
	public enum Field{
		score,rebound,assist
	}
	
	/*
	 * @lv1: <=22
	 * @lv2: 22<X<=25
	 * @lv3: 25<X<=30
	 * @lv4: >30
	 * @All: all age
	 */
	public enum Age{
		lv1,lv2,lv3,lv4,All
	}
}
