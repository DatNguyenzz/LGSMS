$(document).ready(function(){

    $('#itemslider').carousel({ interval: 3000 });
    
    $('.carousel-showmanymoveone .item').each(function(){
    var itemToClone = $(this);
    
    for (var i=1;i<6;i++) {
    itemToClone = itemToClone.next();
    
    if (!itemToClone.length) {
    itemToClone = $(this).siblings(':first');
    }
    
    itemToClone.children(':first-child').clone()
    .addClass("cloneditem-"+(i))
    .appendTo($(this));
    }
    });
    });
    
    $(function () {
        $("*[include-html]").each(function () {
            var t = $(this).attr("include-html"),
            u = this.id;
            jQuery.ajax({
                url: t, success: function (t) { $("#" + u).html(t) }, error: function (n, c, i) {
                    var s = n.status + ": " + n.statusText;
                    $("#" + u).html(t + "-" + s);
                }
            });
        });
    });