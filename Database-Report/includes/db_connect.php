<?php
	
	$servername = "domain_name";
	$username = "db_username";
	$password = "db_password";
	$dbname = "db_name";

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
