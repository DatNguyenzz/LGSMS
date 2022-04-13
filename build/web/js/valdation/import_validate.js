// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const price = document.getElementById('product-price');
const quantity = document.getElementById('product-quantity');

const form1 = document.getElementById('form1');
const price1 = document.getElementById('product-price1');
const quantity1 = document.getElementById('product-quantity1');
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

//Chạy hàm validate form add
form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 2) {
        alertFunction1();
    }
});


//Trim input và các thông báo form add
const validateInputs1 = () => {
    const quantityValue1 = quantity1.value.trim();
    const priceValue1 = price1.value.trim();
    
    //Thông báo nhập địa chỉ
    if (quantityValue1 === '') {
        setError1(quantity1, 'Yêu cầu nhập số lượng sản phẩm');
    } else if (quantityValue1 < 1) {
        setError1(quantity1, 'Yêu cầu nhập đúng số lượng sản phẩm');
    }
     else {
        setSuccess1(quantity1);
    }
    //Thông báo tên nhà cung cấp
    if (priceValue1 === '') {
        setError1(price1, 'Yêu cầu nhập giá sản phẩm');
    }else if (priceValue1 < 0) {
        setError1(price1, 'Yêu cầu nhập đúng giá sản phẩm'); 
    } else {
        setSuccess1(price1);
    }
};
