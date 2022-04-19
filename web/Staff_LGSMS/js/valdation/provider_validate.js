//// Lấy input
//let x = 0;
//let y = 0;
//const form = document.getElementById('form');
//const pname = document.getElementById('provider-name');
//const email = document.getElementById('provider-email');
//const phone = document.getElementById('provider-phone');
//const address = document.getElementById('provider-address');
//
//const form1 = document.getElementById('form1');
//const pname1 = document.getElementById('provider-name1');
//const email1= document.getElementById('provider-email1');
//const phone1 = document.getElementById('provider-phone1');
//const address1 = document.getElementById('provider-address1');
// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const pname1 = document.getElementById('provider-name');
const email1 = document.getElementById('provider-email');
const phone1 = document.getElementById('provider-phone');
const address1 = document.getElementById('provider-address');

const form1 = document.getElementById('form1');
const pname2 = document.getElementById('providerName');
const email2 = document.getElementById('email');
const phone2 = document.getElementById('providerPhone');
const address2 = document.getElementById('address');

//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 4) {
        alertFunction();
    }
});

//Trim input và các thông báo form add
const validateInputs = () => {
    const phoneValue = phone1.value.trim();
    const emailValue = email1.value.trim();
    const nameValue = pname1.value.trim();
    const addressValue = address1.value.trim();

    // Thông báo nhập số điện thoại

    if (phoneValue === '') {
        setError(phone1, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue)) {
        setError(phone1, 'Nhập đúng định dạng số điện thoại có 10 chữ số');
    } else {
        setSuccess(phone1);
    }

    //Thông báo nhập địa chỉ email
    if (emailValue === '') {
        setError(email1, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue)) {
        setError(email1, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess(email1);
    }
    //Thông báo nhập địa chỉ
    if (addressValue === '') {
        setError(address1, 'Yêu cầu nhập địa chỉ nhà cung cấp');
    } else {
        setSuccess(address1);
    }
    //Thông báo tên nhà cung cấp
    if (nameValue === '') {
        setError(pname1, 'Yêu cầu nhập tên nhà cung cấp');
    } else {
        setSuccess(pname1);
    }
};

//Chạy hàm validate form edit
form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 4) {
        alertFunction1();
    }
});
//Trim input và các thông báo form edit
const validateInputs1 = () => {
    const phoneValue1 = phone2.value.trim();
    const emailValue1 = email2.value.trim();
    const nameValue1 = pname2.value.trim();
    const addressValue1 = address2.value.trim();
    // Thông báo nhập số điện thoại
    if (phoneValue1 === '') {
        setError1(phone2, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue1)) {
        setError1(phone2, 'Nhập đúng định dạng số điện thoại có 10 chữ số');
    } else {
        setSuccess1(phone1);
    }
    //Thông báo nhập địa chỉ email
    if (emailValue1 === '') {
        setError1(email2, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue1)) {
        setError1(email2, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess1(email2);
    }
    //Thông báo nhập địa chỉ
    if (addressValue1 === '') {
        setError1(address2, 'Yêu cầu nhập địa chỉ nhà cung cấp');
    } else {
        setSuccess1(address2);
    }
    //Thông báo tên nhà cung cấp
    if (nameValue1 === '') {
        setError1(pname2, 'Yêu cầu nhập tên nhà cung cấp');
    } else {
        setSuccess1(pname2);
    }
};
