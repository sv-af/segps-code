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
	    
	    var checkbox_value = "";
            $(":checkbox").each(function () {
                var ischecked = $(this).is(":checked");
                if (ischecked) {
                    checkbox_value += $(this).val();
                }
             });
            console.log(checkbox_value);

	    $.ajax({
                url: "PopulatingVulnerabilitiesServlet",
                type: "GET",
                data: {
                    vendor: vendor,
                    product: product,
                    version: version,
		    dependency: checkbox_value
                },
                cache: false,
                success: function(responseText) {
			if(checkbox_value === "dependency"){
				/*Visualization for RQ1*/
		   		if ($("#vRQ1").children().size() > 0) {
		        		$("#vRQ1").empty();
 		    		}
		    		if (responseText === "vRQ2"){
		    			$.getScript("js/RQ2.js");

                    			// Success message
                    			$('#successRQ1').html("<div class='alert alert-success'>");
                    			$('#successRQ1 > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;").append("</button>");
                    			$('#successRQ1 > .alert-success').append("<strong>Your message has been sent. </strong>");
                   			$('#successRQ1 > .alert-success').append('</div>');

                   	 		//clear all fields
                    			$('#vRQ1').trigger("reset");
				}else{
					// Fail message for RQ1
					$('#successRQ1').html("<div class='alert alert-danger'>");
                    			$('#successRQ1 > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;").append("</button>");
                    			$('#successRQ1 > .alert-danger').append("<strong>Something went wrong! <br> Please try again in some minutes.</strong>");
                    			$('#successRQ1 > .alert-danger').append('</div>');
                    			//clear all fields
                    			$('#vRQ1').trigger("reset");
				}
			} else{
				/*Visualization for RQ1*/
		   		if ($("#vRQ1").children().size() > 0) {
		        		$("#vRQ1").empty();
 		    		}
		    		if (responseText === "vRQ1"){
		    			$.getScript("js/RQ1.js");

                    			// Success message
                    			$('#successRQ1').html("<div class='alert alert-success'>");
                    			$('#successRQ1 > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;").append("</button>");
                    			$('#successRQ1 > .alert-success').append("<strong>Your message has been sent. </strong>");
                   			$('#successRQ1 > .alert-success').append('</div>');

                   	 		//clear all fields
                    			$('#vRQ1').trigger("reset");
				}else{
					// Fail message for RQ1
					$('#successRQ1').html("<div class='alert alert-danger'>");
                    			$('#successRQ1 > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;").append("</button>");
                    			$('#successRQ1 > .alert-danger').append("<strong>No vulnerabilities on this API <br> Please try again with different API.</strong>");
                    			$('#successRQ1 > .alert-danger').append('</div>');
                    			//clear all fields
                    			$('#vRQ1').trigger("reset");
				}
			}
		  
		   
                },
                error: function() {
		   	if ($("#vRQ1").children().size() > 0) {
		        		$("#vRQ1").empty();
 		    	}
                    	// Fail message for RQ1
                    	$('#successRQ1').html("<div class='alert alert-danger'>");
                    	$('#successRQ1 > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                       	  .append("</button>");
                    	$('#successRQ1 > .alert-danger').append("<strong>Something went wrong! <br> Please try again in some minutes.</strong>");
                    	$('#successRQ1 > .alert-danger').append('</div>');
                    	//clear all fields
                    	$('#vRQ1').trigger("reset");
		   		
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
