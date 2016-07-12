<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<title>member register</title>

<style>
        header, nav, section, article, footer 
        {
            display: block;
        }
        header, nav, section, article, footer
        {
            font-family: cursive;
            text-align: center;
            color: white;
            border-radius: 10px;
        }
        header, footer
        {
            width: 100%;
        }
        header
        {
            background-color: steelblue;
            height: 50px;
            font-size: 30px;
        }
        nav
        {
            position: fixed;
            top:68px;
            right: 20px;
            background-color: darkgray;
            width: 50%;
            height: 520px;
        }
        section
        {
            height: 600px;
            width: 90%;
            background-color: lightblue;
            padding: 10px;
            margin: 10px;
            font-size: 20px;
        }
        footer
        {
            background-color: steelblue;
            height:30px; 
            font-size: 15px;
            font-weight:bold;
        }
        p1
        {
            position:absolute;
            top:-5px;
            left:125px;
        }
        p2
        {
            position:absolute;
            top:90px;
            left:180px;
        }
        p3
        {
            position:absolute;
            top:90px;
            left:-5px;
        }
        p4
        {
            position:absolute;
            top:90px;
            right:-10px;
        }
        
     </style> 
</head>


<body>
<center>
<?php if(isset($_GET["registered"])){ echo'帳號'.$_GET["userid"]."已經有人使用";} ?>
</center>


    <section>
        <article>
            <img src="https://goo.gl/LM21hO" height="220">
			<header>  
        註冊為會員 
    </header> 
</br>
<form name="form1" method="POST" action="register_finish.php" onsubmit="return check_form();"  >
使用者名稱：<input type="text" name="username" placeholder="english or number is ok" /> <br>

建立帳號：<input type="text" name="userid" placeholder="english or number is ok" /> <br>
建立密碼：<input type="password" name="psw" placeholder="english or number is ok" /> <br>
再一次輸入密碼：<input type="password" name="pw2" placeholder="confirm yor password" /> <br>
email：<input type="email" name="email" size="30" /> <br>
<input type="submit" name="join"  value="加入會員" style="width:250px;height:30px;border:1px white none;background-color:steelblue;
                          font-family:cursive;font-size:15px;font-weight:bold;color:white;"/>

</form>
</article>
    </section> 
<script type="text/javascript"> 

function check_form() {
	var username =document.form1.username.value;
	if(username=="") {
		alert("請輸入姓名!");
	return false;
	}
	
	var userid =document.form1.userid.value;
	if(userid=="") {
		alert("請輸入帳號!");
		return false;
	}
	var psw =document.form1.psw.value;
	var pw2 =document.form1.pw2.value;
	if(psw=="") {
		alert("請輸入密碼!");
		return false;
	}
	for(var i=0; i<psw.length; i++){
		if(psw.charAt(i)==" " || psw.charAt(i)=="\""){
			alert("不可以空白或含雙引號!");
			return false;
		}
	}
	if(psw.length<8){
		alert("密碼最少8個字元，包含大小寫和數字");
		return false;
	}
	if(psw!=pw2){
		alert("您輸入的兩次密碼不一樣哦!");
		return false;
	}
	var email =document.form1.email.value;
	if(email=="") {
		alert("請輸入email!");
	return false;
	}
	return confirm("確定送出?");
}
</script>
</body>
</html>


