package Maps;


import java.awt.geom.*;


public class test {


	public static void main(String[] args) {
		Convert c =new Convert();
		Point2D P = new Point2D.Double(946,402);
		Point2D P1 = c.pixToCo(P) ;

		Point2D P2= new Point2D.Double(35.20896833217027, 32.10331682242991);
		Point2D P3 = c.conToPix(P2);

		System.out.println(P1);
		System.out.println(P3);
	}

}
