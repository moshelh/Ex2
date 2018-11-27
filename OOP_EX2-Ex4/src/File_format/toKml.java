package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import GIS.GISElement;
import GIS.GIS_element;
import GIS.GisLayer;
import GIS.GisProject;

public class toKml {
//	public String s;
//	public GisLayer g11;
	
	//public csvData d1;
	
	public static void  projectToKml( GisProject project ,String output)
	{    Iterator pro=project.iterator();
	      
		ArrayList<String> content=new ArrayList<String>();
//	     
//		 csvData d1=new csvData(s);
//		 datatolayer l1=new datatolayer(d1);
//		 GisLayer g1=l1.insert();
//		 Iterator i1= g1.iterator();
		 
		String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>";
		content.add(KmlStart);
		String kmlend = " </Document>\n"+"</kml>";
		try {
			
			 FileWriter fw = new FileWriter(output);
			 BufferedWriter bw = new BufferedWriter(fw);
		        //for (int i = 1; i < g1.size(); i++) {
		        	//get index of each element in kml 
			 while(pro.hasNext()) {
				 GisLayer pr=(GisLayer) pro.next();
				 Iterator i1= pr.iterator();
			 while (i1.hasNext()) {
		         GISElement gis = (GISElement) i1.next();
		           String[]data=gis.getData().toString().split(",");
		            String kmlelement ="<Placemark>\n" +
	                    "<name>"+ data[0]+"</name>\n" +
		                    "<description>"+data[1]+"&"+data[2]+"</description>\n"+
		                    "<Point>\n"+
		                    "<coordinates>"+gis.getPoint().y()+"&"+gis.getPoint().x()+"&"+gis.getPoint().z()+"</coordinates>" +
		                    "</Point>\n" +
		                    "</Placemark>\n";
		            content.add(kmlelement);
		        }
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
	
	
	

public static void kmltoLayer(String s,String Output) {
	
		ArrayList<String> content=new ArrayList<String>();
//	     
		 csvData d1=new csvData(s);
		 datatolayer l1=new datatolayer(d1);
		 GisLayer g1=l1.insert();
		 Iterator i1= g1.iterator();
		 
		String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>";
		content.add(KmlStart);
		String kmlend = " </Document>\n"+"</kml>";
		try {
			
			 FileWriter fw = new FileWriter(Output);
			 BufferedWriter bw = new BufferedWriter(fw);
		        //for (int i = 1; i < g1.size(); i++) {
		        	//get index of each element in kml 
			
				
			 while (i1.hasNext()) {
		         GISElement gis = (GISElement) i1.next();
		           String[]data=gis.getData().toString().split(",");
		            String kmlelement ="<Placemark>\n" +
	                    "<name>"+ data[0]+"</name>\n" +
		                    "<description>"+data[1]+"&"+data[2]+"</description>\n"+
		                    "<Point>\n"+
		                    "<coordinates>"+gis.getPoint().y()+"&"+gis.getPoint().x()+"&"+gis.getPoint().z()+"</coordinates>" +
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

}


