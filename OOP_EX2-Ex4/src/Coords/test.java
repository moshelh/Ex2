package Coords;

import Geom.Point3D;

public class test {
	public static void main(String[] args) {
		MyCoords m= new MyCoords();
		Point3D n1 = new Point3D (32.103315,35.209039,670);
		Point3D n2 = new Point3D (32.106352,35.205225,650);
		double d =m.distance3d(n1, n2);
		System.out.println(d);
	}


}
