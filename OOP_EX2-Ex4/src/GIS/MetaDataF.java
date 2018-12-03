package GIS;

import java.text.SimpleDateFormat;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import File_format.csvData;
import Geom.Point3D;

public class MetaDataF  implements Meta_data{
public String timeF;
public int indexOfElement;
public csvData d;
public String []s;

static final long duration =(long)(((120*60))*1000);

public MetaDataF(csvData d,int index) {
       this.d=d;
   this.indexOfElement=index;
	  this.s=d.getLine(index);

//	  this.s=d.getLine(index);
//	  this.header=d.getHeader();
	   
	  
}

	@Override
	public long getUTC() {
		// TODO Auto-generated method stub
		String time = timeF;                              
        SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
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
	public String toString() {
	
		int indexD=d.getIndexOfHeader("id");
		int indexT=d.getIndexOfHeader("Type");
		return s[indexD]+","+s[indexT];
}
}
