package data.gamedata;

import java.util.ArrayList;
import java.util.HashMap;

public class MapToList {

	public static <T> ArrayList<T> convertList(HashMap<String,T> map){
		java.util.Iterator<String> it=map.keySet().iterator();
		ArrayList<T> list=new ArrayList<T>();
        while(it.hasNext())
        {
			T temp=map.get(it.next());
		    list.add(temp);
	    }
		return list;
	}
}
