<?php

	function draw_calendar($month,$year){

		require_once("db_connect.php");
		//表格的頭
		$calendar = '<table class="table table-hover">';

		//標題
		$headings = array('Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday');
		$calendar.= '<thead class="t-head"><tr><td>'.implode('</td><td>',$headings).'</td></tr>';

		//設定重要參數
		$running_day = date('w',mktime(0,0,0,$month,1,$year));//running_day 是本月1日星期幾的意思
		$days_in_month = date('t',mktime(0,0,0,$month,1,$year));//days_in_month 這個月有幾天
		$days_in_this_week = 0;//這周有幾天

		//第一周的table row
		$calendar.= '<tr class="calendar-row t-content">';

		//到每月1日前的空白天數
		for($x = 0; $x < $running_day; $x++):
			$calendar.= '<td class="calendar-day-np"></td>';
			$days_in_this_week++;
		endfor;

		//顯示每個月的天數
		for($list_day = 1; $list_day <= $days_in_month; $list_day++):
			//每個月的每個日期特有的時間戳。
			$timestamp = mktime(0,0,0,$month,$list_day,$year);
			//每天都用一個td包起來，裡面有check box
			$calendar.= '<td class="calendar-day"><input type="checkbox" name="reserve[]" value="'.$timestamp.'" class="filled-in box">';
			$calendar.='<div>';
			//設定每天的超連結參數，傳月份跟當天日期。
			$calendar.= '<a id="'.$timestamp.'" href="?month='.$month.'&day='.$list_day.'"" class="day-number">'.$list_day.'</a><br>';
			//依據時間選擇當天的活動(名稱)有哪些
			$sql = "SELECT title FROM info WHERE time = '".$timestamp."'" ;
			//印出活動名稱，可能一天有多個
			foreach($db->query($sql) as $title){
				$calendar.='<p class="day-event">'.$title['title'].'</p>';
			}
			//將td包起來
			$calendar.= '</div></td>';
			//當時間來到星期六，星期六是月曆每周的最後一天，也就是table row的結尾
			if($running_day == 6):
				//放上table row的結尾
				$calendar.= '</tr>';
				//如果還沒到這個月的最後一天，就加入下一周的表頭
				if( $list_day != $days_in_month):
					$calendar.= '<tr class="calendar-row t-content">';
				endif;
				//設-1是因為下面running day+1，這樣剛好抵銷變成0
				$running_day = -1;
				//把下一周的天數設為0
				$days_in_this_week = 0;
			endif;
			$days_in_this_week++;
			$running_day++;
		endfor;

		//如果最後一周的天數不夠七天，就補空白天數上去
		//最後一次會多加一次
		$days_in_this_week--;
				
		if($days_in_this_week < 7):
			for($x = 0; $x < (7 - $days_in_this_week); $x++):
				$calendar.= '<td class="calendar-day-np t-content"></td>';
			endfor;
		endif;

		//最後一周的table row 結尾
		$calendar.= '</tr>';

		//table最後的結尾
		$calendar.= '</table>';
		//回傳最後的結果到網頁上
		return $calendar;
	}
?>