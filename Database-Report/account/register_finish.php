<?php session_start();

include("mysql_connect.inc.php");
header("Content-Type: text/html; charset=utf-8");
$userid = $_POST["userid"];
$result = mysqli_query($link,"SELECT * FROM book.account WHERE userid= '".$userid."'") or die(mysqli_error($link));
if(mysqli_num_rows($result)!=0){
	
	echo"此帳號已經有人註冊";
	header ("Location: register.php?registered= true& userid=".$_POST["userid"]);
	
} 
else {

//帳號尚未註冊
   
    
	$username = $_POST['username'];
    $psw = $_POST['psw'];
	$pw2 = $_POST['pw2'];
	$email = $_POST['email'];

if(mb_strlen($psw,'utf-8')>7 && mb_strlen($pw2,'utf-8')>7 && $psw==$pw2){
		$md5psw= md5($psw);
	    $md5pw2= md5($pw2);
	
    
    
	
//判斷帳號密碼是否為空值
//確認密碼輸入的正確性
        if($username != null)
        {
        //新增資料進資料庫語法
	 $stmt = $link->prepare("insert into account (username, userid, password, email) VALUES (?, ?, ?, ?)");
     $stmt->bind_param("ssss", $username, $userid, $md5psw, $email);
	 $stmt->execute();
	 
            
			if($stmt==true)
            {
			    
                echo '帳號註冊成功!';
				$_SESSION['userid']=$userid;
                echo '<meta http-equiv=REFRESH CONTENT=5;url=SignUp.html>';
            }
            else
            {
                echo '註冊失敗!';
                echo '<meta http-equiv=REFRESH CONTENT=2;url=register.php>';
            }
        }
        else
        {
        echo '你沒有輸入用戶名!';
        echo '<meta http-equiv=REFRESH CONTENT=2;url=register.php>';
        }
}


else{    if($psw==$pw2){
		echo"長度沒有到8個";
	     echo '註冊失敗!';
         echo '<meta http-equiv=REFRESH CONTENT=2;url=register.php>';
		
	}
        else{
	     echo "兩次輸入不一樣";
	    echo '註冊失敗!';
        echo '<meta http-equiv=REFRESH CONTENT=2;url=register.php>';
	}
	}
}
?>