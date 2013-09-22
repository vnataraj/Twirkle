<?php
	$DB_HOST = "mysql16.000webhost.com";
	$DB_TABLE = "a8969646_tweets";
	$DB_USER = "a8969646_twirkle";
	$DB_PASS = "tw1rkle";

  // Create connection
  $mysqli=mysqli_connect($DB_HOST,$DB_USER,$DB_PASS,$DB_TABLE);

  // Check connection
  if (mysqli_connect_errno($mysqli)) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    exit;
  }
  //define some constants
  define("FAILURE", "-1\n");
  define ("SUCCESS", "1\n");
?>