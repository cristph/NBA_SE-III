package data.common;

public class Filter {

	public String filt(String s){
		   
		   StringBuffer sb=new StringBuffer(s);
		   char[] array=s.toCharArray();
	       for(int i=0;i<array.length;i++)
	       {
	    	   char temp=array[i];
	    	   boolean b1=(temp>='a')&&(temp<='z');
	    	   boolean b2=(temp>='A')&&(temp<='Z');
	    	   boolean b3=(temp>='0')&&(temp<='9');
	    	   boolean b4=(temp=='-');
	    	   boolean b=!(b1||b2||b3||b4);
	    	   if(b)
	    	   {
	    		   sb=sb.deleteCharAt(i);
	    		   array=sb.toString().toCharArray();
	    		   i=i-1;
	    	   }
	       }
	       return sb.toString();
	}
	public static void main(String args[]){
		String s="║Height		│6-0		║";
		Filter f=new Filter();
		String result=f.filt(s);
		System.out.println(result);
	}
	
}
