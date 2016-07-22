<?php
	
	$servername = "127.0.0.1";
	$username = "Jolin";
	$password = "0000";
	$dbname = "db_report";
	$tablename = "info";

	try 
	{
	    $link = new mysqli($servername, $username, $password, $dbname);
	    $db = new PDO("mysql:host=".$servername.";dbname=".$dbname, $username, $password);
	    //echo wrong messenge 
	    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	}
	catch(PDOException $e)
	{
    	echo "Connection failed: " . $e->getMessage();
	}
?>