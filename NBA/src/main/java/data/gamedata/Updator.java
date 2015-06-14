package data.gamedata;

public class Updator {

	private Selector selector=null;
	private int maxId;
	
	public Updator(){}
    public Updator(Selector st,int id){
		selector=st;
		maxId=id;
	}
	
	public Selector getSelector() {
		return selector;
	}
	public void setSelector(Selector selector) {
		this.selector = selector;
	}
	public int getMaxId() {
		return maxId;
	}
	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}
	
    public boolean equals(Updator u){
    	boolean b1=(u.getSelector().equals(selector));
    	return b1;
    }
    public boolean hasSameId(Updator u){
    	return (u.getMaxId()==maxId);
    }
    public String toString(){
    	return selector.getKind()+";"+selector.getSeason()+";"+maxId;
    }
}
