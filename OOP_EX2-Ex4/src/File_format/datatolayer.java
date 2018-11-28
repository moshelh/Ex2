package File_format;

import java.util.HashSet;

import GIS.GISElement;
import GIS.GIS_element;
import GIS.GisLayer;
/**
 * datatolayer class which has csvData , and convert each data into element and creating a Gis layer.
 * @author ariel and moshe.
 *
 */
public class datatolayer {
	private csvData d;
	public datatolayer(csvData d1) {
		this.d=d1;
	}
	/**
	 *the function creating a Gis layer .
	 * @return a Gislayer.
	 */
	public GisLayer insert(){
		HashSet<GIS_element> Geom = new HashSet<GIS_element>();
		//running over the data and creating the element .
		for(int i=1;i<d.getA1().size();i++) {
			GISElement g1=new GISElement(d,i);
			//adding the element to the set .
			Geom.add(g1);
		}
		GisLayer layer=new GisLayer(Geom);
		return layer;
	}
	

}
