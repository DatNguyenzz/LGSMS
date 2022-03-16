(function($) {
    // Fill background img
    "use strict";
    var fullHeight = function() {

        $('.js-fullheight').css('height', $(window).height());
        $(window).resize(function() {
            $('.js-fullheight').css('height', $(window).height());
        });
    };
    fullHeight();


    // View password
    const togglePassword = document.querySelector("#togglePassword");
    const password = document.querySelector("#password");

    togglePassword.addEventListener("click", function() {
        // toggle the type attribute
        const type = password.getAttribute("type") === "password" ? "text" : "password";
        password.setAttribute("type", type);

    });
    // View password
    const re_togglePassword = document.querySelector("#re_togglePassword");
    const re_password = document.querySelector("#re_password");

    re_togglePassword.addEventListener("click", function() {
        // toggle the type attribute
        const type = re_password.getAttribute("type") === "password" ? "text" : "password";
        re_password.setAttribute("type", type);

    });
})(jQuery);