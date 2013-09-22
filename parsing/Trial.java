import java.io.InputStreamReader;
import java.net.URL;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import twitter4j.*;
//import twitter4j.TwitterStream;
//import twitter4j.TwitterStreamFactory;
import twitter4j.api.SearchResource;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;


public class Trial {
	static String gh = ""; 
	public static String getUserRequest() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the search term for twitter: ");
		return reader.next();
	}
	static Formatter x = null;
	public static void main (String [] args)
	{
		try
		{
				x = new Formatter("companies.txt");
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		//fetchURL("http://suggestor.naukri.com/search.php?q=a&app_id=1&suggestor=EMPLOYER&offset=0&limit=3");
		// ({"17":"Accenture Services Private Limited","29":"Airtel (Bharti Telecom) Private Limited","37":"Mphasis (An EDS Company)","CONTD...":"CONTD..."});
		//String g = "" + ({"17":"Accenture Services Private Limited","29":"Airtel (Bharti Telecom) Private Limited","37":"Mphasis (An EDS Company)","CONTD...":"CONTD..."});
		//manString()  
		char c = 97; 
		System.out.println(c);
		
			 fetchURL("http://twirkle.herobo.com/getTweets.php?term=art" );
			
		//printBreaks(gh);
		
		x.close();
	}
	public static void  fetchURL(String urlScanned) {
	    try {
	      URL url = new URL(urlScanned);
	      //System.out.println("urlscanned="+urlScanned+" url.path="+url.getPath() + "currentURL " + _currentURL);
	      
	      // open reader for URL
	      InputStreamReader in = new InputStreamReader(url.openStream());
	      
	      // read contents into string builder
	      StringBuilder input = new StringBuilder();
	      int ch; 
	      char charRead;  
	      
	      //  int count = 0 ; 
	      while ((ch = in.read()) != -1 ) {
	        input.append((char) ch); 
	        charRead = (char)ch; 
	        
	        
	        
	    
	            
	        }
	        //input = (char)in.read();  
	        //}
	        // input = (char)in.read();     
	    String s = makeHTML(); 
	   // String  s="";
	      int row = 0  ; 
	      int col = 0 ; 
	      String [] temp = input.toString().split(","); 
	      for(int i = 0 ; i < temp.length;i++){
	    	  if(temp[i].equals("0"))
	    	  {
	    		//  System.out.println(temp[i+1] + " " +temp[i+2]);
	    		 s+= " dataTable.setValue(" + row +"," +  0 +"," +  temp[i+1] + ");";
	    		  
	    		 s+= " dataTable.setValue(" + row +"," +  1 +"," +  temp[i+2] + ");";
	    		  s+=(" dataTable.setValue(" + row +"," +  2 +"," +  1+ ");"); 
	    		  s+=(" dataTable.setValue(" + row +"," +  3 +"," +  1 + ");"); 
	    		  row++;
	    		  
	    	  }
	    	   
	      } 
	     s+= makeEndHTML(); 
	      System.out.println(s);
	    // System.out.println(input.toString());
	       // manString(input.toString());
	     
	      gh += s;  
	      System.out.println(gh);
	    //  makeEnd();
	      } 
	      
	      
	   
	    
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    //return s; 
	  }  
	public static String makeHTML(){
		String s  = "<html>  <head> <script type='text/javascript' src='https://www.google.com/jsapi'></script> <script type='text/javascript'> google.load('visualization', '1', {'packages': ['geochart']}); google.setOnLoadCallback(drawMap); function drawMap() { var dataTable = new google.visualization.DataTable();dataTable.addRows(240);dataTable.addColumn('number', 'LATITUDE'); dataTable.addColumn('number', 'LONGITUDE');dataTable.addColumn('number', 'COLOR');dataTable.addColumn('number', 'SIZE'); ";
		return s;
	}
	public static String makeEndHTML(){
		String s  = "var options = { displayMode: 'markers',backgroundColor: {fill: 'white', stroke: 'white', strokeWidth: 1}, colors:['red','red'], datelessRegionColor:'gray',enableRegionInteractivity: true,markerOpacity: 0.5,keepAspectRatio: true,legend: 'none',magnifyingGlass: {enable: true, zoomFactor: 5.0},sizeAxis: {maxSize: 3, minSize: 1},    tooltip: {showColorCode: false}, zoomOutLabel:'-', showZoomOut:true  };               var container = document.getElementById('chart_div');        var chart = new google.visualization.GeoChart(container);        chart.draw(dataTable, options); var previousRegion,previousResolution; google.visualization.events.addListener(chart,'regionClick',function(clickData){previousRegion = options.region; previousResolution = options.resolution; options['region']=clickData.region; options['resolution'] = 'provinces'; options['zoomOutLabel'] = '-'; options['showZoomOut']=true; chart.draw(drawTable,options);}); google.visualization.events.addListener(chart,'zoomOut',function(){ options.region=previousRegion;options.resolution = previousResolution; chart.draw(drawTable,option);}); google.visualization.events.addListener(chart,'error',function(){ options.region = previousRegion; options.resolution = previousResolution; chart.draw(drawTable,options);});  }; function regionClick(){};  </script></head><body> <div id= "+ '"'+ "chart_div" +'"' + "  style= " +'"' + "width: 1200px; height: 640px;" +'"' +"></div></body></html>​";
		return s;
	}
	
	public static void printBreaks(String s){
		String [] d = s.split(";");
		for(int i = 0 ; i < d.length;i++)
				System.out.println(d[i]);
} 
	public static String makeBegin(){
		Scanner s = new Scanner(System.in); 
		System.out.println("String s = " + '"' + '"'); 
		
		String f = ""; 
		gh = "" ; 
		while(s.hasNext()){
			System.out.println(gh+=s.nextLine() + '\n');
			if(gh.contains("SIZE"))
				break;
		}
		System.out.println("hereads");
		System.out.println(gh); 
		
		return gh;
	}
	public static String makeEnd(){
		Scanner s = new Scanner(System.in);
		
		while(s.hasNext()){
			System.out.println(gh += s.nextLine());
		}
		return gh;
	}
}