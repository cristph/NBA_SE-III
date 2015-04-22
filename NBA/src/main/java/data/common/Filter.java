package data.common;

public class Filter {

	public String filtPlayer(String s){
		   
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
	
	public String filtTeam(String s)
	{
		 StringBuffer sb=new StringBuffer(s);
		   char[] array=s.toCharArray();
	       for(int i=0;i<array.length;i++)
	       {
	    	   char temp=array[i];
	    	   boolean b1=(temp>='a')&&(temp<='z');
	    	   boolean b2=(temp>='A')&&(temp<='Z');
	    	   boolean b3=(temp>='0')&&(temp<='9');
	    	   boolean b4=(temp=='│');
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

	public String filtName(String s)
	{
		
		   char[] array=s.toCharArray();
		   int tail=0;
	       for(int i=0;i<array.length;i++)
	       {
	    	   char temp=array[i];
	    	   boolean b1=(temp>='a')&&(temp<='z');
	    	   boolean b2=(temp>='A')&&(temp<='Z');
	    	   boolean b3=(temp>='0')&&(temp<='9');
	    	   
	    	   boolean b=b1||b2||b3;
	    	   if(b)
	    	   tail=i;
	       }
	       
	       return s.substring(0, tail+1);
	       
	}
    

}
