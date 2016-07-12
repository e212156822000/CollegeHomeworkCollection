jQuery(document).ready(function($){

	//CHANGE ME!!! Define the relative or absolute path to your backend script
	var remoteUrl = '/database/jquery-calendar/backend.php';
	
	//Initialize the HTTP cache
	var remoteCache = new Array();
	
	//For each link in the calendar...
	$('table.calendar a').each(function(i,item){
		
		//Unique ID for the link
		var linkId = item.id;
		
		//Unique URL for the link
		var linkUrl = remoteUrl+'?timestamp='+linkId;
		
		//Attach onclick event handler
		$(this).click(function(){		
			var calendarEvents = $('#calendar-events');			
			calendarEvents.slideUp('fast',function(){			
				if( remoteCache[linkId] != undefined ) { 
					calendarEvents.html(remoteCache[linkId]);
					calendarEvents.slideDown('fast');
				} else {
					calendarEvents.load(linkUrl,function(){
						remoteCache[linkId] = calendarEvents.html();
						calendarEvents.slideDown('fast');
					});
				}
			});
			return false;
		});
		
	});
	
});