package GIS;



import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import File_format.csvData;
import File_format.toKml;

public class test {
	
public static void main(String[] args) {
		
		String s="C:\\Users\\ariel\\git\\Ex2-Ex4\\WigleWifi_20171201110209.csv";
		csvData d1=new csvData(s);
		MetaData m1=new MetaData(d1,5);
		long f=m1.getUTC();
		System.out.println(f);

int b=0;
}
	

}
