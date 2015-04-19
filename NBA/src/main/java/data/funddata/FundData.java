package data.funddata;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import data.common.Transverter;
import po.PlayerPO;
import po.TeamPO;

public class FundData implements FundDataService {

	FundDataReadService fdrs=null;
	File imgFold=null;
	File txtFile=null;
	File acimgFold=null;
	File portimgFold=null;
	File playerFold=null;
	
	static{
		convertImg();
		
	}
	/*
	 * convertImg方法
	 * 静态的图片转码方法
	 * 在第一次新建对象的时候完成转码，之后不再转码
	 */
	private static void convertImg(){
        Transverter ts=new Transverter();
		
		String sourceImg="data/teams";
		String targetPath="data/teamPng";
		
		File sourceRoot=new File(sourceImg);
		File array[]=sourceRoot.listFiles();
		for(int i=0;i<array.length;i++)
		{
			String fileName=array[i].getName();
			String backName=fileName.substring(fileName.indexOf('.')+1);
			String preName=fileName.substring(0,fileName.indexOf('.'));
			if(backName.equals("svg"))
			{
				String pngPath=targetPath+"/"+preName+".png";
				ts.convertToPngByFIle(sourceImg+"/"+fileName,pngPath);
			}
		}
	}	
	
	public FundData(){
		fdrs=new FundDataReader();
		imgFold=new File("data/teamPng");
		txtFile=new File("data/teams/teams.txt");
		acimgFold=new File("data/players/action");
		portimgFold=new File("data/players/portrait");
		playerFold=new File("data/players/info");
	}
	

	public ArrayList<TeamPO> getTeamFundData() {
		// TODO Auto-generated method stub
		ArrayList<TeamPO> list=fdrs.readTeamFile(txtFile, imgFold);
		return list;
	}

	
	public HashMap<String, Image> getTeamImage() {
		// TODO Auto-generated method stub
		HashMap<String,Image> imgMap=fdrs.readTeamImgFile(imgFold);
		
		return imgMap;
	}


	public ArrayList<PlayerPO> getPlayerFundData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> list=new ArrayList<PlayerPO>();
		File[] array=playerFold.listFiles();
		for(int i=0;i<array.length;i++){
		PlayerPO temp=fdrs.readPlayerFile(array[i], acimgFold.toString(), portimgFold.toString());
		list.add(temp);
		}
		return list;
	}

}
