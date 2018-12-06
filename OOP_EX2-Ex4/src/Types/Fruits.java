package Types;

import Coords.MyCoords;
import File_format.csvData;
import GIS.GIS_element;
import GIS.MetaData;
import GIS.MetaDataF;
import GIS.Meta_data;
import Geom.Circle;
import Geom.Geom_element;
import Geom.Point3D;

public class Fruits implements GIS_element {
	private Circle c;
	public csvData d;
	private int index;
	private String[] s;
	private String id;
	final int rad=1;
	private MetaDataF m1;
	Point3D p;
	public Fruits(csvData d1,int index){
		System.out.println("F");
		this.d=d1;
		this.index=index;
		s=d1.getLine(index);
		int indexX=d1.getIndexOfHeader("Lat");
		int indexY=d1.getIndexOfHeader("Lon");
		int indexZ=d1.getIndexOfHeader("Alt");
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		int indexOfid=d1.getIndexOfHeader("id");
		this.id = s[indexOfid];
		this.p=new Point3D(x,y,z);
		c= new Circle(this.p,rad);
		this.m1=new MetaDataF(d,index);
	}

	@Override
	public Geom_element getGeom() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub

		return m1;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub

	}


}
