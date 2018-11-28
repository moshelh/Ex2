package GIS;



import java.io.File;
import java.io.IOException;

import File_format.csvData;
import File_format.toKml;

public class test {
	
public static void main(String[] args) {
		
		String s="C:\\Users\\ariel\\git\\Ex2-Ex4\\WigleWifi_20171201110209.csv";
		csvData d1=new csvData(s);
		String S= d1.getRaw("SSID");
		System.out.println(S);
//		MetaData m1=new MetaData(d1,5);
//	
//		long f=m1.getUTC();
//		System.out.println(f);
//		String r=d1.getElement("FirstSeen",5);
//		String d=d1.getElement("SSID",5);
//		System.out.println(r);
//		System.out.println(d);
//		System.out.println(s);
//	File file=new File("WigleWifi_20171203085618.csv");
//	String path;
//
//		path = file.getAbsolutePath();
//		System.out.println(path);
		//
//		toKml.kmltoLayer(path,"C:\\Users\\ariel\\Desktop\\Ex2");//only in the project 
	
	
//	csvData d1=new csvData("C:\\Users\\ariel\\git\\Ex2-Ex4\\WigleWifi_20171201110209.csv");
//	String s=d1.getElement("FirstSeen",2);
//	System.out.println(s);
}
	

}
