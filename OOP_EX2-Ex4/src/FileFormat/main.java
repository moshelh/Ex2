package FileFormat;

import java.io.File;
import java.util.Iterator;

import File_format.csvData;
import GIS.GIS_layer;
import Types.GisGame;
import Types.GisLayerf;
import Types.GisLayerp;

public class main {
	public static void main(String[] args) {
		
	
	//GisProject project=new GisProject();
	GisGame project=new GisGame();
  
    //running over the linkedlist , creating a csvData with a locaion  ,crating  a layer by calling layer to data and add the layer to the project . 
	
		 csvData d1=new csvData("C:\\Users\\moshe\\OneDrive\\Documents\\game_1543684662657.csv");
		 GisLayerf g1=null;
		 GisLayerp g2=null;
		 boolean flag1=false,flag2=false;
		 System.out.println(d1.getA1().size());

		       dataToLayerP l2=new dataToLayerP(d1);
				  g2=l2.insert();
				 // flag1=true;
			 dataToLayerF l1=new dataToLayerF(d1);

		       g1=l1.insert();
		      // flag2=true;
		
		
		// if (flag1)
	
		// if(flag2)
		 project.add(g1);
		 //first in last out
		 project.add(g2);

	Iterator<GIS_layer> pro=project.iterator();
	GIS_layer p=(GisLayerp) pro.next();
	System.out.println(p.get_Meta_data().toString());
	
	System.out.println("1");
	GIS_layer f=(GisLayerf) pro.next();
	System.out.println("2");
	 System.out.println(f.get_Meta_data().toString());
	 //if (flag1) {

	 //}
	  //if(flag2) {


	 
	 // }
	
	}
}
