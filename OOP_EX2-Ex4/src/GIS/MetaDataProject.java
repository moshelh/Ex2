package GIS;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Geom.Point3D;

public class MetaDataProject implements Meta_data {
	/**
	 * meta data for the all project.
	 */
	static final long duration =(long)(((120*60))*1000);
	private String time=new SimpleDateFormat("yyyy-dd-MM hh:mm:ss").format(Calendar.getInstance().getTime());
	/**
	 * return the time the project was created
	 */
	@Override
	public long getUTC() {
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
			java.util.Date dt;
			try {
				dt = df.parse(this.time);
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
		String metaData="the project was created in : "+this.time;
		return metaData;
		
	}

}
