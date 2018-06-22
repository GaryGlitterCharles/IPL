package ipl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CSVReader {

	public static void main(String[] args) {

		String csvFile = "deliveries.csv";
		String csvFile1 = "Matches.csv";
		
		BufferedReader br=null;
		BufferedReader br1=null;
		
		String line = "";
		String cvsSplitBy = ",";

		try {

			  br = new BufferedReader(new FileReader(csvFile));
			  br.readLine();
			  List<Delivery> deliveryList = new ArrayList<Delivery>();
			    while ((line = br.readLine()) != null) {
			     line = br.readLine();
			     String[] del = line.split(cvsSplitBy);
			     Delivery obj = new Delivery(Integer.parseInt(del[0]),
				   Integer.parseInt(del[1]), del[2], del[3], Integer.parseInt(del[4]), Integer.parseInt(del[5]), del[6], del[7],
				   Integer.parseInt(del[8]), Integer.parseInt(del[9]), Integer.parseInt(del[10]), Integer.parseInt(del[11]), Integer.parseInt(del[12]), Integer.parseInt(del[13]), Integer.parseInt(del[14]), Integer.parseInt(del[15]));
				   deliveryList.add(obj);				 
			   }
			
		    br1 = new BufferedReader(new FileReader(csvFile1));
	      br1.readLine();
	      List<Matches> matchList = new ArrayList<Matches>();
	     	  while ((line = br1.readLine()) != null) {
	        String[] del = line.split(cvsSplitBy);
	        Matches obj = new Matches(Integer.parseInt(del[0]),del[1],del[2],del[3],del[4],del[5],del[6],del[7],del[8],del[9]);
	        matchList.add(obj);
	        
	      }
	      
	      Set<String> teamName = new HashSet<String>();
	      List<Integer> matchIdDel = new ArrayList<Integer>();
	      List<Integer> matchId = new ArrayList<Integer>(); 
	      List<String> season = new ArrayList<String>();
	      List <Integer> serialNo = new ArrayList<Integer>();
			
	    	    
	      for(int i = 0; i< deliveryList.size() ; i++) 
	      {				
	          teamName.add(deliveryList.get(i).BATTING_TEAM);
	           matchIdDel.add(deliveryList.get(i).MATCH_ID);
	      }
	      for(int j=0; j<matchList.size();j++) 
	      {
	          matchId.add(matchList.get(j).MATCH_ID);
	          season.add(matchList.get(j).SEASON);
	      }
			
	      int startYear = 2008;
	      int endYear = 2017;
	      while (startYear <= endYear) 
	      {
	        for(int j=0; j<matchList.size();j++) 
	        {
	          if (String.valueOf(startYear).equals(matchList.get(j).SEASON)) 
	          {
			      serialNo.add(matchList.get(j).MATCH_ID);
	          }
			   }
			  
			  Iterator<String> it = teamName.iterator();
        while(it.hasNext())
        {
        String team = it.next();
          int fourCount = 0;
          int sixCount = 0;
          int totalScore = 0;
          
          for(int k = 0; k< deliveryList.size() ; k++) 
          {
              if(team.equals(deliveryList.get(k).BATTING_TEAM)) 
              {
                for (int serial : serialNo) 
                {
                    if(serial == deliveryList.get(k).MATCH_ID) 
                    {
                      totalScore += deliveryList.get(k).TOTAL_RUNS;
                      if(deliveryList.get(k).TOTAL_RUNS == 4)
                        fourCount ++;
                         if(deliveryList.get(k).TOTAL_RUNS == 6)
                         sixCount ++;
                    }
                }
              }
          
            
          }
         
          System.out.println(" Team : " + team + " Total Score : "+ totalScore + " Four : " + fourCount + " Six : " +  sixCount + " Year : " +startYear);
         
        }
        startYear++;
		}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
