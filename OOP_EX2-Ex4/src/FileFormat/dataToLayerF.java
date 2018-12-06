package FileFormat;

import java.util.HashSet;

import File_format.csvData;
import GIS.GISElement;
import GIS.GIS_element;
import GIS.GisLayer;
import Types.Fruits;
import Types.GisLayerf;

public class dataToLayerF {

	private csvData d;
	public dataToLayerF(csvData d1) {
		this.d=d1;
	}
	/**
	 *the function creating a Gis layer .
	 * @return a Gislayer.
	 */
	public GisLayerf insert(){
		HashSet<GIS_element> Geom = new HashSet<GIS_element>();
		
		//running over the data and creating the element .
		for(int i=1;i<d.getA1().size();i++) {
			if(d.getElement("Type", i).equals("F")) {
			//adding the element to the set .
				Fruits g1=new Fruits(d,i);

			       Geom.add(g1);
		}
		}
		GisLayerf layer=new GisLayerf(Geom);
		return layer;
	}
}


