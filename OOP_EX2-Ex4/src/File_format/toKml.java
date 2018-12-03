package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import GIS.GISElement;
import GIS.GIS_element;
import GIS.GisLayer;
import GIS.GisProject;

public class toKml {
	/**
	 * the function convert each layer in the project to one kml page
	 * @param project to convert to kml.
	 * @param output to where to save the kml page.
	 */
	//source:was taken from the moodle
	public static void  projectToKml( GisProject project ,String output)
	
	{   //iterator for the project.
		Iterator pro=project.iterator();

	ArrayList<String> content=new ArrayList<String>();
	String KmlStart="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+" <Document>\n";
	content.add(KmlStart);
	String kmlend = " </Document>\n"+"</kml>";
	try {

		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		int counter=0;
		while(pro.hasNext()) {
			GisLayer pr=(GisLayer) pro.next();
			Iterator i1= pr.iterator();
			counter++;
			//creating a new folder for each layer
			String fold="<Folder>\n"+"<name>"+counter+"</name>\n";
			String endfold="</Folder>\n";
			content.add(fold);
			//running over the elements.
			while (i1.hasNext()) {
				GISElement gis = (GISElement) i1.next();
				String[]data=gis.getData().toString().split(",");

				String kmlelement ="<Placemark>\n" +
						"<name>"+ data[0]+"</name>\n" +
						"<TimeStamp>\n"+
						"<when>"+gis.time()+"</when>\n"+
						"</TimeStamp>\n"+
						"<description>"+data[1]+"&"+data[2]+"</description>\n"+
						"<Point>\n"+
						"<coordinates>"+gis.getPoint().y()+"&"+gis.getPoint().x()+"&"+gis.getPoint().z()+"</coordinates>" +
						"</Point>\n" +
						"</Placemark>\n";
				content.add(kmlelement);
			}
			content.add(endfold);
		}
        //for closing the kml
		content.add(kmlend);
		String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
		csv=csv.replaceAll("&",",");
		bw.write(csv);
		bw.close();
	} catch (Exception e) {
		// TODO: handle exception
	}

	}


	/**
	 * the function converts a layer to kml page.
	 * @param s is the location .
	 * @param Output to where to save the kml page.
	 */

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


