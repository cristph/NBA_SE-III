package data.dataloader;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import data.sqlservice.DBUtil;

public class TableServer {
    
	private String c_tables[];
	private String d_tables[];
	
	
	public TableServer(){
		c_tables=new String[4];
		d_tables=new String[4];
		initSqls();
	}
	
    private void initSqls(){
    	Properties prop=new Properties();
		try
		{
			FileReader in=new FileReader("src//config.sqlTable.properties");
			prop.load(in);
		}
		catch(Exception e)
		{
			System.out.println("Prop文件缺失");
			return ;
		}
		String teamSql=prop.getProperty("teamSql");
		c_tables[0]=teamSql;
		String playerSql=prop.getProperty("playerSql");
		c_tables[1]=playerSql;
		String teamGameSql=prop.getProperty("teamGameSql");
		c_tables[2]=teamGameSql;
		String playerGameSql=prop.getProperty("playerGameSql");
		c_tables[3]=playerGameSql;
		
		String d_teamTbl=prop.getProperty("d_teamTbl");
		d_tables[0]=d_teamTbl;
		String d_playerTbl=prop.getProperty("d_playerTbl");
		d_tables[1]=d_playerTbl;
		String d_teamGameTbl=prop.getProperty("d_teamGameTbl");
		d_tables[2]=d_teamGameTbl;
		String d_playerGameTbl=prop.getProperty("d_playerGameTbl");
		d_tables[3]=d_playerGameTbl;
	}
	
	private void processTables(String tables[])
	{
		Connection conn=DBUtil.open();
		try {
			Statement stat=conn.createStatement();
			for(int i=0;i<tables.length;i++)
			{
				stat.execute(tables[i]);
			}
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(conn);
	}
	
	private void createTables(){
		processTables(c_tables);
	}
	private void dropTables(){
		processTables(d_tables);
	}
	
	boolean hasAllTables(){
		return false;
	}
	
    public static void main(String args[]){
		
		TableServer ts=new TableServer();
		ts.dropTables();
	}
}
