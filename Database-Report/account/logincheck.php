
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<?php
	require("../includes/db_connect.php");
	session_start();
	$printuserid= $_POST['userid'];
	$printpassword=$_POST["psw"];
	$md5password= md5($printpassword);
	if(isset ($printuserid) &&isset($printpassword)){
	$result = mysqli_query($link,"select * from account where userid='".$_POST["userid"]."'") or die("帳密不正確");
	$row=mysqli_fetch_assoc($result);
	$userid=($row['userid']);
	$password=($row['password']);
	$username=($row['username']);
	$_SESSION['username']=$username;
}
	 
if( $md5password==$password) {
	$printuserid = $userid;
	$_SESSION['userid']=$printuserid;
	echo"密碼正確 等待跳轉";
	header ("refresh:3;URL= '../frontend.php'");
} else {
	echo "帳號或密碼不正確，請重新登入，等待跳轉";
	header ("refresh:5; URL='SignUp.html'");
}

?>
	 