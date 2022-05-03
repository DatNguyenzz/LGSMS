/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const price = document.getElementById('product-price');
const quantity = document.getElementById('product-quantity');

const form1 = document.getElementById('form1');
//const aname = document.getElementById('provider-name');
const imQuantity = document.getElementById('return-quantity');
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

function handleClick(cb) {
    if (cb.checked == true) {
        document.getElementById('product-price').removeAttribute('readonly');
        document.getElementById('product-quantity').removeAttribute('readonly');
        document.getElementById('import-note').removeAttribute('readonly');
    } else {
        document.getElementById('product-price').setAttribute('readonly', true);
        document.getElementById('product-quantity').setAttribute('readonly', true);
        document.getElementById('import-note').setAttribute('readonly', true);
    }
}

//Chạy hàm validate form add
form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 1) {
        alertFunction1();
    }
});


//Trim input và các thông báo form add
const validateInputs1 = () => {
    const imQuantityValue = imQuantity.value.trim();
//    const anameValue = aname.value.trim();
    
    //Thông báo nhập địa chỉ
    if (imQuantityValue === '') {
        setError1(imQuantity, 'Yêu cầu nhập số lượng sản phẩm');
    } else if (imQuantityValue < 1) {
        setError1(imQuantity, 'Yêu cầu nhập đúng số lượng sản phẩm');
    }
     else {
        setSuccess1(imQuantity);
    }
};

