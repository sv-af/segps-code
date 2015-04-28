// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

// Highlight the top nav as scrolling occurs
$('body').scrollspy({
    target: '.navbar-fixed-top'
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
});



// form submit and validation
$("input,textarea").jqBootstrapValidation({
        preventSubmit: true,
        submitError: function($form, event, errors) {
            // additional error messages or events
        },
        submitSuccess: function($form, event) {
            event.preventDefault(); // prevent default submit behaviour
            // get values from FORM
            var vendor = $("input#vendor").val();
            var product = $("input#product").val();
            var version = $("input#version").val();
	
            $.ajax({
                url: "PopulatingVulnerabilitiesServlet",
                type: "GET",
                data: {
                    vendor: vendor,
                    product: product,
                    version: version
                },
                cache: false,
                success: function(responseText) {
		    /*Visualization for RQ2*/
		   
		   	if ($("#vRQ2").children().size() > 0) {
		        	$("#vRQ2").empty();
 		    	}
		    	if (responseText.indexOf("vRQ2") !=-1){
		    		$.getScript("js/RQ2.js");

                    		// Success message
                    		$('#successRQ2').html("<div class='alert alert-success'>");
                    		$('#successRQ2 > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                      			.append("</button>");
                    		$('#successRQ2 > .alert-success')
                        		.append("<strong>Your message has been sent. </strong>");
                   		$('#successRQ2 > .alert-success')
                       		 	.append('</div>');

                   	 	//clear all fields
                    		$('#vRQ2').trigger("reset");
		    	}
		
                },
                error: function() {
                    	// Fail message for RQ2
                    	$('#successRQ2').html("<div class='alert alert-danger'>");
                    	$('#successRQ2 > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                       	  .append("</button>");
                    	$('#successRQ2 > .alert-danger').append("<strong>Something went wrong! <br> Please try again in some minutes.</strong>");
                    	$('#successRQ2 > .alert-danger').append('</div>');
                    	//clear all fields
                    	$('#vRQ2').trigger("reset");
		
                },
            })
        },
        filter: function() {
            return $(this).is(":visible");
        },
    });

    $("a[data-toggle=\"tab\"]").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
    });
