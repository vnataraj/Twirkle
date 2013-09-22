<?php
include 'database.php';
$search_term=$_GET["term"];

$query="SELECT longitude, latitude, user_name, text FROM cached_tweets WHERE text LIKE  '%$search_term%' ";

$result=$mysqli->query($query);

if($result){
	$i=0;
	echo '<html><head><script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type= "text/javascript">
google.load("visualization", "1", {"packages":["geochart"]});
google.setOnLoadCallback(drawMap);

function drawMap(){
	var dataTable=new google.visualization.DataTable();
	dataTable.addRows(400);
	dataTable.addColumn("number", "LATITUDE");
	dataTable.addColumn("number", "LONGITUDE");
	dataTable.addColumn("string", "DESCRIPTION");
	dataTable.addColumn("number", "VALUE");';
	while($row=$result->fetch_assoc()){	
		echo 'dataTable.setValue(';
		echo $i;
		echo ',';
		echo 0;
		echo ',';
		echo (float)$row['latitude'];
		echo ');';
		echo 'dataTable.setValue(';
		echo $i;
		echo ',';
		echo 1;
		echo ',';
		echo (float)$row['longitude'];
		echo ');';
		echo 'dataTable.setValue(';
		echo $i;
		echo ',';
		echo 2;
		echo ',';
		echo '"';
		echo (string)$row['user_name'];
		echo '"';
		echo ');';
		echo 'dataTable.setValue(';
		echo $i;
		echo ',';
		echo 3;
		echo ',';
		echo 1;
		echo');';
	  $i++;
	}
	echo'

var options = {
		displayMode: "markers",
		backgroundColor: {fill: "white", stroke: "white", strokeWidth: 1},
		colors: ["red", "red"],
		datalessRegionColor: "gray",
		enableRegionInteractivity: true,
		markerOpacity: 0.5,
		keepAspectRatio: true,
		legend: "none",
		magnifyingGlass: {enable: true, zoomFactor: 5.0},
		sizeAxis: {maxSize: 3, minSize: 1},
		tooltip: {showColorCode: false},
		zoomOutLabel: "-",
		showZoomOut: true
	};
      	
      	var container = document.getElementById("chart_div");
      	var chart = new google.visualization.GeoChart(container);
      	chart.draw(dataTable, options);

	var previousRegion, previousResolution;
	google.visualization.events.addListener(chart, "regionClick", function(clickData) {
		previousRegion = options.region;
		previousResolution = options.resolution;

    		options["region"] = clickData.region;
    		options["resolution"] = "provinces"; 
		options["zoomOutLabel"] = "-";
		options["showZoomOut"] = true;
    		chart.draw(dataTable, options);
	});
	google.visualization.events.addListener(chart, "zoomOu", function() {
		options.region = previousRegion;
    		options.resolution = previousResolution; 
    		chart.draw(dataTable, options);
	});
	google.visualization.events.addListener(chart, "error", function () {
    		// back out one region
    		options.region = previousRegion;
    		options.resolution = previousResolution; 
    		chart.draw(dataTable, options);		

	});

    };

    function regionClick() {

    };

  </script></head><body><div id="chart_div" style="width: 1200px; height: 640px;"</div></head></html>';
}

else{
	echo FAILURE;
	exit;
}
?>