package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class csvReader {
	public  static ArrayList<String[]> csvReader(String S){
			String csvFile = S;
	        String line = "";
	        String cvsSplitBy = ",";
	        ArrayList<String[]> data=new ArrayList<String[]>();
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
	        {   br.readLine();
	            
	        	
	            while ((line = br.readLine()) != null) 
	            {
	                String[] userInfo = line.split(cvsSplitBy);
	                data.add(userInfo);
	                System.out.println(Arrays.toString(userInfo));
	               // System.out.println("Mac Adress: " + userInfo[0] + " , SSID: " + userInfo[1] +
	                	//	" AuthMode " + userInfo[2] + " Firtseen " + userInfo[3] );
                  
	            }
	            

	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
return data;
	}
	
}