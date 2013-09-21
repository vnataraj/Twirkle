<?php
/*
 * addTweet - adds Tweet to SQL database
 * parameters - tweet id, created at(time), favorite count, latitude, longitude, user_id, user_name, text
 * returns - success/failure
 */
include 'database.php';
$id=$_GET["id"];
$createdAt=$_GET["createdAt"];
$retweetCount=$_GET["retweetCount"];
$latitude=$_GET["latitude"];
$longitude=$_GET["longitude"];
$user_id=$_GET["user_id"];
$user_name = $_GET["user_name"];
$text = $_GET["text"];

$result=$mysqli->query("INSERT INTO cached_tweets (id, createdAt, retweetCount, latitude, longitude, user_id, user_name, text) VALUES ('$id', '$createdAt', '$retweetCount', '$latitude', '$longitude', '$user_id', '$user_name', '$text')");

if($result==false){
	echo FAILURE;
	return false;
}
else{
	echo SUCCESS;
	return true;
}	
	
	
?>
	