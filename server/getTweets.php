<?php
include 'database.php';
$search_term=$_GET["term"];

echo $search_term;

$query='SELECT * FROM `cached_tweets` WHERE `text` LIKE CONVERT(_utf8 '$search_term' USING latin1) COLLATE latin1_general_ci';

$result=$mysqli->query($query);

if($result){
	while($row=$result->fetch_assoc()){	
		printf("%s,%s,%s,%s,%s,%s,%s,%s\n",$row['id'], $row['createdAt'], $row['retweetCount'], $row['latitude'], $row['longitude'], $row['user_id'], $row['user_name'], $row['text']);
	}
}

else{
	echo FAILURE;
	exit;
}




?>