(function($) {
    
    "use strict";

        //Hide Loading Box (Preloader)
        function handlePreloader() {
            if($('.preloader').length){
                $('.preloader').delay(200).fadeOut(500);
            }
        }   

        //Update Scroll to Top
        function headerStyle() {
          if($('.main-header').length){
            var mainHeader = $('.main-header').height();
            var windowpos = $(window).scrollTop();
            if (windowpos >= 200) {
              $('.bounce-in-header').addClass('now-visible');
              $('.scroll-to-top').fadeIn(300);
            } else {
              $('.bounce-in-header').removeClass('now-visible');
              $('.scroll-to-top').fadeOut(300);
            }
          }
        }
        
        headerStyle();        
        
        //Submenu Dropdown Toggle
        if($('.main-header li.dropdown ul').length){
          $('.main-header li.dropdown').append('<div class="dropdown-btn"></div>');
          
          //Dropdown Button
          $('.main-header li.dropdown .dropdown-btn').on('click', function() {
            $(this).prev('ul').slideToggle(500);
          });
        } 

        
  
        //Revolution Slider Style One
        if($('.main-slider.default-style .tp-banner').length){

          jQuery('.main-slider.default-style .tp-banner').show().revolution({
            delay:10000,
            startwidth:1200,
            startheight:720,
            hideThumbs:720,
            thumbWidth:80,
            thumbHeight:50,
            thumbAmount:5,
            navigationType:"bullet",
            navigationArrows:"0",
            navigationStyle:"preview3",
        
            touchenabled:"on",
            onHoverStop:"off",
        
            swipe_velocity: 0.7,
            swipe_min_touches: 1,
            swipe_max_touches: 1,
            drag_block_vertical: false,
        
            parallax:"mouse",
            parallaxBgFreeze:"on",
            parallaxLevels:[7,4,3,2,5,4,3,2,1,0],
        
            keyboardNavigation:"off",
        
            navigationHAlign:"center",
            navigationVAlign:"bottom",
            navigationHOffset:0,
            navigationVOffset:40,
        
            soloArrowLeftHalign:"left",
            soloArrowLeftValign:"center",
            soloArrowLeftHOffset:20,
            soloArrowLeftVOffset:0,
        
            soloArrowRightHalign:"right",
            soloArrowRightValign:"center",
            soloArrowRightHOffset:20,
            soloArrowRightVOffset:0,
        
            shadow:0,
            fullWidth:"on",
            fullScreen:"off",
        
            spinner:"spinner4",
        
            stopLoop:"off",
            stopAfterLoops:-1,
            stopAtSlide:-1,
        
            shuffle:"off",
        
            autoHeight:"off",
            forceFullWidth:"on",
        
            hideThumbsOnMobile:"on",
            hideNavDelayOnMobile:1500,
            hideBulletsOnMobile:"on",
            hideArrowsOnMobile:"on",
            hideThumbsUnderResolution:0,
        
            hideSliderAtLimit:0,
            hideCaptionAtLimit:0,
            hideAllCaptionAtLilmit:0,
            startWithSlide:0,
            videoJsPath:"",
            fullScreenOffsetContainer: ""
          });
          
        }
        
        //Testimonials Two Column
        if ($('.testimonial').length) {
            $('.testimonial').owlCarousel({
                loop:true,
                margin:50,
                nav:false,
                smartSpeed: 500,
                autoplay: 5000,
                navText: [ '<span class="fa fa-angle-double-left"></span>', '<span class="fa fa-angle-double-right"></span>' ],
                responsive:{
                    0:{
                        items:1
                    },
                    600:{
                        items:1
                    },
                    1024:{
                        items:2
                    },
                    1200:{
                        items:2
                    }
                }
            });         
        }


        //testimonial Carousel Three Column //
        if ($('.testimonial-2').length) {
            $('.testimonial-2').owlCarousel({
                loop:true,
                margin:50,
                nav:false,
                dots:true,
                smartSpeed: 500,
                autoplay: 5000,
                responsive:{
                    0:{
                        items:1
                    },
                    600:{
                        items:1
                    },
                    1024:{
                        items:1
                    },
                    1200:{
                        items:1
                    }
                }
            });
        }

    
        //offer Three Column
        if ($('.offer-col').length) {
            $('.offer-col').owlCarousel({
                loop:true,
                margin:50,
                nav:true,
                smartSpeed: 500,
                autoplay: 5000,
                
                navText: [ '<span class="fa fa-angle-double-left"></span>', '<span class="fa fa-angle-double-right"></span>' ],
                responsive:{
                    0:{
                        items:1
                    },
                    600:{
                        items:2
                    },
                    992:{
                        items:3
                    },
                    1024:{
                        items:3
                    },
                    1199:{
                        items:3
                    },
                    1200:{
                        items:3
                    }
                }
            });         
        }


        //shop-col Four Column
        if ($('.shop-col').length) {
            $('.shop-col').owlCarousel({
                loop:true,
                margin:50,
                nav:false,
                smartSpeed: 500,
                autoplay: 5000,
                navText: [ '<span class="fa fa-angle-double-left"></span>', '<span class="fa fa-angle-double-right"></span>' ],
                responsive:{
                    0:{
                        items:1
                    },
                    600:{
                        items:3
                    },
                    1024:{
                        items:4
                    },
                    1199:{
                        items:4
                    },
                    1200:{
                        items:4
                    }
                }
            });         
        }


        //shop-col Four Column
        if ($('.list-event-slider').length) {
            $('.list-event-slider').owlCarousel({
                loop:true,
                margin:50,
                nav:true,
                dots:false,
                smartSpeed: 500,
                autoplay: 5000,
                navText: [ '<span class="fa fa-angle-left"></span>', '<span class="fa fa-angle-right"></span>' ],
                responsive:{
                    0:{
                        items:1
                    },
                    600:{
                        items:1
                    },
                    1024:{
                        items:1
                    },
                    1199:{
                        items:1
                    },
                    1200:{
                        items:1
                    }
                }
            });         
        }


        /* ---------------------------------------------
         * flex slider
         *--------------------------------------------- */
        $(window).on('load', function() {
            $('.flexslider').flexslider({
                controlsContainer: $(".custom-controls-container"),
                customDirectionNav: $(".custom-navigation a"),
                controlNav: false,
            });
        });

        $(window).on('load', function () {
            $('.portfolio-slider').flexslider({
                animation: "slide",
                direction: "vertical",
                slideshowSpeed: 3000,
                start:function(){
                    imagesLoaded($(".portfolio"),function(){
                        setTimeout(function(){
                            $('.portfolio-filter li:eq(0) a').trigger("click");
                        },500);
                    });
                }
            });
        });

        $(window).on('load', function () {
            $('.portfolio-slider-alt').flexslider({
                animation: "slide",
                direction: "horizontal",
                slideshowSpeed: 4000,
                start:function(){
                    imagesLoaded($(".portfolio"),function(){
                        setTimeout(function(){
                            $('.portfolio-filter li:eq(0) a').trigger("click");
                        },500);
                    });
                }
            });
        });

        $(window).on('load', function () {
            $('.post-slider-thumb').flexslider({
                animation: "slide",
                controlNav: "thumbnails"
            });
        });

        $(window).on('load', function() {
            $('.post-slider').flexslider({
                animation: "slide"
            });
        });

        $(window).on('load', function() {
            $('.news-slider').flexslider({
                animation: "slide",
                slideshowSpeed: 3000
            });
        });


        /* ---------------------------------------------
         portfolio filter set active class
         --------------------------------------------- */

        $('.portfolio-filter li').on('click', function (event) {
            $(this).siblings('.active').removeClass('active');
            $(this).addClass('active');
            event.preventDefault();
        });


        /* ---------------------------------------------
         isotope | init Isotope
         --------------------------------------------- */

        var $container = $(".portfolio:not(.portfolio-masonry)");
        if ($.fn.imagesLoaded && $container.length > 0) {
            imagesLoaded($container, function () {
                setTimeout(function(){
                    $container.isotope({
                        itemSelector: '.portfolio-item',
                        layoutMode: 'fitRows',
                        filter: '*'
                    });

                    $(window).trigger("resize");
                    // filter items on button click
                },500);

            });
        }

        /* ---------------------------------------------
         portfolio masonry
         --------------------------------------------- */

        $(window).on('load', function() {

            var $c = $('.portfolio-masonry');
            if(typeof imagesLoaded == 'function') {
                imagesLoaded($c, function () {

                    setTimeout(function () {
                        $c.isotope({
                            itemSelector: '.portfolio-item',
                            resizesContainer: false,
                            layoutMode: 'masonry',
                            filter: "*"
                        });
                    }, 500);

                });
            }

        });



        /* ---------------------------------------------
         portfolio gallery
         --------------------------------------------- */


        $('.portfolio-gallery').each(function () { // the containers for all your galleries
            $(this).find(".popup-gallery").magnificPopup({
                type: 'image',
                gallery: {
                    enabled: true
                }
            });
            
            $(this).find(".popup-gallery2").magnificPopup({
                type: 'image',
                gallery: {
                    enabled: true
                }
            });
        });


        /* ---------------------------------------------
         portfolio filtering
         --------------------------------------------- */

        $('.portfolio-filter').on('click', 'a', function () {
            $('#filters button').removeClass('current');
            $(this).addClass('current');
            var filterValue = $(this).attr('data-filter');
            $(this).parents(".portfolio-filter-item").next().isotope({filter: filterValue});
        });

         /* ---------------------------------------------
         popup link
         --------------------------------------------- */


        $('.popup-link').magnificPopup({
            type: 'image'
            // other options
        });


        // This slick script use for client //
        if($('.carousel').length){
            $('.carousel').slick({
            infinite: true,
            slidesToShow: 5,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 2000,
            responsive: [
                {
                  breakpoint: 1200,
                  settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    infinite: true,
                    dots: false,
                  }
                },
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    infinite: true,
                    dots: false,
                  }
                },
                {
                  breakpoint: 991,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 750,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 500,
                  settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                  }
                }
                // You can unslick at a given breakpoint now by adding:
                // settings: "unslick"
                // instead of a settings object
              ]
            });

        }


         /* ---------------------------------------------
         carousel
         --------------------------------------------- */
        if($.fn.owlCarousel) {
            $("#owl-slider").owlCarousel({
                autoPlay: 4000, //Set AutoPlay to 3 seconds
                items : 1,
                navigation : true,
                //pagination : false,
                navigationText:["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
            });


            $("#img-carousel").owlCarousel({
                autoPlay: 3000, //Set AutoPlay to 3 seconds
                items : 4,
                itemsDesktop : [1199,3],
                itemsDesktopSmall : [979,3]

            });

            $("#portfolio-carousel").owlCarousel({
                autoPlay: 3000, //Set AutoPlay to 3 seconds
                items : 3,
                itemsDesktop : [1199,3],
                itemsDesktopSmall : [979,3],
                navigation : true,
                pagination : false,
                navigationText:["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]

            });

            $("#portfolio-carousel-alt").owlCarousel({
                autoPlay: false, //Set AutoPlay to 3 seconds
                items : 3,
                itemsDesktop : [1199,3],
                itemsDesktopSmall : [979,3],
                navigation : true,
                pagination : false,
                navigationText:["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
            });
        }

        $(".portfolio-with-title").addClass("portfolio");


        /* ---------------------------------------------
        accordion
        ---------------------------------------------- */

        var allPanels = $(".accordion > dd").hide();
            allPanels.first().slideDown("easeOutExpo");
            $(".accordion").each(function () {
                $(this).find("dt > a").first().addClass("active").parent().next().css({display: "block"});
            });

        $(".accordion > dt > a").on('click', function () {

            var current = $(this).parent().next("dd");
            $(this).parents(".accordion").find("dt > a").removeClass("active");
            $(this).addClass("active");
            $(this).parents(".accordion").find("dd").slideUp("easeInExpo");
            $(this).parent().next().slideDown("easeOutExpo");

            return false;

        });


        /* ---------------------------------------------------------------------------
        * Paralex Backgrounds
        * --------------------------------------------------------------------------- */
        
        var ua = navigator.userAgent,
            isMobileWebkit = /WebKit/.test(ua) && /Mobile/.test(ua);
            if( ! isMobileWebkit && jQuery(window).width() >= 768 ){
                $.stellar({
                horizontalScrolling : false,
                responsive          : true
            });
        }

        /* ---------------------------------------------------------------------------
        * Paralex Backgrounds
        * --------------------------------------------------------------------------- */
        
        if (typeof stellar !== 'undefined' && $.isFunction(stellar)) {
            var ua = navigator.userAgent,
            isMobileWebkit = /WebKit/.test(ua) && /Mobile/.test(ua);

        if( ! isMobileWebkit && jQuery(window).width() >= 768 ){

            if( window.wpt_parallax == 'stellar' ){

                // Stellar
                jQuery.stellar({
                horizontalScrolling : false,
                responsive          : true
                });

                } else {

                    // Enllax
                    jQuery(window).enllax();

                }

            } else {

                jQuery('.section[data-enllax-ratio], .section[data-stellar-ratio]').css( 'background-attachment' , 'scroll' );

                }
        }


        //LightBox / Fancybox start
        if($('.lightbox-image').length) {
            $('.lightbox-image').fancybox({
                openEffect  : 'elastic',
                closeEffect : 'elastic',
                helpers : {
                    media : {}
                }
            });
        }
        //LightBox / Fancybox end



        // filter-price
        if ($('#filter-price').length) {
            $("#filter-price").slider({
                ticks: [0, 100, 200, 300, 400],
                ticks_labels: ['$0', '$100', '$200', '$300', '$400'],
                ticks_snap_bounds: 30
            });
        }
        


        // scroll to Top end
        if($('.scroll-to-target').length){
            $(".scroll-to-target").on('click', function() {
              var target = $(this).attr('data-target');
               // animate
               $('html, body').animate({
                 scrollTop: $(target).offset().top
               }, 1000);

            });
        }
        /*------------------------------------------
        = FUNFACT
        -------------------------------------------*/  
        if ($(".fun-fact").length) {

            $('.counter').appear();

            $(document.body).on('appear', '.counter', function(e) {
                var $this = $(this),
                countTo = $this.attr('data-count');

                $({ countNum: $this.text()}).animate({
                    countNum: countTo
                }, {
                    duration: 3000,
                    easing:'linear',
                    step: function() {
                        $this.text(Math.floor(this.countNum));
                    },
                    complete: function() {
                        $this.text(this.countNum);
                    }
                });
            });
        }    
      
        //Progress Bar / Levels
        if($('.progress-levels .progress-box .bar-fill').length){
            $(".progress-box .bar-fill").each(function() {
                var progressWidth = $(this).attr('data-percent');
                $(this).css('width',progressWidth+'%');
                $(this).children('.percent').html(progressWidth+'%');
            });
        }

    /* ==========================================================================
    When document is Scrollig, do
    ========================================================================== */
  
    $(window).on('scroll', function() {
        headerStyle();
    });

    /* ==========================================================================
    When document is loading, do
    ========================================================================== */

    $(window).on('load', function() {
        handlePreloader();
    });

    /* ==========================================================================
    contact form ajax
    ========================================================================== */

    $('.cf-msg').hide();
    $('form#cf button#submit').on('click', function() {
        var fname = $('#fname').val();
        var subject = $('#subject').val();
        var email = $('#email').val();
        var msg = $('#msg').val();
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (!regex.test(email)) {
            alert('Please enter valid email');
            return false;
        }

        fname = $.trim(fname);
        subject = $.trim(subject);
        email = $.trim(email);
        msg = $.trim(msg);

        if (fname != '' && email != '' && msg != '') {
            var values = "fname=" + fname + "&subject=" + subject + "&email=" + email + " &msg=" + msg;
            $.ajax({
                type: "POST",
                url: "mail.php",
                data: values,
                success: function() {
                    $('#fname').val('');
                    $('#subject').val('');
                    $('#email').val('');
                    $('#msg').val('');

                    $('.cf-msg').fadeIn().html('<div class="alert alert-success"><strong>Success!</strong> Email has been sent successfully.</div>');
                    setTimeout(function() {
                        $('.cf-msg').fadeOut('slow');
                    }, 4000);
                }
            });
        } else {
            $('.cf-msg').fadeIn().html('<div class="alert alert-danger"><strong>Warning!</strong> Please fillup the informations correctly.</div>')
        }
        return false;
	});


})(window.jQuery);

