package Types;

import File_format.csvData;
import GIS.Meta_data;
import Geom.Point3D;

public class MetaDataLayerf implements Meta_data {
	
	
	@Override
	public long getUTC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
	
		return "F";
}

}
