package FileFormat;

import java.util.HashSet;

import File_format.csvData;
import GIS.GISElement;
import GIS.GIS_element;
import GIS.GisLayer;
import Types.GisLayerp;
import Types.Packman;

public class dataToLayerP {

	private csvData d;
	public dataToLayerP(csvData d1) {
		this.d=d1;
	}
	/**
	 *the function creating a Gis layer .
	 * @return a Gislayer.
	 */
	public GisLayerp insert(){
		HashSet<GIS_element> Geom = new HashSet<GIS_element>();
		
		//running over the data and creating the element .
		for(int i=1;i<d.getA1().size();i++) {
		
			if(d.getElement("Type", i).equals("P")) {
			//adding the element to the set .
				Packman g1=new Packman(d,i);
			       Geom.add(g1);
			}
		}
		GisLayerp layer=new GisLayerp(Geom);
		return layer;
	}
	

}