package data.common;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;


public class Transverter {

	
	public void convertToPngByFIle(String svgPath,String pngPath){
		FileInputStream svgStream=null;
		FileOutputStream pngStream=null;
		try {
			svgStream = new FileInputStream(svgPath);
			pngStream =new FileOutputStream(pngPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PNGTranscoder t=new PNGTranscoder();
		TranscoderInput input=new TranscoderInput(svgStream);
		TranscoderOutput output=new TranscoderOutput(pngStream);
		try {
			t.transcode(input, output);
			pngStream.flush();
		} catch (TranscoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
