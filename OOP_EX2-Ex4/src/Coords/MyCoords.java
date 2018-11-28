package Coords;





import java.lang.reflect.Array;
import java.util.Arrays;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	//Earth radius.
 final double rErth = 6371000;

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		double lonNorm=Math.cos(gps.x()*(Math.PI/180));
		if(!isValid_GPS_Point(gps)) 
			return null;
		double x=Math.asin(local_vector_in_meter.x()/rErth)*(180/Math.PI)+gps.x();
		double y=Math.asin(local_vector_in_meter.y()/rErth*lonNorm)*(180/Math.PI)+gps.y();
		double z=gps.z()+local_vector_in_meter.z();
		if((x>90)||(x<-90)) {
			System.out.println("Invalid x");
			return null;
		}
		if(y>180) {
			y=((y+180)%360)-180;
			
		}
		 if(y<-180) {
			y=(y+180)+180;
			
		}
		
		Point3D negps = new Point3D (x,y,z);
		if(isValid_GPS_Point(negps))
			return negps;
		return null;
     	
		}
	

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		if(!isValid_GPS_Point(gps0)||!isValid_GPS_Point(gps1))
			return Double.MAX_VALUE;
		else {
			
		double lonNorm=Math.cos(gps0.x()*Math.PI/180);
		
		double diff_lat =gps1.x()-gps0.x();
		
		double diff_lon=gps1.y()-gps0.y();
		
		double diff_z=gps1.z()-gps0.z();
		
		double diff_radianlat=diff_lat*Math.PI/180;
		
		double diff_radianlon=diff_lon*Math.PI/180;
		
		double toMeterlat=Math.sin(diff_radianlat)*rErth;
		
		double toMeterlon=Math.sin(diff_radianlon)*lonNorm*rErth;
		
		return Math.sqrt(toMeterlat*toMeterlat+toMeterlon*toMeterlon);
		}
		
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		if(!isValid_GPS_Point(gps0)||!isValid_GPS_Point(gps1))
			return null;
		else {
		double lonNorm=Math.cos(gps0.x()*Math.PI/180);
		
		double diff_lat =gps1.x()-gps0.x();
		
		double diff_lon=gps1.y()-gps0.y();
		
		double diff_z=gps1.z()-gps0.z();
		
		double diff_radianlat=diff_lat*Math.PI/180;
		
		double diff_radianlon=diff_lon*Math.PI/180;
		
		double toMeterlat=Math.sin(diff_radianlat)*rErth;
		
		double toMeterlon=Math.sin(diff_radianlon)*lonNorm*rErth;

	    // Obtain vertical difference, too
	    double z   = gps1.z() - gps0.z();

	    return new Point3D(toMeterlat, toMeterlon, z);
	}
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		if(!isValid_GPS_Point(gps0)||!isValid_GPS_Point(gps1))
			return null;
		else {
		//**azimut***//
		double longps0 = Math.toRadians(gps0.y()); 
		double longps1 = Math.toRadians(gps1.y()); 
		double latgps0 = Math.toRadians(gps0.x()); 
		double latgps1 = Math.toRadians(gps1.x()); 
		double delta = longps1 - longps0;
		double left = Math.sin(delta)*Math.cos(latgps1);
		double right = Math.cos(latgps0)*Math.sin(latgps1)-Math.sin(latgps0)*Math.cos(latgps1)*Math.cos(delta);
		double	azimut = Math.atan2(left, right);
		//***distance***//
		double distance = distance3d(gps0,gps1);
		//***elevation***//
		azimut = Math.toDegrees(azimut);
		if(azimut<0) azimut+=360;
		double high = gps1.z() - gps0.z();
		double eleveation = Math.toDegrees(Math.asin(high/distance));
	
		double arr[] = {azimut,eleveation,distance};
		return arr;
		}
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if ((p.x()<-180 ||  p.x()>180) || (p.y()<-90 || p.y()>90) || (p.z()<-450 )) return false;
		return true;
	}
	public static void main(String[] args) {
		Point3D n1 = new Point3D (32.103315,35.209039,670);
		Point3D n2 = new Point3D (32.106352,35.205225,650);
		MyCoords m=new MyCoords();
		Point3D n3=m.vector3D(n1, n2);
		double[] d = m.azimuth_elevation_dist(n1, n2);
		System.out.println(Arrays.toString(d));
		System.out.println(n3);
	}


}
