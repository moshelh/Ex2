package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class toKml {
	public csvReader csv;
	public static void  toKml( String  s,String output)
	{
		ArrayList<String> content=new ArrayList<String>();
		ArrayList<String[]> data=csvReader.csvReader(s);

		String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>";
		content.add(KmlStart);
		String kmlend = " </Document>\n"+"</kml>";
		try {
			
			 FileWriter fw = new FileWriter(output);
			 BufferedWriter bw = new BufferedWriter(fw);
		        for (int i = 1; i < data.size(); i++) {
		            String[] s1 = data.get(i);
		            String kmlelement ="<Placemark>\n" +
		                    "<name>"+s1[1]+"</name>\n" +
		                    "<description>"+s1[0]+","+s1[2]+","+s1[3]+","+s1[4]+","+s1[9]+","+s1[10]+"</description>\n"+
		                    "<Point>\n"+
		                    "<coordinates>"+s1[7]+"&"+s1[6]+"&"+s1[8]+"</coordinates>" +
		                    "</Point>\n" +
		                    "</Placemark>\n";
		            content.add(kmlelement);
		        }
		        content.add(kmlend);
		        String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
		        csv=csv.replaceAll("&",",");
		        bw.write(csv);
		        bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	

	public static void main(String[] args) {
		// csvReader("C:\\Users\\User\\git\\Ex2-Ex4\\OOP_EX2-Ex4\\src\\File_format\\WigleWifi_20171201110209.csv");
		 //"C:\\Users\\User\\git\\Ex2-Ex4\\OOP_EX2-Ex4\\src\\File_format\\WigleWifi_20171201110209.csv";
		String s="C:\\Users\\User\\git\\Ex2-Ex4\\OOP_EX2-Ex4\\src\\File_format\\WigleWifi_20171203085618.csv";
		String s1="C:\\Users\\User\\git\\Ex2-Ex4\\OOP_EX2-Ex4\\src\\File_format\\test.kml";
		toKml(s,s1);
		
	}

}


