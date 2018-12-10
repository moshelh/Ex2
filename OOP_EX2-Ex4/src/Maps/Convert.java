package Maps;

import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Convert {
  private Point2D p1;
  private Point2D p2;
  private Point2D p3;
   final Point2D c2=new Point2D.Double(35.20238,32.10190);
   final Point2D c3=new Point2D.Double(35.21236,32.10569);
   public static BufferedImage myImage; 
   public Convert()
   {
		try {
			 myImage = ImageIO.read(new File("C:\\Users\\moshe\\eclipse-workspace\\test\\src\\test\\myImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
   public static double normalize(double value, double min, double max) {
	    return Math.abs((value - min) / (max - min));
	}
   public Point2D pixToCo(Point2D p) {
	   double y=0;
	   double xPercent=normalize(p.getX(),0,myImage.getWidth());
	   double x =xPercent*Math.abs(c3.getX()-c2.getX())+c2.getX();
	   double yPercent=normalize(p.getY(),0,myImage.getHeight());
	   if (yPercent>=0.5) {
		    y=yPercent*Math.abs(c3.getY()-c2.getY())+c2.getY();
		  
		   double eps=c3.getY()-y;
		  
		   y=c2.getY()+eps;
		  
	   }
	   else if(yPercent<0.5)
	   {
		    y=yPercent*Math.abs(c3.getY()-c2.getY())+c2.getY();
		   double eps=y-c2.getY();
		   y=c3.getY()-eps;
		   
	   }
	  
	   return new Point2D.Double(x,y);
   }
   public Point2D conToPix(Point2D p) {
	   double y=0;
	   double xPercent=normalize(p.getX(),c2.getX() , c3.getX());
	   double x =xPercent*Math.abs(myImage.getWidth()-0);
	   double yPercent = normalize(p.getY(), c2.getY(), c3.getY());
	   if (yPercent>=0.5) {
		   y=yPercent*Math.abs(myImage.getHeight());
		   double eps = myImage.getHeight() - y;
		   y= eps;
	   }else if(yPercent<0.5) {
		   y=yPercent*Math.abs(myImage.getHeight());
		   double eps =  y;
		   y=myImage.getHeight()- eps;
	   }
	   return new Point2D.Double(x,y);
   }
   


   
   

}
