package GIS;

import File_format.csvData;

public class test {
	
public static void main(String[] args) {
		
		String s="C:\\Users\\ariel\\git\\Ex2-Ex4\\OOP_EX2-Ex4\\src\\File_format\\WigleWifi_20171203085618.csv";
		csvData d1=new csvData(s);
		MetaData m1=new MetaData(d1,5);
	
		long f=m1.getUTC();
		System.out.println(f);
}
}
