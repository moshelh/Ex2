package GIS;

import java.util.Arrays;

import Coords.MyCoords;
import File_format.csvData;
import Geom.Geom_element;
import Geom.Point3D;

public class GISElement implements GIS_element {
	csvData d1;
	private Geom_element g;
	int index;
	String[] s;
	Point3D p;
	MyCoords mycoords=new MyCoords();
	public GISElement(csvData d1,int index){
		this.d1=d1;
		this.index=index;
		s=d1.getLine(index);
		int indexX=d1.getIndexOfHeader("CurrentLatitude");
		int indexY=d1.getIndexOfHeader("CurrentLongitude");
		int indexZ=d1.getIndexOfHeader("AltitudeMeters");
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		
		this.p=new Point3D(x,y,z);
	
		
		
		
	}
	@Override
	//UNCLEAR!!!
	public Geom_element getGeom() {
		
		return g;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub
		MetaData m1=new MetaData(d1,index);
		return m1;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
	
		Point3D d=this.p;
		this.p=mycoords.add(this.p, vec);
		
		
	}
	public Point3D getPoint() {
		return this.p;
	}
	public String time() {
		String temp=this.d1.getElement("FirstSeen",this.index);
		temp=temp.replaceAll(" ","T");
		temp=temp+"Z";
		return temp;
		
	}
	


}
