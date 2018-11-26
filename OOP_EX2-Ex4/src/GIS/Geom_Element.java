package GIS;

import File_format.csvData;
import Geom.Geom_element;
import Geom.Point3D;

public class Geom_Element implements Geom_element {
	csvData d1;
	int index;
	String []s;
	public Geom_Element(csvData d1,int index) {
		this.d1=d1;
		this.index=index;
		this.s=d1.getLine(index);

		
		
	}
	@Override
	public double distance3D(Point3D p) {
		int indexX=d1.getIndexOfHeader("CurrentLatitude");
		int indexY=d1.getIndexOfHeader("CurrentLongitude");
		int indexZ=d1.getIndexOfHeader("AltitudeMeters");
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		
		Point3D p1=new Point3D(x,y,z);
	
	double ans=p1.distance3D(p);
		return ans;
	}
	@Override
	public double distance2D(Point3D p) {
		// TODO Auto-generated method stub
		int indexX=d1.getIndexOfHeader("CurrentLatitude");
		int indexY=d1.getIndexOfHeader("CurrentLongitude");
		int indexZ=d1.getIndexOfHeader("AltitudeMeters");
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		
		Point3D p1=new Point3D(x,y,z);
		double ans=p1.distance2D(p);
		
		return ans;
	}
	
}
