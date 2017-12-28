jQuery(document).ready(function () {
    'use strict';
//============================== PRE LOADER =============================================
    $(window).load(function () {
        $(".page-loader").fadeOut();
    });

//============================== SELECT BOX =========================
    $('.select-drop').selectbox();

//============================== HEADER =========================

    $('.navbar a.dropdown-toggle').on('click', function (e) {
        var elmnt = $(this).parent().parent();
        if (!elmnt.hasClass('nav')) {
            var li = $(this).parent();
            var heightParent = parseInt(elmnt.css('height').replace('px', '')) / 2;
            var widthParent = parseInt(elmnt.css('width').replace('px', '')) - 10;

            if (!li.hasClass('open')) {
                li.addClass('open');
            }
            else {
                li.removeClass('open');
                $(this).next().css('top', heightParent + 'px');
                $(this).next().css('left', widthParent + 'px');
            }

            return false;
        }
    });

    //============================== ALL DROPDOWN ON HOVER =========================
    if ($('.navbar').width() > 1007) {
        $('.nav .dropdown').hover(function () {
                $(this).addClass('open');
            },
            function () {
                $(this).removeClass('open');
            });
    }


//============================== BOOTSTRA THUMBNAIL SLIDER =========================
    (function () {
        $('#thubmnailSlider').carousel({interval: 3000});
    }());

    (function () {
        $('.thumbnailCarousel .item').each(function () {
            var itemToClone = $(this);
            var i = 1;
            if ($(window).width() <= 767) {
                for (i = 1; i < 1; i++) {
                    itemToClone = itemToClone.next();

                    if (!itemToClone.length) {
                        itemToClone = $(this).siblings(':first');
                    }

                    itemToClone.children(':first-child').clone()
                        .addClass('cloneditem-' + (i))
                        .appendTo($(this));
                }
            } else if ($(window).width() <= 991) {
                for (i = 1; i < 2; i++) {
                    itemToClone = itemToClone.next();

                    if (!itemToClone.length) {
                        itemToClone = $(this).siblings(':first');
                    }

                    itemToClone.children(':first-child').clone()
                        .addClass('cloneditem-' + (i))
                        .appendTo($(this));
                }
            } else {
                for (i = 1; i < 3; i++) {
                    itemToClone = itemToClone.next();

                    if (!itemToClone.length) {
                        itemToClone = $(this).siblings(':first');
                    }

                    itemToClone.children(':first-child').clone()
                        .addClass('cloneditem-' + (i))
                        .appendTo($(this));
                }
            }

        });
    }());
//============================== DATE-PICKER =========================

    $('.datepicker').datepicker({
        startDate: 'dateToday',
        autoclose: true
    });


//============================== CLOSE BUTTON =========================
    $('.close-btn').click(function () {
        $(this).parent().hide();
    });
});