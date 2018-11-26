package File_format;
import java.util.ArrayList;

import Geom.Point3D;

public class csvData {
	
	private csvReader c;
	String[] header;
	ArrayList<String[]> a1;
	
	public csvData(String s) {
		a1=c.csvReader(s);
		header=a1.get(0);
	}

	public String[] getHeader() {
		return header;
	}

	public ArrayList<String[]> getA1() {
		return a1;
	}
	
public String getRaw(String s) {
	int index=0;
	String ans="";
	for(int i=0;i<this.header.length;i++) {
		if(this.header[i].equals(s))
			index=i;
	}
	for(int i=0;i<a1.size();i++) {
		ans+=a1.get(i)[index]+",";
	}
	return ans;
}
public String[] getLine(int i) {
	return a1.get(i);
}
public String getElement(String s,int index) {
	int temp=0;
	for(int i=0;i<this.header.length;i++) {
		if(this.header[i].equals(s))
			temp=i;
	}
	return a1.get(index)[temp];
}
public int getIndexOfHeader(String s) {
	int index=0;
	for(int i=0;i<this.header.length;i++) {
		if(this.header[i].equals(s))
			index=i;
	}return index;
}
//public Point3D getP(int index) {
//	
//}

	
}