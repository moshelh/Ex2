package File_format;

import java.util.HashSet;

import GIS.GISElement;
import GIS.GIS_element;
import GIS.GisLayer;

public class datatolayer {
	private csvData d;
	public datatolayer(csvData d1) {
		this.d=d1;
	}
	public GisLayer insert(){
		HashSet<GIS_element> Geom = new HashSet<GIS_element>();
		for(int i=1;i<d.getA1().size();i++) {
			GISElement g1=new GISElement(d,i);
			Geom.add(g1);
		}
		GisLayer l1=new GisLayer(Geom);
		return l1;
	}
	

}
