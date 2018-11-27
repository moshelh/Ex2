package File_format;

import java.io.File;
import java.util.LinkedList;

import GIS.GisLayer;
import GIS.GisProject;

public class multi {
	public static GisLayer g1;
final static String output="C:\\CSVMULT";

static LinkedList<String> filenames = new LinkedList<String>();
public static void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            
			if(fileEntry.getName().contains(".csv"))
                filenames.add("C:\\Users\\ariel\\Desktop\\wig\\"+fileEntry.getName());
            	
        }
    }
   
}


public static void main(String[]args) {
	String output="C:\\CSVMULT\\test2";
	GisProject project=new GisProject();
	final File folder = new File("C:\\Users\\ariel\\Desktop\\wig");
	String n="C:\\Users\\ariel\\Desktop\\wig\\";
	listFilesForFolder(folder);
	System.out.println(filenames.toString());
	for(int i=0;i<filenames.size();i++) {
		 csvData d1=new csvData(filenames.get(i));
		 datatolayer l1=new datatolayer(d1);
		 GisLayer g1=l1.insert();
		 project.add(g1);
	//	 System.getProperty("user.dir");
		 
	}
	toKml. projectToKml(project, output);
	
	
}

}

