<?php
	include('includes/calendar.php');
	session_start();
 	if(!isset ($_SESSION['userid'])){
		header ('location: account/nologin.php');
	}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>預約教室系統</title>
	<!-- 最新編譯和最佳化的 CSS -->
    <!-- Material Design fonts -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-material-design.css">
    <link rel="stylesheet" href="css/book.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <!-- 最新編譯和最佳化的 JavaScript -->
    <script src="scripts/jquery-1.11.3.min.js"></script>
    <script src="scripts/material.min.js"></script>
    <script src="scripts/ripples.min.js"></script>
    

	<style type="text/css" media="screen">
		.day-number{
			float:left;
		}
	</style>
	</head>
	<body>
	    <div class="container">
	    <div class="row">
	        <div class="col-sm-12 pad visible-xs"></div>
	    </div>
	    <div class="row">
	        <div class="col-sm-2">
	            <div class="dropdown">
	              <button class="btn btn-info dropdown-toggle btn-raised" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
	                管二 017
	                <span class="caret"></span>
	              </button>
	              <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
	                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
	                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
	                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
	                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
	              </ul>
	            </div>
	        </div>
	        <div class="col-sm-offset-3 col-sm-3">
	            <?php
	            	//先查看網址後面是否有參數。
	            	if(isset($_GET["month"])){
						$currentM = $_GET["month"];
					}else{
						//沒有參數的話就抓現在時間的月份
						$currentM = date('n');
					}
					//因為稍後月份會做運算，方面比較起見先備分
					$temp = $currentM;
					//若已經到了一月，他的前一月仍會顯示一月
					if($currentM != 1){
						$temp = $currentM - 1;
					}
					//設定前一月的超連結參數
		            echo '<a href="?month='.$temp.'" class="btn btn-info btn-raised">前一月</a>';
		            //重新賦值給$temp，因為$temp剛剛做過運算了
		            $temp = $currentM;
		            //若已經到了十二月，他的下一月仍會顯示十二月
		            if($currentM != 12){
		            	$temp = $currentM + 1;
		            }
		            //設定下一月的超連結參數
		            echo '<a href="?month='.$temp.'" class="btn btn-info btn-raised">下一月</a>';
		       	?>
	        </div>
	    </div>
	    <form method="post" action="reserve.php">
		    <div class="row better-chinese">
		        <div class="col-sm-4  center-block">
		            <div class="panel panel-default">
		                <div class="panel-body" >
		                    <div class="row center-block">
		                        <div class="col-sm-4 general-color">一般借用</div>
		                        <div class="col-sm-4 fix-color">學期固定</div>
		                        <div class="col-sm-4 waiting-color">待審核</div>
		                    </div>
		                </div>
		            </div>
		        </div>
		        <div class="col-sm-offset-7 col-sm-1">
		        	<button type="submit" class="btn-raised btn btn-info " id="reserve">預約</button>
		        </div>
		    </div>
		    <div class="row space">
		        <div class="col-sm-12">
		            <div class="panel panel-primary">
		                <div class="panel-heading">
		                    <h2 class="panel-title">
		                    <?php
		                    	//為了讓使用者提交表單後，還能回到之前月份的頁面，於是傳現在的月份參數到表單去
		                    	echo '<input type="hidden" name="month" value="'.$currentM.'" >';
			                    //把現在$currentM轉變為英文字的月份，讓標題跟著月份動態顯示
			                    $dateObj   = DateTime::createFromFormat('!m', $currentM);
								$monthName = $dateObj->format('F');
								echo $monthName."  ".date('Y');
		                    ?>
		                    </h2>
		                </div>
		                <div class="panel-body">
		          			<?php echo draw_calendar($currentM,date('Y')); ?>
		          		</div>
		            </div>
				</div>
			</div>
		</form>
		<div id="calendar-events">
		<?php
			//testing to catch each days var
			if (isset($_GET["day"])){
		 		echo "You select Day".$_GET["day"];
			}
		?>
		</div>
	</body>
</html>