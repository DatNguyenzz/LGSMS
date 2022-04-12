// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const price = document.getElementById('product-price');
const quantity = document.getElementById('product-quantity');

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
    const quantityValue = quantity.value.trim();
    const priceValue = price.value.trim();
    
    //Thông báo nhập địa chỉ
    if (quantityValue === '') {
        setError(quantity, 'Yêu cầu nhập số lượng sản phẩm');
    } else if (quantityValue < 1) {
        setError(quantity, 'Yêu cầu nhập đúng số lượng sản phẩm');
    }
     else {
        setSuccess(quantity);
    }
    //Thông báo tên nhà cung cấp
    if (priceValue === '') {
        setError(price, 'Yêu cầu nhập giá sản phẩm');
    }else if (priceValue < 0) {
        setError(price, 'Yêu cầu nhập đúng giá sản phẩm'); 
    } else {
        setSuccess(price);
    }
};