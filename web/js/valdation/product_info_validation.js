// Lấy input
let x = 0;
const form = document.getElementById('form');
const price = document.getElementById('product-price');
const pname = document.getElementById('product-name');

//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 2) {
        alertFunction();
    }
});


//Trim input và các thông báo form add
const validateInputs = () => {
    const priceValue = price.value.trim();
    const pnameValue = pname.value.trim();
    //Thông báo nhập tên sản phẩm
    if (pnameValue === '') {
        setError(pname, 'Yêu cầu nhập tên sản phẩm');
    }else {
        setSuccess(pname);
    }
    //Thông báo nhập giá
    if (priceValue === '') {
        setError(price, 'Yêu cần nhập giá sản phẩm');
    }else if (priceValue < 1) {
        setError(price, 'Yêu cầu nhập đúng giá sản phẩm'); 
    } else {
        setSuccess(price);
    }
};