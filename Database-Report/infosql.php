<?php
    require("includes/db_connect.php");
    session_start();
    if(!isset ($_SESSION['userid'])){
        header ('location: account/nologin.php');
    }
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Thanks For Your Submission!</title>
</head>
<style>
    .container {
        font-family: "微軟正黑體";
        border: 1.5px solid white;
        border-radius: 10px;
        margin: 50px 10% 0px 10%;
        padding: 10px 40px;
        background: rgba(0, 0, 0, 0.5);
        color: white;
    }
    
    body {
        background: url(img/paint-1280557_1920.jpg);
    }
</style>

<body>
    <div class="container">
        <h1>謝謝您的提交</h1>
        <h3>我們會盡快審核您的借用！</h3>
    </div>
    <?php
     //連接Mysql資料庫
     //資料庫位置, 用戶名稱, 密碼, 資料庫名稱
     $dbc = mysqli_connect($servername, $username, $password, $dbname)
          or die ('Unable to connect to database.');
     if(isset($_POST['title']) && isset($_POST['name']) && isset($_POST['email']) && isset($_POST['department']) && isset($_POST['professor']) && isset($_POST['message'])  && isset($_POST['time'])){
         $title = $_POST['title'];
         $name = $_POST['name'];
         //$classroom = $_POST['classroom'];
         $email = $_POST['email'];
         $department = $_POST['department'];
         $professor = $_POST['professor'];
         $message = $_POST['message'];
         $time = $_POST['time'];
         for($i=0; $i < count($time); $i++){
             $query = "INSERT INTO info (title,name,email,department, professor,message,time)" . "VALUES ('".$title."', '".$name."', '".$email."', '".$department."', '".$professor."', '".$message."','".$time[$i]."')";
             //  下指令
             $result = mysqli_query($dbc, $query)
             or die("Error: " . $query . "<br>" . mysqli_error($dbc));
        }
     }
    
     //關閉資料庫
     mysqli_close($dbc);
     if(isset($_POST['month'])) $url = $_POST['month'];
     echo '<meta http-equiv="refresh" content="0; URL=frontend.php?month='.$_POST['month'].'">';
    ?>

</body>

</html>