package File_format;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import FileFormat.dataToLayerF;
import FileFormat.dataToLayerP;
import GIS.GisLayer;
import GIS.GisProject;
import Types.GisGame;
import Types.GisLayerf;
import Types.GisLayerp;


public class multi {
	
final static String output="C:\\CSVMULT";

static LinkedList<String> filenames = new LinkedList<String>();
/**
 * the function reads a multi csv pages from the folder .
 * @param folder is a location to start searching .
 */
//the source:https://stackoverflow.com/questions/28236098/how-to-read-multiple-csv-files-from-a-folder-in-java
public static void listFilesForFolder(final File folder) {
	//running over the files , if there is a csv file , add the path to filenamse linkedList.
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            
			if(fileEntry.getName().contains(".csv")) {
				File file=new File(fileEntry.getName());
				String path=file.getAbsolutePath();
				filenames.add(path);
              //  filenames.add("C:\\Users\\ariel\\git\\Ex2-Ex4\\"+fileEntry.getName());
			}
            	
        }
    }
   
}


public static void main(String[]args) {
	// definding a file where to save the kml of the project.
	String output="C:\\CSVMULT\\test11.kml";
	//GisProject project=new GisProject();
	GisGame project=new GisGame();
	final File folder = new File("C:\\Users\\ariel\\git");
    listFilesForFolder(folder);
    //running over the linkedlist , creating a csvData with a locaion  ,crating  a layer by calling layer to data and add the layer to the project . 
	for(int i=0;i<filenames.size();i++) {
		 csvData d1=new csvData(filenames.get(i));
		 dataToLayerF l1=new dataToLayerF(d1);
		 dataToLayerP l2=new dataToLayerP(d1);
		 GisLayerf g1=l1.insert();
		 GisLayerp g2=l2.insert();
		 
		 project.add(g1);
		 project.add(g2);
	 
	}
	Iterator pro=project.iterator();
	
	

	//after finishing running , send the project to kml ,and create one kml file for all the project. 
	//toKml. projectToKml(project, output);
	
	
}

}