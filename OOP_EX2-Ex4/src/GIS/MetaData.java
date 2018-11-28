package GIS;

import java.text.SimpleDateFormat;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import File_format.csvData;
import Geom.Point3D;

public class MetaData implements Meta_data{
	public long date;
	public String []s;
	public String[] header;
	public int indexOfElement;
	public csvData d1;
	
	
	static final long duration =(long)(((120*60))*1000);

  public MetaData(csvData d,int index) {
         this.d1=d;
     this.indexOfElement=index;
	  this.s=d.getLine(index);
	  this.header=d.getHeader();
	   
	  
  }
  /**
   * the function returns the the utc. 
   */
    @SuppressWarnings("deprecation")
	@Override
	public long getUTC()  {
		   int index=d1.getIndexOfHeader("FirstSeen");
			String time = s[index];                              
//			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy hh:mm");//without seconds!!doesnt read!
			SimpleDateFormat df = new SimpleDateFormat("yyy-dd-MM hh:mm:ss");
			java.util.Date dt;
			try {
				dt = df.parse(time);
				Long l = dt.getTime()+duration;
				return l;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                                      
			
		return -1;
	}
	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	public   String toString() {
		String s2="";
		
		 int indexS=d1.getIndexOfHeader("SSID");
		int indexC=d1.getIndexOfHeader("Channel");
		int indexA=d1.getIndexOfHeader("AccuracyMeters");
		int indexT=d1.getIndexOfHeader("Type");
		
		 s2=s[indexS]+","+s[indexA]+","+s[indexT];
		return s2;
		
	}
	

}
