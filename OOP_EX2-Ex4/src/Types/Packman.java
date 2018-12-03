package Types;

import Coords.MyCoords;
import File_format.csvData;
import GIS.GIS_element;
import GIS.MetaDataF;
import GIS.MetaDatap;
import GIS.Meta_data;
import Geom.Circle;
import Geom.Geom_element;
import Geom.Point3D;

public class Packman implements GIS_element{
	private Circle c;
	public csvData d;
	private int index;
	private String[] s;
	public String id;
	final int rad=3;
	private MetaDatap m1;
	private Point3D p;
	private double Speed;
	private double radiusOfeat;
	private MyCoords mm;
	int a=0;
	
	
	public Packman(csvData d1,int index) {
		this.d=d1;
		this.index=index;
		s=d1.getLine(index);
		int indexX=d1.getIndexOfHeader("Lat");
		int indexY=d1.getIndexOfHeader("Lon");
		int indexZ=d1.getIndexOfHeader("Alt");
		int indexOfid=d1.getIndexOfHeader("id");
		int indexOfspeed=d1.getIndexOfHeader("Speed/Weight");
		int indexOfradius=d1.getIndexOfHeader("Radius");
		this.Speed=Double.parseDouble(s[indexOfspeed]);
		this.radiusOfeat=Double.parseDouble(s[indexOfradius]);
		this.id=s[indexOfid];
		double x=Double.parseDouble(s[indexX]);
		double y=Double.parseDouble(s[indexY]);
		double z=Double.parseDouble(s[indexZ]);
		this.p=new Point3D(x,y,z);
		c= new Circle(this.p,rad);
		this.m1=new MetaDatap(d,index);
		this.mm=new MyCoords();
	}
	

	public double getSpeed() {
		return Speed;
	}


	public double getRadiusOfeat() {
		return radiusOfeat;
	}


	@Override
	public Geom_element getGeom() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub
		return  m1;
	}

	@Override
	public void translate(Point3D vec) {
		this.p=mm.add(p, vec);
		
	}

}
