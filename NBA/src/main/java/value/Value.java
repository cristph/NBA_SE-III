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
	 * @block 盖帽
	 * @steal 抢断
	 * @three 三分命中率
	 * @shoot 投篮命中率
	 * @free 罚球命中率 
	 */
	public enum Field{
		score,rebound,assist,block,steal,three,shoot,free
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
	public enum Field2{
		score,rebound, assist, blockShot, steal, foul, fault, shot, three, penalty, defendRebound, offendRebound 
	}
	public enum Std{
		score,rebound,assist,foul
	}
}
