// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const price = document.getElementById('product-price');
const quantity = document.getElementById('product-quantity');
const pname = document.getElementById('product-name')

//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 3) {
        alertFunction();
    }
});

//Trim input và các thông báo form add
const validateInputs = () => {
    const quantityValue = quantity.value.trim();
    const priceValue = price.value.trim();
    const pnameValue = pname.value.trim();
    //Thông báo nhập tên sản phẩm
    if (pnameValue === '') {
        setError(pname, 'Yêu cầu nhập tên sản phẩm');
    }else {
        setSuccess(pname);
    }
    //Thông báo nhập số lượng
    if (quantityValue === '') {
        setError(quantity, 'Yêu cầu nhập số lượng sản phẩm');
    } else if (quantityValue < 1) {
        setError(quantity, 'Yêu cầu nhập đúng số lượng sản phẩm');
    }
     else {
        setSuccess(quantity);
    }
    //Thông báo nhập giá
    if (priceValue === '') {
        setError(price, 'Yêu cầu nhập giá sản phẩm');
    }else if (priceValue < 1) {
        setError(price, 'Yêu cầu nhập đúng giá sản phẩm'); 
    } else {
        setSuccess(price);
    }
};