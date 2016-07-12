<?php
/**
 * Draw Calendar
 *
 * @param	int		$month	One-digit integer of current month (ie. 1, 2, 3...12)
 * @param	int		$year	Four-digit integer of current year	 (ie. 2009)
 * @author	David Walsh
 * @link 	http://davidwalsh.name/php-calendar
 *
 * PLEASE NOTE:
 *
 * I added lines 47 - 56 to add a unique id to each hyperlink for each day.
 */
function draw_calendar($month,$year){

	/* draw table */
	$calendar = '<table cellpadding="0" cellspacing="0" class="calendar">';

	/* table headings */
	$headings = array('Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday');
	$calendar.= '<tr class="calendar-row"><td class="calendar-day-head">'.implode('</td><td class="calendar-day-head">',$headings).'</td></tr>';

	/* days and weeks vars now ... */
	$running_day = date('w',mktime(0,0,0,$month,1,$year));
	$days_in_month = date('t',mktime(0,0,0,$month,1,$year));
	$days_in_this_week = 1;
	$day_counter = 0;
	$dates_array = array();

	/* row for week one */
	$calendar.= '<tr class="calendar-row">';

	/* print "blank" days until the first of the current week */
	for($x = 0; $x < $running_day; $x++):
		$calendar.= '<td class="calendar-day-np"> </td>';
		$days_in_this_week++;
	endfor;

	/* keep going with days.... */
	for($list_day = 1; $list_day <= $days_in_month; $list_day++):
		$calendar.= '<td class="calendar-day">';
			
			/**
			 * Assign a unique id to the day number. This unique id will be
			 * used by jQuery to locate events from the database that are
			 * on this day. The unique id is the timestamp for the first minute
			 * of $list_day of $month of $year.
			 *
			 * @author Josh Lockhart, http://www.newmediacampaigns.com, lines 40-41
			 */
			$timestamp = mktime(0,0,0,$month,$list_day,$year);
			$calendar.= '<div class="day-number"><a id="'.$timestamp.'" href="#">'.$list_day.'</a></div>';
			
		$calendar.= '</td>';
		if($running_day == 6):
			$calendar.= '</tr>';
			if(($day_counter+1) != $days_in_month):
				$calendar.= '<tr class="calendar-row">';
			endif;
			$running_day = -1;
			$days_in_this_week = 0;
		endif;
		$days_in_this_week++; $running_day++; $day_counter++;
	endfor;

	/* finish the rest of the days in the week */
	if($days_in_this_week < 8):
		for($x = 1; $x <= (8 - $days_in_this_week); $x++):
			$calendar.= '<td class="calendar-day-np"> </td>';
		endfor;
	endif;

	/* final row */
	$calendar.= '</tr>';

	/* end the table */
	$calendar.= '</table>';
	
	/* all done, return result */
	return $calendar;
}
?>