jQuery(document).ready(function($){
	
				  
	
	// back to top button
	jQuery.fn.scrollToTop = function(options) {
        var config = {
            "speed" : 800
        };

        if (options) {
            jQuery.extend(config, {
                "speed" : options
            });
        }

        return this.each(function() {

            var $this = $(this);

            jQuery(window).scroll(function() {
                if ($(this).scrollTop() > 100) {
                    $this.fadeIn();
                } else {
                    $this.fadeOut();
                }
            });

            $this.click(function(e) {
                e.preventDefault();
                $("body, html").animate({
                    scrollTop : 0
                }, config.speed);
            });

        });
    };
	jQuery(function() {
        jQuery("#toTop").scrollToTop(1000);
    });
	


// Scrolls to the selected menu item on the page
	jQuery(function() {
	  jQuery('.wpm_menu li a[href*=#]:not([href=#])').click(function() {
	   if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
		var target = $(this.hash);
		target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
		if (target.length) {
		 $('html,body').animate({
		  scrollTop: target.offset().top
		 }, 2000);
		 return false;
		}
	   }
	  });
	 });
	}); // Jquery document ready ends