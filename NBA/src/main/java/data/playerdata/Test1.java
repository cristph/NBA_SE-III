package data.playerdata;

import java.util.ArrayList;

import po.PlayerPO;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PlayerData pd=new PlayerData();
        double time1=System.currentTimeMillis();
        ArrayList<PlayerPO> list1=pd.getPlayerData();
        double time2=System.currentTimeMillis();
        double time=time2-time1;
    	System.out.println("时间为"+time);

        for(int i=0;i<list1.size();i++){
        	PlayerPO temp=list1.get(i);
        	System.out.println(temp.getName()+";"+temp.getExp()+";"+temp.getPosition()+";"
        			+temp.getHeight()+";"+temp.getWeight()+";"+temp.getSchool()+";");
        }
	}

}
