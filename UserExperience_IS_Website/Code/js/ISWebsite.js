$(document).ready(function(){
	var $slider = $('.slider'); // class or id of carousel slider
	var $slide = 'li';//$('.slide'); // could also use 'img' if you're not using a ul
	var $transition_time = 1000; // 1 second
	var $time_between_slides = 3000; // 4 seconds

	function slides(){
		return $slider.find($slide);
	}

	slides().fadeOut();

	// set active classes
	slides().first().addClass('active');
	slides().first().fadeIn($transition_time);

	// auto scroll 
	$interval = setInterval(
			function(){
				var $i = $slider.find($slide + '.active').index();

				slides().eq($i).removeClass('active');
				slides().eq($i).fadeOut($transition_time);

				if (slides().length == $i + 1) $i = -1; // loop to start

				slides().eq($i + 1).fadeIn($transition_time);
				slides().eq($i + 1).addClass('active');
			}
			, $transition_time +  $time_between_slides 
	);
});

$('a[href*=#]:not([href=#])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') 
        || location.hostname == this.hostname) {

        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
           if (target.length) {
             $('html,body').animate({
                 scrollTop: target.offset().top
            }, 1000);
            return false;
        }
    }
});

//$('#hoveringButton').click(function(){
//    $('html, body').animate({
//      scrollTop: $("#events").offset().top
//    }, 800);
//});


//$(document).ready(function(){
//	$('#hoveringButton').click(function(){
//	    $('html, body').animate({
//	      scrollTop: $("#events").offset().top
//	    }, 800);
//	});
//});

/*$(document).ready(function(){
	$("#hoveringButton").click(function() {
		$('html,body').animate({
			scrollTop: $("#events").offset().top},
			800);
	});
})*/

$(document).ready(function(){
	$("#technicalCources").show();
    $("#managementCources").hide();
    $("#dataScienceCources").hide();
    $("#webDevelopmentCources").hide();
    
	$("#techCourse").click(function(){
        $("#technicalCources").show();
        $("#managementCources").hide();
        $("#dataScienceCources").hide();
        $("#webDevelopmentCources").hide();
    });
    $("#manCourse").click(function(){
    	$("#technicalCources").hide();
        $("#managementCources").show();
        $("#dataScienceCources").hide();
        $("#webDevelopmentCources").hide();
    });
    $("#dsCourse").click(function(){
    	$("#technicalCources").hide();
        $("#managementCources").hide();
        $("#dataScienceCources").show();
        $("#webDevelopmentCources").hide();
    });
    $("#webDevCourse").click(function(){
    	$("#technicalCources").hide();
        $("#managementCources").hide();
        $("#dataScienceCources").hide();
        $("#webDevelopmentCources").show();
    });
});