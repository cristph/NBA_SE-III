package data.dataloader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.sqlservice.DBUtil;

public class GetData {
	public GetData(){
		
		String order = "cmd /c python python//getInWin.py "+getMaxDate()+" "+"data//matches";
		Process pro=null;
		System.out.println(order);
		try {
			pro=Runtime.getRuntime().exec(order);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getMaxDate(){
		Connection conn=DBUtil.open();
		String sql="select max(matchDate) from teamgametbl";
	    String maxDate="";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			maxDate=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(conn);
		return maxDate;
	}
	
	public static void main(String[] args){
		new GetData();
	}
	
	
}

