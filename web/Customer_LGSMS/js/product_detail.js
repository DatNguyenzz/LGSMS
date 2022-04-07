/*js for product fallery*/

var productImg = document.getElementById("productImg");
var smallImage = document.getElementsByClassName("small-image");
smallImage[0].onclick = function() {
    productImg.src = smallImage[0].src;
}
smallImage[1].onclick = function() {
    productImg.src = smallImage[1].src;
}
smallImage[2].onclick = function() {
    productImg.src = smallImage[2].src;
}
smallImage[3].onclick = function() {
    productImg.src = smallImage[3].src;
}

/*js for product detail*/

function seeMore() {
    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("myBtn");

    if (dots.style.display === "none") {
        dots.style.display = "inline";
        btnText.innerHTML = "Xêm thêm";
        moreText.style.display = "none";
    } else {
        dots.style.display = "none";
        btnText.innerHTML = "Rút gọn";
        moreText.style.display = "inline";
    }
}