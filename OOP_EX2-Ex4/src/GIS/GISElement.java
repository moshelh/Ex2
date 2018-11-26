package GIS;

import Coords.MyCoords;
import File_format.csvData;
import Geom.Geom_element;
import Geom.Point3D;

public class GISElement implements GIS_element {
	csvData d1;
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
		Point3D p2=new Point3D(x,y,z);
		this.p=p2;
		
		
		
	}
	@Override
	public Geom_element getGeom() {
		
		Geom_element g1=new Geom_Element(d1,index);
		return g1;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub
		Meta_data m1=new MetaData(d1,index);
		return m1;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		int indexX=d1.getIndexOfHeader("CurrentLatitude");
		int indexY=d1.getIndexOfHeader("CurrentLongitude");
		int indexZ=d1.getIndexOfHeader("AltitudeMeters");
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		Point3D t=new Point3D(x,y,z);
		this.p=mycoords.add(t, vec);
		
		
	}


}
